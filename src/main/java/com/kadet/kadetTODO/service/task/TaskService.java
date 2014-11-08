package com.kadet.kadetTODO.service.task;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.project.QProject;
import com.kadet.kadetTODO.persistence.entity.task.QTask;
import com.kadet.kadetTODO.persistence.entity.task.Task;
import com.kadet.kadetTODO.persistence.repo.ProjectRepository;
import com.kadet.kadetTODO.persistence.repo.TaskRepository;
import com.kadet.kadetTODO.util.extjs.FilterRequest;
import com.kadet.kadetTODO.util.mapper.TaskMapper;
import com.kadet.kadetTODO.web.model.EmployeeUI;
import com.kadet.kadetTODO.web.model.ProjectUI;
import com.kadet.kadetTODO.web.model.TaskUI;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AlexSoroka on 11/8/2014.
 */
@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskMapper taskMapper;


    /**
     * CREATE
     */


    @Transactional
    public TaskUI create (TaskUI ui) {
        Task newTask = taskMapper.toPersistenceEntity(ui);
        if (newTask.getProject() != null) {
            Project project = projectRepository.findByName(newTask.getProject().getName());
            newTask.setProject(project);
        }
        Task saved = taskRepository.save(newTask);
        logger.debug("Created Task: " + saved);
        return taskMapper.toUIEntity(saved);
    }


    /**
     * READ
     */


    public TaskUI findById (Long taskId) {
        return taskMapper.toUIEntity(taskRepository.findOne(taskId));
    }

    public TaskUI read (TaskUI taskUI) {
        return findById(taskUI.getId());
    }

    public List<TaskUI> findAll () {
        return taskMapper.toUIEntity(taskRepository.findAll());
    }


    public Page<TaskUI> findAll (Pageable pageable, List<FilterRequest> filters) {
        Predicate predicate = toPredicate(filters);

        return taskMapper.toUIEntity(
                taskRepository.findAll(predicate, pageable),
                pageable
        );
    }

    public TaskUI findByName (String name) {
        return taskMapper.toUIEntity(taskRepository.findByName(name));
    }


    /**
     * UPDATE
     */

    @Transactional
    public TaskUI update (TaskUI taskUI) {
        Task existing = taskRepository.findOne(taskUI.getId());
        if (existing == null) {
            return null;
        }
        // TODO: if (..) set project
        existing.setDescription(taskUI.getDescription());
        // todo a lot of set...

        Task saved = null;

        try {
            saved = taskRepository.save(existing);
        } catch (Exception e) {
            logger.error(e);
        }

        return taskMapper.toUIEntity(saved);
    }


    /**
     * DELETE
     */

    @Transactional
    public boolean delete (TaskUI taskUI) {
        Task existing = taskRepository
                .findOne(taskUI.getId());
        if (existing == null) {
            return false;
        }
        taskRepository.delete(existing);
        return true;
    }


    // TODO; simplify this


    public Page<TaskUI> findByProjectId (Long projectId, Pageable pageable, List<FilterRequest> filters) {
        Page<Task> tasks = taskRepository.findByProjectId(projectId, pageable);
        return taskMapper.toUIEntity(tasks, pageable);
    }

    public List<TaskUI> findByProjectId (Long projectId) {
        return taskMapper.toUIEntity(taskRepository.findByProjectId(projectId));
    }

    private Predicate toPredicate (final List<FilterRequest> filters) {

        logger.info("Entering predicates :: " + filters);

        QTask project = QTask.task;
        BooleanExpression result = null;

        try {
            for (FilterRequest filter : filters) {

                Task.COLUMNS column = Task.COLUMNS.valueOf(
                        filter.getProperty()
                                .toUpperCase()
                );
                BooleanExpression expression = null;

                switch (column) {
                    case NAME:
                        if (checkFilter(filter)) {
                            expression = project.name.like(
                                    "%"
                                            + filter.getValue() + "%"
                            );
                        }
                        break;
                    case DESCRIPTION:
                        if (checkFilter(filter)) {
                            expression = project.description.like(
                                    "%"
                                            + filter.getValue() + "%"
                            );
                        }
                        break;
                }
                if (expression != null) {
                    if (result != null) {
                        result = result.and(expression);
                    } else {
                        result = expression;
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
        logger.info(
                "Result Predicate :: "
                        + (result != null ? result.toString() : "")
        );

        logger.info("Exiting predicates");
        return result;
    }


    private boolean checkFilter (FilterRequest filter) {
        return filter.getValue() != null
                && !"".equals(filter.getValue());
    }

}

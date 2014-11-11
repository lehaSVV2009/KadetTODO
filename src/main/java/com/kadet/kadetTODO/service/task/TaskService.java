package com.kadet.kadetTODO.service.task;

import com.kadet.kadetTODO.persistence.entity.task.Level;
import com.kadet.kadetTODO.persistence.entity.task.Status;
import com.kadet.kadetTODO.persistence.entity.task.Task;
import com.kadet.kadetTODO.persistence.repo.TaskRepository;
import com.kadet.kadetTODO.util.mapper.TaskMapper;
import com.kadet.kadetTODO.web.model.TaskUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Service for tasks manipulating
 *  Used to create, get, update, delete tasks
 *
 * @author Alex Soroka
 */
@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;


    /**
     * CREATE
     */


//    @Transactional
    public TaskUI create (TaskUI ui) {
        Task newTask = taskMapper.toPersistenceEntity(ui);
        Task saved = taskRepository.save(newTask);
        logger.debug("Created Task: " + saved);
        return taskMapper.toUIEntity(saved);
    }


    /**
     * READ
     */


    public TaskUI findById (Long taskId) {
        Task task = taskRepository.findOne(taskId);
        return taskMapper.toUIEntity(task);
    }

    public TaskUI find (TaskUI taskUI) {
        return findById(taskUI.getId());
    }

    public List<TaskUI> findAll () {
        return taskMapper.toUIEntity(taskRepository.findAll());
    }

    public TaskUI findByTitle(String title) {
        return taskMapper.toUIEntity(taskRepository.findByTitle(title));
    }


    /**
     * UPDATE
     */

//    @Transactional
    public TaskUI update (TaskUI taskUI) {
        Task existing = taskRepository.findOne(taskUI.getId());
        if (existing == null) {
            return null;
        }
        existing.setTitle(taskUI.getTitle());
        existing.setDescription(taskUI.getDescription());

        existing.setLevel(Level.valueOf(taskUI.getLevel()));
        existing.setStatus(Status.valueOf(taskUI.getStatus()));

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

//    @Transactional
    public boolean delete (TaskUI taskUI) {
        Task existing = taskRepository
                .findOne(taskUI.getId());
        if (existing == null) {
            return false;
        }
        taskRepository.delete(existing);
        return true;
    }

}

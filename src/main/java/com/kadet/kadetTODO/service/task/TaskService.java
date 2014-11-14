package com.kadet.kadetTODO.service.task;

import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.domain.repo.TaskRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 * <p/>
 * Service for tasks manipulating
 * Used to create, get, update, delete tasks
 *
 * @author Alex Soroka
 */
@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;


    /**
     * CREATE
     */


    @Transactional
    public Task create (Task newTask) {
        newTask.setOpenedDate(new Date());
        Task saved = taskRepository.save(newTask);
        logger.debug("Created Task: " + saved);
        return saved;
    }


    /**
     * READ
     */


    public Task findById (Long taskId) {
        Task task = taskRepository.findOne(taskId);
        return task;
    }

    public Task find (Task task) {
        return findById(task.getId());
    }

    public List<Task> findAll () {
        return taskRepository.findAll();
    }


    /**
     * UPDATE
     */

    @Transactional
    public Task update (Task task) {
        Task existing = taskRepository.findOne(task.getId());
        if (existing == null) {
            return null;
        }
        if (task.getTitle() != null) {
            existing.setTitle(task.getTitle());
        }
        if (task.getDescription() != null) {
            existing.setDescription(task.getDescription());
        }

        if (task.getLevel() != null) {
            existing.setLevel(task.getLevel());
        }
        if (task.getStatus() != null) {
            Status status = task.getStatus();
            existing.setStatus(status);
            if (Status.CLOSED.equals(status)) {
                existing.setClosedDate(new Date());
            }
        }

        Task saved = null;

        try {
            saved = taskRepository.save(existing);
        } catch (Exception e) {
            logger.error(e);
        }

        return saved;
    }


    /**
     * DELETE
     */

    @Transactional
    public boolean delete (Task task) {
        Task existing = taskRepository
                .findOne(task.getId());
        if (existing == null) {
            return false;
        }
        taskRepository.delete(existing);
        return true;
    }

}

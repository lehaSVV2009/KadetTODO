package com.kadet.kadetTODO.service.task.impl;

import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.domain.repo.TaskRepository;
import com.kadet.kadetTODO.service.task.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Alex Soroka
 */
@Service
public class TaskServiceImpl implements TaskService {

    private Logger logger = Logger.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository;


    /**
     * CREATE
     */


    @Override
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

    @Override
    public Task findById (Long taskId) {
        Task task = taskRepository.findOne(taskId);
        return task;
    }

    @Override
    public Task find (Task task) {
        return findById(task.getId());
    }

    @Override
    public List<Task> findAll () {
        return taskRepository.findAll();
    }

    @Override
    public Page<Task> findAll (Pageable pageable) {
        return taskRepository.findAll(pageable);
    }



    /**
     * UPDATE
     */

    @Override
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
            Status newStatus = task.getStatus();
            switch (newStatus) {
                case OPENED: {
                    Status oldStatus = existing.getStatus();
                    if (oldStatus != null && Status.CLOSED.equals(oldStatus)) {
                        existing.setReopenedDate(new Date());
                        existing.setClosedDate(null);
                    }
                    break;
                }
                case CLOSED: {
                    existing.setClosedDate(new Date());
                    break;
                }
            }
            existing.setStatus(newStatus);
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

    @Override
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


    public void setTaskRepository (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskRepository getTaskRepository () {
        return taskRepository;
    }
}

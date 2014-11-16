package com.kadet.kadetTODO.service.task;

import com.kadet.kadetTODO.domain.entity.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
public interface TaskService {

    /**
     * CREATE
     */
    public Task create (Task newTask);


    /**
     * READ
     */

    public Task findById (Long taskId);

    public Task find (Task task);

    public List<Task> findAll ();

    public Page<Task> findAll (Pageable pageable);


    /**
     * UPDATE
     */

    public Task update (Task task);


    /**
     * DELETE
     */

    public boolean delete (Task task);

}

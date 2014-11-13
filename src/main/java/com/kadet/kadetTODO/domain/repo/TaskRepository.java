package com.kadet.kadetTODO.domain.repo;

import com.kadet.kadetTODO.domain.entity.task.Task;

import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *
 * @author Alex Soroka
 */
public interface TaskRepository {

    public List<Task> findAll ();

    public Task findOne (Long id);

    public Task create (Task newTask);

    public Task save (Task task);

    public void delete (Task task);

    public Task findByTitle (String title);

}

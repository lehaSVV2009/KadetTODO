package com.kadet.kadetTODO.persistence.repo;

import com.kadet.kadetTODO.persistence.entity.task.Task;
import org.springframework.stereotype.Repository;

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

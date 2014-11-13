package com.kadet.kadetTODO.domain.repo;

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.domain.entity.task.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 * @author Alex Soroka
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private List<Task> tasks = new ArrayList<Task>() {
        {

            add(createTask(1l, "title 1", Level.TRIVIAL));
            add(createTask(2l, "title 2", Level.CRITICAL));
            add(createTask(3l, "title 3", Level.MAJOR));
            add(createTask(4l, "title 4", Level.MINOR));
            add(createTask(5l, "title5", Level.CRITICAL));
            add(createTask(6l, "title6", Level.TRIVIAL));
            add(createTask(7l, "title7", Level.TRIVIAL));
            add(createTask(8l, "title8", Level.BLOCKER));
            add(createTask(9l, "title9", Level.TRIVIAL));
            add(createTask(10l, "title10", Level.TRIVIAL));
            add(createTask(11l, "title11", Level.TRIVIAL));
            add(createTask(12l, "title12", Level.TRIVIAL));
            add(createTask(13l, "title13", Level.TRIVIAL));
        }

        public Task createTask (Long id, String title, Level level) {
            Task task = new Task();
            task.setId(id);
            task.setTitle(title);
            task.setDescription("desc of \n new task");
            task.setLevel(level);
            task.setStatus(Status.OPENED);
            task.setOpenedDate(new Date());
            return task;
        }

    };

    @Override
    public List<Task> findAll () {
        return tasks;
    }

    @Override
    public Task findOne (Long id) {
        for (Task task : tasks) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Task create (Task newTask) {
        newTask.setId(tasks.get(tasks.size() - 1).getId() + 1);
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Task save (Task task) {
        Task oldTask = findOne(task.getId());
        if (oldTask == null) {
            throw new RuntimeException("Can not save!");
        }
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setLevel(task.getLevel());
        return oldTask;
    }

    @Override
    public void delete (Task task) {
        Task deletedTask = findOne(task.getId());
        if (deletedTask == null) {
            throw new RuntimeException("Can not delete");
        }
        tasks.remove(deletedTask);
    }

    @Override
    public Task findByTitle (String title) {
        return null;
    }
}

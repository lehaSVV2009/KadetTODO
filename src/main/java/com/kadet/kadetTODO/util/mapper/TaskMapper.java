package com.kadet.kadetTODO.util.mapper;

/**
 * Created by AlexSoroka on 11/8/2014.
 */

import com.kadet.kadetTODO.persistence.entity.task.Level;
import com.kadet.kadetTODO.persistence.entity.task.Status;
import com.kadet.kadetTODO.persistence.entity.task.Task;
import com.kadet.kadetTODO.web.model.TaskUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Transforms Task view model to persistence entity and vice versa
 *
 * @author Alex Soroka
 */
// TODO: make by Reflection
@Service
public class TaskMapper implements Mapper<TaskUI, Task> {

    @Override
    public TaskUI toUIEntity(Task task) {
        TaskUI taskUI = null;
        if (task != null) {
            taskUI = new TaskUI();
            taskUI.setId(task.getId());

            taskUI.setTitle(task.getTitle());
            taskUI.setDescription(task.getDescription());

            taskUI.setOpenedDate(task.getOpenedDate());
            taskUI.setModifiedDate(task.getModifiedDate());
            taskUI.setResolvedDate(task.getResolvedDate());
            taskUI.setClosedDate(task.getClosedDate());
            taskUI.setReopenedDate(task.getReopenedDate());

            taskUI.setLevel(task.getLevel().name());
            taskUI.setStatus(task.getStatus().name());
        }
        return taskUI;
    }

    public List<TaskUI> toUIEntity(List<Task> projects) {
        List<TaskUI> projectUIs = new ArrayList<TaskUI>();
        for (Task project : projects) {
            projectUIs.add(toUIEntity(project));
        }
        return projectUIs;
    }

    @Override
    public Task toPersistenceEntity(TaskUI ui) {
        Task task = null;
        if (ui != null) {
            task = new Task();
            task.setId(ui.getId());

            task.setTitle(ui.getTitle());
            task.setDescription(ui.getDescription());

            task.setOpenedDate(ui.getOpenedDate());
            task.setModifiedDate(ui.getModifiedDate());
            task.setResolvedDate(ui.getResolvedDate());
            task.setClosedDate(ui.getClosedDate());
            task.setReopenedDate(ui.getReopenedDate());

            task.setLevel(Level.valueOf(ui.getLevel()));
            task.setStatus(Status.valueOf(ui.getStatus()));
        }
        return task;
    }

}

package com.kadet.kadetTODO.util.mapper;

/**
 * Created by AlexSoroka on 11/8/2014.
 */

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.task.Task;
import com.kadet.kadetTODO.web.model.TaskUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            taskUI.setLevel(task.getLevel());
            if (task.getProject() != null) {
                taskUI.setProjectName(task.getProject().getName());
            }
            taskUI.setOpenedDate(task.getOpenedDate());
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

    public Page<TaskUI> toUIEntity(Page<Task> groups,
                                   Pageable pageable) {
        Page<TaskUI> ui = new PageImpl<TaskUI>(
                toUIEntity(groups.getContent()), pageable,
                groups.getTotalElements());

        return ui;
    }

    @Override
    public Task toPersistenceEntity(TaskUI ui) {
        Task task = null;
        if (ui != null) {
            task = new Task();
            task.setId(ui.getId());
            task.setTitle(ui.getTitle());
            task.setDescription(ui.getDescription());
            task.setStatus(1);
            // TODO: task set level
            task.setLevel(ui.getLevel());
            Project project = new Project();
            project.setName(ui.getProjectName());
            task.setProject(project);
        }
        return task;
    }

}

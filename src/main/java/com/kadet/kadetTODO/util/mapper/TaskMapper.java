package com.kadet.kadetTODO.util.mapper;

/**
 * Created by AlexSoroka on 11/8/2014.
 */

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.util.DateUtil;
import com.kadet.kadetTODO.web.to.TaskTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 11.11.2014
 * Time: 10:37
 * <p/>
 * Transforms Task view to to persistence entity and vice versa
 *
 * @author Alex Soroka
 */
// TODO: make by Reflection
@Service
public class TaskMapper implements Mapper<TaskTO, Task> {

    public Map<String, Object> toMap (final TaskTO taskTO) {
        return new HashMap<String, Object>() {{
            put("id", taskTO.getId());
            put("title", taskTO.getTitle());
            put("description", taskTO.getDescription());
            put("level", taskTO.getLevel());
            put("status", taskTO.getStatus());
            put("openedDate", taskTO.getOpenedDate());
            put("reopenedDate", taskTO.getReopenedDate());
            put("closedDate", taskTO.getClosedDate());
        }};
    }


    @Override
    public TaskTO toUIEntity (Task task) {
        TaskTO taskTO = null;
        if (task != null && task.getId() != null) {
            taskTO = new TaskTO();
            taskTO.setId(task.getId());

            taskTO.setTitle(task.getTitle());
            taskTO.setDescription(task.getDescription());

            taskTO.setOpenedDate(task.getOpenedDate());
            taskTO.setReopenedDate(task.getReopenedDate());
            taskTO.setClosedDate(task.getClosedDate());

            taskTO.setLevel(task.getLevel().name());
            taskTO.setStatus(task.getStatus().name());
        }
        return taskTO;
    }

    public List<TaskTO> toUIEntity (List<Task> projects) {
        List<TaskTO> projectUIs = new ArrayList<TaskTO>();
        for (Task project : projects) {
            projectUIs.add(toUIEntity(project));
        }
        return projectUIs;
    }

    @Override
    public Task toPersistenceEntity (TaskTO ui) {
        Task task = null;
        if (ui != null) {
            task = new Task();
            task.setId(ui.getId());

            task.setTitle(ui.getTitle());
            task.setDescription(ui.getDescription());

            task.setOpenedDate(ui.getOpenedDate());
            task.setReopenedDate(ui.getReopenedDate());
            task.setClosedDate(ui.getClosedDate());

            if (ui.getLevel() != null) {
                task.setLevel(Level.valueOf(ui.getLevel()));
            }
            if (ui.getStatus() != null) {
                task.setStatus(Status.valueOf(ui.getStatus()));
            }
        }
        return task;
    }

}

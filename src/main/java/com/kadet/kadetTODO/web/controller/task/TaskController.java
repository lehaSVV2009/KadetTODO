package com.kadet.kadetTODO.web.controller.task;

import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.service.task.TaskService;
import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.util.extjs.ExtJSResponse;
import com.kadet.kadetTODO.util.mapper.TaskMapper;
import com.kadet.kadetTODO.web.to.TaskTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Date: 11.11.2014
 * Time: 10:37
 * <p/>
 * Simple REST API for manipulating with tasks
 *
 * @author Alex Soroka
 */
@Controller
@RequestMapping("/api")
public class TaskController {

    private Logger logger = Logger.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private ExtJSResponse<TaskTO> extJS;

    @Autowired
    private TaskMapper taskMapper;



    /**
     * CREATE
     */

    @RequestMapping(value = "/tasks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> create (TaskTO newTaskTO) {
        try {
            Task newTask = taskMapper.toPersistenceEntity(newTaskTO);
            Task created = taskService.create(newTask);
            TaskTO createdTO = taskMapper.toUIEntity(created);
            return (createdTO != null)
                    ? extJS.mapOK(createdTO, Strings.TASK_CREATE_SUCCESS)
                    : extJS.mapError(Strings.TASK_CREATE_ERROR);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASK_CREATE_ERROR);
        }
    }



    /**
     * READ
     */


    /**
     * Read one
     */
    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> read (@PathVariable("taskId") Long taskId) {
        try {
            Task task = taskService.findById(taskId);
            TaskTO taskTO = taskMapper.toUIEntity(task);

            return extJS.restOk(taskMapper.toMap(taskTO));
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASK_RETRIEVE_ERROR);
        }
    }


    /**
     * Read all
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> readAll () {
        try {
            List<Task> tasks = taskService.findAll();
            List<TaskTO> taskTOs = taskMapper.toUIEntity(tasks);
            return extJS.mapOK(taskTOs, Strings.TASK_UPDATE_SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASKS_RETRIEVE_ERROR);
        }
    }



    /**
     * UPDATE
     */

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> update (@RequestBody TaskTO taskTO, @PathVariable("taskId") Long taskId) throws Exception {
        try {
            taskTO.setId(taskId);
            Task task = taskMapper.toPersistenceEntity(taskTO);
            Task updateTask = taskService.update(task);
            TaskTO updatedTaskTO = taskMapper.toUIEntity(updateTask);
            return (updatedTaskTO != null)
                    ? extJS.mapOK(updatedTaskTO, Strings.TASK_UPDATE_SUCCESS)
                    : extJS.mapError(Strings.TASK_UPDATE_ERROR);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASK_UPDATE_ERROR);
        }
    }



    /**
     * DELETE
     */


    /**
     * Delete one
     */
    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> delete (@PathVariable("taskId") Long id) throws Exception {
        try {
            Task deletedTask = taskService.findById(id);
            taskService.delete(deletedTask);
            TaskTO deletedTaskTO = taskMapper.toUIEntity(deletedTask);
            return extJS.mapOK(deletedTaskTO, Strings.TASK_DELETE_SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASK_DELETE_ERROR);
        }
    }



    /**
     * Delete many tasks
     *
     * @param taskIds String contains list of task ids. Format example:  '[1, 2, 3]'
     */
    @RequestMapping(value = "/tasks/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, ? extends Object> deleteTasks (@RequestParam(value = "tasks") String taskIds) throws Exception {
        try {
            List<TaskTO> deletedTasks = new ArrayList<TaskTO>();
            for (String stringTaskId : taskIds.substring(1, taskIds.length() - 1).replaceAll("\"", "").split(",")) {

                Task task = taskService.findById(Long.parseLong(stringTaskId));
                if (task != null) {
                    taskService.delete(task);
                    deletedTasks.add(taskMapper.toUIEntity(task));
                }

            }
            return extJS.mapOK(deletedTasks, Strings.TASK_DELETE_SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.TASK_DELETE_ERROR);
        }
    }


}
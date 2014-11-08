package com.kadet.kadetTODO.web.controller.project;

import com.kadet.kadetTODO.service.employee.EmployeeService;
import com.kadet.kadetTODO.service.project.ProjectService;
import com.kadet.kadetTODO.service.task.TaskService;
import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.util.extjs.ExtJSResponse;
import com.kadet.kadetTODO.util.extjs.FilterRequest;
import com.kadet.kadetTODO.util.extjs.JsonUtils;
import com.kadet.kadetTODO.web.model.EmployeeUI;
import com.kadet.kadetTODO.web.model.ProjectUI;
import com.kadet.kadetTODO.web.model.TaskUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
@Controller
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExtJSResponse<ProjectUI> extJS;

    @Autowired
    private ExtJSResponse<TaskUI> taskExtJS;

    @Autowired
    private ExtJSResponse<EmployeeUI> employeeExtJs;

    private Logger logger = Logger.getLogger(ProjectController.class);

    /**
     * Get one page with projects (for tables)
     *
     * @param page   Projects Page
     * @param start
     * @param limit  how many projects will be received
     * @param filter some properties for searching
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> findAll (@RequestParam int page, @RequestParam int start, @RequestParam int limit, @RequestParam(required = false) Object filter) {
        try {

            Pageable pageable = new PageRequest(page - 1, limit);
            Page<ProjectUI> projects = null;


            List<FilterRequest> filters = new ArrayList<FilterRequest>();

            if (filter != null) {
                filters.addAll(JsonUtils.getListFromJsonArray((String) filter));
            }

            projects = projectService.findAll(pageable, filters);
            long total = projects.getTotalElements();

            logger.debug("projects : " + projects.getContent());

            return extJS.mapOK(projects.getContent(), total);

        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECTS_RETRIEVE_ERROR);
        }
    }


    /**
     * Get project by id
     *
     * @param id projectId
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> find (@PathVariable("id") Long id) {
        try {
            ProjectUI projectUI = projectService.findById(id);
            return extJS.mapOK(projectUI);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECT_RETRIEVE_ERROR);
        }
    }


    /**
     * Get page with tasks by project id
     *
     * @param id project id
     */
    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> findProjectTasks (@PathVariable("id") Long id, @RequestParam int page, @RequestParam int start, @RequestParam int limit, @RequestParam(required = false) Object filter) {
        try {

            Pageable pageable = new PageRequest(page - 1, limit);
            Page<TaskUI> tasks = null;

            List<FilterRequest> filters = new ArrayList<FilterRequest>();

            if (filter != null) {
                filters.addAll(JsonUtils.getListFromJsonArray((String) filter));
            }

            tasks = taskService.findByProjectId(id, pageable, filters);
            long total = tasks.getTotalElements();

            logger.debug("tasks : " + tasks.getContent());

            return taskExtJS.mapOK(tasks.getContent(), total);

        } catch (Exception e) {
            logger.error(e);
            return taskExtJS.mapError(Strings.TASKS_RETRIEVE_ERROR);
        }
    }



    /**
     * Get task by task id and project id
     */
    @RequestMapping(value = "/{id}/tasks/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> findProjectTask (@PathVariable("id") Long id, @PathVariable("taskId") Long taskId) {
        return new HashMap<String, Object>();
    }


}

package com.kadet.kadetTODO.web.controller.project;

import com.kadet.kadetTODO.service.project.ProjectService;
import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.util.extjs.ExtJSResponse;
import com.kadet.kadetTODO.web.model.ProjectUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private ExtJSResponse<ProjectUI> extJS;

    private Logger logger = Logger.getLogger(ProjectController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> list () {
        try {
            List<ProjectUI> projectUIs = projectService.findAll();
            return extJS.mapOK(projectUIs);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECTS_RETRIEVE_ERROR);
        }
    }


    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> getProject (@PathVariable("name") String name) {
        try {
            ProjectUI projectUI = projectService.findByName(name);
            return extJS.mapOK(projectUI);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECT_RETRIEVE_ERROR);
        }
    }



}

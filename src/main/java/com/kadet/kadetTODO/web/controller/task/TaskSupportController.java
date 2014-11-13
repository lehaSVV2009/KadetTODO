package com.kadet.kadetTODO.web.controller.task;

import com.kadet.kadetTODO.service.task.TaskService;
import com.kadet.kadetTODO.service.task.TaskSupportService;
import com.kadet.kadetTODO.web.to.LevelTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 * @author Alex Soroka
 */
@Controller
@RequestMapping("/api")
public class TaskSupportController {

    private Logger logger = Logger.getLogger(TaskSupportController.class);

    @Autowired
    private TaskSupportService taskSupportService;


    @RequestMapping(value = "/levels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<LevelTO> getLevels () throws Exception {
        try {
            final List<String> levels = taskSupportService.getAllLevels();
            return new ArrayList<LevelTO>() {{
                for (String level : levels) {
                    add(new LevelTO(level));
                }
            }};
        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<LevelTO>();
        }
    }


}

package com.kadet.kadetTODO.web.controller.task;

import com.kadet.kadetTODO.service.task.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private TaskService taskService;

    /*@Autowired
    private LevelMapper levelMapper;


    @RequestMapping (value = "/levels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<LevelUI> getLevels () throws Exception {
        try {
            return levelMapper.toUIEntity(taskService.getLevels());
        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<LevelUI>();
        }
    }
*/

}

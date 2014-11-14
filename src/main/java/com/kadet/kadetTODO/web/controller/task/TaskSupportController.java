package com.kadet.kadetTODO.web.controller.task;

import com.kadet.kadetTODO.service.task.TaskSupportService;
import com.kadet.kadetTODO.web.to.TextTO;
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

    /**
     *  Get all levels in JSON format like [{text: 'Level1'}, {text: 'Level2'}]
     */
    @RequestMapping(value = "/levels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TextTO> getLevels () throws Exception {
        try {
            return getTextTOs(
                    taskSupportService.getAllLevels());
        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<TextTO>();
        }
    }


    /**
     *  Get all statuses in JSON format like [{text: 'Status1'}, {text: 'Status2'}]
     */
    @RequestMapping(value = "/statuses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TextTO> getStatuses () throws Exception {
        try {
            return getTextTOs(
                    taskSupportService.getAllStatuses());
        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<TextTO>();
        }
    }


    private List<TextTO> getTextTOs (final List<String> texts) {
        return new ArrayList<TextTO>() {{
            for (String text : texts) {
                add(new TextTO(text));
            }
        }};
    }


}

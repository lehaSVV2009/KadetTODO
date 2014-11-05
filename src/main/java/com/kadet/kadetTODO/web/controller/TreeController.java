package com.kadet.kadetTODO.web.controller;

import com.kadet.kadetTODO.service.project.TreeService;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
@Controller
@RequestMapping("/api/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    private Logger logger = Logger.getLogger(TreeController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TreeEntityUI tree () {
        try {
            return treeService.getTree();
        } catch (Exception e) {
            logger.error(e);
            return treeService.getErrorTree();
        }
    }


}

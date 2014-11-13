package com.kadet.kadetTODO.web.controller;

import com.kadet.kadetTODO.util.extjs.TreeEntityBuilder;
import com.kadet.kadetTODO.web.to.TreeEntityTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 * @author Alex Soroka
 */
@Controller
@RequestMapping("/api/tree")
public class TreeController {

    private Logger logger = Logger.getLogger(TreeController.class);

    @Autowired
    private TreeEntityBuilder treeEntityBuilder;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TreeEntityTO tree () {
        try {
            return treeEntityBuilder.build();
        } catch (Exception e) {
            logger.error(e);
            return new TreeEntityTO();
        }
    }


}

package com.kadet.kadetTODO.service;

import com.kadet.kadetTODO.util.extjs.TreeEntityBuilder;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Service for creating Tree Entities of definite format
 *
 * @author Alex Soroka
 */
@Service
public class TreeService {

    public TreeEntityUI getTree () {
        TreeEntityBuilder treeEntityBuilder = new TreeEntityBuilder();
        return treeEntityBuilder.getRoot();
    }

    public TreeEntityUI getErrorTree () {
        return new TreeEntityUI();
    }


}

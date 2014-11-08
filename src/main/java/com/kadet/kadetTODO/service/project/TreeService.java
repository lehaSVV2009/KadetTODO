package com.kadet.kadetTODO.service.project;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.user.User;
import com.kadet.kadetTODO.persistence.repo.ProjectRepository;
import com.kadet.kadetTODO.persistence.repo.UserRepository;
import com.kadet.kadetTODO.util.extjs.TreeEntityBuilder;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
@Service
public class TreeService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    private Logger logger = Logger.getLogger(TreeService.class);

    public TreeEntityUI getTree () {
        TreeEntityBuilder treeEntityBuilder = new TreeEntityBuilder();
        List<Project> projects = projectRepository.findAll();
        // TODO: remove later
//        List<User> employees = userRepository.findAll();
//        treeEntityBuilder.addEmployees(employees);
        treeEntityBuilder.addProjects(projects);
        return treeEntityBuilder.getRoot();
    }

    public TreeEntityUI getErrorTree () {
        return new TreeEntityUI();
    }


}

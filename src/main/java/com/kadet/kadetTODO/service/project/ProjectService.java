package com.kadet.kadetTODO.service.project;

import com.kadet.kadetTODO.persistence.repo.ProjectRepository;
import com.kadet.kadetTODO.util.mapper.ProjectMapper;
import com.kadet.kadetTODO.web.model.ProjectUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AlexSoroka on 11/3/2014.
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper mapper;


    private Logger logger = Logger.getLogger(ProjectService.class);

    public ProjectService () {
        super();
    }


    public List<ProjectUI> findAll () {
        return mapper.toUI(projectRepository.findAll());
    }

    public ProjectUI findByName (String name) {
        return mapper.toUI(projectRepository.findByName(name));
    }

}

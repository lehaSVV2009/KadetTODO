package com.kadet.kadetTODO.util.mapper;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.web.model.ProjectUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
@Service
public class ProjectMapper implements Mapper<ProjectUI, Project>{

    public ProjectUI toUIEntity (Project project) {
        ProjectUI projectUI = null;
        if (project != null) {
            projectUI = new ProjectUI();
            projectUI.setName(project.getName());
            projectUI.setDescription(project.getDescription());
            projectUI.setCreatedDate(project.getCreatedDate());
        }
        return projectUI;
    }

    @Override
    public Project toPersistenceEntity (ProjectUI ui) {
        Project project = null;
        if (ui != null) {
            project = new Project();
            project.setName(ui.getName());
            project.setDescription(ui.getDescription());
            project.setCreatedDate(ui.getCreatedDate());
        }
        return project;
    }

    public List<ProjectUI> toUI (List<Project> projects) {
        List<ProjectUI> projectUIs = new ArrayList<ProjectUI>();
        for (Project project : projects) {
            projectUIs.add(toUIEntity(project));
        }
        return projectUIs;
    }

}

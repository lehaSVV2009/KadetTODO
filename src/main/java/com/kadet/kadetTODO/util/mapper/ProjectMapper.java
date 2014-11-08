package com.kadet.kadetTODO.util.mapper;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.web.model.ProjectUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
@Service
public class ProjectMapper implements Mapper<ProjectUI, Project> {

    @Override
    public ProjectUI toUIEntity (Project project) {
        ProjectUI projectUI = null;
        if (project != null) {
            projectUI = new ProjectUI();
            projectUI.setId(project.getId());
            projectUI.setName(project.getName());
            projectUI.setDescription(project.getDescription());
            projectUI.setCreatedDate(project.getCreatedDate());
        }
        return projectUI;
    }

    public List<ProjectUI> toUIEntity (List<Project> projects) {
        List<ProjectUI> projectUIs = new ArrayList<ProjectUI>();
        for (Project project : projects) {
            projectUIs.add(toUIEntity(project));
        }
        return projectUIs;
    }

    public Page<ProjectUI> toUIEntity (Page<Project> groups,
                                       Pageable pageable) {
        Page<ProjectUI> ui = new PageImpl<ProjectUI>(
                toUIEntity(groups.getContent()), pageable,
                groups.getTotalElements());

        return ui;
    }

    @Override
    public Project toPersistenceEntity (ProjectUI ui) {
        Project project = null;
        if (ui != null) {
            project = new Project();
            project.setId(ui.getId());
        }
        return project;
    }

}

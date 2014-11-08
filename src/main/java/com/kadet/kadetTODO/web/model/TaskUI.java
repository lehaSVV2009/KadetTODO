package com.kadet.kadetTODO.web.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Created by AlexSoroka on 11/8/2014.
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class TaskUI {

    private Long projectId;
    private Long id;
    private String name;
    private String description;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Long getProjectId () {
        return projectId;
    }

    public void setProjectId (Long projectId) {
        this.projectId = projectId;
    }
}

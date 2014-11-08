package com.kadet.kadetTODO.web.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class ProjectUI {

    private Long id;
    private String name;
    private String description;
    private Date createdDate;

    private Page<TaskUI> tasks;

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

    public Date getCreatedDate () {
        return createdDate;
    }

    public void setCreatedDate (Date createdDate) {
        this.createdDate = createdDate;
    }

    public Page<TaskUI> getTasks () {
        return tasks;
    }

    public void setTasks (Page<TaskUI> tasks) {
        this.tasks = tasks;
    }
}





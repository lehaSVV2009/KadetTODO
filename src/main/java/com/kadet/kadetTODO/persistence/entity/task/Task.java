package com.kadet.kadetTODO.persistence.entity.task;

import com.kadet.kadetTODO.persistence.entity.project.Project;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by AlexSoroka on 11/8/2014.
 */
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date openedDate;

    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @Temporal(TemporalType.DATE)
    private Date resolvedDate;

    @Temporal(TemporalType.DATE)
    private Date closedDate;

    @Temporal(TemporalType.DATE)
    private Date reopenedDate;

    @Temporal(TemporalType.DATE)
    private Date removedDate;

    //TODO: to enum
    private Integer status;
    private Integer level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId")
    private Project project;

    public static enum COLUMNS {
        NAME, DESCRIPTION, OPENEDDATE
    }

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

    public Date getOpenedDate () {
        return openedDate;
    }

    public void setOpenedDate (Date openedDate) {
        this.openedDate = openedDate;
    }

    public Date getModifiedDate () {
        return modifiedDate;
    }

    public void setModifiedDate (Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getResolvedDate () {
        return resolvedDate;
    }

    public void setResolvedDate (Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public Date getClosedDate () {
        return closedDate;
    }

    public void setClosedDate (Date closedDate) {
        this.closedDate = closedDate;
    }

    public Date getReopenedDate () {
        return reopenedDate;
    }

    public void setReopenedDate (Date reopenedDate) {
        this.reopenedDate = reopenedDate;
    }

    public Date getRemovedDate () {
        return removedDate;
    }

    public void setRemovedDate (Date removedDate) {
        this.removedDate = removedDate;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Integer getLevel () {
        return level;
    }

    public void setLevel (Integer level) {
        this.level = level;
    }

    public Project getProject () {
        return project;
    }

    public void setProject (Project project) {
        this.project = project;
    }
}

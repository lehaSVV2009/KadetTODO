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

    private String title;
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

    private String level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId")
    private Project project;

    public static enum COLUMNS {
        TITLE, DESCRIPTION, OPENEDDATE
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }


    public Project getProject () {
        return project;
    }

    public void setProject (Project project) {
        this.project = project;
    }
}

package com.kadet.kadetTODO.domain.entity.task;

import java.util.Date;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Main entity in application
 *
 * @author Alex Soroka
 */
public class Task {

    private Long id;

    private String title;
    private String description;

    private Date openedDate = new Date();
    private Date modifiedDate;
    private Date resolvedDate;
    private Date closedDate;
    private Date reopenedDate;

    private Level level = Level.TRIVIAL;
    private Status status = Status.OPENED;

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

    public Level getLevel () {
        return level;
    }

    public void setLevel (Level level) {
        this.level = level;
    }

    public Status getStatus () {
        return status;
    }

    public void setStatus (Status status) {
        this.status = status;
    }
}

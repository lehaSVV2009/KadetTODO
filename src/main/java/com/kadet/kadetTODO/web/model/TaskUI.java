package com.kadet.kadetTODO.web.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.util.Date;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Task for viewing in ExtJS
 *
 * @author Alex Soroka
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class TaskUI {

    private Long id;

    private String title;
    private String description;
    private Date openedDate;
    private Date modifiedDate;
    private Date resolvedDate;
    private Date closedDate;
    private Date reopenedDate;

    private String level;
    private String status;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
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

    public String getLevel () {
        return level;
    }

    public void setLevel (String level) {
        this.level = level;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }
}

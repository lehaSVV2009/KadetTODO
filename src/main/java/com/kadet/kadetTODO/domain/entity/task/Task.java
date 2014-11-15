package com.kadet.kadetTODO.domain.entity.task;


import javax.persistence.*;
import java.util.Date;

/**
 * Date: 11.11.2014
 * Time: 10:37
 * <p/>
 * Main entity in application
 *
 * @author Alex Soroka
 */
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    private Date openedDate = new Date();
    private Date closedDate;
    private Date reopenedDate;

    @Enumerated(EnumType.STRING)
    private Level level = Level.TRIVIAL;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPENED;

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

    public Date getClosedDate () {
        return closedDate;
    }

    public void setClosedDate (Date closedDate) {
        this.closedDate = closedDate;
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

    public Date getReopenedDate () {
        return reopenedDate;
    }

    public void setReopenedDate (Date reopenedDate) {
        this.reopenedDate = reopenedDate;
    }
}

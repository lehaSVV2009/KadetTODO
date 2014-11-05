package com.kadet.kadetTODO.persistence.entity.project;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
@Entity(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public static enum COLUMNS {
        NAME, DESCRIPTION, CREATEDDATE
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

    public Date getCreatedDate () {
        return createdDate;
    }

    public void setCreatedDate (Date createdDate) {
        this.createdDate = createdDate;
    }
}

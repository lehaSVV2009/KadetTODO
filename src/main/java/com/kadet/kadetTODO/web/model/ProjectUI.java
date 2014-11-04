package com.kadet.kadetTODO.web.model;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
public class ProjectUI {

    private BigInteger id;
    private String name;
    private String description;
    private Date createdDate;

    public BigInteger getId () {
        return id;
    }

    public void setId (BigInteger id) {
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

package com.kadet.kadetTODO.web.to;

import org.codehaus.jackson.annotate.JsonSubTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  View to for viewing on the ExtJS Tree component
 *
 * @author Alex Soroka
 */
@JsonSubTypes({@JsonSubTypes.Type(TreeEntityTO.class)})
public class TreeEntityTO {

    private List<TreeEntityTO> children = new ArrayList<TreeEntityTO>();

    private Long entityId;

    private String text;
    private boolean leaf;
    private String cls;

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public boolean isLeaf () {
        return leaf;
    }

    public void setLeaf (boolean leaf) {
        this.leaf = leaf;
    }

    public String getCls () {
        return cls;
    }

    public void setCls (String cls) {
        this.cls = cls;
    }

    public void addTreeEntity (TreeEntityTO entity) {
        children.add(entity);
    }

    public List<TreeEntityTO> getChildren () {
        return children;
    }

    public void setChildren (List<TreeEntityTO> children) {
        this.children = children;
    }

    public Long getEntityId () {
        return entityId;
    }

    public void setEntityId (Long entityId) {
        this.entityId = entityId;
    }


}

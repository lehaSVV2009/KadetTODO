package com.kadet.kadetTODO.web.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonSubTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  View model for viewing on the ExtJS Tree component
 *
 * @author Alex Soroka
 */
@JsonSubTypes({@JsonSubTypes.Type(TreeEntityUI.class)})
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class TreeEntityUI {

    private List<TreeEntityUI> children = new ArrayList<TreeEntityUI>();

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

    public void addTreeEntity (TreeEntityUI entity) {
        children.add(entity);
    }

    public List<TreeEntityUI> getChildren () {
        return children;
    }

    public void setChildren (List<TreeEntityUI> children) {
        this.children = children;
    }

    public Long getEntityId () {
        return entityId;
    }

    public void setEntityId (Long entityId) {
        this.entityId = entityId;
    }


}

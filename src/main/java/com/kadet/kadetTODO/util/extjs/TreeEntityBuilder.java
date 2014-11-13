package com.kadet.kadetTODO.util.extjs;

import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.web.to.TreeEntityTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Build tree with definite structure for ExtJS
 *
 * @author Alex Soroka
 */
@Service
@Scope(value = "prototype")
public class TreeEntityBuilder {

    private TreeEntityTO root = new TreeEntityTO();

    private TreeEntityTO myPage = new TreeEntityTO();
    private TreeEntityTO tasks = new TreeEntityTO();

    public TreeEntityBuilder () {
        root.setText(Strings.ROOT_TEXT);
        initRootEntities();
        addRootEntitiesToRoot();
    }

    private void initRootEntities () {
        myPage.setText(Strings.MY_PAGE_TEXT);
        myPage.addTreeEntity(createLeaf(Strings.MY_TASKS_TEXT));
        tasks.setText(Strings.TASKS_TEXT);
        tasks.addTreeEntity(createLeaf(Strings.NEW_TASK_TEXT));
    }

    private void addRootEntitiesToRoot () {
        root.addTreeEntity(myPage);
        root.addTreeEntity(tasks);
    }

    private TreeEntityTO createLeaf (String text) {
        TreeEntityTO treeEntityTO = new TreeEntityTO();
        treeEntityTO.setText(text);
        treeEntityTO.setLeaf(true);
        return treeEntityTO;
    }

    public void addTreeEntityToRoot (TreeEntityTO treeEntityTO) {
        root.addTreeEntity(treeEntityTO);
    }

    public void addTreeEntityToMyPage (TreeEntityTO treeEntityTO) {
        myPage.addTreeEntity(treeEntityTO);
    }

    public void addTreeEntityToTasks (TreeEntityTO treeEntityTO) {
        myPage.addTreeEntity(treeEntityTO);
    }

    public TreeEntityTO build () {
        return root;
    }

}

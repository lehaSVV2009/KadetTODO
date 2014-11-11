package com.kadet.kadetTODO.util.extjs;

import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
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
public class TreeEntityBuilder {

    private TreeEntityUI root = new TreeEntityUI();

    private TreeEntityUI myPage = new TreeEntityUI();
    private TreeEntityUI tasks = new TreeEntityUI();

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

    private TreeEntityUI createLeaf (String text) {
        TreeEntityUI treeEntityUI = new TreeEntityUI();
        treeEntityUI.setText(text);
        treeEntityUI.setLeaf(true);
        return treeEntityUI;
    }

    public TreeEntityUI getRoot () {
        return root;
    }

}

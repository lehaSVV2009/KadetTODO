package com.kadet.kadetTODO.util.extjs;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.user.User;
import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
@Service
public class TreeEntityBuilder {

    private TreeEntityUI root = new TreeEntityUI();

    private TreeEntityUI projects = new TreeEntityUI();
    private TreeEntityUI myPage = new TreeEntityUI();

    public TreeEntityBuilder () {
        root.setText(Strings.ROOT_TEXT);
        initRootEntities();
        addRootEntitiesToRoot();
    }

    private void initRootEntities () {
        // todo: remove later
//        employees.setText(Strings.EMPLOYEES_TEXT);
        projects.setText(Strings.PROJECTS_TEXT);
        myPage.setText(Strings.MY_PAGE_TEXT);
        myPage.addTreeEntity(createLeaf(Strings.MY_TASKS_TEXT));
    }

    private void addRootEntitiesToRoot () {
//        root.addTreeEntity(employees);
        root.addTreeEntity(projects);
        root.addTreeEntity(myPage);
    }

    public void addProjects (List<Project> projects) {
        for (Project project : projects) {
            addProject(project);
        }
    }

    public void addProject (Project project) {
        projects.addTreeEntity(toTreeEntityUI(project));
    }
/*

    public void addEmployees (List<User> employees) {
        for (User employee : employees) {
            addEmployee(employee);
        }
    }

    public void addEmployee (User employee) {
        employees.addTreeEntity(toTreeEntityUI(employee));
    }
*/

    public TreeEntityUI toTreeEntityUI (Project project) {
        TreeEntityUI projectNode = new TreeEntityUI();
        projectNode.setEntityId(project.getId());
        projectNode.setText(project.getName());
        projectNode.addTreeEntity(createLeaf(Strings.TASKS_TEXT));
        projectNode.addTreeEntity(createLeaf(Strings.EMPLOYEES_TEXT));
        return projectNode;
    }
/*
    public TreeEntityUI toTreeEntityUI (User employee) {
        TreeEntityUI employeeNode = new TreeEntityUI();
        employeeNode.setText(employee.getLastName() + " " + employee.getFirstName());
        employeeNode.addTreeEntity(createLeaf(Strings.TASKS_TEXT));
        return employeeNode;
    }*/

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

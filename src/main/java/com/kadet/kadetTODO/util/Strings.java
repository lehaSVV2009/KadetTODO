package com.kadet.kadetTODO.util;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
public class Strings {

    /**
     * Tree
     */
    public static final String ROOT_TEXT = "Root";
    public static final String PROJECTS_TEXT = "Projects";
    public static final String EMPLOYEES_TEXT = "Employees";
    public static final String TASKS_TEXT = "Tasks";
    public static final String MY_PAGE_TEXT = "My Page";
    public static final String MY_TASKS_TEXT = "My Tasks";

    public static final String TASK = "Task";
    public static final String TASKS = "Tasks";
    public static final String PROJECT = "Project";
    public static final String PROJECTS = "Projects";
    public static final String EMPLOYEE = "Employee";
    public static final String EMPLOYEES = "Employees";

    /**
     * Errors
     */
    public static final String RETRIEVE_ERROR_START = "Error retrieving ";
    public static final String RETRIEVE_ERROR_END = " from database.";
    public static final String PROJECTS_RETRIEVE_ERROR = RETRIEVE_ERROR_START + PROJECTS + RETRIEVE_ERROR_END;
    public static final String PROJECT_RETRIEVE_ERROR = RETRIEVE_ERROR_START + PROJECT + RETRIEVE_ERROR_END;
    public static final String TASKS_RETRIEVE_ERROR = RETRIEVE_ERROR_START + TASKS + RETRIEVE_ERROR_END;
    public static final String TASK_RETRIEVE_ERROR = RETRIEVE_ERROR_START + TASK + RETRIEVE_ERROR_END;
    public static final String EMPLOYEES_RETRIEVE_ERROR = RETRIEVE_ERROR_START + EMPLOYEES + RETRIEVE_ERROR_END;
    public static final String EMPLOYEE_RETRIEVE_ERROR = RETRIEVE_ERROR_START + EMPLOYEE + RETRIEVE_ERROR_END;

    public static final String CREATE_ERROR_START = "Error trying to create ";
    public static final String TASK_CREATE_ERROR = CREATE_ERROR_START + TASK;

    public static final String UPDATE_ERROR_START = "Error trying to update ";
    public static final String TASK_UPDATE_ERROR = UPDATE_ERROR_START + TASK;

    public static final String DELETE_ERROR_START = "Error trying to delete ";
    public static final String TASK_DELETE_ERROR = DELETE_ERROR_START + TASK;

    /**
     * Success
     */
    public static final String CREATE_SUCCESS_END = " was successfully created!";
    public static final String TASK_CREATE_SUCCESS = TASK + CREATE_SUCCESS_END;

    public static final String UPDATE_SUCCESS_END = " was successfully updated!";
    public static final String TASK_UPDATE_SUCCESS = TASK + UPDATE_SUCCESS_END;

    public static final String DELETE_SUCCESS_END = " were successfully deleted!";
    public static final String TASK_DELETE_SUCCESS = TASK + DELETE_SUCCESS_END;
}

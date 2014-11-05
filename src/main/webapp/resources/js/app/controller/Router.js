/**
 * Created by AlexSoroka on 11/5/2014.
 */
/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.Router', {

    extend: 'Ext.app.Controller',

    stores: ['NavigationTreeStore', 'ProjectStore', 'EmployeeStore'],
    models: [],
    views: ['NavigationPanel', 'ViewPanel', 'panel.ProjectsPanel', 'panel.EmployeesPanel'],
    refs: [
        {
            ref: 'navigationPanel',
            selector: 'todoNavigationPanel'
        },
        {
            ref: 'viewPanel',
            selector: 'todoViewPanel'
        }
    ],

    routes: {

        'projects': 'onProjects',
        'projects/:id': 'onProject',

        'projects/:id/tasks': 'onTasks',
        'projects/:id/tasks/:taskId': 'onTask',
        'projects/:id/tasks/newTask': 'newTask',

        'projects/:id/employees': 'onProjectEmployees',


        'employees': 'onEmployees',
        'employees/:id': 'onEmployee',


        'myPage': 'onMyPage',
        'myTasks': 'onMyTasks'

    },

    init: function () {
    },

    /**
     *  Show list of all projects
     */
    onProjects: function () {
        var viewPanel = this.getViewPanel();
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            items: [
                {
                    xtype: 'projectsPanel'
                }
            ]
        });
        viewPanel.updateByItem(newPanel);
    },

    /**
     *  Show information about project
     *
     * @param id    Project id
     */
    onProject : function (id) {

    },


    /**
     *  Show all tasks in projects
     *
     * @param id    Project id
     */
    onTasks: function (id) {

    },


    /**
     *
     * @param id        Project id
     * @param taskId    Task id
     */
    onTask: function (id, taskId) {

    },

    /**
     *
     * @param id    Project id
     */
    newTask: function (id) {

    },

    /**
     *
     * @param id    Project id
     */
    onProjectEmployees: function (id) {

    },



    onEmployees: function () {
        var viewPanel = this.getViewPanel();
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            items: [
                {
                    xtype: 'employeesPanel'
                }
            ]
        });
        viewPanel.updateByItem(newPanel);
    },

    /**
     *
     * @param id    Employee id
     */
    onEmployee : function (id) {

    },


    onMyPage: function () {
        console.log('onMyPage');
    },

    onMyTasks : function () {

    }


});


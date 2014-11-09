/**
 * Created by AlexSoroka on 11/5/2014.
 */
/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.Router', {

    extend: 'Ext.app.Controller',

    stores: ['NavigationTreeStore', 'ProjectStore', 'EmployeeStore'],
    models: ['Project', 'Employee', 'Task'],
    views: [
        'NavigationPanel',
        'ViewPanel',
        'panel.ProjectsPanel',
        'panel.EmployeesPanel',
        'panel.TasksPanel',
        'panel.ProjectPanel',
        'form.NewTaskForm',
        'form.EditTaskForm'
    ],
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

        'tasks/:taskId': 'onTask',
        'tasks/newTask': 'onNewTask',
        'tasks/:taskId/edit': 'onEditTask',

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
    onProject: function (id) {
        var me = this;
        var Project = Ext.create('kadetTODO.model.Project', {
            id: id
        });
        Project.load({
            success: function (project) {
                if (project) {
                    debugger;
                    var viewPanel = me.getViewPanel();
                    var projectForm = Ext.create('kadetTODO.view.panel.ProjectPanel', {
                        title: project.data.data.name
                    });
                    projectForm.getForm().setValues({
                        name: project.data.data.name,
                        description: project.data.data.description,
                        createdDate: project.data.data.createdDate
                    });
                    var newPanel = Ext.create('Ext.panel.Panel', {
                        xtype: 'gridPanel',
                        items: [projectForm]
                    });
                    viewPanel.updateByItem(newPanel);
                }
            },
            failure: function (proxy, response, operation) {
                debugger;
                me.showRemoteErrorBox(response.responseText);
            }
        });
    },


    /**
     *  Show all tasks in projects
     *
     * @param id    Project id
     */
    onTasks: function (id) {

        var tasksStore = Ext.create('kadetTODO.store.TaskStore');
        tasksStore.getProxy().url = 'api/projects/' + id + '/tasks';
        tasksStore.load();
        var viewPanel = this.getViewPanel();
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            items: [
                {
                    xtype: 'tasksPanel',
                    store: tasksStore
                }
            ]
        });
        viewPanel.updateByItem(newPanel);

    },


    /**
     *
     * @param taskId    Task id
     */
    onTask: function (taskId) {
    },


    onNewTask: function () {
        var viewPanel = this.getViewPanel();
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            items: [
                {
                    xtype: 'newTaskForm'
                }
            ]
        });
        viewPanel.updateByItem(newPanel);
    },


    onEditTask: function (id) {
        var viewPanel = this.getViewPanel();
        var task = Ext.create('kadetTODO.model.Task',
            {id: id}
        );
        task.load({
            success: function (task) {
                if (task) {
                    var editForm = Ext.create('kadetTODO.view.form.EditTaskForm');

                    editForm.getForm().setValues({
                        id: task.data.data.id,
                        title: task.data.data.title,
                        description: task.data.data.description,
                        projectName: task.data.data.projectName,
                        level: task.data.data.level
                    });

                    var newPanel = Ext.create('Ext.panel.Panel', {
                        xtype: 'gridPanel',
                        items: [editForm]
                    });
                    viewPanel.updateByItem(newPanel);
                }
            }
        });

    },

    /**
     *
     * @param id    Project id
     */
    onProjectEmployees: function (id) {
        var employeesStore = Ext.create('kadetTODO.store.EmployeeStore');
        employeesStore.getProxy().url = 'api/projects/' + id + '/employees';
        employeesStore.load();
        var viewPanel = this.getViewPanel();
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            items: [
                {
                    xtype: 'employeesPanel',
                    store: employeesStore
                }
            ]
        });
        viewPanel.updateByItem(newPanel);
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
    onEmployee: function (id) {

    },


    onMyPage: function () {
        console.log('onMyPage');
    },

    onMyTasks: function () {

    },


    showRemoteErrorBox: function (errorMessage) {
        Ext.MessageBox.show({
            title: "MESSAGE_BOX_REMOTE_EXCEPTION_TITLE".translate(),
            msg: errorMessage,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    }


});


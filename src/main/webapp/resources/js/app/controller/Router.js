/**
 *  Router
 *  Listens to all redirects
 *
 * Created by Alex Soroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.Router', {

    extend: 'Ext.app.Controller',

    stores: [
        'NavigationTreeStore',
        'TaskStore'
    ],
    models: ['Task'],
    views: [
        'NavigationPanel',
        'ViewPanel',
        'table.TaskTable',
        'form.NewTaskForm',
        'form.EditTaskForm',
        'form.ViewTaskForm'
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

    /**
     * All redirects
     */
    routes: {

        'myPage': 'onMyPage',
        'myTasks': 'onMyTasks',

        'tasks': 'onTasks',
        'tasks/:taskId': 'onTask',
        'newTask': 'onNewTask',
        'tasks/:taskId/edit': 'onEditTask'

    },

    init: function () {
    },

    /**
     *  Show Page with user information
     */
    onMyPage: function () {
        var viewPanel = this.getViewPanel();
        viewPanel.toDefault();
    },

    /**
     *  Show Page with user tasks
     */
    onMyTasks: function () {

    },

    /**
     *  Show list of all tasks
     */
    onTasks: function () {
        var viewPanel = this.getViewPanel();
        var tasksStore = this.getTaskStoreStore();
        var tasksPanel = Ext.create('kadetTODO.view.table.TaskTable', {
            store: tasksStore
        });
        viewPanel.updateInnerPanel(tasksPanel);
    },


    /**
     *  Show information about the task
     */
    onTask: function (taskId) {
        var viewFormPanel = Ext.create('kadetTODO.view.form.ViewTaskForm');
        this.loadTaskToForm(taskId, viewFormPanel);
    },


    /**
     *  Show panel for creating new task
     */
    onNewTask: function () {
        var viewPanel = this.getViewPanel();
        viewPanel.updateInnerPanel(
            Ext.create('kadetTODO.view.form.NewTaskForm')
        );
    },


    /**
     *  Show panel for editing task with taskId = @taskId
     */
    onEditTask: function (taskId) {
        var editFormPanel = Ext.create('kadetTODO.view.form.EditTaskForm');
        this.loadTaskToForm(taskId, editFormPanel);
    },


    /**
     *  Loads task by id and then load it to form as a record
     */
    loadTaskToForm: function (taskId, formPanel) {
        var me = this,
            viewPanel = this.getViewPanel(),
            form = formPanel.getForm(),
            Task = this.getTaskModel();
        Task.load(taskId, {
            success: function (task) {
                form.loadRecord(task);
                viewPanel.updateInnerPanel(formPanel);
            },
            failure: function (response) {
                me.showRemoteErrorBox(response.data.message);
                viewPanel.toDefault();
            }
        });
    },


    /**
     *  Show Error dialog
     */
    showRemoteErrorBox: function (errorMessage) {
        Ext.MessageBox.show({
            title: "MESSAGE_BOX_REMOTE_EXCEPTION_TITLE".translate(),
            msg: errorMessage,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    }


});


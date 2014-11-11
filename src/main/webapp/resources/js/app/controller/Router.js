/**
 *  Router
 *  Listens to all redirects
 *
 * Created by Alex Soroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.Router', {

    extend: 'Ext.app.Controller',

    stores: ['NavigationTreeStore'],
    models: ['Task'],
    views: [
        'NavigationPanel',
        'ViewPanel',
        'panel.TasksPanel',
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

    /**
     * All redirects
     */
    routes: {

        'myPage': 'onMyPage',
        'myTasks': 'onMyTasks',

        'tasks': 'onTasks',
        'tasks/:taskId': 'onTask',
        'tasks/newTask': 'onNewTask',
        'tasks/:taskId/edit': 'onEditTask'

    },

    init: function () {
    },

    /**
     *  Show Page with user information
     */
    onMyPage: function () {
        console.log('onMyPage');
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

    },


    /**
     *  Show information about the task
     */
    onTask: function (taskId) {
    },


    /**
     *  Show panel for creating new task
     */
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
        viewPanel.updatePanel(newPanel);
    },


    /**
     *  Show panel for editing task with id = @id
     */
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
                    viewPanel.updatePanel(newPanel);
                }
            }
        });

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


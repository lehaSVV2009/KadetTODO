/**
 *  Controls actions with task (create, view, update, delete)
 *          from tasks panel (from list of tasks),
 *          from new task panel,
 *          from edit task panel,
 *          from header buttons
 *
 * Created by Alex Soroka on 09.11.2014.
 */
Ext.define('kadetTODO.controller.TasksController', {

    extend: 'Ext.app.Controller',

    stores: [],
    models: ['Task'],
    views: [
        'common.Header',
        'table.TaskTable',
        'form.NewTaskForm',
        'form.EditTaskForm'
    ],

    refs: [
        {
            ref: 'newTaskForm',
            selector: 'newTaskForm'
        },
        {
            ref: 'taskTable',
            selector: 'taskTable'
        },
        {
            ref: 'editTaskForm',
            selector: 'editTaskForm'
        }
    ],

    init: function () {
        this.control({

            'commonHeader button[action=newTask]': {
                click: this.toNewTask
            },


            'taskTable button[action=add]': {
                click: this.toNewTask
            },
            'taskTable button[action=view]': {
                click: this.toViewTask
            },
            'taskTable button[action=edit]': {
                click: this.toEditTask
            },
            'taskTable button[action=delete]': {
                click: this.deleteTasks
            },


            'newTaskForm button[action=save]': {
                click: this.saveTask
            },
            'newTaskForm button[action=cancel]': {
                click: this.cancelSaveTask
            },


            'editTaskForm button[action=save]': {
                click: this.updateTask
            },
            'editTaskForm button[action=cancel]': {
                click: this.cancelUpdateTask
            }

        });
    },


    /**
     * create Task
     */

    saveTask: function () {
        var me = this,
            newTaskForm = this.getNewTaskForm();
        newTaskForm.getForm().submit({
            success: function (form, response) {
                me.showSuccessDialog(me.getMessageFromResponse(response));
                me.toHomePage();
            },
            failure: function (form, response) {
                me.showErrorDialog(me.getMessageFromResponse(response));
            }
        });
    },

    cancelSaveTask: function () {
        this.toHomePage();
    },


    /**
     *  update task
     */

    updateTask: function () {
        debugger;
        var me = this,
            editTaskForm = this.getEditTaskForm(),
            form = editTaskForm.getForm();
        form.updateRecord();
        form.getRecord().save({
            success: function (response) {
                me.showSuccessDialog(response.data.message);
                me.toHomePage();
            },
            failure: function (response) {
                me.showErrorDialog(response.data.message);
            }
        });
    },

    cancelUpdateTask: function () {
        this.toHomePage();
    },


    /**
     *  delete task
     */

    deleteTasks: function () {
        /*var tasksPanel = this.getTasksPanel();
         var selections = tasksPanel.getSelectionModel().getSelection();
         if (selections.length > 0) {
         var tasks = [];
         Ext.each(selections, function (selection) {
         tasks.push(selection.get('id'));
         });
         }
         Ext.MessageBox.show({
         title: 'MESSAGE_BOX_DELETE_TASKS'.translate(),
         buttons: Ext.MessageBox.YESNO,
         msg: 'MESSAGE_BOX_TEXT'.translate(),
         fn: function (btn) {
         if (btn == 'yes') {
         Ext.Ajax.request(
         {
         url: 'api/tasks/delete',
         method: 'POST',
         params: {
         'tasks': Ext.JSON.encode(tasks)
         },
         success: function (response) {
         Ext.Msg.alert('SUCCESS'.translate(), Ext.decode(response.responseText).message);
         tasksPanel.getStore().load();
         },
         failure: function (response) {
         Ext.Msg.alert('ERROR'.translate(), Ext.decode(response.responseText).message);
         }
         });
         }
         }
         });*/
    },


    /**
     * redirect to
     */

    toNewTask: function () {
        this.redirectTo('newTask');
    },

    toViewTask: function () {
        var taskId = this.getIdFromSelectedItemInTable();
        if (taskId) {
            this.redirectTo('tasks/' + taskId);
        }
    },

    toEditTask: function () {
        var taskId = this.getIdFromSelectedItemInTable();
        if (taskId) {
            this.redirectTo('tasks/' + taskId + '/edit');
        }
    },

    getIdFromSelectedItemInTable: function () {
        var taskTable = this.getTaskTable(),
            selections = taskTable.getSelectionModel().getSelection();
        if (selections.length == 1) {
            return selections[0].get('id');
        }
    },

    toHomePage: function () {
        this.redirectTo('myPage');
    },

    /**
     *  Parse response, get message from there
     */
    getMessageFromResponse: function (response) {
        return Ext.decode(response.response.responseText).message;
    },

    showErrorDialog: function (errorMessage) {
        Ext.MessageBox.show({
            title: "ERROR".translate(),
            msg: errorMessage,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    },

    showSuccessDialog: function (successMessage) {
        Ext.MessageBox.show({
            title: "SUCCESS".translate(),
            msg: successMessage,
            buttons: Ext.Msg.OK
        });
    }



});
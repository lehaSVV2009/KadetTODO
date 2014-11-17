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

    stores: ['TaskStore'],
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
                me.showSuccessDialog(me.parseResponse(response.response));
                me.reloadStores();
                me.toHomePage();
            },
            failure: function (form, response) {
                me.showErrorDialog(me.parseResponse(response.response));
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
        var me = this,
            editTaskForm = this.getEditTaskForm(),
            form = editTaskForm.getForm();
        form.updateRecord();
        form.getRecord().save({
            success: function (response) {
                me.showSuccessDialog(response.data.message);
                me.reloadStores();
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
        var me = this,
            taskTable = this.getTaskTable(),
            tasks = this.getIdsArrayOfSelectedItemsFromTable(taskTable);
        if (tasks.length > 0) {
            this.showAreYouSureDialog(
                "MESSAGE_BOX_DELETE_TASKS_TITLE".translate(),
                "MESSAGE_BOX_DELETE_TASKS_TEXT".translate(),
                function () {
                    Ext.Ajax.request(
                        {
                            url: 'api/tasks/delete',
                            method: 'POST',
                            params: {
                                'tasks': Ext.JSON.encode(tasks)
                            },
                            success: function (response) {
                                me.showSuccessDialog(me.parseResponse(response));
                                me.reloadStores();
                            },
                            failure: function (response) {
                                me.showErrorDialog(me.parseResponse(response));
                            }
                        });
                }
            );
        }
    },


    /**
     * redirect to
     */

    toNewTask: function () {
        this.redirectTo('newTask');
    },

    toViewTask: function () {
        var taskId = this.getIdOfSelectedItemFromTable(this.getTaskTable());
        if (taskId) {
            this.redirectTo('tasks/' + taskId);
        }
    },

    toEditTask: function () {
        var taskId = this.getIdOfSelectedItemFromTable(this.getTaskTable());
        if (taskId) {
            this.redirectTo('tasks/' + taskId + '/edit');
        }
    },


    /**
     *  Update all required stores
     */
    reloadStores: function () {
        this.getTaskStoreStore().load();
    },


    /**
     *  Get id from selected record of table
     */
    getIdOfSelectedItemFromTable: function (table) {
        var selections = table.getSelectionModel().getSelection();
        if (selections.length == 1) {
            return selections[0].get('id');
        }
    },


    /**
     *  Get array of id from selected records of table
     */
    getIdsArrayOfSelectedItemsFromTable: function (table) {
        var selections = table.getSelectionModel().getSelection();
        if (selections.length > 0) {
            var tasks = [];
            Ext.each(selections, function (selection) {
                tasks.push(selection.get('id'));
            });
        }
        return tasks || [];
    },


    toHomePage: function () {
        this.redirectTo('myPage');
    },


    /**
     *  Parse response, get message from there
     *  @return     string message
     */
    parseResponse: function (response) {
        return Ext.decode(response.responseText).message;
    },


    /**
     *
     *  ERROR DIALOG
     *
     */
    showErrorDialog: function (errorMessage) {
        Ext.MessageBox.show({
            title: "ERROR".translate(),
            msg: errorMessage,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    },


    /**
     *
     *  SUCCESS DIALOG
     *
     */
    showSuccessDialog: function (successMessage) {
        Ext.MessageBox.show({
            title: "SUCCESS".translate(),
            msg: successMessage,
            buttons: Ext.Msg.OK
        });
    },


    /**
     *
     *  YES NO DIALOG
     *
     */
    showAreYouSureDialog: function (title, message, yesFunction, noFunction) {
        Ext.MessageBox.show({
            title: title,
            buttons: Ext.MessageBox.YESNO,
            msg: message,
            fn: function (btn) {
                if (btn == 'yes') {
                    yesFunction();
                } else {
                    noFunction()
                }
            }
        });
    }



});
/**
 * Created by AlexSoroka on 09.11.2014.
 */
Ext.define('kadetTODO.controller.TasksController', {

    extend: 'Ext.app.Controller',

    stores: [],
    models: ['Task'],
    views: [
        'common.Header',
        'panel.TasksPanel',
        'form.NewTaskForm',
        'form.EditTaskForm'
    ],

    refs: [
        {
            ref: 'newTaskForm',
            selector: 'newTaskForm'
        },
        {
            ref: 'tasksPanel',
            selector: 'tasksPanel'
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


            'tasksPanel button[action=add]': {
                click: this.toNewTask
            },
            'tasksPanel button[action=edit]': {
                click: this.toEditTask
            },
            'tasksPanel button[action=delete]': {
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

    toNewTask: function () {
        this.redirectTo('tasks/newTask');
    },

    toEditTask: function () {
        var tasksPanel = this.getTasksPanel();
        var selections = tasksPanel.getSelectionModel().getSelection();
        if (selections.length == 1) {
            var taskId = selections[0].get('id');
            this.redirectTo('tasks/' + taskId + '/edit');
        }
    },

    deleteTasks: function () {
        var tasksPanel = this.getTasksPanel();
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
        });
    },


    saveTask: function () {
        var me = this,
            newTaskForm = this.getNewTaskForm();
        newTaskForm.getForm().submit({
            success: function (form, action) {
                console.log(action);
                Ext.Msg.alert('SUCCESS'.translate(), action.result.message);
                me.redirectTo("myPage/myTasks");
            },
            failure: function (form, action) {
                Ext.Msg.alert('ERROR'.translate(), action.result.message);
            }
        });
    },

    cancelSaveTask: function () {
        this.redirectTo("myPage");
    },


    updateTask: function () {
        debugger;
        var me = this,
            editTaskForm = this.getEditTaskForm();
        editTaskForm.getForm().submit({
            method: "PUT",
            url: ('api/tasks/' + editTaskForm.getForm().getValues().id),
            success: function (form, action) {
                console.log(action);
                Ext.Msg.alert('SUCCESS'.translate(), action.result.message);
                me.redirectTo("myPage/myTasks");
            },
            failure: function (form, action) {
                Ext.Msg.alert('ERROR'.translate(), action.result.message);
            }
        });
        /*debugger;
         var me = this,
         editTaskForm = this.getEditTaskForm(),
         form = editTaskForm.getForm();
         var values = form.getValues();
         var task = Ext.create('kadetTODO.model.Task', {
         id : values.id
         });
         task.set('title', values.title);
         task.set('description', values.description);
         task.set('level', values.level);
         task.set('projectName', values.projectName);
         task.save({
         success: function (response) {
         Ext.Msg.alert('SUCCESS'.translate(), Ext.decode(response.responseText).message);
         me.redirectTo("myPage/myTasks");
         },
         failure: function (response) {
         Ext.Msg.alert('ERROR'.translate(), Ext.decode(response.responseText).message);
         }
         });*/
    },

    cancelUpdateTask: function () {
        this.redirectTo("myPage");
    }

});
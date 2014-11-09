/**
 * Created by Кадет on 09.11.2014.
 */
Ext.define('kadetTODO.controller.TasksController', {

    extend: 'Ext.app.Controller',

    stores: [],
    models: [],
    views: ['common.Header'],

    init: function () {
        this.control({
            'commonHeader button[text=New Task]': {
                click: this.redirectToNewTask
            }
        });
    },

    redirectToNewTask: function () {
        this.redirectTo('tasks/newTask');
    }

});
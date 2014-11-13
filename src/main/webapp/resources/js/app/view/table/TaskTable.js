/**
 *  Panel contains list of tasks and buttons (add, edit, delete)
 *
 * Created by Alex Soroka on 11/4/2014.
 */
Ext.define('kadetTODO.view.table.TaskTable', {

    extend: "kadetTODO.view.table.AbstractTable",

    alias: 'widget.taskTable',

    title: "TASK_TABLE_TITLE".translate(),

    columns: [
        {
            text: "TASK_TABLE_NAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'id'
        },
        {
            text: "TASK_TABLE_TASK_TITLE".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'title'
        },
        {
            text: "TASK_TABLE_DESCRIPTION".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'description'
        }
    ]

});
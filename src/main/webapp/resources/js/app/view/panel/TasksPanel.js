/**
 * Created by AlexSoroka on 11/8/2014.
 */
/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.view.panel.TasksPanel', {

    extend: "Ext.grid.Panel",

    alias: 'widget.tasksPanel',

    title: "TASKS_PANEL_TITLE".translate(),

    selModel: Ext.create('Ext.selection.CheckboxModel'),
    iconCls: 'icon-user',

    columns: [
        {
            text: "TASKS_PANEL_NAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'name'
        },
        {
            text: "TASKS_PANEL_DESCRIPTION".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'description'
        }
    ],

    dockedItems: [
        {
            items: [
                '-',
                {
                    text: "BUTTON_ADD".translate(),
                    itemId: 'add',
                    handler: function () {

                    }
                },
                '-',
                {
                    text: "BUTTON_EDIT".translate(),
                    action: 'edit',
                    handler: function () {

                    }
                },
                '-',
                {
                    text: "BUTTON_REMOVE".translate(),
                    action: 'delete',
                    handler: function () {

                    }
                }
            ],
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            emptyMsg: "TASKS_PANEL_EMPTY_DISPLAY".translate()
        }
    ]

});
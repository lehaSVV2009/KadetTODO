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
            dataIndex: 'id'
        },
        {
            text: "TASKS_PANEL_TASK_TITLE".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'title'
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
                    action: 'add'
                },
                '-',
                {
                    text: "BUTTON_EDIT".translate(),
                    action: 'edit'
                },
                '-',
                {
                    text: "BUTTON_REMOVE".translate(),
                    action: 'delete'
                }
            ],
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            emptyMsg: "TASKS_PANEL_EMPTY_DISPLAY".translate()
        }
    ],

    initComponent: function () {
        this.callParent(arguments);
        this.getSelectionModel().on('selectionchange', this.onSelectChange, this);
        this.onSelectChange(this.getSelectionModel(), []);
    },

    onSelectChange: function (selModel, selections) {
        this.down('button[action=delete]').setDisabled(selections.length === 0);
        this.down('button[action=edit]').setDisabled(selections.length != 1);
    }

});
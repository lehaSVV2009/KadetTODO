/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.view.panel.EmployeesPanel', {

    extend: "Ext.grid.Panel",

    alias: 'widget.employeesPanel',

    store: 'EmployeeStore',

    title: "EMPLOYEES_PANEL_TITLE".translate(),

    selModel: Ext.create('Ext.selection.CheckboxModel'),
    iconCls: 'icon-user',

    columns: [
        {
            text: "EMPLOYEES_PANEL_USERNAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'username'
        },
        {
            text: "EMPLOYEES_PANEL_FIRST_NAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'firstName'
        },
        {
            text: "EMPLOYEES_PANEL_LAST_NAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'lastName'
        },
        {
            text: "EMPLOYEES_PANEL_EMAIL".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'email'
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
                    text: "BUTTON_REMOVE".translate(),
                    action: 'delete',
                    handler: function () {

                    }
                }
            ],
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            store: 'EmployeeStore',
            displayInfo: true,
            emptyMsg: "EMPLOYEES_PANEL_EMPTY_DISPLAY".translate()
        }
    ]

});
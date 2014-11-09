/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.view.panel.ProjectsPanel', {

    extend: "Ext.grid.Panel",

    alias: 'widget.projectsPanel',

    store: 'ProjectStore',

    title: "PROJECTS_PANEL_TITLE".translate(),

    selModel: Ext.create('Ext.selection.CheckboxModel'),
    iconCls: 'icon-user',

    columns: [
        {
            text: "PROJECTS_PANEL_NAME".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'name'
        },
        {
            text: "PROJECTS_PANEL_DESCRIPTION".translate(),
            flex: 1,
            sortable: true,
            filterable: true,
            dataIndex: 'description'
        }
    ],

    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            store: 'ProjectStore',
            displayInfo: true,
            emptyMsg: "PROJECTS_PANEL_EMPTY_DISPLAY".translate()
        }
    ]

});
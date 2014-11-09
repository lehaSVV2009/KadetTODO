/**
 * Created by AlexSoroka on 11/6/2014.
 */
Ext.define('kadetTODO.view.panel.ProjectPanel', {

    extend: 'Ext.form.Panel',

    alias: 'widget.projectPanel',

    bodyStyle: 'padding:5px',
    labelWidth: 80,
    monitorValid: true,
    border: false,
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },

    layout: 'anchor',
    defaults: {
        anchor: '90%'
    },

    items: [
        {
            xtype: 'displayfield',
            fieldLabel: "PROJECT_PANEL_NAME_LABEL".translate(),
            name: 'name'
        },
        {
            xtype: 'displayfield',
            fieldLabel: "PROJECT_PANEL_DESCRIPTION_LABEL".translate(),
            name: 'description'
        },
        {
            xtype: 'datefield',
            fieldLabel: "PROJECT_PANEL_CREATED_DATE_LABEL".translate(),
            name: 'createdDate',
            readOnly: true
        }
    ]
});
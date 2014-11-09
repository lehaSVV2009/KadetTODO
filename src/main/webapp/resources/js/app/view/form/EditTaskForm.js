/**
 * Created by Kadet on 09.11.2014.
 */
Ext.define('kadetTODO.view.form.EditTaskForm', {

    extend: 'Ext.form.Panel',

    alias: 'widget.editTaskForm',

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
            xtype: 'textfield',
            fieldLabel: "EDIT_TASK_FORM_ID".translate(),
            name: 'id',
            readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: "EDIT_TASK_FORM_TASK_TITLE".translate(),
            name: 'title'
        },
        {
            xtype: 'textarea',
            fieldLabel: "EDIT_TASK_FORM_DESCRIPTION".translate(),
            name: 'description'
        },
        {
            xtype: 'combobox',
            fieldLabel: 'EDIT_TASK_FORM_PROJECT'.translate(),
            store: 'ProjectStore',
            name: 'projectName',
            anchor: '95%',
            allowBlank: false,
            displayField: 'name'
        },
        {
            xtype: 'combobox',
            fieldLabel: 'EDIT_TASK_FORM_LEVEL'.translate(),
            name: 'level',
            anchor: '95%',
            allowBlank: false,
            displayField: 'text',
            valueField: 'text',
            store: {
                autoLoad: true,
                fields: ['text'],
                proxy: {
                    type: 'ajax',
                    url: 'api/levels'
                }
            }
        }
    ],
    buttons: [
        {
            text: 'BUTTON_SAVE'.translate(),
            formBind: true,
            action: 'save'
        },
        {
            text: 'BUTTON_CANCEL'.translate(),
            action: 'cancel'
        }
    ],
    buttonAlign: 'left'

});
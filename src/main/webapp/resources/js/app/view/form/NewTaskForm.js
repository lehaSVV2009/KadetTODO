/**
 * Created by AlexSoroka on 11/8/2014.
 */
Ext.define('kadetTODO.view.form.NewTaskForm', {

    extend: 'Ext.form.Panel',

    alias: 'widget.newTaskForm',
    bodyStyle: 'padding:5px',
    labelWidth: 80,
    monitorValid: true,
    border: false,
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },
    defaults: {
        anchor: '100%'
    },

    url: 'api/tasks/',

    items: [
        {
            title: 'NEW_TASK_FORM_TITLE'.translate(),
            layout: 'column',
            bodyStyle: 'padding:10px',
            border: false,
            items: [
                {
                    border: false, layout: 'anchor', defaultType: 'textfield',
                    items: [
                        {
                            fieldLabel: 'NEW_TASK_FORM_NAME'.translate(),
                            name: 'name',
                            anchor: '95%',
                            allowBlank: false
                        },
                        {
                            fieldLabel: 'NEW_TASK_FORM_DESCRIPTION'.translate(),
                            name: 'description',
                            anchor: '95%',
                            allowBlank: false
                        },
                        {
                            fieldLabel: 'NEW_TASK_FORM_PROJECT'.translate(),
                            store: 'kadetTODO.store.ProjectStore',
                            name: 'projectName',
                            anchor: '95%',
                            xtype: 'combobox',
                            allowBlank: false,
                            displayField: 'name'
                        }
                    ]
                }
            ]
        }
    ],
    buttons: [
        {
            text: 'BUTTON_SAVE'.translate(),
            formBind: true,
            handler: function () {
                //this.up('form').getForm().reset();
                /*productDetailsForm.getForm().submit(
                 {
                 success: function (form, action) {
                 window.location = "<c:url value=" / product
                 "/>";
                 },
                 failure: function (form, action) {
                 Ext.Msg.alert('Warning', action.result.message);
                 }
                 });*/
            }
        },
        {
            text: 'BUTTON_CANCEL'.translate(),
            handler: function () {
                /*window.location = "<c:url value=" / product
                 "/>";*/
            }
        }
    ],
    buttonAlign: 'left'

});
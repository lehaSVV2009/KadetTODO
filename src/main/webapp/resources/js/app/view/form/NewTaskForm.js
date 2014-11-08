/**
 * Created by AlexSoroka on 11/8/2014.
 */
Ext.define('kadetTODO.view.form.NewTaskForm', {

    extend: 'Ext.form.Panel',

    alias: 'widget.newTaskForm',

    layout: 'anchor',
    defaults: {
        anchor: '90%'
    },

    items: [
        {
            xtype: 'textfield',
            fieldLabel: "NEW_TASK_FORM_NAME".translate(),
            name: 'name'
        },
        {
            xtype: 'textareafield',
            fieldLabel: "NEW_TASK_FORM_DESCRIPTION".translate(),
            name: 'description'
        },
        {
            xtype: 'checkboxfield',
            fieldLabel: "NEW_TASK_FORM_LEVEL".translate(),
            name: 'description'
        }
    ],

    buttons: [
        {
            text: 'BUTTON_RESET',
            handler: function () {
                this.up('form').getForm().reset();
            }
        },
        {
            text: 'BUTTON_SUBMIT',
            formBind: true,
            disabled: true,
            handler: function () {
                var form = this.up('form').getForm();
                if (form.isValid()) {
                    form.submit({
                        
                        success: function (form, action) {

                            Ext.Msg.alert('Success', action.result.msg);
                        },
                        failure: function (form, action) {
                            Ext.Msg.alert('Failed', action.result.msg);
                        }
                    });
                }
            }
        }
    ]

});
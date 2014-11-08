/**
 * Created by AlexSoroka on 11/6/2014.
 */
Ext.define('kadetTODO.view.panel.ProjectPanel', {

    extend: 'Ext.form.Panel',

    alias: 'widget.projectPanel',

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
        }
        /*, {
         xtype: 'datefield',
         fieldLabel: "PROJECT_PANEL_CREATED_DATE_LABEL".translate(),
         name: 'createdDate'
         }*/
    ],

    buttons: [{
        text: 'Reset',
        handler: function() {
            this.up('form').getForm().reset();
        }
    } /*{
        text: 'Submit',
        formBind: true, //only enabled once the form is valid
        disabled: true,
        handler: function() {
            var form = this.up('form').getForm();
            if (form.isValid()) {
                form.submit({
                    success: function(form, action) {
                        Ext.Msg.alert('Success', action.result.msg);
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
            }
        }
    }*/]

});
/**
 *  Form is used for editing task
 *
 * Created by Alex Soroka on 09.11.2014.
 */
Ext.define('kadetTODO.view.form.EditTaskForm', {

    extend: 'kadetTODO.view.form.AbstractForm',

    alias: 'widget.editTaskForm',

    items: [
        {
            title: 'EDIT_TASK_FORM_TITLE'.translate(),
            layout: 'column',
            bodyStyle: 'padding:10px',
            border: false,
            items: [
                {
                    border: false, layout: 'anchor', defaultType: 'textfield',
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
            action: 'save'
        },
        {
            text: 'BUTTON_CANCEL'.translate(),
            action: 'cancel'
        }
    ]

});
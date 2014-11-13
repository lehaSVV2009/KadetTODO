/**
 * Form is used for creating new task
 *
 * Created by Alex Soroka on 11/8/2014.
 */
Ext.define('kadetTODO.view.form.NewTaskForm', {

    extend: 'kadetTODO.view.form.AbstractForm',

    alias: 'widget.newTaskForm',

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
                            fieldLabel: 'NEW_TASK_FORM_TASK_TITLE'.translate(),
                            name: 'title',
                            anchor: '95%',
                            allowBlank: false
                        },
                        {
                            xtype: 'textarea',
                            fieldLabel: 'NEW_TASK_FORM_DESCRIPTION'.translate(),
                            name: 'description',
                            anchor: '95%',
                            allowBlank: false
                        },
                        {
                            fieldLabel: 'NEW_TASK_FORM_LEVEL'.translate(),
                            name: 'level',
                            anchor: '95%',
                            xtype: 'combobox',
                            allowBlank: false,
                            displayField: 'text',
                            valueField: 'text',
                            store: 'Levels'
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
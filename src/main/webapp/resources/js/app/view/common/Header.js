/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.common.Header', {

    extend: "Ext.panel.Panel",

    alias: 'widget.commonHeader',

    items: [
        {
            xtype: 'toolbar',
            items: [
                {
                    xtype: 'box',
                    autoEl: {
                        tag: 'img',
                        src: '/resources/images/todo.png',
                        width: '70px',
                        height: '39px'
                    }
                },
                {
                    text: "HEADER_HOME_BUTTON_TEXT".translate(),
                    handler: function () {
                        window.location = "/home"
                    }
                },
                {
                    text: "HEADER_NEW_TASK_BUTTON_TEXT".translate(),
                    handler: function () {

                    }
                },
                '->',
                {
                    text: "HEADER_LOGOUT_BUTTON_TEXT".translate(),
                    handler: function () {
                        window.location = "/logout";
                    }
                }
            ]
        }
    ]
});
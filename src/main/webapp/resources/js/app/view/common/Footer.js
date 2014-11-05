/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.common.Footer', {

    extend: "Ext.panel.Panel",

    alias: 'widget.commonFooter',

    layout: {
        align: 'middle',
        pack: 'center',
        type: 'hbox'
    },

    items: [
        {
            xtype: 'box',
            autoEl: {
                tag: 'img',
                src: '/resources/images/made-by-me.png',
                width: '200px',
                height: '50px'
            }
        }
    ]
});
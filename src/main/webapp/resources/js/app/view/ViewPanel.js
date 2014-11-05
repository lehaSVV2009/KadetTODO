/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.ViewPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.todoViewPanel',
    title: "VIEW_PANEL_TITLE".translate(),
    items: [
        {
            xtype: 'gridpanel',
            title: 'Start View'
        }
    ],

    updateByItem: function (newItem) {
        this.removeAll(true, true);
        this.add(newItem);
    }

});
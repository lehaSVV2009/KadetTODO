/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.TabPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.todoTabPanel',
    title: "TAB_PANEL_TITLE".translate(),
    items: [
        {
            closable: true,
            xtype: 'gridpanel',
            title: 'Yahoo!'
        }
    ]
});
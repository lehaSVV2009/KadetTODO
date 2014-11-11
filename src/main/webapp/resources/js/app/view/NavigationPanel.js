/**
 *  Simple tree. Used for navigation
 *
 * Created by Alex Soroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.NavigationPanel', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.todoNavigationPanel',
    title: "NAVIGATION_PANEL_TITLE".translate(),
    rootVisible: false,
    store: 'NavigationTreeStore',

    dockedItems: [{
        xtype: 'toolbar',
        items: [{
            text: "NAVIGATION_PANEL_EXPAND_ALL_BUTTON_TEXT".translate(),
            action: 'expandAll'
        }, {
            text: "NAVIGATION_PANEL_COLLAPSE_ALL_BUTTON_TEXT".translate(),
            action: 'collapseAll'
        }]
    }]

});
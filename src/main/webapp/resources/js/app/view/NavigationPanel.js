/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.view.NavigationPanel', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.todoNavigationPanel',
    title: 'Navigation',
    rootVisible: false,
    store: 'Projects',

    dockedItems: [{
        xtype: 'toolbar',
        items: [{
            text: 'Expand All'
        }, {
            text: 'Collapse All'
        }]
    }]

});
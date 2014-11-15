/**
 *  Panel is for viewing, editing, creating something
 *  Main panel for working
 *
 * Created by Alex Soroka on 11/1/2014.
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

    /**
     *  Inserts newPanel instead previous. It fills ViewPanel
     * @param newPanel
     */
    updatePanel: function (newPanel) {
        this.removeAll(true, true);
        this.add(newPanel);
    },

    updateInnerPanel: function (innerNewPanel) {
        var newPanel = Ext.create('Ext.panel.Panel', {
            xtype: 'gridPanel',
            layout: 'fit',
            items: [
                innerNewPanel
            ]
        });
        this.updatePanel(newPanel);
    },

    toDefault: function (){
        this.removeAll(true, true);
        this.add({
            xtype: 'gridpanel',
            title: 'Start View'
        });
    }

});
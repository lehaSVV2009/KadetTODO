/**
 * Created by Alex Soroka on 11/13/2014.
 */
Ext.define('kadetTODO.view.table.AbstractTable', {

    extend: "Ext.grid.Panel",

    alias: 'widget.abstractTable',

    selModel: Ext.create('Ext.selection.CheckboxModel'),
    iconCls: 'icon-user',

    initComponent: function () {
        var me = this;
        this.dockedItems = {
            items: [
                '-',
                {
                    text: "BUTTON_ADD".translate(),
                    action: 'add'
                },
                '-',
                {
                    text: "BUTTON_VIEW".translate(),
                    action: 'view'
                },
                '-',
                {
                    text: "BUTTON_EDIT".translate(),
                    action: 'edit'
                },
                '-',
                {
                    text: "BUTTON_REMOVE".translate(),
                    action: 'delete'
                }
            ],
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            store: me.store
        };
        this.callParent(arguments);
        this.getSelectionModel().on('selectionchange', this.onSelectChange, this);
        this.onSelectChange(this.getSelectionModel(), []);
    },

    onSelectChange: function (selModel, selections) {
        this.down('button[action=delete]').setDisabled(selections.length === 0);
        this.down('button[action=edit]').setDisabled(selections.length != 1);
        this.down('button[action=view]').setDisabled(selections.length != 1);
    }

});
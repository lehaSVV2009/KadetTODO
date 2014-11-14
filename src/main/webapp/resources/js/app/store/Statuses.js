/**
 * Created by Alex Soroka on 11/14/2014.
 */
Ext.define("kadetTODO.store.Statuses", {

    extend: 'Ext.data.Store',

    autoLoad: true,
    fields: ['text'],
    proxy: {
        type: 'ajax',
        url: 'api/statuses'
    }

});
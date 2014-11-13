/**
 * Created by Alex Soroka on 11/13/2014.
 */
Ext.define("kadetTODO.store.Levels", {

    extend: 'Ext.data.Store',

    autoLoad: true,
    fields: ['text'],
    proxy: {
        type: 'ajax',
        url: 'api/levels'
    }

});
/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.model.Task', {

    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'name',
            type: 'string'
        },
        {
            name: 'description',
            type: 'string'
        }
    ]

});
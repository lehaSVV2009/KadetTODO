/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.model.Project', {

    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        {
            name: 'id',
            type: 'int',
            mapping: 'id'
        },
        {
            name: 'name',
            type: 'string',
            mapping: 'name'
        },
        {
            name: 'description',
            type: 'string',
            mapping: 'description'
        }
    ],

    proxy: {
        type: 'rest',
        url: '/api/projects'
    }

});
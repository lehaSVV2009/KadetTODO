/**
 *  Task entity
 *
 * Created by Alex Soroka on 11/4/2014.
 */
Ext.define('kadetTODO.model.Task', {

    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        {
            name: 'id',
            type: 'int',
            mapping: 'id'
        },
        {
            name: 'title',
            type: 'string',
            mapping: 'title'
        },
        {
            name: 'description',
            type: 'string',
            mapping: 'description'
        },
        {
            name: 'level',
            type: 'string',
            mapping: 'level'
        },
        {
            name: 'status',
            type: 'string',
            mapping: 'status'
        },
        {
            name: 'openedDate',
            type: 'date',
            mapping: 'openedDate',
            convert: function (newValue) {
                return new Date(newValue);
            }
        }
    ],

    proxy: {
        type: 'rest',
        url: '/api/tasks'
    }


});
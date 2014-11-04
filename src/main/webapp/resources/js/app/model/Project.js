/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define('kadetTODO.model.Project', {

    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'id',
            type: 'int',
            useNull: true
        },
        'name',
        'description'
    ]

});
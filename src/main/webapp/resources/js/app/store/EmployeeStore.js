/**
 * Created by AlexSoroka on 11/5/2014.
 */
Ext.define("kadetTODO.store.EmployeeStore", {

    extend: 'Ext.data.Store',

    model: 'kadetTODO.model.Employee',

    buffered: true,

    pageSize: 50,
    leadingBufferZone: 1000,
    remoteSort: true,

    autoLoad: true,

    proxy: {
        type: 'ajax',
        api: {
            read: '/api/employees'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        singleSortMode: true,
        listeners: {
            exception: function (proxy, response, operation) {
                Ext.MessageBox.show({
                    title: "MESSAGE_BOX_REMOTE_EXCEPTION_TITLE".translate(),
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }

});
/**
 *
 * Created by Alex Soroka on 11/4/2014.
 */
Ext.define("kadetTODO.store.TaskStore", {

    extend: 'Ext.data.Store',

    model: 'kadetTODO.model.Task',

    buffered: true,

    pageSize: 50,
    leadingBufferZone: 1000,
    remoteSort: true,

    autoLoad: true,

    proxy: {
        url: 'api/tasks',
        type: 'ajax',
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
/**
 * Created by AlexSoroka on 11/4/2014.
 */
Ext.define("kadetTODO.store.ProjectStore", {

    extend: 'Ext.data.Store',

    pageSize: 200,
    model: 'kadetTODO.model.Project',
    remoteSort: true,
    buffered: true,

    autoLoad: true,

    proxy: {
        type: 'ajax',
        api: {
            read: '/api/projects'
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
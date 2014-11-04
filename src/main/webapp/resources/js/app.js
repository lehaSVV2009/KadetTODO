/**
 * Created by AlexSoroka on 10/30/2014.
 */
Ext.application({

    name: 'kadetTODO',
    appFolder: 'resources/js/app',

    requires : [
        'kadetTODO.util.Strings'
    ],

    controllers: [
        'ProjectsController'
    ],

    launch: function () {
        Ext.create('kadetTODO.view.MainViewport');
    }

});
/**
 * Application is for task management
 *
 * Created by Alex Soroka on 10/30/2014.
 */
Ext.Loader.setPath('kadetTODO', 'resources/js/app');

Ext.require([
    'kadetTODO.util.LocaleUtil',
    'kadetTODO.util.DateUtil'
], function () {

    /**
     *  Set default en_GB language for entire application
     */
    Ext.create('kadetTODO.util.LocaleUtil').setLanguage(function () {

        Ext.application({

            name: 'kadetTODO',
            appFolder: 'resources/js/app',

            controllers: [
                'Router',
                'NavigationController',
                'TasksController'
            ],

            launch: function () {
                Ext.create('kadetTODO.view.MainViewport');
            }

        });

    })

});
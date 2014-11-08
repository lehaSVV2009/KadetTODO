/**
 * Created by AlexSoroka on 10/30/2014.
 */
Ext.Loader.setPath('kadetTODO', 'resources/js/app');

Ext.require([
    'kadetTODO.util.LocaleUtil',
    'kadetTODO.util.ParameterProxy'
], function () {


    Ext.create('kadetTODO.util.LocaleUtil').setLanguage(function () {

        Ext.application({

            name: 'kadetTODO',
            appFolder: 'resources/js/app',

            controllers: [
                'Router',
                'NavigationController'
            ],

            launch: function () {
                Ext.create('kadetTODO.view.MainViewport');
            }

        });

    })

});
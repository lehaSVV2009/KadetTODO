/**
 * Application is for task management
 *
 * Created by Alex Soroka on 10/30/2014.
 */
var Application = null;

Ext.Loader.setPath('kadetTODO', 'resources/js/app');

Ext.require([
    'kadetTODO.util.LocaleUtil',
    'kadetTODO.util.DateUtil'
], function () {

    /**
     *  Set default en_GB language for entire application
     */
    Ext.create('kadetTODO.util.LocaleUtil').setLanguage(function () {

        Application = Ext.create('Ext.app.Application', {

            name: 'kadetTODO',
            appFolder: 'resources/js/app',

            controllers: [
                'Router',
                'NavigationController',
                'TasksController'
            ],

            // Setting the autoCreateViewPort to initialize the Application without
            // View being rendered
            autoCreateViewport: false,

            launch: function () {
                var jasmineEnv = jasmine.getEnv();
                jasmineEnv.updateInterval = 1000;
                var htmlReporter = new jasmine.HtmlReporter();
                jasmineEnv.addReporter(htmlReporter);
                jasmineEnv.execute();
            }

        });

    })

});
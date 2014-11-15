/**
 * Created by Alex Soroka on 11/15/2014.
 */
Ext.onReady(function () {

    Ext.QuickTips.init();

    Ext.create('Ext.Window', {
        closable: false,
        text: '<h2>Access denied!</h2>'
    }).show();


});
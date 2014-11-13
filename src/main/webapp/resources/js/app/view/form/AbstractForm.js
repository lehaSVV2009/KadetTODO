/**
 *  Abstract Form has default settings for all forms
 *
 * Created by Alex Soroka on 11/13/2014.
 */
Ext.define('kadetTODO.view.form.AbstractForm', {

    extend: 'Ext.form.Panel',

    alias: 'widget.abstractForm',

    bodyStyle: 'padding:5px',
    labelWidth: 80,
    monitorValid: true,
    border: false,
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },
    defaults: {
        anchor: '100%'
    },

    buttonAlign: 'left'


});
/**
 * Created by Alex Soroka on 11/15/2014.
 */
Ext.onReady(function () {

    Ext.QuickTips.init();

    var login = Ext.create('Ext.FormPanel',
        {
            title: 'Please Login',
            url: 'j_spring_security_check',
            labelWidth: 80,
            frame: true,
            defaultType: 'textfield',
            width: 300,
            height: 150,
            monitorValid: true,
            bodyStyle: 'padding:10px',
            items: [
                {
                    fieldLabel: 'User name',
                    name: 'j_username',
                    id: 'userName',
                    allowBlank: false,
                    listeners: {
                        afterrender: function (field) {
                            field.focus();
                        }
                    }
                },
                {
                    fieldLabel: 'Password',
                    name: 'j_password',
                    inputType: 'password',
                    allowBlank: false
                }
            ],
            buttons: [
                {
                    text: 'Login',
                    formBind: true,
                    handler: function () {
                        loginSubmit();
                    }
                },
                {
                    text: 'Reset',
                    formBind: true,
                    handler: function () {
                        reset();
                    }
                }
            ],
            listeners: {
                afterRender: function (thisForm, options) {
                    this.keyNav = Ext.create('Ext.util.KeyNav', this.el,
                        {
                            enter: loginSubmit,
                            scope: this
                        });
                }
            }
        });

    function reset() {
        login.getForm().reset();
    }

    function loginSubmit() {
        login.getForm().submit(
            {
                method: 'POST',
                success: function (form, action) {
                    window.location = 'home';
                },
                failure: function (form, action) {
                    Ext.Msg.alert('Login Failed!', 'Login Failed!');
                    reset();
                }
            });
    }


    Ext.create('Ext.Window', {
        closable: false,
        items: [
            login
        ]
    }).show();


});

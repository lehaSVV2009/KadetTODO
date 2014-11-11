/**
 *  Util class for loading properties of wanted language and setting these properties to 'String' method 'translate'
 *
 * Created by Alex Soroka on 11/4/2014.
 */
Ext.define('kadetTODO.util.LocaleUtil', {
    signleton: true,

    getWantedLang: function () {
        return 'en_GB';
    },


    loadProperties: function (text) {
        var lines = Ext.Array.filter(text.split(/\r\n|\n|\r/), function (line) {
            return line.trim() !== '' && line.indexOf('#') !== 0;
        });

        return lines.reduce(function (previousValue, currentValue) {
            var delimIndex = currentValue.indexOf('='),
                key = currentValue.substring(0, delimIndex).trim(),
                value = currentValue.substring(delimIndex + 1, currentValue.length).trim();

            previousValue[key] = value;

            return previousValue;
        }, []);
    },

    setLanguage: function (callback) {

        var me = this,
            preferredLanguage = me.getWantedLang();

        Ext.Ajax.request({
            url: 'resources/locale/messages_' + preferredLanguage + '.properties',
            method: 'GET',
            success: function (response) {
                var text = response.responseText,

                    properties = me.loadProperties(text),

                    translate = function () {
                        var key = this.valueOf(),
                            value = properties[key];

                        if (!value) {
                            Ext.Msg.alert("Warning", 'Missing translation for: ' + key);
                            return key;
                        }

                        return value;
                    };

                String.prototype.translate = translate;

                if (callback) {
                    callback();
                }

            }
        });

    }
});
/**
 * Created by AlexSoroka on 11/8/2014.
 */
Ext.define('kadetTODO.util.ParameterProxy', {
    extend: 'Ext.data.proxy.Ajax',
    alias: 'proxy.parameterProxy',

    buildUrl: function(request) {
        return this.substituteParameters(this.callParent(arguments), request);
    },

    substituteParameters: function(url, request) {
        return url.replace(/{(.*?)}/g, function(full, capture) {
            var index = capture.indexOf('.');
            var dataValue;

            if (index === -1) {
                dataValue = request._operation[capture];
            }
            else {
                var obj = request._operation[capture.slice(0, index)];

                if (obj.isModel) {
                    dataValue = obj.get(capture.slice(index + 1));
                }
                else {
                    dataValue = obj[capture.slice(index + 1)];
                }
            }

            return encodeURIComponent(dataValue);
        });
    }
});
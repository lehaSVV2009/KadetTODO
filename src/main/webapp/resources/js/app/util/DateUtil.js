/**
 * Created by Alex Soroka on 11/14/2014.
 */
/**
 *  Util class for loading properties of wanted language and setting these properties to 'String' method 'translate'
 *
 * Created by Alex Soroka on 11/4/2014.
 */
Ext.define('kadetTODO.util.DateUtil', {

    signleton: true,

    getDateInFormatFromLong: function (long, format) {
        return (long)
            ? Ext.util.Format.date(new Date(long), format)
            : null;
    }

});
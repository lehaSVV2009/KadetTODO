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

    /**
     * @return String
     */
    getDateInFormatFromLong: function (long, format) {
        try {
            return (long)
                ? ((format)
                    ? Ext.util.Format.date(new Date(long), format)
                    : Ext.util.Format.date(new Date(long), "DATE_FORMAT".translate()))
                : null;
        } catch (e) {
            return null;
        }
    }

});
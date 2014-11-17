/**
 * Created by Alex Soroka on 11/17/2014.
 */
describe("Date Util test", function () {
    var me = this,
        dateUtil = null;

    beforeEach(function () {
        dateUtil = Ext.create('kadetTODO.util.DateUtil');
    });


    it('Should return null if null is in arguments', function () {

        // when
        var dateText = dateUtil.getDateInFormatFromLong(null);

        // then
        expect(dateText).toBeNull();
    });



    it('Should return date if valid long is in arguments', function () {

        // when
        var dateText = dateUtil.getDateInFormatFromLong(1231232133);

        // then
        expect(dateText).toEqual(jasmine.any(String));
    });


});

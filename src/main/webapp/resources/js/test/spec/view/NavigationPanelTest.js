/**
 * Created by Alex Soroka on 11.11.2014.
 */
describe("Navigation Controller test", function () {
    var controller = null,
        navigationPanel = null;


    beforeEach(function () {

        controller = kadetTODO.app.getController('NavigationController');
        controller.init();

        navigationPanel = controller.getView('NavigationPanel').create({id: 'todoNavigationPanel'});
        navigationPanel.initComponent();

    });


    it('Should Call Expand All method in NavigationController', function () {

        /*spyOn(controller, 'expandAll');

        // when
        navigationPanel.getDockedItems()[0].items.items[0].fireEvent('onclick');

        // then
        expect(controller.expandAll).toHaveBeenCalled();
*/
    });

});
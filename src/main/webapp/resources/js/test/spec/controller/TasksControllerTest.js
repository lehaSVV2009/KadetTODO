/**
 * Created by Alex Soroka on 11/17/2014.
 */
describe("Tasks Controller test", function () {
    var me = this,
        controller = null;

    beforeEach(function () {

        controller = kadetTODO.app.getController('TasksController');
        controller.init();

    });


    it('Should not show dialog if there are no items for deleting', function () {

        spyOn(controller, 'showAreYouSureDialog');
        controller.getTaskTable = jasmine.createSpy("getTaskTable() spy").andCallFake(function() {
            return null;
        });
        controller.getIdsArrayOfSelectedItemsFromTable = jasmine.createSpy("getIdsArrayOfSelectedItemsFromTable() spy").andCallFake(function() {
            // length = 0!
            return [];
        });

        // when
        controller.deleteTasks();

        // then
        // verify that if number of selected items = 0
        //  than dialog will not be shown
        expect(controller.showAreYouSureDialog).not.toHaveBeenCalled();

    });


    it('Should not show dialog if there are no items for deleting', function () {

        spyOn(controller, 'showAreYouSureDialog');
        controller.getTaskTable = jasmine.createSpy("getTaskTable() spy").andCallFake(function() {
            return null;
        });
        controller.getIdsArrayOfSelectedItemsFromTable = jasmine.createSpy("getIdsArrayOfSelectedItemsFromTable() spy").andCallFake(function() {
            // length = 0!
            return [];
        });

        // when
        controller.deleteTasks();

        // then
        // verify that if number of selected items = 0
        //  than dialog will not be shown
        expect(controller.showAreYouSureDialog).not.toHaveBeenCalled();

    });

    it('Should redirect to #tasks/1', function () {

        spyOn(controller, 'redirectTo');
        controller.getIdOfSelectedItemFromTable = jasmine.createSpy("getIdOfSelectedItemFromTable() spy").andCallFake(function() {
            // taskId = 1
            return 1;
        });

        // when
        controller.toViewTask();

        // then
        expect(controller.redirectTo).toHaveBeenCalledWith('tasks/1');

    });



    it('Should redirect to #tasks/2/edit', function () {

        spyOn(controller, 'redirectTo');
        controller.getIdOfSelectedItemFromTable = jasmine.createSpy("getIdOfSelectedItemFromTable() spy").andCallFake(function() {
            // taskId = 2
            return 2;
        });

        // when
        controller.toEditTask();

        // then
        expect(controller.redirectTo).toHaveBeenCalledWith('tasks/2/edit');

    });



    it('Should not redirect to any', function () {

        spyOn(controller, 'redirectTo');
        controller.getIdOfSelectedItemFromTable = jasmine.createSpy("getIdOfSelectedItemFromTable() spy").andCallFake(function() {
            return null;
        });

        // when
        controller.toEditTask();

        // then
        expect(controller.redirectTo).not.toHaveBeenCalled();

    });



});

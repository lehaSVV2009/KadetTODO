/**
 * Created by Alex Soroka on 11.11.2014.
 */
describe("Navigation Controller test", function () {
    var me = this,
        controller = null,
        navigationPanel = null;


    beforeEach(function () {

        controller = kadetTODO.app.getController('NavigationController');
        controller.init();

        navigationPanel = controller.getView('NavigationPanel').create({id: 'todoNavigationPanel'});

    });


    it('Should Expand All in Navigation Panel', function () {

        spyOn(navigationPanel, 'expandAll');

        // when
        controller.expandAll();

        // then
        expect(navigationPanel.expandAll).toHaveBeenCalled();

    });

    it('Should redirect to #tasks', function () {

        var record = getTasksRecord();
        spyOn(controller, 'redirectTo');

        // when
        controller.treeItemClick(null, record);

        expect(controller.redirectTo).toHaveBeenCalledWith('tasks');

    });


    it('Should redirect to #newTask', function () {

        var record = getNewTaskRecord();
        spyOn(controller, 'redirectTo');

        // when
        controller.treeItemClick(null, record);

        // then
        expect(controller.redirectTo).toHaveBeenCalledWith('newTask');

    });



    /**
     *  support
     */

    function getTasksRecord () {
        return {
            getDepth: function () {
                return 1;
            },
            get: function (text) {
                return "Tasks"
            }
        };
    }

    function getNewTaskRecord () {
        return {
            getDepth: function () {
                return 2;
            },
            get: function (text) {
                return "New Task"
            },
            getRefOwner: function () {
                return getTasksRecord();
            }
        }
    }
});
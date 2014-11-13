/**
 * Created by Alex Soroka on 11.11.2014.
 */
describe ("ExtJS Question App Test Suite", function () {
    var navigationPanel = null;
    var treeStore = null;
    var storeLength = -1;
    var controller = null;
    /* Setup method to be called before each Test case.*/
    beforeEach (function () {
        // Initializing the navigationPanel.
        navigationPanel = Ext.create ('kadetTODO.view.NavigationPanel');
        /*treeStore = Ext.StoreManager.lookup ('NavigationTreeStore');
        controller = Ext.create ('QAApp.controller.QuestionController');
        storeLength = treeStore.data.items.length;*/
    }); // before each

    /* Test if View is created Successfully.*/
    it ('Main View is loaded', function () {
        expect (navigationPanel != null).toBeTruthy ();
    });

  /*  *//* Test if store is loaded successfully.*//*
    it ('Store shouldn’t be null', function () {
        expect (treeStore != null).toBeTruthy();
    });

    *//* Test controller is initialized successfully.*//*
    it ('Controller shouldn’t be null', function () {
        expect (controller != null).toBeTruthy();
    });

    *//* Test if Grid in MainPanel is loaded successfully.*//*
    it ('Grid should be loaded', function () {
        expect (Ext.getCmp ("questionGrid") != null).toBeTruthy ();
    });

    *//* Test if Grid in MainPanel is loaded successfully.*//*
    it ('Store has items', function () {

        expect (treeStore.data.items.length).toBe (storeLength);
    });

    *//* Test if new item is added to store.*//*
    it ('New item should be added to store', function () {
        var record = Ext.create ("QAApp.to.Question");
        record.id = 1;
        record.question = 'Questions 3';
        treeStore.add (record);
        expect (treeStore.data.items.length).toBe (storeLength + 1);
        treeStore.removeAt (storeLength);
    });

    *//* Item should be removed from store via controller.*//*
    it ('Item should be removed from store', function () {
        var record = Ext.create ("QAApp.to.Question");
        record.id = 1;
        record.question = 'Questions 3';
        treeStore.add (record);

        *//* Removing item from controller API.*//*
        controller.deleteQuestionFromStore(record);
        treeStore.removeAt (storeLength);
        expect (treeStore.data.items.length).toBe (storeLength);
    });*/

});
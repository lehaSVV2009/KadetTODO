/**
 * Controller of main Tree Panel
 * Parses text of clicked record in the tree and redirect to definite url
 *
 * Created by Alex Soroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.NavigationController', {

    extend: 'Ext.app.Controller',

    stores: ['NavigationTreeStore'],
    models: [],
    views: ['NavigationPanel'],
    refs: [
        {
            ref: 'navigationPanel',
            selector: 'todoNavigationPanel'
        }
    ],

    init: function () {
        this.control({
            'todoNavigationPanel button[action=expandAll]': {
                click: this.expandAll
            },
            'todoNavigationPanel button[action=collapseAll]': {
                click: this.collapseAll
            },
            'todoNavigationPanel': {
                itemClick: this.treeItemClick
            }
        });
    },

    /**
     *  Expand all the tree nodes
     */
    expandAll: function () {
        var navigationPanel = this.getNavigationPanel();
        navigationPanel.expandAll();
    },


    /**
     *  Collapse all the tree nodes
     */
    collapseAll: function () {
        var navigationPanel = this.getNavigationPanel();
        navigationPanel.collapseAll();
    },

    /**
     *  On tree item click
     * @param view      tree
     * @param record    clicked record (has item text)
     */
    treeItemClick: function (view, record) {

        this.parsePath(record);

    },


    /**
     *  Parses path to clicked item and make redirect to appropriate url
     *
     * @param record
     */
    parsePath: function (record) {

        var recordDepth = record.getDepth();
        if (recordDepth == 1) {
            this.parseRootEntities(record);
        } else if (recordDepth == 2) {
            this.parseSecondLevel(record);
        }

    },

    /**
     *  Parse first level items
     *  ( MyPage, Tasks )
     *
     * @param record
     */
    parseRootEntities: function (record) {
        if (this.isMyPage(record)) {
            this.redirectTo(
                this.createMyPageUrl());
        } else if(this.isTasks(record)) {
            this.redirectTo(
                this.createTasksUrl()
            );
        }
    },

    isMyPage: function (record) {
        return record.get('text') == ('TREE_MY_PAGE'.translate());
    },

    isTasks: function (record) {
        return record.get('text') == ('TREE_TASKS'.translate());
    },



    /**
     *  Parse second level items
     *  ( My Tasks, New Task )
     *
     */
    parseSecondLevel: function (record) {
        if (this.isMyTasks(record)) {
            this.redirectTo(
                this.createMyTasksUrl()
            );
        } else if (this.isNewTask(record)) {
            this.redirectTo(
                this.createNewTaskUrl()
            );
        }
    },


    isMyTasks: function (record) {
        return (record.get('text') == ('TREE_MY_TASKS'.translate()))
            && (record.getRefOwner().getDepth() == 1)
            && this.isMyPage(record.getRefOwner());
    },

    isNewTask: function (record) {
        return (record.get('text') == ('TREE_NEW_TASK'.translate()))
            && (record.getRefOwner().getDepth() == 1)
            && this.isTasks(record.getRefOwner());
    },



    /**
     *  URL Building methods
     */

    createMyPageUrl: function () {
        return 'myPage';
    },

    createMyTasksUrl: function () {
        return this.createMyPageUrl() + "/myTasks";
    },

    createTasksUrl: function () {
        return 'tasks';
    },

    createNewTaskUrl: function () {
        return this.createTasksUrl() + "/newTask";
    }

});

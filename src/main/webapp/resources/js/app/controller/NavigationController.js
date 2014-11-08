/**
 * Created by AlexSoroka on 11/1/2014.
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
            'todoNavigationPanel button[text=Expand All]': {
                click: this.expandAll
            },
            'todoNavigationPanel button[text=Collapse All]': {
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


    treeItemClick: function (view, record, item, index, e, eOpts) {

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
        } else if (recordDepth == 3) {
            this.parseThirdLevel(record);
        }

    },

    /**
     *  Parse first level items
     *
     * @param record
     */
    parseRootEntities: function (record) {
        if (this.isMyPage(record)) {
            this.redirectTo(
                this.createMyPageUrl());
        } else if (this.isProjects(record)) {
            this.redirectTo(
                this.createProjectsUrl());
        }
    },

    isMyPage: function (record) {
        return record.get('text') == ('TREE_MY_PAGE'.translate());
    },

    isProjects: function (record) {
        return record.get('text') == ('TREE_PROJECTS'.translate());
    },

    /**
     *  Parse second level items
     *
     * @param record
     */
    parseSecondLevel: function (record) {
        if (this.isMyTasks(record)) {
            this.redirectTo(
                this.createMyTasksUrl());
        } else if (this.isProject(record)) {
            this.redirectTo(
                this.createProjectUrl(record.get("entityId")));
        }
    },

    isMyTasks: function (record) {
        return (record.get('text') == ('TREE_MY_TASKS'.translate()))
            && (record.getRefOwner().getDepth() == 1)
            && this.isMyPage(record.getRefOwner());
    },

    isProject: function (record) {
        return (record.getRefOwner().getDepth() == 1)
            && this.isProjects(record.getRefOwner());
    },


    /**
     *  Parse third level items
     *
     * @param record
     */
    parseThirdLevel: function (record) {
        if (this.isProjectTasks(record)) {
            this.redirectTo(
                this.createProjectTasksUrl(record.getRefOwner().get('entityId')));
        } else if (this.isProjectEmployees(record)) {
            this.redirectTo(
                this.createProjectEmployeesUrl(record.getRefOwner().get('entityId')));
        }
    },

    isProjectTasks: function (record) {
        return (record.get('text') == ('TREE_TASKS'.translate()))
            && this.isProject(record.getRefOwner());
    },

    isProjectEmployees: function (record) {
        return (record.get('text') == ('TREE_EMPLOYEES'.translate()))
            && this.isProject(record.getRefOwner());
    },

    createProjectsUrl: function () {
        return 'projects';
    },

    createProjectUrl: function (projectId) {
        return this.createProjectsUrl() + '/' + projectId;
    },

    createProjectTasksUrl: function (projectId) {
        return this.createProjectUrl(projectId) + '/tasks';
    },

    createProjectEmployeesUrl: function (projectId) {
        return this.createProjectUrl(projectId) + '/employees';
    },

    createMyPageUrl: function () {
        return 'myPage';
    },

    createMyTasksUrl: function () {
        return this.createMyPageUrl() + "/myTasks";
    }

});

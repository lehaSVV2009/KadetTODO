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


    treeItemClick: function (view, record) {

        var itemTitle = record.get('text');
        if (itemTitle == 'Projects') {
            this.redirectTo('projects');
        }
        if (itemTitle == 'Employees') {
            this.redirectTo('employees');
        }
    }

});

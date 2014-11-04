/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.controller.NavigationController', {

    extend: 'Ext.app.Controller',

    stores: ['NavigationTreeStore', 'ProjectStore'],
    models: [],
    views: ['NavigationPanel', 'TabPanel', 'panel.ProjectsPanel'],
    refs: [
        {
            ref: 'navigationPanel',
            selector: 'todoNavigationPanel'
        },
        {
            ref: 'tabPanel',
            selector: 'todoTabPanel'
        }
    ],

   /* routes: {
        'projects': 'onProjects',
        'myPage': 'onMyPage'
    },
*/
    init: function () {
        this.control({
//            'viewport': {
//                render: this.onPanelRendered
//            },
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

  /*  onProjects: function () {
        console.log("onProjects");
    },

    onMyPage: function () {
        console.log('onMyPage');
    },
*/
    onPanelRendered: function () {
        //just a console log to show when the panel si rendered
        console.log('The panel was rendered');
    },

    expandAll: function () {
        //expand all the Tree Nodes
        var navigationPanel = this.getNavigationPanel();
        navigationPanel.expandAll();
    },

    collapseAll: function () {
        //expand all the Tree Nodes
        var navigationPanel = this.getNavigationPanel();
        navigationPanel.collapseAll();
    },

    treeItemClick: function (view, record) {
        var tabPanel = this.getTabPanel();
        //some node in the tree was clicked
        //you have now access to the node record and the tree view

        var newTabTitle = record.get('text');

        var tab = tabPanel.items.find(function (item) {
            return item.title === newTabTitle;
        });
        if (!tab) {

            if (newTabTitle == 'Projects') {
                var newTabPanel = Ext.create('Ext.panel.Panel', {
                    xtype: 'gridPanel',
                    title: record.get('text'),
                    items : [{
                        xtype: 'projectsPanel'
                    }],
                    closable: true
                });
                tabPanel.add(newTabPanel);
                tabPanel.setActiveTab(newTabPanel);
            }

            /*if (newTabTitle == 'Projects') {
                this.redirectTo('projects');
            } else {
                this.redirectTo('myPage');
            }*/

            /*Ext.each(tabPanel.getTabBar().items, function (item) {
             console.log(item);
             if (item.title == newTabTitle) {
             hasSuchName = true;
             }
             });*/


/*

            Ext.getBody().mask();

            Ext.Ajax.request({

                url: ('/api/projects/' + newTabTitle),
                method: "GET",
                success: function (response, opts) {
                    newTabPanel.update(response.responseText);
                    tabPanel.add(newTabPanel);
                    tabPanel.setActiveTab(newTabPanel);
                    Ext.getBody().unmask();
                },
                failure: function (request) {
                    Ext.MessageBox.show({title: 'Error', msg: "Can't make a request: " + request, buttons: Ext.MessageBox.OK});
                    Ext.getBody().unmask();
                }

            });
*/

        }

    }
});
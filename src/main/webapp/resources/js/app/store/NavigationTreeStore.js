/**
 * Created by AlexSoroka on 11/1/2014.
 */
Ext.define('kadetTODO.store.NavigationTreeStore', {

    extend: 'Ext.data.TreeStore',
    fields: ['text'],

    proxy: {
        type: 'ajax',
        url: "/api/tree"
    },

    root: {
        expanded: true,
        id: 'navigationTree'
        /*
         children: [
         {
         text: 'Projects',
         children: [
         {
         text: 'AAA',
         children: [
         {
         text: 'Tasks',
         children: [
         {
         text: '123',
         leaf: true
         }
         ]
         },
         {
         text: 'Employees',
         children: [
         {
         text: 'Alex',
         leaf: true
         }
         ]
         }
         ]
         },
         {
         text: 'BBB',
         children: [
         {
         text: 'Tasks',
         children: [
         {
         text: 'xxx',
         leaf: true
         }
         ]
         },
         {
         text: 'Employees',
         children: [
         {
         text: 'Sergey',
         leaf: true
         },
         {
         text: 'Alex',
         leaf: true
         }
         ]
         }
         ]
         }


         ]
         }
         ]
         */
    },

    folderSort: true,
    sorters: [
        {
            property: 'text',
            direction: 'ASC'
        }
    ]

});
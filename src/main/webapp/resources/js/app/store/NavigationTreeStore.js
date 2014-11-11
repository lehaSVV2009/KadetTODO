/**
 * Load tree by url
 *
 * Has the following structure:
 * Root {
 *    text : 'text',
 *    children: [
 *      {
 *          text: 'child1',
 *          id: 'id1',
 *          leaf: false,
 *          children: [
 *              {
 *                  text: 'child11',
 *                  id: 'id3',
 *                  leaf: true
 *              }
 *          ]
 *      },
 *      {
 *          text: 'child2',
 *          id: 'id2',
 *          leaf: true
 *      }
 *    ]
 * }
 *
 * Created by Alex Soroka on 11/1/2014.
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
    },

    folderSort: true,
    sorters: [
        {
            property: 'text',
            direction: 'ASC'
        }
    ]

});
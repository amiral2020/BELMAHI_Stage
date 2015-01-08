Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.panel.*',
    'Ext.layout.container.Border'
]);

/**
     * App.BookGrid
     * @extends Ext.grid.Panel
     * This is a custom grid which will display book information. It is tied to
     * a specific record definition by the dataIndex properties.
     *
     * It follows a very custom pattern used only when extending Ext.Components
     * in which you can omit the constructor.
     *
     * It also registers the class with the Component Manager with an xtype of
     * bookgrid. This allows the application to take care of the lazy-instatiation
     * facilities provided in Ext's Component Model.
     */
    Ext.define('App.BookGrid', {
        extend: 'Ext.grid.Panel',
        // This will associate an string representation of a class
        // (called an xtype) with the Component Manager
        // It allows you to support lazy instantiation of your components
        alias: 'widget.bookgrid',

        // override
        initComponent : function() {
            // Pass in a column model definition
            // Note that the DetailPageURL was defined in the record definition but is not used
            // here. That is okay.
            this.columns = [
                {text: "Author", width: 120, dataIndex: 'Author', sortable: true},
                {text: "Title", flex: 1, dataIndex: 'Title', sortable: true},
                {text: "Manufacturer", width: 115, dataIndex: 'Manufacturer', sortable: true},
                {text: "Product Group", width: 100, dataIndex: 'ProductGroup', sortable: true}
            ];
            // Note the use of a storeId, this will register thisStore
            // with the StoreManager and allow us to retrieve it very easily.
            this.store = new App.BookStore({
                storeId: 'gridBookStore',
                url: 'sheldon.xml'
            });
            // finally call the superclasses implementation
            this.callParent();
        }
    });
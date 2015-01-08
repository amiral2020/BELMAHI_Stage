Ext.define('Book',{
    extend: 'Ext.data.Model',
    fields: [
        // set up the fields mapping into the xml doc
        // The first needs mapping, the others are very basic
        {name: 'Author', mapping: 'ItemAttributes > Author'},
        'Title',
        'Manufacturer',
        'ProductGroup',
        'DetailPageURL'
    ]
});

/**
 * App.BookStore
 * @extends Ext.data.Store
 * @cfg {String} url This will be a url of a location to load the BookStore
 * This is a specialized Store which maintains books.
 * It already knows about Amazon's XML definition and will expose the following
 * Record defintion:
 *  - Author
 *  - Manufacturer
 *  - ProductGroup
 *  - DetailPageURL
 */
Ext.define('App.BookStore', {
    extend: 'Ext.data.Store',
    constructor: function(config) {
        config = config || {};

        config.model = 'Book';
        config.proxy = {
            type: 'ajax',
            url: 'sheldon.xml',
            reader: Ext.create('Ext.data.reader.Xml', {
                // records will have an "Item" tag
                record: 'Item',
                id: 'ASIN',
                totalRecords: '@total'
            })
        };

        // call the superclass's constructor
        this.callParent([config]);
    }
});

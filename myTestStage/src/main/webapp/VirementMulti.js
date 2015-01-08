Ext.Loader.setPath('ExtJSWebSpring', '/js/MyApp');
Ext.Loader.setConfig({
    enabled: true
});

//Finally now that we've defined all of our classes we can instantiate
//an instance of the app and renderTo an existing div called 'binding-example'
//Note now that classes have encapsulated this behavior we can easily create
//an instance of this app to be used in many different contexts, you could
//easily place this application in an Ext.Window for example
//Ext.onReady(function() {
//	// create an instance of the app
//	var bookApp = new App.BookMasterDetail({
//		renderTo : 'binding-example'
//	});
//	// We can retrieve a reference to the data store
//	// via the StoreManager by its storeId
//	Ext.data.StoreManager.get('gridBookStore').load();
//});
Ext.application({
	
//	requires : ['ExtJSWebSpring.view.Login'],
//	views : ['Login'],
	
	controllers : ['VirementMultiController'],
	
	name : 'ExtJSWebSpring',
	
	appFolder: '../app',
	
	launch : function() {

		splashscreen = Ext.getBody().mask('Loading application', 'splashscreen');
		
		var task = new Ext.util.DelayedTask(function() {
			splashscreen.fadeOut({
				duration : 1000,
				remove : true
			});
			
			splashscreen.next().fadeOut({
				duration : 1000,
				remove : true,
				listeners : {
					afteranimate : function(el, startTime, eOpts){
						// create an instance of the app
						var bookApp = new App.BookMasterDetail({
							renderTo : 'binding-example'
						});
						// We can retrieve a reference to the data store
						// via the StoreManager by its storeId
						Ext.data.StoreManager.get('gridBookStore').load();
					}
				}
			});
			console.log('App launched ...')
		
		}
		
		);
		
		task.delay(2000);
		
	},
	init : function(){
		console.log('app init ...');
		splashscreen = Ext.getBody().mask('Loading application', 'splashscreen');
		
	}
})
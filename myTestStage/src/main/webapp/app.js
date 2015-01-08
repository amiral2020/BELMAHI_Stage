Ext.Loader.setPath('ExtJSWebSpring', '/js/MyApp');
Ext.Loader.setConfig({
    enabled: true
});
Ext.Loader.setPath('Ext.ux', '../ux');


Ext.application({
	
//	requires : ['ExtJSWebSpring.view.Login'],
//	views : ['Login'],
	
	controllers : ['LoginController'],
	
	name : 'ExtJSWebSpring',
	
	appFolder: 'app',
	
	launch : function() {

//		splashscreen = Ext.getBody().mask('Loading application', 'splashscreen');
		
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
						Ext.widget('login');
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
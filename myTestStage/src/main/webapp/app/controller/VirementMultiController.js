
Ext.define('ExtJSWebSpring.controller.VirementMultiController', {
	extend : 'Ext.app.Controller',
	
	model : ['Beneficiare'],
	views : [ 'VirementMultiView' ],
	
	init : function(application){
		console.log('init');
	}
})
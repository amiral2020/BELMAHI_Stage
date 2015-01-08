Ext.onReady(function(){

	var ta = new Ext.form.TextArea({
		width: 370,
		hideLabel: true
	});

	
	
	var plugin = new Ext.ux.plugins.VirtualKeyboard();
	
	plugin.on({
		expand: function(plugin){
			if(console)
				console.log('Keyboard expanded');
		},
		collapse: function(plugin){
			if(console)
				console.log('Keyboard collapsed');
		},
		scope: this
	});
	
	new Ext.FormPanel({
		title: "Merci d'entre votre mot de passe correct",
		labelWidth: 75, // label settings here cascade unless overridden
		bodyStyle:'padding:5px 5px 0',
		width: 350,
		frame: true,
		renderTo: 'virtualkeyboard-form',
		defaults: {width: 230},
		defaultType: 'textfield',
		items: [{
				fieldLabel: 'French',
				id : 'passwordField',
				allowBlank:false,
				anchor: '-40',
				inputType : 'password',
				allowBlank: false,
				maxLength : 12,
				keyboardConfig: {
					language: 'French',
					showIcon: true
				},
				plugins: plugin
			}
		],

		buttons: [{
			text: 'Comfirmer et signer',
				
			listeners : {
					click : function(){
						
						var password = Ext.getCmp('passwordField').value;
						var i = window.location.pathname.lastIndexOf('/')
						var idVirement = window.location.pathname.substring(i+1,window.location.pathname.length);
						console.log(password);
						idVirement = parseInt(idVirement);
						
						Ext.Ajax.request({
         	        	    url: '../virmentMultiple/signer',
//          	        	   dataType: 'json'
       	        	        method : "POST",
//        	        	        ,contentType: "application/json; charset=utf-8",
//          	        	    params: Ext.JSON.encode(gridData)
							jsonData : {"idVirement": idVirement,
								"password" : password}
         	        	    ,
         	        	   failure : function(conn, response, option, eOpts){

         						Ext.Msg.show({
         							title : 'Server Error',
         							msg : conn.responseText,
         							icon : Ext.Msg.ERROR,
         							buttons : Ext.Msg.OK
         						});
         					},
         					success : function(conn, response, option, eOpts){
         						var result = Ext.JSON.decode(conn.responseText, true);
         						if (result.genericResponse.success){
         							Ext.Msg.show({
         								title : 'Virment validé ...',
         								msg : result.genericResponse.message,
										
         								buttons : Ext.Msg.OK,
         								fn : function(btn) {
         									if (btn == 'ok') {
         										console.log('click el');
          										open('..','_top');
         									}
         								}
         							});
         						}else{
         							Ext.Msg.show({
         								title : 'Virement non comfirmer',
         								msg : result.genericResponse.message,
         								icon : Ext.Msg.ERROR,
         								buttons : Ext.Msg.OK
         							});
         						}
         					}
         	        	});
					}
				}
		}/*,{
			text: 'Cancel'
		}*/]
	});
	
});
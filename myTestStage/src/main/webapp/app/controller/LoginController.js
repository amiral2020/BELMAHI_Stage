Ext.define('ExtJSWebSpring.controller.LoginController', {
	extend : 'Ext.app.Controller',
	
	views : [ 'Login' ],
	
	init : function(application){
		this.control({
			"login form button#submit" : {
				click : this.buttonSubmit
			},
			"login form button#cancel" : {
				click : this.buttonCancel
			}
		});
	},
	
	buttonSubmit : function (button, e, options){
		console.log('Submit button');
		var formPanel = button.up('form');
		var login = button.up('login');
		var username = formPanel.down('textfield[name=username]').getValue();
		var password = formPanel.down('textfield[name=password]').getValue();
		
		
		
		if(formPanel.getForm().isValid()){
			
//			open('POST', 'j_spring_security_check', {request: {username : username, password : password}}, _self);
			
			Ext.Ajax.request({
				url : 'j_spring_security_check',
				params : {
					username : username,
					password : password
				},
				
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
							title : 'Login successful ...',
							msg : result.genericResponse.message,
							buttons : Ext.Msg.OK,
							fn : function(btn) {
								if (btn == 'ok') {
									console.log('click el');
									open('compte','_top');
								}
							}
						});
					}else{
						Ext.Msg.show({
							title : 'Login Failed',
							msg : result.genericResponse.message,
							icon : Ext.Msg.ERROR,
							buttons : Ext.Msg.OK
						});
					}
				}
			});
		}
	},
	
	buttonCancel : function(button, e, options){
		console.log('Cancel button');
		button.up('form').getForm().reset();
	}
})
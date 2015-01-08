var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

Ext.define('ExtJSWebSpring.view.Login', {
	extend : 'Ext.window.Window',
	alias : 'widget.login', 
	autoShow : true,
	height : 170,
	width : 400,
	resizable : false
	,
	layout : {
		type : 'fit'
	},
	title : 'Login form',
	closeAction : 'hide',
	closeable : false,
    items : [{
		xtype : 'form',
		frame : false,
		bodyPadding : 15,
		defaults : {
			xtype : 'textfield',
			anchor : '100%',
			labelWidth : 60,
			allowBank : false,
			vtype : 'alphanum',
			minLength : 4,
			maxLength : 30,
			msgTarget : 'under'
		},
		
		items : [{
			name : 'username',
			itemId : 'user',
			fieldLabel : 'Username',
			allowBlank: false,
			maxLength : 25
		}, {
			name : 'password',
			itemId : 'password',
			fieldLabel : 'Password',
			inputType : 'password',
			allowBlank: false,
			maxLength : 12
		}],
		dockedItems : [{
			xtype : 'toolbar',
			dock : 'bottom',
			items : [{
				xtype : 'tbfill'
			}, {
				xtype : 'button',
				itemId : 'cancel',
				text : 'Annuler'
			}, {
				xtype : 'button',
				itemId : 'submit',
				text : 'Se connecter',
				formBind : true
			}]
		}]
	}]
})
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value='j_spring_security_check' />
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>My App web</title>
<!-- ExtJS import -->
<%-- <link rel="stylesheet" type="text/css" href='<spring:url value="/extjs/ext-all.css" htmlEscape="true"/>' /> --%>
<link rel="stylesheet" type="text/css" href='http://cdn.sencha.com/ext/gpl/4.1.1/resources/css/ext-all.css' />
<%-- <script type="text/javascript" src='<spring:url value="/extjs/ext-all-debug.js" htmlEscape="true"/>'></script> --%>
<script type="text/javascript" src='http://cdn.sencha.com/ext/gpl/4.1.1/ext-all-debug.js'></script>
<script type="text/javascript" src='<spring:url value="/extjs/ext-lang-fr.js" htmlEscape="true"/>'></script>

<!-- Our script -->
<script type="text/javascript" src='<spring:url value="/app/model/BeneficiaireModel.js" htmlEscape="true"/>'></script>
<script type="text/javascript" src='<spring:url value="/app/view/VirementMultiView.js" htmlEscape="true"/>'></script>
<!-- <script type="text/javascript" src="app/controller/VirementMultiView.js"></script> -->
<script type="text/javascript" src='<spring:url value="/VirementMulti.js" htmlEscape="true"/>'></script>
<script type="text/javascript" src='<spring:url value="/shared/examples.js" htmlEscape="true"/>'></script>
<!-- <script type="text/javascript" src="array-grid.js"></script> -->
</head>
<body>

<a href='<spring:url value="/logout" />'>Se Déconnecter</a><br />

<div id="panel">
</div>


<script type="text/javascript">
Ext.require([
             'Ext.form.field.ComboBox',
             'Ext.form.FieldSet',
             'Ext.tip.QuickTipManager',
             'Ext.data.*'
         ]);

         // Define the model for a State
         Ext.define('State', {
             extend: 'Ext.data.Model',
             fields: [
                 {type: 'string', name: 'abbr'},
                 {type: 'string', name: 'name'},
                 {type: 'string', name: 'slogan'}
             ]
         });


         //compte
         Ext.define('Compte', {
             extend: 'Ext.data.Model',
             fields: [
                 {type: 'int', name: 'idCompte'},
                 {type: 'string', name: 'numeroCompte'},
                 {type: 'string', name: 'intitule'},
                 {type: 'int', name: 'soldeComptable'}
             ]
         });

         var store_ComptesList = Ext.create('Ext.data.Store', {
             model: 'Compte',
             proxy: {
                 // load using HTTP
                 type: 'ajax',
                 url: 'rest/getComptes',
                 // the return will be XML, so lets set up a reader
                 reader: {
                     type: 'json',
//                      record: 'Item',
                     root: 'compteList',
                     totalProperty  : 'total'
                 }
             },
             autoLoad: true
         });
         
         
Ext.require([
             'Ext.grid.*',
             'Ext.data.*',
             'Ext.panel.*',
             'Ext.Date',
             'Ext.layout.container.Border'
         ]);
         
Ext.example.shortBogusMarkup = '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, '+
'sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales '+
'non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet '+
'tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla.</p>';


Ext.require([
             'Ext.grid.*',
             'Ext.data.*',
             'Ext.dd.*'
         ]);
var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
Ext.require([
             'Ext.grid.*',
             'Ext.data.*',
             'Ext.form.field.Number',
             'Ext.form.field.Date',
             'Ext.tip.QuickTipManager'
         ]);

Ext.require([
             'Ext.form.*',
             'Ext.tip.QuickTipManager'
         ]);
         Ext.define('DataObject', {
             extend: 'Ext.data.Model',
             fields: ['name', 'column1', 'column2']
         });


         Ext.onReady(function(){
        	 
        	 Ext.tip.QuickTipManager.init();
        	    
        	    

        	    var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
        	        clicksToEdit: 1
        	    });
        	    
        	    
        	    
        	    //for the date range 
        	     // Add the additional 'advanced' VTypes
    Ext.apply(Ext.form.field.VTypes, {
        daterange: function(val, field) {
            var date = field.parseDate(val);

            if (!date) {
                return false;
            }
            if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
                var start = field.up('form').down('#' + field.startDateField);
                start.setMaxValue(date);
                start.validate();
                this.dateRangeMax = date;
            }
            else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
                var end = field.up('form').down('#' + field.endDateField);
                end.setMinValue(date);
                end.validate();
                this.dateRangeMin = date;
            }
            /*
             * Always return true since we're only using this vtype to set the
             * min/max allowed values (these are tested for after the vtype test)
             */
            return true;
        },

        daterangeText: 'Start date must be less than end date',

        password: function(val, field) {
            if (field.initialPassField) {
                var pwd = field.up('form').down('#' + field.initialPassField);
                return (val == pwd.getValue());
            }
            return true;
        },

        passwordText: 'Passwords do not match'
    });
    
    Ext.tip.QuickTipManager.init();

        	    
        	    
        	    
        	    

						//model custom
						Ext.define('Beneficiaire', {
			             extend: 'Ext.data.Model',
			             fields: ['idBeneficiaire', 'nom', 'prenom','numeroCompte','montant']
			         });
						// create the Data Store
			             var store_BeneficiairesList = Ext.create('Ext.data.Store', {
			                 model: 'Beneficiaire',
			                 proxy: {
			                     // load using HTTP
			                     type: 'ajax',
			                     url: 'rest/getBeneficiaires',
			                     // the return will be XML, so lets set up a reader
			                     reader: {
			                         type: 'json',
// 			                         record: 'Item',
			                         root: 'beneficiaireList',
			                         totalProperty  : 'total'
			                     }
			                 },
			                 autoLoad: true
			             });

// 			             store_BeneficiairesList.load();
							
        	           // create the data store
        	           var firstGridStore = Ext.create('Ext.data.Store', {
        	               model: 'Beneficiaire',
        	               data: store_BeneficiairesList
        	           });


        	           // Column Model shortcut array
        	           var columns = [
        	               {text: "Identifiant", flex: 1, width: 70, sortable: true, dataIndex: 'idBeneficiaire'},
        	               {text: "Nom & Prénom", width: 160, sortable: true, dataIndex: 'nom'},
        	               {text: "Numéro du compte", width: 160, sortable: true, dataIndex: 'numeroCompte'}
        	           ];
        	           // Column Model shortcut array
        	           var columns_bVirement = [
        	               {text: "Identifiant", flex: 1, width: 70, sortable: true, dataIndex: 'idBeneficiaire'},
        	               {text: "Nom & Prénom", width: 150, sortable: true, dataIndex: 'nom'},
        	               {text: "Numéro du compte", width: 150, sortable: true, dataIndex: 'numeroCompte'},
        	               {text: "Montant", width: 70, sortable: true, dataIndex: 'montant', editor: {
        	                   xtype: 'numberfield',
        	                   allowBlank: false,
        	                   minValue: 1,
        	                   maxValue: 150000
        	               }}
        	           ];

        	           // declare the source Grid
        	           var firstGrid = Ext.create('Ext.grid.Panel', {
        	               multiSelect: true,
//         	               plugins: [cellEditing],
        	               viewConfig: {
        	                   plugins: {
        	                       ptype: 'gridviewdragdrop',
        	                       dragGroup: 'firstGridDDGroup',
        	                       dropGroup: 'secondGridDDGroup'
        	                   },
        	                   listeners: {
        	                       drop: function(node, data, dropRec, dropPosition) {
        	                           var dropOn = dropRec ? ' ' + dropPosition + ' ' + dropRec.get('name') : ' on empty view';
        	                           Ext.example.msg("Drag from right to left", 'Dropped ' + data.records[0].get('name') + dropOn);
        	                       }
        	                   }
        	               },
        	               store            : store_BeneficiairesList,
        	               columns          : columns,
        	               stripeRows       : true,
        	               title            : 'Liste des bénéficiaires',
        	               margins          : '0 2 0 0'
        	           });

        	           var secondGridStore = Ext.create('Ext.data.Store', {
        	               model: 'DataObject'
        	           });

        	           // create the destination Grid
        	           var secondGrid = Ext.create('Ext.grid.Panel', {
        	        	   plugins: [cellEditing],
        	               viewConfig: {
        	                   plugins: {
        	                       ptype: 'gridviewdragdrop',
        	                       dragGroup: 'secondGridDDGroup',
        	                       dropGroup: 'firstGridDDGroup'
        	                   },
        	                   listeners: {
        	                       drop: function(node, data, dropRec, dropPosition) {
        	                           var dropOn = dropRec ? ' ' + dropPosition + ' ' + dropRec.get('name') : ' on empty view';
        	                           Ext.example.msg("Drag from left to right", 'Dropped ' + data.records[0].get('name') + dropOn);
        	                       }
        	                   }
        	               },
        	               store            : secondGridStore,
        	               columns          : columns_bVirement,
//         	               stripeRows       : true,
        	               title            : 'Bénéficiaire des virements',
        	               margins          : '0 0 0 3'
        	           });

        	           //Simple 'border layout' panel to house both grids
//         	           var displayPanel = Ext.create('Ext.Panel', {
//         	               width        : 650,
//         	               height       : 300,
//         	               layout       : {
//         	                   type: 'hbox',
//         	                   align: 'stretch',
//         	                   padding: 5
//         	               },
//         	               renderTo     : 'panel',
//         	               defaults     : { flex : 1 }, //auto stretch
//         	               items        : [
//         	                   firstGrid,
//         	                   secondGrid
//         	               ],
//         	               dockedItems: {
//         	                   xtype: 'toolbar',
//         	                   dock: 'bottom',
//         	                   items: ['->', // Fill
//         	                   {
//         	                       text: 'Reset both grids',
//         	                       handler: function(){
//         	                           //refresh source grid
//         	                           firstGridStore.loadData(myData);

//         	                           //purge destination grid
//         	                           secondGridStore.removeAll();
//         	                       }
//         	                   }]
//         	               }
//         	           });
        	 
        	 var viewport = Ext.create('Ext.Viewport', {
                 layout:'border',
                 items:[/* {
                     region:'west',
                     id:'west-panel',
                     title:'West',
                     split:true,
                     width: 200,
                     minSize: 175,
                     maxSize: 400,
                     collapsible: true,
                     margins:'35 0 5 5',
                     cmargins:'35 5 5 5',
                     layout:'accordion',
                     layoutConfig:{
                         animate:true
                     },
                     items: [{
                         html: Ext.example.shortBogusMarkup,
                         title:'Navigation',
                         autoScroll:true,
                         border:false,
                         iconCls:'nav'
                     },{
                         title:'Settings',
                         html: Ext.example.shortBogusMarkup,
                         border:false,
                         autoScroll:true,
                         iconCls:'settings'
                     }]
                 }, */{
                     region:'center',
                     margins:'0 5 5 0',
                     layout:'column',
                     autoScroll:true,
                     defaults: {
                         layout: 'anchor',
                         defaults: {
                             anchor: '100%'
                         }
                     },
                     items: [{
//                          columnWidth: 1/2,
                         baseCls:'y-plain',
                         bodyStyle:'padding:10px 10 10px 10px',
                         items:[ {
                             title: 'Choisir le bénéficiaire'
//                              html: Ext.example.shortBogusMarkup

                         },
                         
                       //Simple 'border layout' panel to house both grids
                         displayPanel = Ext.create('Ext.Panel', {
                             width        : 900,
                             height       : 300,
                             layout       : {
                                 type: 'hbox',
                                 align: 'stretch',
                                 padding: 5
                             },
//                              renderTo     : 'panel',
                             defaults     : { flex : 1 }, //auto stretch
                             items        : [
                                 firstGrid,
                                 secondGrid
                             ],
                             dockedItems: {
                                 xtype: 'toolbar',
                                 dock: 'bottom',
                                 items: ['->', // Fill
                                 {
                                     text: 'Initialiser les tables',
                                     handler: function(){
                                         //refresh source grid
//                                          firstGridStore.loadData(store_BeneficiairesList);
                                         store_BeneficiairesList.load()

                                         //purge destination grid
                                         secondGridStore.removeAll();
                                     }
                                 }]
                             }
                         }),
                         {
                             title: 'Spécification du virement multiple',
//                              html: Ext.example.shortBogusMarkup,
								
 xtype: 'form',
        id: 'virementForm',
        collapsible: true,
        bodyPadding: 20,
        width: 600,
        fieldDefaults: {
            labelAlign: 'top',
            msgTarget: 'side'
        },
        defaults: {
            anchor: '100%'
        },

        items: [{
            xtype: 'container',
            layout:'hbox',
            items:[{
                xtype: 'container',
                flex: 1,
                border:false,
                layout: 'anchor',
                defaultType: 'textfield',
                items: [
//                         {
//                     fieldLabel: 'Choisir un compte ',
                    
//                     name: 'yourComte',
//                     anchor:'95%'
//                 }
                simpleCombo = Ext.create('Ext.form.field.ComboBox', {
                    fieldLabel: 'Choisir un compte ',
                    afterLabelTextTpl: required,
//                     renderTo: 'simpleCombo',
                    displayField: 'intitule',
                    width: 220,
                    labelWidth: 130,
                    allowBlank:false,
                    store: store_ComptesList,
                    queryMode: 'local',
                    typeAhead: true
                    /* validator: function(value){
                    	var compte = store_ComptesList.findRecord("intitule", value)
                    	console.log(compte.data.soldeComptable);
                        if(1 != 9) {
                            return 'Solde du compte non sufisant';
                        } else {
                            return true;
                        }
                    } */
                })
                , /* {
                    fieldLabel: 'Date d\'exécution ',
                    name: 'theDate2',
                    xtype: 'datefield',
                    anchor:'95%'
                } */
                {
                    fieldLabel: 'Motif ',
                    id: 'fieldMotif',
                    afterLabelTextTpl: required,
                    name: 'motif',
                    allowBlank:false,
//                     vtype:'textfield',
                    anchor:'95%'
                }
                
                ]
            },{
                xtype: 'container',
                flex: 1,
                layout: 'anchor',
                defaultType: 'datefield',
                items: [/* {
                    fieldLabel: 'Date de création ',
                    afterLabelTextTpl: required,
                    name: 'theDate',
                    anchor:'95%'
                } */
                {
                    fieldLabel: 'Date de création',
                    afterLabelTextTpl: required,
                    name: 'startdt',
                    itemId: 'startdt',
                    vtype: 'daterange',
                    allowBlank:false,
                    endDateField: 'enddt', // id of the end date field
                    anchor:'95%',
                    listeners : {
                        render : function(datefield) {
                            /// code to convert GMT String to date object
                            datefield.setValue(new Date());
                            datefield.setReadOnly(true);
                            }
                            }
                },{
                    fieldLabel: 'Date d\'exécution',
                    afterLabelTextTpl: required,
                    name: 'enddt',
                    itemId: 'enddt',
                    dateFormat: 'd/m/Y',
                    id : 'dateExecution',
                    allowBlank:false,
                    vtype: 'daterange',
                    startDateField: 'startdt' // id of the start date field
                    ,anchor:'95%',
                    listeners : {
                        render : function(datefield) {
                            /// code to convert GMT String to date object
                            datefield.setValue(new Date());
                                    }
                            }
                }]
            },{
                xtype: 'container',
                flex: 1,
                layout: 'anchor',
                defaultType: 'numberfield',
                items: [{
                    fieldLabel: 'Nombre de bénéficiaires ',
                    afterLabelTextTpl: required,
                    name: 'nombreBeneficiaires',
                    validator: function(value){

                    	var tourData = secondGrid.getStore().getRange();
		       	         gridData = new Array();
		       	          Ext.each(tourData, function (record) {
		       	        	    gridData.push(record.data);
		       	        	});
                        if(gridData.length != value) {
                            return 'Le nombre de bénéficiaires saisie est différent au nombre de bénéficiaires selectionnés.';
                        } else {
                            return true;
                        }
                    },
                    allowBlank:false,
                    anchor:'95%'
                },{
                    fieldLabel: 'Montant ',
                    id: 'fieldMontant',
                    afterLabelTextTpl: required,
                    name: 'motant',
                     validator: function(value){

                    	 var tourData = secondGrid.getStore().getRange();
		       	         gridData = new Array();
		       	          Ext.each(tourData, function (record) {
		       	        	    gridData.push(record.data);
		       	        	});
 						var totalMotant = 0;
 						for(i = 0; i < gridData.length; i++){
								totalMotant += gridData[i].montant;
 	 						}
                         
                        if(totalMotant != value) {
                            return 'Le montant total doit étre égal à la somme des montants des bénéficiaires.';
                        } else {
                            return true;
                        }
                    },
                    allowBlank:false,
//                     vtype:'textfield',
                    anchor:'95%'
                }]
            }]
        }]
                             
                         },
                        	 
                        	 Ext.create('Ext.Button', {
                         	    text     : 'Button',
                         	   height : 50,
                         	    renderTo : Ext.getBody(),
                         	    listeners: {
                         	        click: function() {
                         	            //this == the button, as we are in the local scope
                         	            this.setText('I was clicked!');
//                          	           console.log(secondGrid.getStore().data.items[0]);
                         	          
                         	          var form = Ext.getCmp('virementForm');
                         	          if(form.getForm().isValid()){
                         	        	 var compte = store_ComptesList.findRecord("intitule", simpleCombo.value)
                                     	console.log(compte.data.soldeComptable);
                             	          var idCompte = compte.data.idCompte; 
                         	          	var dateExecutionVal = Ext.getCmp('dateExecution').value
											console.log(dateExecution);
                             	          	var motif = Ext.getCmp('fieldMotif').value
                             	          	var montantVal = Ext.getCmp('fieldMontant').value
                         	          
                         	          var tourData = secondGrid.getStore().getRange();
//                          	          console.log(tourData);
//                          	         var 
                         	         gridData = new Array();
                         	          Ext.each(tourData, function (record) {
                         	        	    gridData.push(record.data);
                         	        	});
                         	            console.log(gridData);

                         	           Ext.Ajax.request({
                         	        	    url: 'virmentMultiple/do',
//                          	        	   dataType: 'json'
                       	        	        method : "POST",
//                        	        	        ,contentType: "application/json; charset=utf-8",
//                          	        	    params: Ext.JSON.encode(gridData)
											jsonData : {"beneficiairesDuVirement": gridData,
												"idCompte" : idCompte, "motif" : motif,
												"dateExecution" :dateExecutionVal.getDate()+"-"+(dateExecutionVal.getMonth()+1)+"-"+dateExecutionVal.getFullYear(),
												"montant" : montantVal}
                         	        	    ,
                         	        	   failure : function(conn, response, option, eOpts){
                         						console.log(response);
                         						console.log(option);
                         						console.log(eOpts);
//                          						console.log(respone);
                         						Ext.Msg.show({
                         							title : 'Server Error',
                         							msg : conn.responseText,
                         							icon : Ext.Msg.ERROR,
                         							buttons : Ext.Msg.OK
                         						});
                         					},
                         					success : function(conn, response, option, eOpts){
                         						var result = Ext.JSON.decode(conn.responseText, true);
                         						if (result.genericVirementMultiDo.success){
                         							Ext.Msg.show({
                         								title : 'Virment effuctue avec succes ...',
                         								msg : result.genericVirementMultiDo.message,
														
                         								buttons : Ext.Msg.OK,
                         								fn : function(btn) {
                         									if (btn == 'ok') {
                         										console.log('click el');

                         										open('consulterSigner/'+result.genericVirementMultiDo.idVirementMulti,'_top');
                         									}
                         								}
                         							});
                         						}else{
                         							Ext.Msg.show({
                         								title : 'Virement not effectue',
                         								msg : result.genericVirementMultiDo.message,
                         								icon : Ext.Msg.ERROR,
                         								buttons : Ext.Msg.OK
                         							});
                         						}
                         					}
                         	        	});
                         	          }
                         	        },
                         	        mouseover: function() {
                         	            //set a new config which says we moused over, if not already set
                         	            if (!this.mousedOver) {
                         	                this.mousedOver = true;
//                          	                alert('You moused over a button!\n\nI wont do this again.');
                         	            }
                         	        }
                         	    }
                         	})
                         
                         
                         ]
                     }/* ,{
                         columnWidth: 1/2,
                         baseCls:'y-plain',
                         bodyStyle:'padding:10px 10 10px 10px',
                         items:[{
                             title: 'Bénéficiaire des virements'
//                              html: Ext.example.shortBogusMarkup,
                             
                         }]
                     } */]
                 }
                 
                 ]
             });
        	 
        	 
        	 
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

             // create the Data Store
             var store = Ext.create('Ext.data.Store', {
                 model: 'Book',
                 proxy: {
                     // load using HTTP
                     type: 'ajax',
                     url: 'sheldon.xml',
                     // the return will be XML, so lets set up a reader
                     reader: {
                         type: 'xml',
                         record: 'Item',
                         totalProperty  : 'total'
                     }
                 }
             });

             // create the grid
             var grid = Ext.create('Ext.grid.Panel', {
                 store: store,
                 columns: [
                     {text: "Identifiant", width: 60, dataIndex: 'Author', sortable: true},
                     {text: "Numéro du compte", width:120 , dataIndex: 'Title', sortable: true},
                     {text: "cosulter", width: 55, dataIndex: 'Manufacturer', sortable: true}
//                      {text: "Product Group", width: 100, dataIndex: 'ProductGroup', sortable: true}
                 ],
                 forceFit: true,
                 height:180,
                 width : 300,
                 split: true,
                 region: 'north'
             });
                 
             // define a template to use for the detail view
             var bookTplMarkup = [
                 'Title: <a href="{DetailPageURL}" target="_blank">{Title}</a><br/>',
                 'Author: {Author}<br/>',
                 'Manufacturer: {Manufacturer}<br/>',
                 'Product Group: {ProductGroup}<br/>'
             ];
             var bookTpl = Ext.create('Ext.Template', bookTplMarkup);
			
/*              
             var win2 = Ext.create('widget.window', {
                 height: 400,
                 width: 700,
                 resizable : false,
                 x: 450,
                 y: 450,
                 title: 'Constraining Window, plain: true',
                 closable: false,
                 plain: true,
                 layout: 'fit',
                 items: [grid
                         , constrainedWin2 = Ext.create('Ext.Window', {
                     title: 'Header-Constrained Win',
                     width: 200,
                     height: 100,
                     x: 120,
                     y: 120,
                     constrainHeader: true,
                     layout: 'fit',
                     items: {
                         border: false
                     }
                 }),{
                     border: false
                 }]
             });
             win2.show();
             
//              constrainedWin.show();
             constrainedWin2.show(); */
             
             
//              Ext.create('Ext.Panel', {
//                  renderTo: 'binding-example',
//                  frame: true,
//                  title: 'Book List',
//                  width: 540,
//                  height: 400,
//                  layout: 'border',
//                  items: [
//                      grid
//                      /* , {
//                          id: 'detailPanel',
//                          region: 'center',
//                          bodyPadding: 7,
//                          bodyStyle: "background: #ffffff;",
//                          html: 'Please select a book to see additional details.'
//                  } */
//                      ]
//              });
             
             // update panel body on selection change
             grid.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
                 if (selectedRecord.length) {
                     var detailPanel = Ext.getCmp('detailPanel');
                     bookTpl.overwrite(detailPanel.body, selectedRecord[0].data);
                 }
             });

             store.load();
             store_BeneficiairesList.load();
             
             
             
         });
</script>

</body>
</html>
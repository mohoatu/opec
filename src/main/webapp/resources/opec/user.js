var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm mới DTU");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $('#mainSplitter').jqxSplitter({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#tableUser").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	$("#username").jqxInput('val', rowData.username);
    $("#password").jqxPasswordInput('val', rowData.password);
	$("#fullname").jqxInput('val', rowData.fullname);
	$("#donvi").jqxComboBox('val', rowData.donvi_id);
	
}

//-------------------------------------------------------------------------------
// Xóa bản ghi
//-------------------------------------------------------------------------------
function deleteItem() {
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	if (confirm('Bạn có chắc chắn muốn xóa?')) {
		// Save it!
	} else {
	    // Do nothing!
	    return;
	}
	
	var url = './dtu_bh/delete';
	$.ajax({
	    url: url,
	    type: 'POST',
	    dataType: 'json',
	    data: rowData.dtu_id.trim(), // JSON.stringify(rowData), 
	    contentType: 'application/json; charset=utf-8',
	    mimeType: 'application/json',
	    success: function(response) {

	    	//alert('success');
	    	$("#jqxDataTable").jqxDataTable('deleteRow', row_index);
	    },
	    error:function(response, status, er) {
	        
	    	alert("error: " + response + " status: " + status+" er:" + er);
	    }
	});
	
}

//-------------------------------------------------------------------------------
//Xuất dữ liệu sang Excel
//-------------------------------------------------------------------------------
function exportXls() {
	
	$("#jqxDataTable").jqxDataTable('exportData', 'xls');
	
}

//-------------------------------------------------------------------------------
// Khởi tạo các điều khiển
//-------------------------------------------------------------------------------
function initControl() {
	
	var height = $(window).height();
	
    $('#mainSplitter').jqxSplitter({ width: '100%', height:  height - 100,
    	theme: 'energyblue',
    	panels: [{ size: 300 }, { size: 300}
    	] });
    
    $("#tabswidget").jqxTabs({  height: '100%', width: '100%', theme: 'energyblue' });
    
    var loadPage = function (url, tabIndex) {
        $.get(url, function (data) {
            $('#content1').html('<div style="overflow: auto; width: 100%; height: 100%;">' + data + '</div>');
        });
    }
    //loadPage('./dtu_bh', 1);
    
    $("#cmdSave").jqxButton({ width: '80', height: '25'});
	$("#cmdCancel").jqxButton({ width: '80', height: '25'});
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});
	
	$("#tableUser").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 100,
		source: getUser(),
		pageable: false,
		altRows: false,
		columnsResize: true,
		columnsheight: 50,
		filterable: false,
		sortable: true,
		localization: gridLocalization(),
		columns: [
		          { text: 'Tên đăng nhập', datafield: 'username', width: 250 }
		]
	});
	
	$('#tableUser').on('rowSelect', 
		 function (event) {
		     var args = event.args;
		     row_index = args.index;
		     
		     editItem();
		     $('#tabswidget').jqxTabs({ selectedItem: 0 }); 
	});
	
}


function initDanhmuc() {
	
	$("#username").jqxInput({ height: 25, width: 100 });
	$("#password").jqxPasswordInput({  height: 25, width: 100, showStrength: true, showStrengthPosition: "right" });
	$("#fullname").jqxInput({ height: 25, width: 250 });
	$("#enabled").jqxCheckBox({ height: 15, width: 20 });
	//$("#donvi").jqxComboBox({ source:dmDonVi(), displayMember: "ten_donvi", valueMember: "id", width: 250, height: 25, autoDropDownHeight: true});
	
	var height = $(window).height();
	
	/*
	var data = [{
	      "id": "01",
	      "name": "Corporate Headquarters",
	      "budget": "1230000",
	      "location": "Las Vegas",
	          "children": [{
	          "id": "2",
	          "name": "Finance Division",
	          "budget": "423000",
	          "location": "San Antonio",
	              "children": [{
	              "id": "3",
	              "name": "Accounting Department",
	              "budget": "113000",
	              "location": "San Antonio"
	          }, {
	              "id": "4",
	              "name": "Investment Department",
	              "budget": "310000",
	              "location": "San Antonio",
	              children: [{
	                  "id": "5",
	                  "name": "Banking Office",
	                  "budget": "240000",
	                  "location": "San Antonio"
	              }, {
	                  "id": "6",
	                  "name": "Bonds Office",
	                  "budget": "70000",
	                  "location": "San Antonio"
	              }, ]
	          }]
	      }, {
	          "id": "7",
	          "name": "Operations Division",
	          "budget": "600000",
	          "location": "Miami",
	              "children": [{
	              "id": "8",
	              "name": "Manufacturing Department",
	              "budget": "300000",
	              "location": "Miami"
	          }, {
	              "id": "9",
	              "name": "Public Relations Department",
	              "budget": "200000",
	              "location": "Miami"
	          }, {
	              "id": "10",
	              "name": "Sales Department",
	              "budget": "100000",
	              "location": "Miami"
	          }]
	      }, {
	          "id": "11",
	          "name": "Research Division",
	          "budget": "200000",
	          "location": "Boston"
	      }]
	  }];

	
	var source = {
		      dataType: "json",
		      dataFields: [{
		          name: "name",
		          type: "string"
		      }, {
		          name: "budget",
		          type: "number"
		      }, {
		          name: "id",
		          type: "string"
		      }, {
		          name: "children",
		          type: "array"
		      }, {
		          name: "location",
		          type: "string"
		      }],
		      hierarchy: {
		          root: "children"
		      },
		      localData: data,
		      id: "id"
		  };

		  var dataAdapter = new $.jqx.dataAdapter(source, {
		      loadComplete: function () {

		      }
		  });
	
	$("#tableUserMenu").jqxTreeGrid(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 100,
		source: dataAdapter, //getMenu(),
		altRows: false,
		checkboxes: true,
		hierarchicalCheckboxes: true,
		
		columns: [{
	          text: "Name",
	          align: "center",
	          dataField: "name",
	          width: 300
	      }, {
	          text: "Budget",
	          cellsAlign: "center",
	          align: "center",
	          dataField: "budget",
	          cellsFormat: "c2",
	          width: 250
	      }, {
	          text: "Location",
	          dataField: "location",
	          cellsAlign: "center",
	          align: "center"
	      }]
	});
	*/
	
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'id'},
			             { name: 'parentid'},
			             { name: 'name'},
			             { name: 'func'}
			             ],
			id: 'id',
			url: './sys_menu/get'
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source);
	dataAdapter.dataBind();
	var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', [{ name: 'name', map: 'label'}]);
	
	$("#tableUserMenu").jqxGrid(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 145,
		source: getMenuRight(),
		altRows: false,
		editable: true,
		filterable: false,
		filtermode: 'simple',
		columns: [
		          { text: 'Chức năng', datafield: 'name', width: 250, editable:false  },
		          { text: 'func', datafield: 'func', width: 250, editable:false },
		          { text: 'R', datafield: 'r', columntype:'checkbox', width: 80, editable:true },
		          { text: 'W', datafield: 'w', columntype:'checkbox', width: 80, editable:true },
		          { text: 'D', datafield: 'd', columntype:'checkbox', width: 80, editable:true },
		          { text: 'S', datafield: 's', columntype:'checkbox', width: 80, editable:true }
		]
	});
	
	// TAB 3
	$("#treeWidget").jqxTree({
		theme: 'energyblue',
		width: "100%",
		height: height - 120,
		hasThreeStates: true, 
		checkboxes: true,
		source: localData()
	});
			
	/*
	$("#tableUserMenu").jqxTreeGrid(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 100,
		source: dataAdapter, //getMenu(),
		altRows: false,
		checkboxes: true,
		//hierarchicalCheckboxes: true,
		columns: [
		          { text: 'ID', datafield: 'id', width: 350 },
		          { text: 'Chức năng', datafield: 'name', width: 350 },
		          { text: 'func', datafield: 'func' },
		          { text: 'R', datafield: 'R', columntype:'checkbox', width: 80 },
		          { text: 'W', datafield: 'W', columntype:'checkbox', width: 80 },
		          { text: 'D', datafield: 'D', columntype:'checkbox', width: 80 }
		]
	});
	
	$("#tableUserMenu").jqxTreeGrid('checkRow', '01');
	$("#tableUserMenu").jqxTreeGrid('checkRow', '02');
	
	$('#tableUserMenu').on('rowCheck', function (event) 
	{
	    var args = event.args;
	    var element = args.element;
	    var checked = args.checked;
	}); 
	*/
	
	
}

function localData() {
	var data = [
    { "id": "2",
        "parentid": "1",
        "name": "Hot Chocolate",
        "value": "$2.3"
    }, {
        "id": "3",
        "parentid": "1",
        "name": "Peppermint Hot Chocolate",
        "value": "$2.3"
    }, {
        "id": "4",
        "parentid": "1",
        "name": "Salted Caramel Hot Chocolate",
        "value": "$2.3"
    }, {
        "id": "5",
        "parentid": "1",
        "name": "White Hot Chocolate",
        "value": "$2.3"
    }, {
        "name": "Chocolate Beverage",
        "id": "1",
        "parentid": "-1",
        "value": "$2.3"
}, {
        "id": "6",
        "name": "Espresso Beverage",
        "parentid": "-1",
        "value": "$2.3"
    }, {
        "id": "7",
        "parentid": "6",
        "name": "Caffe Americano",
        "value": "$2.3"
        }, {
        "id": "8",
        "name": "Caffe Latte",
        "parentid": "6",
        "value": "$2.3"
    }, {
        "id": "9",
        "name": "Caffe Mocha",
        "parentid": "6",
        "value": "$2.3"
        }, {
        "id": "10",
        "name": "Cappuccino",
        "parentid": "6",
        "value": "$2.3"
    }, {
        "id": "11",
        "name": "Pumpkin Spice Latte",
        "parentid": "6",
        "value": "$2.3"
        }, {
        "id": "12",
        "name": "Frappuccino",
        "parentid": "-1"
    }, {
        "id": "13",
        "name": "Caffe Vanilla Frappuccino",
        "parentid": "12",
        "value": "$2.3"
        }, {
        "id": "15",
        "name": "450 calories",
        "parentid": "13",
        "value": "$2.3"
    }, {
        "id": "16",
        "name": "16g fat",
        "parentid": "13",
        "value": "$2.3"
        }, {
        "id": "17",
        "name": "13g protein",
        "parentid": "13",
        "value": "$2.3"
    }, {
        "id": "14",
        "name": "Caffe Vanilla Frappuccino Light",
        "parentid": "12",
        "value": "$2.3"
        }]
    // prepare the data
    var source =
    {
        datatype: "json",
        datafields: [
            { name: 'id' },
            { name: 'parentid' },
            { name: 'name' }
        ],
        id: 'id',
        localdata: data
        //url: './sys_menu/get'
    };
    // create data adapter.
    var dataAdapter = new $.jqx.dataAdapter(source, {
	      loadComplete: function () {
	    	  	
	      }
	});
    
    // perform Data Binding.
    dataAdapter.dataBind();
    // get the tree items. The first parameter is the item's id. The second parameter is the parent item's id. The 'items' parameter represents 
    // the sub items collection name. Each jqxTree item has a 'label' property, but in the JSON data, we have a 'name' field. The last parameter 
    // specifies the mapping between the 'name' and 'label' fields.  
    var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', [{ name: 'name', map: 'label'}]);
    
    return records;
}



//
function getUser() {
	
	var key = "";
	var url = "./sys_user/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'username', type: 'string' },
			             { name: 'password', type: 'string' },
			             { name: 'fullname', type: 'string' },
			             { name: 'enabled', type: 'bool' },
			             { name: 'donvi_id', type: 'int' }
			             ],
			id: 'username',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
	 		
}

function getMenuRight() {
	
	var key = "";
	var url = "./sys_user_menu/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'id', type: 'string' },
			             { name: 'menu_id', type: 'string' },
			             { name: 'parentid', type: 'string' },
			             { name: 'name', type: 'string' },
			             { name: 'func', type: 'string' },
			             { name: 'user_id', type: 'string' },
			             { name: 'r', type: 'bool' },
			             { name: 'w', type: 'bool' },
			             { name: 'd', type: 'bool' }
			             ],
             //hierarchy:
             //   {
             //       keyDataField: { name: 'id' },
             //       parentDataField: { name: 'parentid' }
             //   },
			id: 'menu_id',
			url: url,
			async: false
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 dataAdapter.dataBind();
	 
	 
	 var dataAdapter = new $.jqx.dataAdapter(source, {
	      loadComplete: function () {
	    		    	  
	      }
	 });

	 alert(dataAdapter.records.length.toString());
	 
	 /*
	 var menuItems = new Array();
	 alert(dataAdapter.records.length.toString());
	  
	 for(var i=0; i<dataAdapter.records.length; i++) {
		  
		  //dataAdapter.records[i].r = true;
		  //dataAdapter.records[i].w = true;
		  //dataAdapter.records[i].d = true;
		  menuItems[i] = dataAdapter.records[i];
		  menuItems[i].r = true;
		  menuItems[i].w = true;
		  menuItems[i].d = true;
		  
		  alert(menuItems[i].name);
	  }
	  
	 //return menuItems;
	 */
	 
 	 return dataAdapter;
	 
}



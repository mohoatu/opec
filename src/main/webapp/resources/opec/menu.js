
var row_index;
var rowData;
var menuItems;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm mới DTU");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxTreeGrid").jqxTreeGrid({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxTreeGrid").jqxTreeGrid('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin DTU");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTreeGrid").jqxTreeGrid({ disabled: true });
    
    $("#dtu_id").jqxInput('val', rowData.dtu_id);
    $("#dtu_desc").jqxInput('val', rowData.dtu_desc);
	$("#dtu_x").jqxInput('val', rowData.dtu_x);
	$("#dtu_y").jqxInput('val', rowData.dtu_y);
	$("#dtu_z").jqxInput('val', rowData.dtu_z);
	
	$("#dtu_Ilim").jqxNumberInput('val', rowData.dtu_Ilim);
	$("#dtu_Tlim").jqxNumberInput('val', rowData.dtu_Tlim);

	$("#dtu_tel").jqxInput('val', rowData.dtu_tel);
	
	$("#dtu_B1").jqxInput('val', rowData.dtu_B1);
	$("#dtu_B2").jqxInput('val', rowData.dtu_B2);
	$("#dtu_B3").jqxInput('val', rowData.dtu_B3);
	$("#dtu_B4").jqxInput('val', rowData.dtu_B4);
	$("#dtu_B5").jqxInput('val', rowData.dtu_B5);
	$("#dtu_B6").jqxInput('val', rowData.dtu_B6);
	
	$('#dialog').jqxWindow('resize', 700, 500);
}

//-------------------------------------------------------------------------------
// Xóa bản ghi
//-------------------------------------------------------------------------------
function deleteItem() {
	
	var rows_selected = $("#jqxTreeGrid").jqxTreeGrid('getSelection');
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
	    	$("#jqxTreeGrid").jqxTreeGrid('deleteRow', row_index);
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
	
	$("#jqxTreeGrid").jqxTreeGrid('exportData', 'xls');
	
}

//-------------------------------------------------------------------------------
// Khởi tạo các điều khiển
//-------------------------------------------------------------------------------
function initControl() {
	
	var height = $(window).height();
	
	$("#jqxTreeGrid").jqxTreeGrid(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 100,
		source: getMenu(),
		pageable: false,
		pagerMode: 'default',
		altRows: true,
		columnsResize: true,
		columnsReorder: true,
		columnsheight: 50,
		filterable: true,
		filtermode: 'simple',
		sortable: false,
		editable: true,
		localization: gridLocalization(),
		pageSize: 20,
		checkboxes: true,
		//hierarchicalCheckboxes: true,
		columns: [
		          { text: 'Name', datafield: 'name', width: 350 },
		          { text: 'ID', datafield: 'id', width: 150 },
		          { text: 'ParentID', datafield: 'parentid', width: 150 } ,
		          { text: 'Function', datafield: 'func', width: 150 },
		          { text: 'SubMenuWidth', datafield: 'subMenuWidth', width: 150 },
		          { text: 'Fullscreen', datafield: 'fullscreen', columntype: 'checkbox', width: 80 }
		          
		]
	});
	
	controlResize();
	
	//$("#cmdSave").jqxButton({ width: '80', height: '25'});
	//$("#cmdCancel").jqxButton({ width: '80', height: '25'});
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdXml").jqxButton({ width: '80', height: '25'});
	$("#cmdImport").jqxButton({ width: '80', height: '25'});
	
	$('#jqxTreeGrid').on('rowSelect', 
		 function (event)
		 {
		     var args = event.args;
		     row_index = args.index;
	});
	
	/*
	$("#cmdCancel").mousedown(function () {
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    $("#dialog").jqxWindow('close');
	    
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData = {};
	    }
	    
	    rowData.dtu_id = $("#dtu_id").jqxInput('val').trim();
	    rowData.dtu_desc = $("#dtu_desc").jqxInput('val');
	    rowData.dtu_x = $("#dtu_x").jqxInput('val');
	    rowData.dtu_y = $("#dtu_y").jqxInput('val');
	    rowData.dtu_z = $("#dtu_z").jqxInput('val');
	    rowData.dtu_Ilim = $("#dtu_Ilim").jqxNumberInput('val');
	    rowData.dtu_Tlim = $("#dtu_Tlim").jqxNumberInput('val');
	    rowData.dtu_tel = $("#dtu_tel").jqxInput('val');
	    rowData.dtu_B1 = $("#dtu_B1").jqxInput('val');
	    rowData.dtu_B2 = $("#dtu_B2").jqxInput('val');
	    rowData.dtu_B3 = $("#dtu_B3").jqxInput('val');
	    rowData.dtu_B4 = $("#dtu_B4").jqxInput('val');
	    rowData.dtu_B5 = $("#dtu_B5").jqxInput('val');
	    rowData.dtu_B6 = $("#dtu_B6").jqxInput('val');
	    
	    var url = './dtu_bh/update';
	    if(editRow == -1) {
	    	url = './dtu_bh/insert';
	    }
	    	    
	    $.ajax({
		    url: url,
		    type: 'POST',
		    dataType: 'json',
		    data: JSON.stringify(rowData), 
		    contentType: 'application/json; charset=utf-8',
		    mimeType: 'application/json',
		    success: function(response) {
				
		    	if(editRow != -1) {
			    	$("#jqxTreeGrid").jqxTreeGrid('updateRow', editRow, rowData);
			    } else {
			    	//rowData.dtu_id = response;
			    	//var row_count = $("#jqxTreeGrid").jqxTreeGrid('getRows').length;
			    	//alert(row_count);
			    	$("#jqxTreeGrid").jqxTreeGrid('addRow', rowData.dtu_id, rowData); // Tham so thu 2 la null thi ID++
			    }
		    	
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	});
	*/
}


//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	/*
	$("#dtu_id").jqxInput({ height: 25, width: 100 });
	
	$("#dtu_desc").jqxInput({ height: 25, width: 600 });
	$("#dtu_x").jqxInput({ height: 25, width: 100 });
	$("#dtu_y").jqxInput({ height: 25, width: 100 });
	$("#dtu_z").jqxInput({ height: 25, width: 100 });
	
	$("#dtu_Ilim").jqxNumberInput({ height: 25, width: 100 });
	$("#dtu_Tlim").jqxNumberInput({ height: 25, width: 100 });

	$("#dtu_tel").jqxInput({ height: 25, width: 100 });
	
	$("#dtu_B1").jqxInput({ height: 25, width: 280 });
	$("#dtu_B2").jqxInput({ height: 25, width: 280 });
	$("#dtu_B3").jqxInput({ height: 25, width: 280 });
	$("#dtu_B4").jqxInput({ height: 25, width: 280 });
	$("#dtu_B5").jqxInput({ height: 25, width: 280 });
	$("#dtu_B6").jqxInput({ height: 25, width: 280 });
	
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        height: 550, width: 1100,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 50,
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	
	$("#dialog").on('close', function () {
		$("#jqxTreeGrid").jqxTreeGrid({ disabled: false });
	});
	
	controlResize();
	*/
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 100;
		
	$('#jqxTreeGrid').jqxTreeGrid({height: height.toString() + "px"});
}

//
function getMenu() {
	
	var key = "";
	var url = "./sys_menu/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'id', type: 'string' },
			             { name: 'parentid', type: 'string' },
			             { name: 'name', type: 'string' },
			             { name: 'func', type: 'string' },
			             { name: 'subMenuWidth', type: 'string' },
			             { name: 'fullscreen', type: 'bool' }
			             ],
             hierarchy:
                {
                    keyDataField: { name: 'id' },
                    parentDataField: { name: 'parentid' }
                },
			id: 'id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 dataAdapter.dataBind();
	 return dataAdapter;
	 
	 //var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', [{ name: 'name', map: 'label'}]);
	 //return records;
	 		
}

function getXmlMenu() {
	
	var key = "";
	var url = "./resources/menu.xml";
	
	// prepare the data
	var source =
	{
			dataType: "xml",
			dataFields: [
			             { name: 'id', type: 'string' },
			             { name: 'parentid', type: 'string' },
			             { name: 'name', type: 'string' },
			             { name: 'func', type: 'string' },
			             { name: 'subMenuWidth', type: 'string' },
			             { name: 'fullscreen', type: 'bool' }
			             ],
			 record: "item",
             hierarchy:
                {
                    keyDataField: { name: 'id' },
                    parentDataField: { name: 'parentid' }
                },
			id: 'id',
			url: url,
			async: false
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 dataAdapter.dataBind();
	 
	 menuItems = new Array();
	 for(var i=0; i<dataAdapter.records.length; i++)
		 menuItems[i] = dataAdapter.records[i];
	 
	 return dataAdapter;
	 		
}

function loadXml() {
	
	$('#jqxTreeGrid').jqxTreeGrid({source: getXmlMenu()});
}

function importXml() {
	
	for(var i=0; i<menuItems.length; i++) {
		
		var url = './sys_menu/import_xml';
	    	    
	    $.ajax({
		    url: url,
		    type: 'POST',
		    dataType: 'json',
		    data: JSON.stringify(menuItems[i]), 
		    contentType: 'application/json; charset=utf-8',
		    mimeType: 'application/json',
		    success: function(response) {
				
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	}
		
}


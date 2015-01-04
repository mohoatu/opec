
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm hãng tàu biểu");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin hãng tàu biển");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#hangtau_ma").jqxInput('val', rowData.hangtau_ma);
	$("#hangtau_ten").jqxInput('val', rowData.hangtau_ten);
	$("#dia_chi").jqxInput('val', rowData.dia_chi);
	$("#nguoi_lien_he").jqxInput('val', rowData.nguoi_lien_he);
	$("#dien_thoai").jqxInput('val', rowData.dien_thoai);
	$("#fax").jqxInput('val', rowData.fax);
	$("#quocgia_id").jqxComboBox('val', rowData.quocgia_id);
	$("#ghi_chu").jqxInput('val', rowData.ghi_chu);
    
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
	
	var url = './dm_hang_tau_bien/delete';
	$.ajax({
	    url: url,
	    type: 'POST',
	    dataType: 'json',
	    data: JSON.stringify(rowData), 
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
	
	$("#jqxDataTable").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		source: dmHangTauBien(),
		pageable: true,
		pagerMode: 'default',
		altRows: false,
		columnsResize: true,
		columnsReorder: true,
		columnsheight: 50,
		filterable: false,
		filtermode: 'simple',
		sortable: true,
		localization: gridLocalization(),
		pageSize: 20,
		columns: [
		          { text: 'STT', datafield: 'hangtau_id', width: 60 },
		          { text: 'Mã HT', datafield: 'hangtau_ma', width: 100 },
		          { text: 'Tên hãng tàu', datafield: 'hangtau_ten', width: 200 },
		          { text: 'Địa chỉ', datafield: 'dia_chi' },
		          { text: 'Người liên hệ', datafield: 'nguoi_lien_he', width: 120 },
		          { text: 'Điện thoại', datafield: 'dien_thoai', width: 100 },
		          { text: 'Fax', datafield: 'fax', width: 100 },
		          { text: 'Quốc gia', datafield: 'quocgia_ten', width: 100 },
		          { text: 'Ghi chú', datafield: 'ghi_chu', width: 200 }
		]
	});
	
	controlResize();
	
	$("#cmdSave").jqxButton({ width: '80', height: '25'});
	$("#cmdCancel").jqxButton({ width: '80', height: '25'});
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});
	
	$('#jqxDataTable').on('rowSelect', 
			 function (event)
			 {
			     // event args.
			     var args = event.args;
			     // row data.
			     var row = args.row;
			     // row index.
			     //var index = args.index;
			     row_index = args.index;
			     // row's data bound index.
			     var boundIndex = args.boundIndex;
			     // row key.
			     var key = args.key;
	});
	
	
	$("#cmdCancel").mousedown(function () {
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    $("#dialog").jqxWindow('close');
	    
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData = {};
	    	rowData.hangtau_id = 0;
	    }
	    
	    rowData.hangtau_ma = $("#hangtau_ma").jqxInput('val');
	    rowData.hangtau_ten = $("#hangtau_ten").jqxInput('val');
	    rowData.dia_chi = $("#dia_chi").jqxInput('val');
	    rowData.nguoi_lien_he = $("#nguoi_lien_he").jqxInput('val');
	    rowData.dien_thoai = $("#dien_thoai").jqxInput('val');
	    rowData.fax = $("#fax").jqxInput('val');
	    
	    if($("#quocgia_id").jqxComboBox('getSelectedIndex') >= 0) {
		    rowData.quocgia_id = $("#quocgia_id").jqxComboBox('getSelectedItem').value;
		    rowData.quocgia_ten = $("#quocgia_id").jqxComboBox('getSelectedItem').label;
	    }
	    
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	    
	    var url = './dm_hang_tau_bien/update';
	    if(editRow == -1) {
	    	url = './dm_hang_tau_bien/insert';
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
			    	$("#jqxDataTable").jqxDataTable('updateRow', editRow, rowData);
			    } else {
			    	rowData.hangtau_id = response;
			    	$("#jqxDataTable").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
			    }
		    	
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	});
}




//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	$("#hangtau_ma").jqxInput({ height: 25, width: 100 });
	$("#hangtau_ten").jqxInput({ height: 25, width: 300 });
	$("#dia_chi").jqxInput({ height: 25, width: 450 });
	$("#nguoi_lien_he").jqxInput({ height: 25, width: 300 });
	$("#dien_thoai").jqxInput({ height: 25, width: 100 });
	$("#fax").jqxInput({ height: 25, width: 100 });
	$("#quocgia_id").jqxComboBox({ source:dmQuocGia(), displayMember: "quocgia_ten", valueMember: "quocgia_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#ghi_chu").jqxInput({ height: 25, width: 450 });
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        height: 650, width: 1100,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 50,
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	
	$("#dialog").on('close', function () {
		$("#jqxDataTable").jqxDataTable({ disabled: false });
	});
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
}

//-------------------------------------------------------------------------------
//	Danh mục hãng tàu biển
//-------------------------------------------------------------------------------
function dmHangTauBien() {
	
	var key = "";
	var url = "./dm_hang_tau_bien/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'hangtau_id', type: 'int' },
			             { name: 'hangtau_ma', type: 'string' },
			             { name: 'hangtau_ten', type: 'string' },
			             { name: 'dia_chi', type: 'string' },
			             { name: 'nguoi_lien_he', type: 'string' },
			             { name: 'dien_thoai', type: 'string' },
			             { name: 'fax', type: 'string' },
			             { name: 'quocgia_id', type: 'int' },
			             { name: 'ghi_chu', type: 'string' },
			             { name: 'quocgia_ten', map: 'objQuocGia>quocgia_ten', type: 'string' }
			             ],
			id: 'hangtau_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
	 		
}


function initEmbedded() {
		
		var height = 200;
		
		$("#jqxgrid").jqxDataTable(
		{
			theme: 'energyblue',
			width: "100%",
			height: height - 111,
			source: dmHangTauBien(),
			pageable: true,
			pagerMode: 'default',
			altRows: false,
			columnsResize: true,
			columnsReorder: true,
			columnsheight: 50,
			filterable: false,
			filtermode: 'simple',
			sortable: true,
			localization: gridLocalization(),
			pageSize: 20,
			columns: [
			          { text: 'STT', datafield: 'hangtau_id', width: 60 },
			          { text: 'Mã HT', datafield: 'hangtau_ma', width: 100 },
			          { text: 'Tên hãng tàu', datafield: 'hangtau_ten', width: 200 },
			          { text: 'Địa chỉ', datafield: 'dia_chi' },
			          { text: 'Người liên hệ', datafield: 'nguoi_lien_he', width: 120 },
			          { text: 'Điện thoại', datafield: 'dien_thoai', width: 100 },
			          { text: 'Fax', datafield: 'fax', width: 100 },
			          { text: 'Quốc gia', datafield: 'quocgia_ten', width: 100 },
			          { text: 'Ghi chú', datafield: 'ghi_chu', width: 150 }
			]
		});
		
}

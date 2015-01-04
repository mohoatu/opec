
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm hàng hóa");
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
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin hàng hóa");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#ma_hang").jqxInput('val', rowData.ma_hang);
	$("#ma_noi_bo").jqxInput('val', rowData.ma_noi_bo);
	$("#ten_hang").jqxInput('val', rowData.ten_hang);
	$("#don_vi_tinh").jqxInput('val', rowData.don_vi_tinh);
	$("#code").jqxInput('val', rowData.code);
	
	$("#phanloai_ten").jqxComboBox('val', rowData.phanloai_id);
	$("#nhasanxuat_ten").jqxComboBox('val', rowData.nhasanxuat_id);
	$("#ungdung_ten").jqxComboBox('val', rowData.ungdung_id);
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
	
	var url = './dm_hang_hoa/delete';
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
		source: dmHangHoa(),
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
		          { text: 'STT', datafield: 'hang_id', width: 60 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 100 },
		          { text: 'Mã nội bộ', datafield: 'ma_noi_bo', width: 100 },
		          { text: 'Code', datafield: 'code', width: 100 },
		          { text: 'Tên hàng hóa', datafield: 'ten_hang', width: 200 },
		          { text: 'ĐVT', datafield: 'don_vi_tinh', width: 100 },
		          { text: 'Nhóm', datafield: 'phanloai_ten', width: 100 },
		          { text: 'Nhà sản xuất', datafield: 'nhasanxuat_ten', width: 150 },
		          { text: 'Ứng dụng', datafield: 'ungdung_ten', width: 150 },
		          { text: 'Ghi chú', datafield: 'ghi_chu' }
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
	    	rowData.hang_id = 0;
	    	rowData.phanloai_id = 0;
	    	rowData.ungdung_id = 0;
	    	rowData.nhasanxuat_id = 0;
	    }
	    
	    rowData.ma_hang = $("#ma_hang").jqxInput('val');
	    rowData.ma_noi_bo = $("#ma_noi_bo").jqxInput('val');
	    rowData.ten_hang = $("#ten_hang").jqxInput('val');
	    rowData.don_vi_tinh = $("#don_vi_tinh").jqxInput('val');
	    rowData.code = $("#code").jqxInput('val');
	    
	    if($("#phanloai_ten").jqxComboBox('getSelectedIndex') >= 0) {
		    rowData.phanloai_id = $("#phanloai_ten").jqxComboBox('getSelectedItem').value;
		    rowData.phanloai_ten = $("#phanloai_ten").jqxComboBox('getSelectedItem').label;
	    }
	    
	    if($("#nhasanxuat_ten").jqxComboBox('getSelectedIndex') >= 0) {
		    rowData.nhasanxuat_id = $("#nhasanxuat_ten").jqxComboBox('getSelectedItem').value;
		    rowData.nhasanxuat_ten = $("#nhasanxuat_ten").jqxComboBox('getSelectedItem').label;
	    }
	    
	    if($("#ungdung_ten").jqxComboBox('getSelectedIndex') >= 0) {
		    rowData.ungdung_id = $("#ungdung_ten").jqxComboBox('getSelectedItem').value;
		    rowData.ungdung_ten = $("#ungdung_ten").jqxComboBox('getSelectedItem').label;
	    }
	    
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	    
	    var url = './dm_hang_hoa/update';
	    if(editRow == -1) {
	    	url = './dm_hang_hoa/insert';
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
			    	rowData.hang_id = response;
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
	
	$("#ma_hang").jqxInput({ height: 25, width: 100 });
	$("#ma_noi_bo").jqxInput({ height: 25, width: 100 });
	$("#code").jqxInput({ height: 25, width: 100 });
	$("#ten_hang").jqxInput({ height: 25, width: 450 });
	$("#don_vi_tinh").jqxInput({source:dmDonViTinh(), displayMember: "don_vi_tinh", height: 25, width: 100 });
	$("#phanloai_ten").jqxComboBox({ source:dmPhanLoaiHangHoa(), displayMember: "phanloai_ten", valueMember: "phanloai_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#nhasanxuat_ten").jqxComboBox({ source:dmNhaSanXuat(), displayMember: "nhasanxuat_ten", valueMember: "nhasanxuat_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#ungdung_ten").jqxComboBox({ source:dmUngDung(), displayMember: "ungdung_ten", valueMember: "ungdung_id", width: 250, height: 25, autoDropDownHeight: true});
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
//	Danh mục hàng hóa
//-------------------------------------------------------------------------------
function dmHangHoa() {
	
	var key = "";
	var url = "./dm_hang_hoa/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'hang_id', type: 'int' },
			             { name: 'ma_hang', type: 'string' },
			             { name: 'ma_noi_bo', type: 'string' },
			             { name: 'code', type: 'string' },
			             { name: 'ten_hang', type: 'string' },
			             { name: 'don_vi_tinh', type: 'string' },
			             { name: 'phanloai_id', type: 'int' },
			             { name: 'nhasanxuat_id', type: 'int' },
			             { name: 'ungdung_id', type: 'int' },
			             { name: 'ghi_chu', type: 'string' },
			             { name: 'phanloai_ten', map: 'objLoaiHang>phanloai_ten', type: 'string' },
			             { name: 'ungdung_ten', map: 'objUngDung>ungdung_ten', type: 'string' },
			             { name: 'nhasanxuat_ten', map: 'objNhaSanXuat>nhasanxuat_ten', type: 'string' }
			             ],
			id: 'hang_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
	 		
}


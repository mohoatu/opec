
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin phí dịch vụ");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    //$("#jqxDataTable").jqxDataTable({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin phí dịch vụ");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    
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
	
	var url = './data/xnk_nk_hop_dong/delete';
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
	
	$('#jqxTabs').jqxTabs({ width: '100%', height: height - 20, position: 'top',
		selectionTracker: true,
		animationType: 'fade'
	});
	
	$("#jqxDataTable1").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		//source: dataAdapter,
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
		          { text: 'Code', datafield: 'code_id', width: 60 },
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten', width: 100 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 80 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Số lượng', datafield: 'nhanvien_ma', width: 100 },
		          { text: 'Số lượng cont', datafield: 'so_luong_container' },
		          { text: 'Loại cont', datafield: 'loai_container' }
		]
	});
	
	//--------------------------------------------------------------
	$("#jqxDataTable2").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: "100%",
		//source: dataAdapter,
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
		          { text: 'Code', datafield: 'code_id', width: 60 },
		          { text: 'Chi phí', datafield: 'so_hop_dong', width: 100 },
		          { text: 'Số lượng cont', datafield: 'ten_cang', width: 80 },
		          { text: 'Giá/cont', datafield: 'hang_tau', width: 80 },
		          { text: 'Thành tiền (có VAT)', datafield: 'thanh_tien', width: 80 },
		          { text: 'Giá/cont', datafield: 'gia_cont', width: 80 },
		          { text: 'Ghi chú', datafield: 'so_bill' }
		]
	});


	controlResize();
	
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});
}




//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
}

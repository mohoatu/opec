
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin nộp thuế");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxDataTable1").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Cập nhật thông tin nộp thuế");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
    
    $("#code").jqxInput('val', rowData.code);
	$("#so_to_khai_hq").jqxInput('val', rowData.thongquan_so_to_khai);
	$("#ngay_to_khai_hq").jqxDateTimeInput('setDate', rowData.thongquan_ngay);
	$("#thue_suat_nhap_khau").jqxNumberInput('val', rowData.thue_suat_nhap_khau);
	$("#thue_suat_vat").jqxNumberInput('val', rowData.thue_suat_vat);
	$("#cuoc_bien").jqxNumberInput('val', rowData.chi_phi_van_tai_bien);
	$("#bao_hiem").jqxNumberInput('val', rowData.chi_phi_bao_hiem);
	$("#ty_gia_nop").jqxNumberInput('val', rowData.ty_gia_thu_thue);
	$("#so_tien_nop").jqxNumberInput('val', rowData.so_thue_phai_nop);
	$("#tien_thue_nhap_khau").jqxNumberInput('val', rowData.tien_thue_nhap_khau);
	$("#tien_thue_vat").jqxNumberInput('val', rowData.tien_thue_vat);
	$("#thoi_han_nop").jqxDateTimeInput('setDate', rowData.ngay_han_muc_nop_thue);
	$("#tien_nop_thuc_te").jqxNumberInput('val', rowData.so_thue_thuc_te);
	$("#ngay_nop_thuc_te").jqxDateTimeInput('setDate', rowData.ngay_nop_thue_thuc_te);
	$("#nguoi_nop").jqxInput('val', rowData.nguoi_nop_thue);
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

function xnk_nk_thue() {
	
	var height = $(window).height();
	$("#jqxDataTable1").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		source: dataCodeNkHopDong(),
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
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 100 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 80 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Tên hàng', datafield: 'ten_hang', width: 250 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_du_kien', width: 80 },
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten' }
		]
	});
	
	//--------------------------------------------------------------
	$("#jqxDataTable2").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: "100%",
		source: dataCodeNkHopDong(),
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
		          { text: 'Thuế suất NK', datafield: 'thue_suat_nhap_khau', width: 100 },
		          { text: 'Thuế suất VAT', datafield: 'thue_suat_vat', width: 100 },
		          { text: 'Tỷ giá nộp', datafield: 'ty_gia_thu_thue', width: 100 },
		          { text: 'Số tiền nộp', datafield: 'so_thue_phai_nop', width: 100 },
		          { text: 'Chi cục HQ', datafield: 'chicuchq_ten' }
		]
	});

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
	
	controlResize();
	
	$("#cmdSave").jqxButton({ width: '80', height: '25'});
	$("#cmdCancel").jqxButton({ width: '80', height: '25'});
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});
	
	$('#jqxDataTable1').on('rowSelect', 
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
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	    
	    // update edited row.
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData.code_id = 0;
	    }
	    
	    rowData.thue_suat_nhap_khau = $("#thue_suat_nhap_khau").jqxNumberInput('val');
	    rowData.thue_suat_vat = $("#thue_suat_vat").jqxNumberInput('val');
	    rowData.chi_phi_van_tai_bien = $("#cuoc_bien").jqxNumberInput('val');
	    rowData.chi_phi_bao_hiem = $("#bao_hiem").jqxNumberInput('val');
	    rowData.ty_gia_thu_thue = $("#ty_gia_nop").jqxNumberInput('val');
	    rowData.so_thue_phai_nop = $("#so_tien_nop").jqxNumberInput('val');
	    rowData.tien_thue_nhap_khau = $("#tien_thue_nhap_khau").jqxNumberInput('val');
	    rowData.tien_thue_vat = $("#tien_thue_vat").jqxNumberInput('val');
	    rowData.ngay_han_muc_nop_thue = $("#thoi_han_nop").jqxDateTimeInput('getDate');
	    rowData.so_thue_thuc_te = $("#tien_nop_thuc_te").jqxNumberInput('val');
	    rowData.ngay_nop_thue_thuc_te = $("#ngay_nop_thuc_te").jqxDateTimeInput('getDate');
	    rowData.nguoi_nop_thue = $("#nguoi_nop").jqxInput('val');
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	        
	    var url = './xnk_nk_code_hop_dong/update';
	    if(editRow == -1) {
	    	url = './xnk_nk_code_hop_dong/insert';
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
			    	$("#jqxDataTable1").jqxDataTable('updateRow', editRow, rowData);
			    } else {
			    	rowData.code_id = response;
			    	$("#jqxDataTable1").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
			    }
		    	
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	});
	
	$("#dialog").on('close', function () {
		$("#jqxTabs").jqxTabs({ disabled: false });
	});
}




//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	$("#code").jqxInput({ height: 25, width: 100, disabled: true });
	$("#so_to_khai_hq").jqxInput({ height: 25, width: 100, disabled: true });
	$("#ngay_to_khai_hq").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true, disabled: true });
	$("#thue_suat_nhap_khau").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#thue_suat_vat").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#cuoc_bien").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#bao_hiem").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#ty_gia_nop").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#so_tien_nop").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#tien_thue_nhap_khau").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#tien_thue_vat").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#thoi_han_nop").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#tien_nop_thuc_te").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#ngay_nop_thuc_te").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#nguoi_nop").jqxInput({ height: 25, width: 150 });
	$("#ghi_chu").jqxInput({ height: 25, width: 500 });
	
	
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
		$("#jqxTabs").jqxTabs({ disabled: false });
	});
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
}

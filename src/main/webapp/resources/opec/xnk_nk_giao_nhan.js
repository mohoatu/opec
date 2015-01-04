
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin giao nhận");
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
	
	$("#dialog").jqxWindow('setTitle', "Cập nhật thông tin giao nhận");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
    
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

function xnk_nk_giao_nhan() {
	
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
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten'},
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Tên hàng', datafield: 'ten_hang', width: 250 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_du_kien', width: 100 },
		          { text: 'Loại cont', datafield: 'container_ten' },
		          { text: 'Số lượng cont', datafield: 'so_luong_container' }
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
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 100 },
		          { text: 'Tên cảng', datafield: 'cangnhap_ten', width: 250 },
		          { text: 'Hãng tàu', datafield: 'hangtau_ten' },
		          { text: 'Số BL', datafield: 'so_bill', width: 90 },
		          { text: 'Ngày BL', datafield: 'ngay_bill', width: 100, cellsFormat: 'dd/MM/yyyy' },
		          { text: 'Agent', datafield: 'dvvantai_ten', width: 150 },
		          { text: 'ETD', datafield: 'ngay_etd', width: 100, cellsFormat: 'dd/MM/yyyy' },
		          { text: 'ETA', datafield: 'ngay_eta', width: 100, cellsFormat: 'dd/MM/yyyy' },
		          { text: 'Ngày cập cảng', datafield: 'ngay_cap_cang', width: 100, cellsFormat: 'dd/MM/yyyy' }
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
}




//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	$("#code").jqxInput({ height: 25, width: 100, disabled: true });
	$("#cang_nhap").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25});
	$("#nhom_hang").jqxInput({ height: 25, width: 100, disabled: true });
	$("#ma_hang").jqxInput({ height: 25, width: 100, disabled: true });
	$("#so_luong").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#so_luong_con_lai").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#han_luu_container").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#han_luu_bai").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#han_luu_vo").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#so_container_con_lai").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#loai_container").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25});
	$("#don_vi_van_tai").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25});
	$("#khach_hang").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25});
	$("#dia_chi").jqxInput({ height: 25, width: 500, disabled: true });
	$("#so_luong_giao_yeu_cau").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#so_luong_giao_thuc_te").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#ngay_yc_keo_container_khoi_cang").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#ngay_giao_hang_thuc_te").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#so_luong_container").jqxNumberInput({ width: 100, height: 25, digits: 5, decimalDigits: 2, spinButtons: true });
	$("#da_giao_xong_code").jqxCheckBox({ width: 100, height: 25 });
	$("#ghi_chu").jqxInput({ height: 25, width: 500, disabled: true });
	
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

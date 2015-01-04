
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin vận tải");
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
	
	$("#dialog").jqxWindow('setTitle', "Cập nhật thông tin vận tải");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
    $("#code").jqxInput('val', rowData.code);
    $("#so_hop_dong").jqxInput('val', rowData.so_hop_dong);
    $("#ma_hang").jqxInput('val', rowData.ma_hang);
    $("#so_luong").jqxInput('val', rowData.so_luong_hang_du_kien);
    $("#loai_container").jqxInput('val', rowData.container_ten);
    $("#so_luong_container").jqxInput('val', rowData.so_luong_container);
    $("#cang_nhap").jqxInput('val', rowData.cangnhap_ten);
    $("#cang_xuat").jqxInput('val', rowData.cangxuat_ten);
    $("#cang_xuat_cbo").jqxComboBox('val', rowData.cangxuat_id);
    $("#cang_den_cuoi").jqxComboBox('val', rowData.cangnhap_id);
    
    $("#so_bill").jqxInput('val', rowData.so_bill);
    $("#ngay_bill").jqxDateTimeInput('setDate', rowData.ngay_bill);
    $("#eta").jqxDateTimeInput('setDate', rowData.ngay_eta);
    $("#etd").jqxDateTimeInput('setDate', rowData.ngay_etd);
    $("#hang_tau").jqxComboBox('val', rowData.hangtau_id);
    $("#ngay_cap_cang").jqxDateTimeInput('setDate', rowData.ngay_cap_cang);
    $("#han_luu_container").jqxDateTimeInput('setDate', rowData.ngay_het_han_luu_cont);
    $("#han_luu_bai").jqxDateTimeInput('setDate', rowData.ngay_het_han_luu_bai);
    $("#so_dem").jqxInput('val', rowData.so_dem);
    $("#so_det").jqxInput('val', rowData.so_det);
    $("#so_ngay_luu_bai").jqxInput('val', rowData.so_ngay_luu_bai);
    $("#dia_diem_tra_rong").jqxInput('val', rowData.dia_diem_tra_rong);
    $("#local_charge").jqxInput('val', rowData.local_charge);
    $("#pallet").jqxCheckBox('val', rowData.pallet);
    $("#pallet_loai").jqxInput('val', rowData.pallet_loai);
    $("#pallet_so_luong").jqxInput('val', rowData.pallet_so_luong);
    $("#ghi_chu").jqxInput('val', rowData.ghi_chu);
    
    $("#agent").jqxComboBox('val', rowData.dvvantai_id);
}

//-------------------------------------------------------------------------------
// Xóa bản ghi
//-------------------------------------------------------------------------------
function deleteItem() {
	var rows_selected = $("#jqxDataTable1").jqxDataTable('getSelection');
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
	
	$("#jqxDataTable1").jqxDataTable('exportData', 'xls');
	
}

function xnk_nk_van_tai() {
	
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
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten' },
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 100 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_du_kien', width: 100 },
		          { text: 'Loại cont', datafield: 'container_ten', width:150 },
		          { text: 'Số lượng cont', datafield: 'so_luong_container', width:100 }
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
		          { text: 'Hãng tàu', datafield: 'hangtau_ten', width: 250 },
		          { text: 'Số BL', datafield: 'so_bill', width: 90 },
		          { text: 'Ngày BL', datafield: 'ngay_bill', width: 100, cellsFormat: 'dd/MM/yyyy' },
		          { text: 'Agent', datafield: 'dvvantai_ten' },
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
	    
	    rowData.cangnhap_id = $("#cang_den_cuoi").jqxComboBox('val');
	    rowData.cangnhap_ten = $("#cang_den_cuoi").jqxComboBox('getSelectedItem').label;
	    rowData.cangxuat_id = $("#cang_xuat_cbo").jqxComboBox('val');
	    rowData.cangxuat_ten = $("#cang_xuat_cbo").jqxComboBox('getSelectedItem').label;
	    
	    rowData.so_bill = $("#so_bill").jqxInput('val');
	    rowData.ngay_bill = $("#ngay_bill").jqxDateTimeInput('getDate');
	    rowData.ngay_eta = $("#eta").jqxDateTimeInput('getDate');
	    rowData.ngay_etd = $("#etd").jqxDateTimeInput('getDate');
	    rowData.hangtau_id = $("#hang_tau").jqxComboBox('getSelectedItem').value;
	    rowData.hangtau_ten = $("#hang_tau").jqxComboBox('getSelectedItem').label;
	    rowData.ngay_cap_cang = $("#ngay_cap_cang").jqxDateTimeInput('getDate');
	    rowData.ngay_het_han_luu_cont = $("#han_luu_container").jqxDateTimeInput('getDate');
	    rowData.ngay_het_han_luu_bai = $("#han_luu_bai").jqxDateTimeInput('getDate');
	    rowData.so_dem = $("#so_dem").jqxInput('val');
	    rowData.so_det = $("#so_det").jqxInput('val');
	    rowData.so_ngay_luu_bai = $("#so_ngay_luu_bai").jqxInput('val');
	    rowData.dia_diem_tra_rong = $("#dia_diem_tra_rong").jqxInput('val');
	    rowData.local_charge = $("#local_charge").jqxInput('val');
	    rowData.pallet = $("#pallet").jqxCheckBox('val');
	    rowData.pallet_loai = $("#pallet_loai").jqxInput('val');
	    rowData.pallet_so_luong = $("#pallet_so_luong").jqxInput('val');
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	    
	    rowData.dvvantai_id = $("#agent").jqxComboBox('getSelectedItem').value;
	        
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
	$("#so_hop_dong").jqxInput({ height: 25, width: 100, disabled: true });
	$("#ma_hang").jqxInput({ height: 25, width: 100, disabled: true });
	$("#so_luong").jqxInput({ height: 25, width: 100, disabled: true });
	$("#loai_container").jqxInput({ height: 25, width: 100, disabled: true });
	$("#so_luong_container").jqxInput({ height: 25, width: 100, disabled: true });
	$("#cang_nhap").jqxInput({ height: 25, width: 250, disabled: true });
	$("#cang_xuat").jqxInput({ height: 25, width: 250, disabled: true });
	
	$("#cang_xuat_cbo").jqxComboBox({ source:dmCangBien(), displayMember: "cangbien_ten", valueMember: "cangbien_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#cang_den_cuoi").jqxComboBox({ source:dmCangBien(), displayMember: "cangbien_ten", valueMember: "cangbien_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#so_bill").jqxInput({ height: 25, width: 100 });
	$("#ngay_bill").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true });
	$("#eta").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#etd").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#hang_tau").jqxComboBox({ source:dmHangTauBien(), displayMember: "hangtau_ten", valueMember: "hangtau_id", width: 250, height: 25, autoDropDownHeight: true});
	//$("#browse_hang_tau").jqxDropDownButton({ width: 50, height: 25});
	$("#agent").jqxComboBox({ source: dmDonViVanTai(), displayMember: "dvvantai_ten", valueMember: "dvvantai_id", width: 250, height: 25, autoDropDownHeight: true, dropDownWidth: 350});
	$("#ngay_cap_cang").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true });
	$("#so_dem").jqxInput({ height: 25, width: 100 });
	$("#han_luu_container").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#so_det").jqxInput({ height: 25, width: 100 });
	$("#han_luu_vo").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#so_ngay_luu_bai").jqxInput({ height: 25, width: 100 });
	$("#han_luu_bai").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	$("#dia_diem_tra_rong").jqxInput({ height: 25, width: 250 });
	$("#local_charge").jqxInput({ height: 25, width: 100 });
	$("#pallet").jqxCheckBox({ height: 25, width: 100 });
	$("#pallet_loai").jqxInput({ height: 25, width: 150 });
	$("#pallet_so_luong").jqxInput({ height: 25, width: 100 });
	$("#ghi_chu").jqxInput({ height: 25, width: 250 });
	
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


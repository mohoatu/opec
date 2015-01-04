
//$.getScript("./resources/opec/dm_common.js", function(){

//   alert("Script loaded and executed.");
   // Here you can use anything you defined in the loaded script
//});

var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm hợp đồng");
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
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin hợp đồng");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#so_hop_dong").jqxInput('val', rowData.so_hop_dong);
    $("#nhacungcap_ten").jqxComboBox('val', rowData.nhacungcap_id);
    $("#phapnhan_ten").jqxComboBox('val', rowData.phapnhan_id);
    $("#nhanvien_ten").jqxComboBox('val', rowData.nhanvien_id);
    $("#mucdoyc_ten").jqxComboBox('val', rowData.mucdoyc_id);
    $("#ghi_chu").jqxInput('val', rowData.ghi_chu);
    
    $("#ngay_ky_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_ky_hop_dong);
    $("#ngay_giao_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_giao_hop_dong);
    $("#ngay_het_hieu_luc_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_het_hieu_luc_hop_dong);
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
	
	var url = './xnk_nk_hop_dong/delete';
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
	
	$("#cancel").mousedown(function () {
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	});
	
	$("#save").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	    
	    // update edited row.
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData = {"hopdong_id":0,
	    			"so_hop_dong":""
	    			};
	    }
	    
	    rowData.so_hop_dong = $("#so_hop_dong").val();
	    
	    rowData.phapnhan_id = $("#phapnhan_ten").jqxComboBox('getSelectedItem').value;
	    rowData.phapnhan_ten = $("#phapnhan_ten").jqxComboBox('getSelectedItem').label;
	    
	    rowData.nhacungcap_id = $("#nhacungcap_ten").jqxComboBox('getSelectedItem').value;
	    rowData.nhacungcap_ten = $("#nhacungcap_ten").jqxComboBox('getSelectedItem').label;
	    
	    rowData.nhanvien_id = $("#nhanvien_ten").jqxComboBox('getSelectedItem').value;
	    rowData.nhanvien_ten = $("#nhanvien_ten").jqxComboBox('getSelectedItem').label;
	    
	    rowData.mucdoyc_id = $("#mucdoyc_ten").jqxComboBox('getSelectedItem').value;
	    rowData.mucdoyc_ten = $("#mucdoyc_ten").jqxComboBox('getSelectedItem').label;
	    
	    if($("#tiente_ten").jqxComboBox('getSelectedIndex') != -1)
	    	rowData.don_vi_tien_te = $("#tiente_ten").jqxComboBox('getSelectedItem').label;
	    
	    rowData.ngay_ky_hop_dong = $("#ngay_ky_hop_dong").jqxDateTimeInput('getDate'); //getDate
	    rowData.ngay_giao_hop_dong = $("#ngay_giao_hop_dong").jqxDateTimeInput('getDate');
	    rowData.ngay_het_hieu_luc_hop_dong = $("#ngay_het_hieu_luc_hop_dong").jqxDateTimeInput('getDate');
	    
	    rowData.ghi_chu = $("#ghi_chu").val();
	        
	    var url = './xnk_nk_hop_dong/update';
	    if(editRow == -1) {
	    	url = './xnk_nk_hop_dong/insert';
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
			    	rowData.hopdong_id = response;
			    	$("#jqxDataTable").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
			    }
		    	
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	});
	
	
	$('#dialog').jqxValidator({
	    rules: [
	           //{ input: '#nhasanxuat_ten', message: 'Trường này phải nhập!', action: 'keyup, blur', rule: 'required' }
		]
	});
	
	$("#dialog").on('close', function () {
	    // enable jqxDataTable.
	    $("#jqxDataTable").jqxDataTable({ disabled: false });
	});
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        //maxHeight: 400, maxWidth: 700, 
        //minHeight: 200, minWidth: 200, 
        height: 950, width: 700,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 500,
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	
}

//-------------------------------------------------------------------------------
// Thiết lập DataTable và Load dữ liệu
//-------------------------------------------------------------------------------
function xnk_nk_ky_hau() {
	var key = "";
	var url = "./data/xnk_nk_ky_hau"; 
	
	// prepare the data
	 var source =
	 {
	     dataType: "json",
	     dataFields: [
	         { name: 'kyhau_id', type: 'int' },
	         { name: 'hopdong_id', type: 'int' },
	         { name: 'codehopdong_id', type: 'int' },
	         { name: 'hang_id', type: 'int' },
	         { name: 'nganhang_id', type: 'int' },
	         { name: 'nhanvien_id', type: 'int' },
	         { name: 'trangthai_id', type: 'int' },
	         { name: 'don_vi_tien_te', type: 'string' },
	         { name: 'so_luong', type: 'float' },
	         { name: 'so_ngay_tra_cham', type: 'int' },
	         { name: 'tien_thanh_toan_von_tu_co', type: 'double' },
	         { name: 'so_tien_nhan_no', type: 'double' },
	         { name: 'don_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_ngoai_te', type: 'float' },
	         { name: 'so_luong_thuc_te', type: 'float' },
	         { name: 'gia_tri_thuc_te', type: 'float' },
	         { name: 'ngay_chung_tu_ve_ngan_hang', type: 'date' },
	         { name: 'thoi_han_thanh_toan', type: 'date' },
	         { name: 'ngay_giao_hop_dong', type: 'date' },
	         { name: 'ho_so_goc_da_chuyen', type: 'bool' },
	         { name: 'ghi_chu', type: 'string' },
	         { name: 'user_modify', type: 'string' },
	         { name: 'date_modify', type: 'date' },
	         { name: 'code', map: 'objCodeHopDong->code', type: 'string' },
	         { name: 'so_hop_dong', map: 'objHopDong->so_hop_dong', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'nganhang_ma', map: 'objNganHang>nganhang_ma', type: 'string' },
	         { name: 'nhanvien_ma', map: 'objNhanVien>nhanvien_ma', type: 'string' },
	         { name: 'trang_thai', map: 'objTrangThaiThanhToan>trangthai_ten', type: 'string' }
	     ],
	     id: 'kyhau_id',
	     url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
		
	// jqxDataTable initialization
	$("#jqxDataTable").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: 600,
		source: dataAdapter,
		pageable: true,
		pagerMode: 'default',
		altRows: true,
		columnsResize: true,
		columnsReorder: true,
		filterable: true,
		filtermode: 'simple',
		sortable: true,
		localization: gridLocalization(),
		pageSize: 20,
		columns: [
		          { text: 'Code', datafield: 'code', width: 60 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong'},
		          { text: 'Mã hàng', datafield: 'ma_hang'},
		          { text: 'Số lượng thực tế', datafield: 'so_luong_thuc_te'},
		          { text: 'Giá trị thực tế', datafield: 'gia_tri_thuc_te'},
		          { text: 'Ngân hàng', datafield: 'nganhang_ma'},
		          { text: 'Ngày chứng từ về NH', datafield: 'ngay_chung_tu_ve_ngan_hang',  cellsFormat: 'dd/MM/yyyy'},
		          { text: 'Thời hạn thanh toán', datafield: 'thoi_han_thanh_toan',  cellsFormat: 'dd/MM/yyyy'},
		          { text: 'CV Phụ trách', datafield: 'nhanvien_ma'}
		]
	});
		
}

function valChanged() {
	
	$("#tri_gia_ngoai_te").jqxNumberInput('val', $("#so_luong").jqxNumberInput('val')*
			$("#don_gia_ngoai_te").jqxNumberInput('val'));
	
	$("#tri_gia_vnd").jqxNumberInput('val', $("#ty_gia_ngoai_te").jqxNumberInput('val')*
			$("#tri_gia_ngoai_te").jqxNumberInput('val'));
}
//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	$("#code").jqxInput({ placeHolder: "Code", height: 25, width: 150});
	$("#so_hop_dong").jqxInput({ placeHolder: "Nhập số hợp đồng", height: 25, width: 150});
	$("#ngan_hang").jqxInput({ placeHolder: "Ngân hàng", height: 25, width: 150});
	$("#ty_gia_ngoai_te").jqxInput({ placeHolder: "Ngân hàng", height: 25, width: 150});
	$("#tri_gia_ngoai_te").jqxInput({ placeHolder: "Ngân hàng", height: 25, width: 150});
	$("#gia_tri_thuc_te").jqxInput({ placeHolder: "Ngân hàng", height: 25, width: 150});
	$("#tien_thanh_toan_von_tu_co").jqxInput({ placeHolder: "Ngân hàng", height: 25, width: 150});
	
	// Combo danh mục mã hàng
	$("#ma_hang").jqxComboBox({ source: dmHangHoa(), displayMember: "ma_hang", valueMember: "hang_id", width: '150', height: '25'});
	$("#ma_hang").jqxComboBox({ autoComplete: true });
	$("#ma_hang").jqxComboBox({ searchMode: 'containsignorecase' });
	
	// So luong
	$("#so_luong").jqxNumberInput({ width: '150px', height: '25px', digits: 5, decimalDigits: 2, spinButtons: true });
	$('#so_luong').on('change', function (event)
	{
	    valChanged();
	}); 
/*	$("#don_vi_tinh").jqxInput({ height: 25, width: 100, disabled: true });*/
	$("#don_gia_ngoai_te").jqxNumberInput({ width: '150px', height: '25px', digits: 9, decimalDigits: 2, spinButtons: false, groupSeparator: " " });
	$('#don_gia_ngoai_te').on('change', function (event)
	{
	    valChanged();
	});
	
	// Combo danh mục ngân hàng
/*	$("#ngan_hang").jqxComboBox({ source: objNganHang(), displayMember: "nganhang_ma", valueMember: "nganhang_id", width: '100%', height: '25'});
	$("#ngan_hang").jqxComboBox({ autoComplete: true });
	$("#ngan_hang").jqxComboBox({ searchMode: 'containsignorecase' });*/
	
	// Combo danh mục nhân viên
	$("#nhanvien_ten").jqxComboBox({ source: dmNhanVien(), displayMember: "nhanvien_ten", valueMember: "nhanvien_id", width: '200', height: '25'});
	$("#nhanvien_ten").jqxComboBox({ autoComplete: true });
	$("#nhanvien_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
	// Combo danh mục pháp nhân
	$("#mucdoyc_ten").jqxComboBox({ source: dmMucDoYeuCau(), displayMember: "mucdoyc_ten", valueMember: "mucdoyc_id", width: '100', height: '25'});
	$("#mucdoyc_ten").jqxComboBox({ autoComplete: true });
	$("#mucdoyc_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
	$("#tiente_ten").jqxComboBox({ source: dmTienTe(), displayMember: "tiente_ma", valueMember: "tiente_id", width: '100', height: '25'});
	$("#tiente_ten").jqxComboBox({ autoComplete: true });
	$("#tiente_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
	$("#ngay_ky_hop_dong").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', 
		width: '100', height: '25', allowKeyboardDelete: true,
		enableAbsoluteSelection: true});
	$("#ngay_giao_hop_dong").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true });
	$("#ngay_het_hieu_luc_hop_dong").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true });
	
	$("#ghi_chu").jqxInput({ placeHolder: "Ghi chú", height: 25, width: '100%'});
	
	$("#save").jqxButton({ width: '100', height: '30'});
	$("#cancel").jqxButton({ width: '100', height: '30'});
	$("#cmdNew").jqxButton({ width: '100', height: '30'});
	$("#cmdEdit").jqxButton({ width: '100', height: '30'});
	$("#cmdDelete").jqxButton({ width: '100', height: '30'});
	$("#cmdExport").jqxButton({ width: '100', height: '30'});

	//$("#jqxDataTable").jqxDataTable({localization: gridLocalization()});
	
	controlResize();
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
	$('#jqxDataTable').jqxDataTable({height: height.toString() + "px"});
}

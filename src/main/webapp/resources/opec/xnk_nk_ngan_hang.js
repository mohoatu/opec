
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin ngân hàng");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxDataTable1").jqxDataTable({ disabled: true });
    
    //$("#nhasanxuat_id").val(rowData.nhasanxuat_id);
    //$("#nhasanxuat_ma").val(rowData.nhasanxuat_ma);
    //$("#nhasanxuat_ten").val(rowData.nhasanxuat_ten);
    //$("#dia_chi").val(rowData.dia_chi);
    //$("#nguoi_lien_he").val(rowData.nguoi_lien_he);
    //$("#dien_thoai").val(rowData.dien_thoai);
    //$("#fax").val(rowData.fax);
    
    //$("#nhasanxuat_id").val(0);
    //$("#nhasanxuat_ma").val("");
    //$("#nhasanxuat_ten").val("");
    //$("#dia_chi").val("");
    //$("#nguoi_lien_he").val("");
    //$("#dien_thoai").val("");
    //$("#fax").val("");
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxDataTable1").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Cập nhật thông tin ngân hàng");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable1").jqxDataTable({ disabled: true });
    
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
	    	$("#jqxDataTable1").jqxDataTable('deleteRow', row_index);
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

//-------------------------------------------------------------------------------
// Khởi tạo các điều khiển
//-------------------------------------------------------------------------------
function initControl() {
	
	var height = $(window).height();
	
	$('#jqxTabs').jqxTabs({ width: '100%', height: height - 20, position: 'top',
		selectionTracker: true,
		animationType: 'fade'
	});
	
	/*$("#jqxDataTable1").jqxDataTable(
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
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 90 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Số ngày trả chậm', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Phương thức giá', datafield: 'so_luong_hang_du_kien', width: 80 },
		          { text: 'Số lượng', datafield: 'nhanvien_ma', width: 100 },
		          { text: 'Đơn giá NT', datafield: 'ghi_chu' },
		          { text: 'Trị giá NT', datafield: 'ghi_chu1' },
		          { text: 'CV phụ trách', datafield: 'ghi_chu2' }
		]
	});*/
	
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
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten', width: 100 },
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 90 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Ngân hàng', datafield: 'ngan_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Số ngày trả chậm', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Phương thức giá', datafield: 'so_luong_hang_du_kien', width: 80 },
		          { text: 'Số lượng', datafield: 'nhanvien_ma', width: 100 },
		          { text: 'Đơn giá NT', datafield: 'ghi_chu' },
		          { text: 'Trị giá NT', datafield: 'ghi_chu1' },
		          { text: 'CV phụ trách', datafield: 'ghi_chu2' }
		]
	});

	//----------------------------------------------------------------------
	
	$("#jqxDataTable3").jqxDataTable(
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
		          { text: 'Ngân hàng', datafield: 'ngan_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Số ngày trả chậm', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Phương thức giá', datafield: 'so_luong_hang_du_kien', width: 80 },
		          { text: 'Số LC', datafield: 'so_lc' },
		          { text: 'Ngày mở LC', datafield: 'ngay_lc' },
		          { text: 'Số tiền thanh toán', datafield: 'nhanvien_ma', width: 100 },
		          { text: 'Hạn thanh toán', datafield: 'ghi_chu' },
		          { text: 'Giá trị cũ', datafield: 'ghi_chu1' },
		          { text: 'CV phụ trách', datafield: 'ghi_chu2' }
		]
	});

	controlResize();
	
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});

	$("#cmdEdit1").jqxButton({ width: '80', height: '25'});
	$("#cmdExport1").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit2").jqxButton({ width: '80', height: '25'});
	$("#cmdExport2").jqxButton({ width: '80', height: '25'});
}


//-------------------------------------------------------------------------------
//Thiết lập DataTable và Load dữ liệu
//-------------------------------------------------------------------------------
function xnk_nk_ngan_hang_lc() {
	
	var height = $(window).height();
	
	$('#jqxTabs').jqxTabs({ width: '100%', height: height - 20, position: 'top',
		selectionTracker: true,
		animationType: 'fade'
	});
	
	var key = "";
	var url = "./data/xnk_nk_ngan_hang_lc";
	
	// prepare the data
	 var source =
	 {
	     dataType: "json",
	     dataFields: [
	         { name: 'code_id', type: 'int' },
	         { name: 'thanhtoan_thu_tu', type: 'int' },
	         { name: 'phuongthuctt_id', type: 'int' },
	         { name: 'ngay_han_mo', type: 'date' },
	         { name: 'so_ngay_tra_cham', type: 'int' },
	         { name: 'nganhang_id', type: 'int' },
	         { name: 'ngay_han_muc_vay', type: 'date' },
	         { name: 'so_tien_vay_no', type: 'double' },
	         { name: 'lai_suat_vay_no', type: 'double' },
	         { name: 'ngay_chung_tu_gui_ngan_hang', type: 'date' },
	         { name: 'so_luong_hang_thuc_te', type: 'double' },
	         { name: 'tri_gia_thuc_te', type: 'double' },
	         { name: 'so_tien_tu_thanh_toan', type: 'double' },
	         { name: 'so_tien_ky_no', type: 'double' },
	         { name: 'ngay_thanh_toan_thuc_te', type: 'date' },
	         { name: 'so_tien_thanh_toan_thuc_te', type: 'double' },
	         { name: 'so_lc', type: 'String' },
	         { name: 'ngay_mo_lc', type: 'date' },
	         { name: 'ghi_chu', type: 'String' },
	         { name: 'trangthai_thanh_toan_id', type: 'int' },
	         { name: 'code', map: 'objCodeHopDong>code', type: 'string' },
	         { name: 'so_hop_dong', map: 'objCodeHopDong>objHopDong>so_hop_dong', type: 'string' },
	         { name: 'don_gia_ngoai_te', map: 'objCodeHopDong>don_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_ngoai_te', map: 'objCodeHopDong>tri_gia_ngoai_te', type: 'float' },
	         { name: 'cangnhap_ten', map: 'objCodeHopDong>objCangNhap>cangbien_ten', type: 'string' },
	         { name: 'nhom_hang', map: 'objCodeHopDong>objHangHoa>objLoaiHang>phanloai_ma', type: 'string' },
	         { name: 'ten_hang', map: 'objCodeHopDong>objHangHoa>ten_hang', type: 'string' },
	         { name: 'don_vi_tinh', map: 'objCodeHopDong>objHangHoa>don_vi_tinh', type: 'string' },
	         { name: 'ma_hang', map: 'objCodeHopDong>objHangHoa>ma_hang', type: 'string' },
	         { name: 'nhanvien_ma', map: 'objCodeHopDong>objHopDong>objNhanVien>nhanvien_ma', type: 'string' },
	         { name: 'phuongthuctt_ma', map: 'objPhuongThucThanhToan>phuongthuctt_ma', type: 'string' },
	         { name: 'phuongthucgia_ma', map: 'objCodeHopDong>objPhuongThucGia>phuongthucgia_ma', type: 'string' },
	         { name: 'ghi_chu', type: 'string' }
	     ],
	     id: 'thanhtoan_id',
	     url: url
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source);
	console.log(dataAdapter);
		
	$("#jqxDataTable1").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		source: dataAdapter,
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
	      { text: 'Code', datafield: 'code', width: 60 },
	      { text: 'Cảng nhập', datafield: 'cangnhap_ten', width: 100 },
	      { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
	      { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 90 },
	      { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
	      { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
	      { text: 'Số ngày trả chậm', datafield: 'so_ngay_tra_cham', width: 80 },
	      { text: 'Phương thức giá', datafield: 'phuongthucgia_ma', width: 80 },
	      { text: 'Số lượng', datafield: 'so_luong_hang_thuc_te', width: 100 },
	      { text: 'Đơn giá NT', datafield: 'don_gia_ngoai_te' },
	      { text: 'Trị giá NT', datafield: 'tri_gia_ngoai_te' },
	      { text: 'Ghi Chú', datafield: 'ghi_chu' },
	      { text: 'CV phụ trách', datafield: 'nhanvien_ma' }
		]
	});
	
	//--------------------------------------------------------------
	$("#jqxDataTable2").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: "100%",
		source: dataAdapter,
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
		          { text: 'Code', datafield: 'code', width: 60 },
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten', width: 100 },
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 90 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Ngân hàng', datafield: 'ngan_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Số ngày trả chậm', datafield: 'so_ngay_tra_cham', width: 80 },
		          { text: 'Phương thức giá', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_thuc_te', width: 100 },
		          { text: 'Đơn giá NT', datafield: 'don_gia_ngoai_te' },
		          { text: 'Trị giá NT', datafield: 'tri_gia_ngoai_te' },
		          { text: 'CV phụ trách', datafield: 'nhanvien_ma' }
		]
	});

	//----------------------------------------------------------------------
	
	$("#jqxDataTable3").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: "100%",
		source: dataAdapter,
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
		          { text: 'Code', datafield: 'code', width: 60 },
		          { text: 'Ngân hàng', datafield: 'ngan_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Số ngày trả chậm', datafield: 'so_ngay_tra_cham', width: 80 },
		          { text: 'Phương thức giá', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Số LC', datafield: 'so_lc' },
		          { text: 'Ngày mở LC', datafield: 'ngay_mo_lc' },
		          { text: 'Số tiền thanh toán', datafield: 'so_tien_thanh_toan_thuc_te', width: 100 },
		          { text: 'Hạn thanh toán', datafield: 'ngay_thanh_toan_thuc_te' },
		          { text: 'Giá trị cũ', datafield: 'so_tien_ky_no' },
		          { text: 'CV phụ trách', datafield: 'nhanvien_ma' }
		]
	});	
}


//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {

	// Combo danh mục pháp nhân
	$("#phapnhan_ten").jqxComboBox({ source: dmPhapNhan(), displayMember: "phapnhan_ten", valueMember: "phapnhan_id", width: '500', height: '25'});
	$("#phapnhan_ten").jqxComboBox({ autoComplete: true });
	$("#phapnhan_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
	$("#so_hop_dong").jqxInput({ placeHolder: "Nhập số hợp đồng", height: 25, width: 100});
	
	// Combo danh mục nhà cung cấp
	$("#nhacungcap_ten").jqxComboBox({ source: dmNhaCungCap(), displayMember: "nhacungcap_ten", valueMember: "nhacungcap_id", width: '100%', height: '25'});
	$("#nhacungcap_ten").jqxComboBox({ autoComplete: true });
	$("#nhacungcap_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
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

	$("#dialog").on('close', function () {
	    // enable jqxDataTable.
	    $("#jqxDataTable1").jqxDataTable({ disabled: false });
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
	    rowData.ghi_chu = $("#ghi_chu").val();
	    var url = './xnk_nk_ngan_hang_lc/update';
	    if(editRow == -1) {
	    	url = './xnk_nk_ngan_hang_lc/insert';
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
			    	rowData.hopdong_id = response;
			    	$("#jqxDataTable1").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
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
	    $("#jqxDataTable1").jqxDataTable({ disabled: false });
	});
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        maxHeight: 900, maxWidth: 1400, 
        //minHeight: 200, minWidth: 300, 
        height: 800, width: 1000,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 50,
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	//$("#jqxDataTable").jqxDataTable({localization: gridLocalization()});
	controlResize();

}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
	//$('#jqxTabs').jqxTabs({height: height.toString() + "px"});
	//$('#jqxDataTable1').jqxDataTable({height: height.toString() + "px"});
}
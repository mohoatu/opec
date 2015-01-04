
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm thông tin thông quan");
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
	
	$("#dialog").jqxWindow('setTitle', "Cập nhật thông tin thông quan");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
    $("#code").jqxInput('val', rowData.code);
    $("#so_hop_dong").jqxInput('val', rowData.so_hop_dong);
    
    $("#loai_hinh_nhap_khau").jqxComboBox('val', rowData.loaihinhxnk_id);
    $("#so_to_khai_hq").jqxInput('val', rowData.thongquan_so_to_khai);
    $("#ngay_to_khai_hq").jqxDateTimeInput('setDate', rowData.thongquan_ngay);
    $("#chi_cuc_hai_quan").jqxComboBox('val', rowData.chicuchq_id);
    $("#don_vi_khai").jqxComboBox('val', rowData.donvi_lap_to_khai_id);
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
	
	$("#jqxDataTable1").jqxDataTable('exportData', 'xls');
	
}

function xnk_nk_thong_quan() {
	
	var height = $(window).height();
	$("#jqxDataTable1").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		source: dataCodeNkChuaThongQuan(),
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
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 100 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 100 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Tên hàng', datafield: 'ten_hang', width: 200 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_du_kien', width: 100 },
		          { text: 'Đơn giá NT', datafield: 'loai_container', width: 100 },
		          { text: 'Trị giá NT', datafield: 'tri_gia_ngoai_te', width: 80 }
		]
	});
	
	//--------------------------------------------------------------
	$("#jqxDataTable2").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: "100%",
		source: dataCodeNkDaThongQuan(),
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
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 100 },
		          { text: 'Loại hình nhập khẩu', datafield: 'loaihinhxnk_ten', width: 150 },
		          { text: 'Số TKHQ', datafield: 'thongquan_so_to_khai', width: 80 },
		          { text: 'Ngày TKHQ', datafield: 'thongquan_ngay', width: 100, cellsFormat: 'dd/MM/yyyy' },
		          { text: 'Phân luồng tờ khai', datafield: 'thongquan_phanluong_ten', width: 150 },
		          { text: 'Chi cục HQ', datafield: 'chicuchq_ten', width: 250 },
		          { text: 'Đơn vị khai', datafield: 'donvi_lap_to_khai_ten' }
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
	
	$("#cmdCancel").mousedown(function () {
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    $("#dialog").jqxWindow('close');
	    
	    // update edited row.
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData.code_id = 0;
	    }
	    
	    rowData.loaihinhxnk_id = $("#loai_hinh_nhap_khau").jqxComboBox('getSelectedItem').value;
	    rowData.loaihinhxnk_ten = $("#loai_hinh_nhap_khau").jqxComboBox('getSelectedItem').label;
	    rowData.thongquan_so_to_khai = $("#so_to_khai_hq").jqxInput('val');
	    rowData.thongquan_ngay = $("#ngay_to_khai_hq").jqxDateTimeInput('getDate');
	    rowData.chicuchq_id = $("#chi_cuc_hai_quan").jqxComboBox('getSelectedItem').value;
	    rowData.chicuchq_ten = $("#chi_cuc_hai_quan").jqxComboBox('getSelectedItem').label;
	    rowData.donvi_lap_to_khai_id = $("#don_vi_khai").jqxComboBox('getSelectedItem').value;
	    rowData.donvi_lap_to_khai_ten = $("#don_vi_khai").jqxComboBox('getSelectedItem').label;
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	    rowData.thongquan_phanluong_id = $("#phan_luong_to_khai_txt").jqxInput('val'); 	    	
	        
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
		    	//Reload page:
		    	xnk_nk_thong_quan();
		    	
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
	$("#loai_hinh_nhap_khau").jqxComboBox({ source: dmLoaiHinhXnk(), displayMember: "loaihinhxnk_ten", valueMember: "loaihinhxnk_id", width: 250, height: 25});
	$("#so_to_khai_hq").jqxInput({ height: 25, width: 100 });
	$("#ngay_to_khai_hq").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	//$("#phan_luong_to_khai").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25});
	$("#chi_cuc_hai_quan").jqxComboBox({ source: dmChiCucHaiQuan(), displayMember: "chicuchq_ten", valueMember: "chicuchq_id", width: 250, height: 25});
	$("#don_vi_khai").jqxComboBox({ source: dmDonViVanTai(), displayMember: "dvvantai_ten", valueMember: "dvvantai_id", width: 250, height: 25});
	$("#ghi_chu").jqxInput({ height: 25, width: 400 });
	$("#phan_luong_to_khai_txt").jqxInput({ height: 25, width: 400 });
	
	
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

function dataCodeNkChuaThongQuan() {
	
	var key = "";
	var url = "./data/xnk_nk_code_hop_dong?thongquan=0";
	
	// prepare the data
	 var source =
	 {
	     dataType: "json",
	     dataFields: [
	         { name: 'code_id', type: 'int' },
	         { name: 'code', type: 'string' },
	         { name: 'hopdong_id', type: 'int' },
	         { name: 'hang_id', type: 'int' },
	         { name: 'ngay_hen_giao_hang', type: 'date' },
	         { name: 'so_luong_hang_du_kien', type: 'float' },
	         { name: 'don_vi_tinh', type: 'string' },
	         { name: 'don_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_ngoai_te', type: 'float' },
	         { name: 'ty_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_vnd', type: 'float' },
	         { name: 'dung_sai', type: 'float' },
	         { name: 'container_id', type: 'int' },
	         { name: 'so_luong_container', type: 'int' },
	         { name: 'phuongthucgia_id', type: 'int' },
	         { name: 'so_lan_thanh_toan', type: 'int' },
	         { name: 'cangnhap_id', type: 'int' },
	         { name: 'cangxuat_id', type: 'int' },
	         { name: 'so_bill', type: 'int' },
	         { name: 'ngay_bill', type: 'date' },
	         { name: 'ngay_etd', type: 'date' },
	         { name: 'ngay_eta', type: 'date' },
	         { name: 'hangtau_id', type: 'int' },
	         { name: 'dvvantai_id', type: 'int' },
	         { name: 'ngay_cap_cang', type: 'date' },
	         { name: 'so_dem', type: 'int' },
	         { name: 'so_det', type: 'int' },
	         { name: 'ngay_het_han_luu_cont', type: 'date' },
	         { name: 'ngay_het_han_luu_vo', type: 'date' },
	         { name: 'so_ngay_luu_bai', type: 'int' },
	         { name: 'ngay_het_han_luu_bai', type: 'date' },
	         { name: 'dia_diem_tra_rong', type: 'string' },
	         { name: 'local_charge', type: 'int' },
	         { name: 'pallet', type: 'int' },
	         { name: 'pallet_loai', type: 'string' },
	         { name: 'pallet_so_luong', type: 'int' },
	         { name: 'loaihinhxnk_id', type: 'int' },
	         { name: 'thongquan_so_to_khai', type: 'string' },
	         { name: 'thongquan_ngay', type: 'date' },
//	         { name: 'thongquan_phanluong_id', type: 'int' },
	         { name: 'thongquan_phanluong_id', type: 'string' },
	         { name: 'chicuchq_id', type: 'int' },
	         { name: 'donvi_lap_to_khai_id', type: 'int' },
	         { name: 'p_khau', type: 'float' },
	         { name: 'thue_suat_nhap_khau', type: 'float' },
	         { name: 'thue_suat_vat', type: 'float' },
	         { name: 'chi_phi_van_tai_bien', type: 'float' },
	         { name: 'chi_phi_bao_hiem', type: 'float' },
	         { name: 'ty_gia_thu_thue', type: 'float' },
	         { name: 'tien_thue_nhap_khau', type: 'float' },
	         { name: 'tien_thue_vat', type: 'float' },
	         { name: 'so_thue_phai_nop', type: 'float' },
	         { name: 'ngay_han_muc_nop_thue', type: 'date' },
	         { name: 'so_thue_thuc_te', type: 'float' },
	         { name: 'ngay_nop_thue_thuc_te', type: 'date' },
	         { name: 'nguoi_nop_thue', type: 'string' },
	         { name: 'trangthai_giao_hang_id', type: 'int' },
	         { name: 'trangthai_thanh_toan_id', type: 'int' },
	         { name: 'trangthai_code_id', type: 'int' },
	         { name: 'ghi_chu', type: 'string' },
	         { name: 'so_hop_dong', map: 'objHopDong>so_hop_dong', type: 'string' },
	         { name: 'cangnhap_ten', map: 'objCangNhap>cangbien_ten', type: 'string' },
	         { name: 'cangxuat_ten', map: 'objCangXuat>cangbien_ten', type: 'string' },
	         { name: 'nhom_hang', map: 'objHangHoa>objLoaiHang>phanloai_ma', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'ten_hang', map: 'objHangHoa>ten_hang', type: 'string' },
	         { name: 'don_vi_tinh', map: 'objHangHoa>don_vi_tinh', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'nhanvien_ma', map: 'objHopDong>objNhanVien>nhanvien_ma', type: 'string' },
	         { name: 'phuongthuctt_ma', map: 'objPhuongThucThanhToan>phuongthuctt_ma', type: 'string' },
	         { name: 'phuongthucgia_ma', map: 'objPhuongThucGia>phuongthucgia_ma', type: 'string' },
	         { name: 'container_ten', map: 'objLoaiContainer>container_ten', type: 'string' },
	         { name: 'hangtau_ten', map: 'objHangTauBien>hangtau_ten', type: 'string' },
	         { name: 'dvvantai_ten', map: 'objDonViVanTai>dvvantai_ten', type: 'string' },
	         { name: 'loaihinhxnk_ten', map: 'objLoaiHinhXnk>loaihinhxnk_ten', type: 'string' },
	         { name: 'chicuchq_ten', map: 'objChiCucHq>chicuchq_ten', type: 'string' },
	         { name: 'donvi_lap_to_khai_ten', map: 'objDonViLapToKhai>donvi_lap_to_khai_ten', type: 'string' },
	         { name: 'ghi_chu', type: 'string' }
	     ],
	     id: 'nhasanxuat_id',
	     url: url
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source);
	dataAdapter.formatDate(new Date(), 'd');
	return dataAdapter;
}

function dataCodeNkDaThongQuan() {
	
	var key = "";
	var url = "./data/xnk_nk_code_hop_dong?thongquan=1";
	
	// prepare the data
	 var source =
	 {
	     dataType: "json",
	     dataFields: [
	         { name: 'code_id', type: 'int' },
	         { name: 'code', type: 'string' },
	         { name: 'hopdong_id', type: 'int' },
	         { name: 'hang_id', type: 'int' },
	         { name: 'ngay_hen_giao_hang', type: 'date' },
	         { name: 'so_luong_hang_du_kien', type: 'float' },
	         { name: 'don_vi_tinh', type: 'string' },
	         { name: 'don_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_ngoai_te', type: 'float' },
	         { name: 'ty_gia_ngoai_te', type: 'float' },
	         { name: 'tri_gia_vnd', type: 'float' },
	         { name: 'dung_sai', type: 'float' },
	         { name: 'container_id', type: 'int' },
	         { name: 'so_luong_container', type: 'int' },
	         { name: 'phuongthucgia_id', type: 'int' },
	         { name: 'so_lan_thanh_toan', type: 'int' },
	         { name: 'cangnhap_id', type: 'int' },
	         { name: 'cangxuat_id', type: 'int' },
	         { name: 'so_bill', type: 'int' },
	         { name: 'ngay_bill', type: 'date' },
	         { name: 'ngay_etd', type: 'date' },
	         { name: 'ngay_eta', type: 'date' },
	         { name: 'hangtau_id', type: 'int' },
	         { name: 'dvvantai_id', type: 'int' },
	         { name: 'ngay_cap_cang', type: 'date' },
	         { name: 'so_dem', type: 'int' },
	         { name: 'so_det', type: 'int' },
	         { name: 'ngay_het_han_luu_cont', type: 'date' },
	         { name: 'ngay_het_han_luu_vo', type: 'date' },
	         { name: 'so_ngay_luu_bai', type: 'int' },
	         { name: 'ngay_het_han_luu_bai', type: 'date' },
	         { name: 'dia_diem_tra_rong', type: 'string' },
	         { name: 'local_charge', type: 'int' },
	         { name: 'pallet', type: 'int' },
	         { name: 'pallet_loai', type: 'string' },
	         { name: 'pallet_so_luong', type: 'int' },
	         { name: 'loaihinhxnk_id', type: 'int' },
	         { name: 'thongquan_so_to_khai', type: 'string' },
	         { name: 'thongquan_ngay', type: 'date' },
//	         { name: 'thongquan_phanluong_id', type: 'int' },
	         { name: 'thongquan_phanluong_id', type: 'string' },
	         { name: 'chicuchq_id', type: 'int' },
	         { name: 'donvi_lap_to_khai_id', type: 'int' },
	         { name: 'p_khau', type: 'float' },
	         { name: 'thue_suat_nhap_khau', type: 'float' },
	         { name: 'thue_suat_vat', type: 'float' },
	         { name: 'chi_phi_van_tai_bien', type: 'float' },
	         { name: 'chi_phi_bao_hiem', type: 'float' },
	         { name: 'ty_gia_thu_thue', type: 'float' },
	         { name: 'tien_thue_nhap_khau', type: 'float' },
	         { name: 'tien_thue_vat', type: 'float' },
	         { name: 'so_thue_phai_nop', type: 'float' },
	         { name: 'ngay_han_muc_nop_thue', type: 'date' },
	         { name: 'so_thue_thuc_te', type: 'float' },
	         { name: 'ngay_nop_thue_thuc_te', type: 'date' },
	         { name: 'nguoi_nop_thue', type: 'string' },
	         { name: 'trangthai_giao_hang_id', type: 'int' },
	         { name: 'trangthai_thanh_toan_id', type: 'int' },
	         { name: 'trangthai_code_id', type: 'int' },
	         { name: 'ghi_chu', type: 'string' },
	         { name: 'so_hop_dong', map: 'objHopDong>so_hop_dong', type: 'string' },
	         { name: 'cangnhap_ten', map: 'objCangNhap>cangbien_ten', type: 'string' },
	         { name: 'cangxuat_ten', map: 'objCangXuat>cangbien_ten', type: 'string' },
	         { name: 'nhom_hang', map: 'objHangHoa>objLoaiHang>phanloai_ma', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'ten_hang', map: 'objHangHoa>ten_hang', type: 'string' },
	         { name: 'don_vi_tinh', map: 'objHangHoa>don_vi_tinh', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'nhanvien_ma', map: 'objHopDong>objNhanVien>nhanvien_ma', type: 'string' },
	         { name: 'phuongthuctt_ma', map: 'objPhuongThucThanhToan>phuongthuctt_ma', type: 'string' },
	         { name: 'phuongthucgia_ma', map: 'objPhuongThucGia>phuongthucgia_ma', type: 'string' },
	         { name: 'container_ten', map: 'objLoaiContainer>container_ten', type: 'string' },
	         { name: 'hangtau_ten', map: 'objHangTauBien>hangtau_ten', type: 'string' },
	         { name: 'dvvantai_ten', map: 'objDonViVanTai>dvvantai_ten', type: 'string' },
	         { name: 'loaihinhxnk_ten', map: 'objLoaiHinhXnk>loaihinhxnk_ten', type: 'string' },
	         { name: 'chicuchq_ten', map: 'objChiCucHq>chicuchq_ten', type: 'string' },
	         { name: 'donvi_lap_to_khai_ten', map: 'objDonViLapToKhai>donvi_lap_to_khai_ten', type: 'string' },
	         { name: 'ghi_chu', type: 'string' }
	     ],
	     id: 'nhasanxuat_id',
	     url: url
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source);
	dataAdapter.formatDate(new Date(), 'd');
	return dataAdapter;
}

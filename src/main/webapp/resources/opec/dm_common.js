
function gridLocalization() {
	var localizationobj = {};
	localizationobj.pagerGoToPageString = "Chuyển đến trang:";
    localizationobj.pagerShowRowsString = "Số dòng/trang:";
    localizationobj.pagerRangeString = " trên ";
    localizationobj.pagerNextButtonString = "Tiếp theo";
    localizationobj.pagerFirstButtonString = "Đầu tiên";
    localizationobj.pagerLastButtonString = "Cuối cùng";
    localizationobj.pagerPreviousButtonString = "Phía trước";
    localizationobj.sortAscendingString = "Sắp xếp tăng dần";
    localizationobj.sortDescendingString = "Sắp xếp giảm dần";
    localizationobj.sortRemoveString = "Bỏ sắp xếp";
    localizationobj.firstDay = 1;
    localizationobj.percentSymbol = "%";
    localizationobj.currencySymbol = "€";
    localizationobj.currencySymbolPosition = "after";
    localizationobj.decimalSeparator = ".";
    localizationobj.thousandsSeparator = ",";
    localizationobj.filterSearchString = "Tìm kiếm:";
    localizationobj.loadText = "Đang nạp dữ liệu...";
    localizationobj.emptyDataString = "Không có dữ liệu!";
    localizationobj.filterClearString = "Bỏ lọc";
    
    var days = {
            // full day names
            names: ["Chủ nhật", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"],
            // abbreviated day names
            namesAbbr: ["CN", "T2", "T3", "T4", "T5", "T6", "T7"],
            // shortest day names
            namesShort: ["CN", "T2", "T3", "T4", "T5", "T6", "T7"]
        };
        localizationobj.days = days;
        var months = {
            // full month names (13 months for lunar calendards -- 13th month should be "" if not lunar)
            names: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 11", "Tháng 12", "Dezember", ""],
            // abbreviated month names
            namesAbbr: ["T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", ""]
        };
        
    //localizationobj.patterns = patterns;
    localizationobj.months = months;
    return localizationobj;
}

//-------------------------------------------------------------------------------
// Danh mục Quốc gia
//-------------------------------------------------------------------------------
function dmQuocGia() {
	
	var key = "";
	var url = "./dm_quoc_gia/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'quocgia_id', type: 'int' },
			             { name: 'quocgia_ten', type: 'string' }
			             ],
			id: 'quocgia_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
	 		
}

//-------------------------------------------------------------------------------
//Danh mục Tiền tệ
//-------------------------------------------------------------------------------
function dmTienTe() {
	
	var key = "";
	var url = "./dm_tien_te/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'tiente_id', type: 'int' },
			             { name: 'tiente_ma', type: 'string' }
			             ],
			id: 'tiente_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}


//-------------------------------------------------------------------------------
// Danh mục Pháp nhân
//-------------------------------------------------------------------------------
function dmPhapNhan() {
	
	var key = "";
	var url = "./dm_phap_nhan/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'phapnhan_id', type: 'int' },
			             { name: 'phapnhan_ten', type: 'string' }
			             ],
			id: 'phapnhan_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
// Danh mục Nhà cung cấp
//-------------------------------------------------------------------------------
function dmNhaCungCap() {
	
	var key = "";
	var url = "./data/dm_ncc";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'nhacungcap_id', type: 'int' },
			             { name: 'nhacungcap_ten', type: 'string' }
			             ],
			id: 'nhacungcap_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
// Danh mục Nhân viên
//-------------------------------------------------------------------------------
function dmNhanVien() {
	
	var key = "";
	var url = "./dm_nhan_vien/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'nhanvien_id', type: 'int' },
			             { name: 'nhanvien_ten', type: 'string' }
			             ],
			id: 'nhanvien_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
// Danh mục Mức độ yêu cầu
//-------------------------------------------------------------------------------
function dmMucDoYeuCau() {
	
	var key = "";
	var url = "./dm_muc_do_yeu_cau/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'mucdoyc_id', type: 'int' },
			             { name: 'mucdoyc_ten', type: 'string' }
			             ],
			id: 'mucdoyc_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}


//-------------------------------------------------------------------------------
// Danh mục Trạng thái hợp đồng
//-------------------------------------------------------------------------------
function dmTrangThaiHopDong() {
	
	var key = "";
	var url = "./dm_trang_thai_hop_dong/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'trangthai_id', type: 'int' },
			             { name: 'trangthai_ten', type: 'string' }
			             ],
			id: 'trangthai_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}


//-------------------------------------------------------------------------------
// Danh mục cảng biển
//-------------------------------------------------------------------------------
function dmCangBien() {
	
	var key = "";
	var url = "./dm_cang_bien/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'cangbien_id', type: 'int' },
			             { name: 'cangbien_ten', type: 'string' }
			             ],
			id: 'cangbien_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}


//-------------------------------------------------------------------------------
// Danh mục hàng hóa
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
			             { name: 'ten_hang', type: 'string' },
			             { name: 'don_vi_tinh', type: 'string' },
			             { name: 'phanloai_ma', map: 'objLoaiHang>phanloai_ma', type: 'string' },
			             ],
			id: 'hang_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}



//-------------------------------------------------------------------------------
// Danh mục Loại container
//-------------------------------------------------------------------------------
function dmLoaiContainer() {
	
	var key = "";
	var url = "./dm_loai_container/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'container_id', type: 'int' },
			             { name: 'container_ten', type: 'string' }
			             ],
			id: 'container_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
// Danh mục Phương thức giá
//-------------------------------------------------------------------------------
function dmPhuongThucGia() {
	
	var key = "";
	var url = "./dm_phuong_thuc_gia/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'phuongthucgia_id', type: 'int' },
			             { name: 'phuongthucgia_ma', type: 'string' }
			             ],
			id: 'phuongthucgia_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
//Danh mục Phương thức thanh toán
//-------------------------------------------------------------------------------
function dmPhuongThucThanhToan() {
	
	var key = "";
	var url = "./dm_phuong_thuc_thanh_toan/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'phuongthuctt_id', type: 'int' },
			             { name: 'phuongthuctt_ma', type: 'string' }
			             ],
			id: 'phuongthuctt_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

//-------------------------------------------------------------------------------
//Danh mục Ngân Hàng
//-------------------------------------------------------------------------------
function dmNganHang() {
	
	var key = "";
	var url = "./dm_ngan_hang/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
	             { name: 'nganhang_id', type: 'int' },
	             { name: 'nganhang_ma', type: 'string' },
	             { name: 'nganhang_ten', type: 'string' },
	             
			],
			id: 'nganhang_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
}

function dataCodeNkHopDong() {
	
	var key = "";
	var url = "./data/xnk_nk_code_hop_dong";
	
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
	         { name: 'thongquan_phanluong_id', type: 'int' },
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
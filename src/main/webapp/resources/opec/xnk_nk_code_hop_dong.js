
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm mới CODE hợp đồng");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
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
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	if(rows_selected.length <= 0){
		alert("Hãy chọn 1 dòng để sửa!");
		return;
	}
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin CODE hợp đồng");
	$('#dialog').jqxWindow('resize', 800, 1100);
	$("#dialog").jqxWindow('open');
    $('#dialog').jqxWindow('bringToFront');
    
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#code").jqxInput('val', rowData.code);
    $("#so_hop_dong").jqxInput('val', rowData.so_hop_dong);
    
    $("#nhom_hang").jqxInput('val', rowData.nhom_hang);
    $("#ten_hang").jqxComboBox('val', rowData.hang_id);
    $("#so_luong").jqxNumberInput('val', rowData.so_luong_hang_du_kien);
    $("#don_vi_tinh").jqxInput('val', rowData.don_vi_tinh);
    $("#don_gia_ngoai_te").jqxNumberInput('val', rowData.don_gia_ngoai_te);
    $("#ty_gia_ngoai_te").jqxNumberInput('val', rowData.ty_gia_ngoai_te);
    $("#tri_gia_ngoai_te").jqxNumberInput('val', rowData.tri_gia_ngoai_te);
    $("#tri_gia_vnd").jqxNumberInput('val', rowData.tri_gia_vnd);
    $("#dung_sai").jqxInput('val', rowData.dung_sai);
    
    $("#cang_nhap").jqxComboBox('val', rowData.cangnhap_id);
    $("#cang_xuat").jqxComboBox('val', rowData.cangxuat_id);
    
    $("#phuong_thuc_gia").jqxComboBox('val', rowData.phuongthucgia_id);
    $("#loai_container").jqxComboBox('val', rowData.container_id);
    $("#so_luong_container").jqxNumberInput('val', rowData.so_luong_container);
    
    $("#ngay_hen_giao_hang").jqxDateTimeInput('setDate', rowData.ngay_hen_giao_hang);
    
    //$("#ngay_ky_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_ky_hop_dong);
    //$("#ngay_giao_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_giao_hop_dong);
    //$("#ngay_het_hieu_luc_hop_dong").jqxDateTimeInput('setDate', rowData.ngay_het_hieu_luc_hop_dong);
    
    $("#so_lan_thanh_toan").jqxComboBox('val', rowData.so_lan_thanh_toan);
    $("#ghi_chu").jqxInput('val', rowData.ghi_chu);
}

//-------------------------------------------------------------------------------
// Xóa bản ghi
//-------------------------------------------------------------------------------
function deleteItem() {
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	console.log(rows_selected);
	if(rows_selected.length <= 0){
		alert("Hãy chọn 1 dòng để xóa!");
		return;
	}

	rowData = rows_selected[0];
	
	if (confirm('Bạn có chắc chắn muốn xóa?')) {
		// Save it!
		var url = './xnk_nk_code_hop_dong/delete';
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
	} else {
	    // Do nothing!
	    return;
	}
		
}

//-------------------------------------------------------------------------------
//Xuất dữ liệu sang Excel
//-------------------------------------------------------------------------------
function exportXls() {
	$("#jqxDataTable").jqxDataTable({exportSettings:  { fileName: "CODE Hợp đồng nhập khẩu"}});
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
	
	$("#cmdCancel").click(function () {
		//hide validation
		$('#dialog').jqxValidator('hide');
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").click(function () {
		$('#dialog').jqxValidator('validate');
	});
	
	
	$('#dialog').jqxValidator({
	    rules: [
	         /*{ input: '#phapnhan_ten', message: 'Trường này phải nhập!', action: 'keyup, blur', rule: 'required' },
	           { input: '#so_hop_dong', message: 'Trường này phải nhập!', action: 'keyup, blur', rule: 'required' },
	           { input: '#so_hop_dong', message: 'Hãy nhập số!', action: 'keyup, blur', rule: function (input, commit) { return !isNaN(input.val()) }},
	           { input: '#nhacungcap_ten', message: 'Trường này phải nhập!', action: 'keyup, blur, select', rule: function(input){
					return (input.val() === "") ? false : true;
				} },
	           { input: '#nhanvien_ten', message: 'Trường này phải nhập!', action: 'select', rule: function(input){
					return (input.val() === "") ? false : true;
				} },
	           { input: '#tiente_ten', message: 'Trường này phải nhập!', action: 'select', rule: function(input){
					return (input.val() === "") ? false : true;
				} },
	           { input: '#ngay_ky_hop_dong', message: 'Trường này phải nhập!', action: 'select', rule: function(input){
					return (input.val() === "") ? false : true;
				} },
				{ input: '#ngay_giao_hop_dong', message: 'Trường này phải nhập!', action: 'select', rule: function(input){
					return (input.val() === "") ? false : true;
				} }
				*/
		]
	});
	
	$('#dialog').on('validationSuccess', function (event) {
   		add_update_code_hd();
	    console.log("db success");
	});
	
	$("#dialog").on('close', function () {
		resetInputWhenClose();
	});
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        maxHeight: 900, maxWidth: 1400, 
        //minHeight: 200, minWidth: 300, 
        height: 700, width: 1000,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 50,
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	
}

//-------------------------------------------------------------------------------
// Thiết lập DataTable và Load dữ liệu
//-------------------------------------------------------------------------------
function xnk_nk_code_hop_dong() {
	
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
	         { name: 'thongquan_so_to_khai', type: 'int' },
	         { name: 'thongquan_ngay', type: 'date' },
	         { name: 'thongquan_phanluong_id', type: 'int' },
	         { name: 'p_khau', type: 'float' },
	         { name: 'thue_suat_vat', type: 'float' },
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
	         { name: 'nhom_hang', map: 'objHangHoa>objLoaiHang>phanloai_ma', type: 'string' },
	         { name: 'ten_hang', map: 'objHangHoa>ten_hang', type: 'string' },
	         { name: 'don_vi_tinh', map: 'objHangHoa>don_vi_tinh', type: 'string' },
	         { name: 'ma_hang', map: 'objHangHoa>ma_hang', type: 'string' },
	         { name: 'nhanvien_ma', map: 'objHopDong>objNhanVien>nhanvien_ma', type: 'string' },
	         { name: 'phuongthuctt_ma', map: 'objPhuongThucThanhToan>phuongthuctt_ma', type: 'string' },
	         { name: 'phuongthucgia_ma', map: 'objPhuongThucGia>phuongthucgia_ma', type: 'string' },
	         { name: 'ghi_chu', type: 'string' }
	     ],
	     id: 'nhasanxuat_id',
	     url: url
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source);
	console.log(dataAdapter);
		
	// jqxDataTable initialization
	$("#jqxDataTable").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: 500,
		source: dataAdapter,
		pageable: true,
		pagerMode: 'default',
		altRows: true,
		columnsResize: true,
		columnsReorder: true,
		columnsheight: 50,
		filterable: true,
		filtermode: 'simple',
		sortable: true,
		localization: gridLocalization(),
		pageSize: 20,
		columns: [
		          { text: 'ID', datafield: 'code_id', width: 60 },
		          { text: 'Cảng nhập', datafield: 'cangnhap_ten', width: 100 },
		          { text: 'Code', datafield: 'code', width: 80 },
		          { text: 'Số HĐ', datafield: 'so_hop_dong', width: 80 },
		          { text: 'Nhóm hàng', datafield: 'nhom_hang', width: 90 },
		          { text: 'Mã hàng', datafield: 'ma_hang', width: 80 },
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: 100 },
		          { text: 'Phương thức giá', datafield: 'phuongthucgia_ma', width: 80 },
		          { text: 'Số lượng', datafield: 'so_luong_hang_du_kien', width: 80 },
		          { text: 'CV phụ trách', datafield: 'nhanvien_ma', width: 100 },
		          { text: 'Ghi chú', datafield: 'ghi_chu' }
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
	
	// Combo danh mục pháp nhân
	//$("#phapnhan_ten").jqxComboBox({ source: dmPhapNhan(), displayMember: "phapnhan_ten", valueMember: "phapnhan_id", width: '200', height: '25'});
	//$("#phapnhan_ten").jqxComboBox({ autoComplete: true });
	//$("#phapnhan_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	
	$("#code").jqxInput({ placeHolder: "Code hợp đồng", height: 25, width: 100});
	
	$("#so_hop_dong").jqxInput({ placeHolder: "Nhập số hợp đồng", height: 25, width: 300});
	
	$("#ten_hang").jqxComboBox({ source: dmHangHoa(), displayMember: "ten_hang", valueMember: "hang_id", width: 300, height: 25});
	$("#ten_hang").on('change', function (event) 
		{
		    var args = event.args;
		    if (args) {
			    // index represents the item's index.                          
			    var index = args.index;
			    var item = args.item;
			    // get item's label and value.
			    //var label = item.label;
			    var value = item.value;
			    var source = $("#ten_hang").jqxComboBox('source');
			    //console.log(source);
			    
			    if(source != undefined) {
			    	$("#nhom_hang").jqxInput('val', source.cachedrecords[index].phanloai_ma);
			    	$("#don_vi_tinh").jqxInput('val', source.cachedrecords[index].don_vi_tinh);
			    }
		    }
	}); 
	
	$("#nhom_hang").jqxInput({ placeHolder: "Nhóm hàng", disabled: true, height: 25, width: 100});
	
	$("#so_luong").jqxNumberInput({ width: '100px', height: '25px', digits: 5, decimalDigits: 2, spinButtons: true });
	$('#so_luong').on('change', function (event)
	{
	    valChanged();
	}); 
	$("#don_vi_tinh").jqxInput({ height: 25, width: 100, disabled: true });
	$("#don_gia_ngoai_te").jqxNumberInput({ width: '130px', height: '25px', digits: 9, decimalDigits: 2, spinButtons: false, groupSeparator: " " });
	$('#don_gia_ngoai_te').on('change', function (event)
	{
	    valChanged();
	});
	$("#ty_gia_ngoai_te").jqxNumberInput({ width: '130px', height: '25px', digits: 9, decimalDigits: 2, spinButtons: false, groupSeparator: " " });
	$('#ty_gia_ngoai_te').on('change', function (event)
	{
	    valChanged();
	});
	$("#tri_gia_ngoai_te").jqxNumberInput({ width: '130px', height: '25px', disabled: true, digits: 9, decimalDigits: 2, spinButtons: false, symbolPosition: 'right', symbol: ' $', groupSeparator: " " });
	$("#tri_gia_vnd").jqxNumberInput({ width: '130px', height: '25px', disabled: true, digits: 9, decimalDigits: 0, spinButtons: false, symbolPosition: 'right', symbol: ' VNĐ', groupSeparator: " " });
	
	$("#phuong_thuc_gia").jqxComboBox({ source: dmPhuongThucGia(), displayMember: "phuongthucgia_ma", valueMember: "phuongthucgia_id", width: 100, height: 25});
	$("#dung_sai").jqxInput({ height: 25, width: 100});
	
	$("#loai_container").jqxComboBox({ source: dmLoaiContainer(), displayMember: "container_ten", valueMember: "container_id", width: 100, height: 25});
	$("#so_luong_container").jqxNumberInput({ width: '100px', height: '25px', digits: 2, decimalDigits: 0, spinButtons: true });
	$("#ngay_hen_giao_hang").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 100, height: 25, allowKeyboardDelete: true });
	
	var _dmCangBien = dmCangBien();
	$("#cang_nhap").jqxComboBox({ source: _dmCangBien, displayMember: "cangbien_ten", valueMember: "cangbien_id", width: 130, height: 25});
	$("#cang_xuat").jqxComboBox({ source: _dmCangBien, displayMember: "cangbien_ten", valueMember: "cangbien_id", width: 130, height: 25});
	
	
	$("#ghi_chu").jqxInput({ placeHolder: "Ghi chú", height: 25, width: "100%"});
	
	$("#so_lan_thanh_toan").jqxComboBox({ height: 25, width: 50, source: [1, 2, 3, 4, 5], autoDropDownHeight: true});
	
	$("#jqxDataTT").jqxDataTable(
	{
		theme: 'energyblue',
		width: '100%',
		height: 150,
		//source: test,
		pageable: true,
		altRows: false,
		columnsResize: true,
		columnsReorder: false,
		filterable: false,
		filtermode: 'simple',
		sortable: false,
		localization: gridLocalization(),
		editable: true,
        autoRowHeight: false,
        pagesize: 3,
		columns: [
		          { text: 'Phương thức thanh toán', datafield: 'phuongthuctt_ma', width: '200px', columntype: 'template', 
		        	  createEditor: function (row, cellvalue, editor, cellText, width, height) {
                          // construct the editor. 
                          editor.jqxComboBox({
                              source: dmPhuongThucThanhToan(), displayMember: 'phuongthuctt_ma', valueMember: 'phuongthuctt_ma', width: width, height: height
                          });
                      },
                      initEditor: function (row, cellvalue, editor, celltext, width, height) {
                          // set the editor's current value. The callback is called each time the editor is displayed.
                          editor.jqxComboBox({ width: width, height: height });
                          editor.val(cellvalue);
                      },
                      getEditorValue: function (row, cellvalue, editor) {
                          // return the editor's value.
                          return editor.val();
                      }
		          },
		          { text: 'Hạn mở LC/TT', datafield: 'cangnhap_ten', width: '150px' },
		          { text: 'Số ngày trả chậm', datafield: 'code', width: '150px' }
		]
	});
	$("#jqxDataTT").jqxDataTable('addRow', null, ["LC", "LC", "LC", "LC", "LC"]);
	
	$("#cmdSave").jqxButton({ width: '100', height: '30'});
	$("#cmdCancel").jqxButton({ width: '100', height: '30'});
	$("#cmdNew").jqxButton({ width: '100', height: '30'});
	$("#cmdEdit").jqxButton({ width: '100', height: '30'});
	$("#cmdDelete").jqxButton({ width: '100', height: '30'});
	$("#cmdExport").jqxButton({ width: '100', height: '30'});
	
	controlResize();
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
	$('#jqxDataTable').jqxDataTable({height: height.toString() + "px"});
	
	//$("#dialog").jqxWindow({maxHeight: height - 10, height: height - 10});
	//$("#dialog").jqxWindow({height: height - 10, width: 1100});
	
	
}

function add_update_code_hd(){
    // update edited row.
    var editRow = parseInt($("#dialog").attr('data-row'));
    
    if(editRow == -1) {
    	rowData = {};
    	rowData = {"code_id":0};
    }
    
    rowData.code = $("#code").jqxInput('val');
    rowData.so_hop_dong = $("#so_hop_dong").jqxInput('val');
    rowData.hang_id = $("#ten_hang").jqxComboBox('val');
    rowData.nhom_hang = $("#nhom_hang").jqxInput('val');
    rowData.so_luong_hang_du_kien = $("#so_luong").jqxNumberInput('val');
    rowData.don_vi_tinh = $("#don_vi_tinh").jqxInput('val');
    rowData.don_gia_ngoai_te = $("#don_gia_ngoai_te").jqxNumberInput('val');
    rowData.ty_gia_ngoai_te = $("#ty_gia_ngoai_te").jqxNumberInput('val');
    rowData.tri_gia_ngoai_te = $("#tri_gia_ngoai_te").jqxNumberInput('val');
    rowData.tri_gia_vnd = $("#tri_gia_vnd").jqxNumberInput('val');
    rowData.dung_sai = $("#dung_sai").jqxInput('val');
    
    rowData.cangnhap_id = $("#cang_nhap").jqxComboBox('val');
    rowData.cangxuat_id = $("#cang_xuat").jqxComboBox('val');
    
    rowData.phuongthucgia_id = $("#phuong_thuc_gia").jqxComboBox('val');
    rowData.container_id = $("#loai_container").jqxComboBox('val');
    rowData.so_luong_container = $("#so_luong_container").jqxNumberInput('val');
    
    rowData.ngay_hen_giao_hang = $("#ngay_hen_giao_hang").jqxDateTimeInput('getDate');
    
    rowData.so_lan_thanh_toan = $("#so_lan_thanh_toan").jqxComboBox('val');
        
    var url = './xnk_nk_code_hop_dong/update';
    if(editRow == -1) {
    	url = './xnk_nk_code_hop_dong/insert';
    }
    
    // close jqxWindow.
    $("#dialog").jqxWindow('close');

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
		    	rowData.code_id = response;
		    	$("#jqxDataTable").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
		    }
	    	
	    },
	    error:function(response, status, er) {
	        
	    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

	    }
	});
}

function resetInputWhenClose () {
	// enable jqxDataTable.
    $("#jqxDataTable").jqxDataTable({ disabled: false });
}
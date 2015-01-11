
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
	if(rows_selected.length <= 0){
		alert("Hãy chọn 1 dòng để sửa!");
		return;
	}

	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin hợp đồng");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#so_hop_dong").jqxInput('val', rowData.so_hop_dong);
    $("#nhacungcap_ten").jqxComboBox('val', rowData.nhacungcap_id);
    $("#phapnhan_ten").jqxComboBox('val', (rowData.phapnhan_id == 0) ? '' : rowData.phapnhan_id);
    $("#nhanvien_ten").jqxComboBox('val', rowData.nhanvien_id);
    $("#mucdoyc_ten").jqxComboBox('val', (rowData.mucdoyc_id == 0) ? '' : rowData.mucdoyc_id);
    $("#tiente_ten").jqxComboBox('val', rowData.don_vi_tien_te);
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
	$("#jqxDataTable").jqxDataTable({exportSettings:  { fileName: "Hợp đồng nhập khẩu"}});
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
	
	$("#cancel").click(function () {
		//hide validation
		$('#dialog').jqxValidator('hide');
	    // close jqxWindow.
	    $("#dialog").jqxWindow('close');
	});
	
	$("#save").click(function () {
		$('#dialog').jqxValidator('validate');
	});

	$('#dialog').jqxValidator({
	    rules: [
	         //  { input: '#phapnhan_ten', message: 'Trường này phải nhập!', action: 'keyup, blur', rule: 'required' },
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
		]
	});
	
	$('#dialog').on('validationSuccess', function (event) {
   		add_update_nk_hop_dong();
	    console.log("db success");
	});
	
	
	
	$("#dialog").on('close', function () {
		doWhenCloseWindow();
	});
	
	$("#dialog").jqxWindow({
		theme: 'energyblue',
		showCollapseButton: false, 
        //maxHeight: 400, maxWidth: 700, 
        //minHeight: 200, minWidth: 200, 
        height: 470, width: 700,
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
function xnk_nk_hop_dong() {
	
	var key = "";
	var url = "./data/xnk_nk_hop_dong";
	
	// prepare the data
	 var source =
	 {
	     dataType: "json",
	     dataFields: [
	         { name: 'hopdong_id', type: 'int' },
	         { name: 'so_hop_dong', type: 'string' },
	         { name: 'phapnhan_id', type: 'int' },
	         { name: 'nhacungcap_id', type: 'int' },
	         { name: 'nhanvien_id', type: 'int' },
	         { name: 'mucdoyc_id', type: 'int' },
	         { name: 'don_vi_tien_te', type: 'string' },
	         { name: 'ngay_ky_hop_dong', type: 'date' },
	         { name: 'ngay_duyet_hop_dong', type: 'date' },
	         { name: 'ngay_giao_hop_dong', type: 'date' },
	         { name: 'ngay_thuc_hien_hop_dong', type: 'date' },
	         { name: 'ngay_het_hieu_luc_hop_dong', type: 'date' },
	         { name: 'ghi_chu', type: 'string' },
	         { name: 'user_modify', type: 'string' },
	         { name: 'date_modify', type: 'date' },
	         { name: 'trangthai_hop_dong_id', type: 'int' },
	         { name: 'phapnhan_ten', map: 'objPhapNhan>phapnhan_ten', type: 'string' },
	         { name: 'nhacungcap_ten', map: 'objNhaCungCap>nhacungcap_ten', type: 'string' },
	         { name: 'nhanvien_ten', map: 'objNhanVien>nhanvien_ten', type: 'string' },
	         { name: 'mucdoyc_ten', map: 'objMucDoYeuCau>mucdoyc_ten', type: 'string' }
	     ],
	     id: 'nhasanxuat_id',
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
		selectionMode: 'singleRow',
		columns: [
		          { text: 'Mã HĐ', datafield: 'hopdong_id', width: 60 },
		          { text: 'Pháp nhân nhập', datafield: 'phapnhan_ten'},
		          { text: 'Số HĐ', datafield: 'so_hop_dong'},
		          { text: 'Mã KH/NCC', datafield: 'nhacungcap_ten'},
		          { text: 'Người phụ trách', datafield: 'nhanvien_ten'},
		          { text: 'Ngày ký', datafield: 'ngay_ky_hop_dong',  cellsFormat: 'dd/MM/yyyy'},
		          { text: 'Ngày nhận HĐ', datafield: 'ngay_giao_hop_dong',  cellsFormat: 'dd/MM/yyyy'},
		          { text: 'Ngày dự kiến kết thúc', datafield: 'ngay_het_hieu_luc_hop_dong',  cellsFormat: 'dd/MM/yyyy'},
		          { text: 'Mức độ YC', datafield: 'mucdoyc_ten'},
		          { text: 'Ngoại tệ', datafield: 'don_vi_tien_te'},
		          { text: 'Ghi chú', datafield: 'ghi_chu'}
		]
	});
		
}



//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	// Combo danh mục pháp nhân
	//
	$("#phapnhan_ten").jqxComboBox({ source: dmPhapNhan(), displayMember: "phapnhan_ten", valueMember: "phapnhan_id", width: '500', height: '25'});
	$("#phapnhan_ten").jqxComboBox({ autoComplete: true });
	$("#phapnhan_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	$("#phapnhan_ten").jqxComboBox({ selectionMode: 'dropDownList' });
	
	$("#so_hop_dong").jqxInput({ placeHolder: "Nhập số hợp đồng", height: 25, width: 100});
	
	// Combo danh mục nhà cung cấp
	$("#nhacungcap_ten").jqxComboBox({ source: dmNhaCungCap(), displayMember: "nhacungcap_ten", valueMember: "nhacungcap_id", width: '100%', height: '25'});
	$("#nhacungcap_ten").jqxComboBox({ autoComplete: true });
	$("#nhacungcap_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	$("#nhacungcap_ten").jqxComboBox({ selectionMode: 'dropDownList' });

	// Combo danh mục nhân viên
	$("#nhanvien_ten").jqxComboBox({ source: dmNhanVien(), displayMember: "nhanvien_ten", valueMember: "nhanvien_id", width: '200', height: '25'});
	$("#nhanvien_ten").jqxComboBox({ autoComplete: true });
	$("#nhanvien_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	$("#nhanvien_ten").jqxComboBox({ selectionMode: 'dropDownList' });
	
	// Combo danh mục pháp nhân
	$("#mucdoyc_ten").jqxComboBox({ source: dmMucDoYeuCau(), displayMember: "mucdoyc_ten", valueMember: "mucdoyc_id", width: '100', height: '25'});
	$("#mucdoyc_ten").jqxComboBox({ autoComplete: true });
	$("#mucdoyc_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	$("#mucdoyc_ten").jqxComboBox({ selectionMode: 'dropDownList' });
	
	$("#tiente_ten").jqxComboBox({ source: dmTienTe(), displayMember: "tiente_ma", valueMember: "tiente_id", width: '100', height: '25'});
	$("#tiente_ten").jqxComboBox({ autoComplete: true });
	$("#tiente_ten").jqxComboBox({ searchMode: 'containsignorecase' });
	$("#tiente_ten").jqxComboBox({ selectionMode: 'dropDownList' });
	
	$("#ngay_ky_hop_dong").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true, enableAbsoluteSelection: true});
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

function add_update_nk_hop_dong(){
	// update edited row.
    var editRow = parseInt($("#dialog").attr('data-row'));
    
    
    if(editRow == -1) {
    	rowData = {};
    	rowData = {"hopdong_id":0, "so_hop_dong":""};
    }
    
    rowData.so_hop_dong = $("#so_hop_dong").val();
    
    if($("#phapnhan_ten").jqxComboBox('getSelectedIndex') != -1){
    	rowData.phapnhan_id = $("#phapnhan_ten").jqxComboBox('getSelectedItem').value;
    	rowData.phapnhan_ten = $("#phapnhan_ten").jqxComboBox('getSelectedItem').label;
    }else{
    	rowData.phapnhan_id = "0";
    	rowData.phapnhan_ten = "";
    }    
    
    rowData.nhacungcap_id = $("#nhacungcap_ten").jqxComboBox('getSelectedItem').value;
    rowData.nhacungcap_ten = $("#nhacungcap_ten").jqxComboBox('getSelectedItem').label;
    
    rowData.nhanvien_id = $("#nhanvien_ten").jqxComboBox('getSelectedItem').value;
    rowData.nhanvien_ten = $("#nhanvien_ten").jqxComboBox('getSelectedItem').label;
    
    if($("#mucdoyc_ten").jqxComboBox('getSelectedItem') == null){
    	rowData.mucdoyc_id = "0";
   		rowData.mucdoyc_ten = "";
    }else{
    	rowData.mucdoyc_id = $("#mucdoyc_ten").jqxComboBox('getSelectedItem').value;
    	rowData.mucdoyc_ten = $("#mucdoyc_ten").jqxComboBox('getSelectedItem').label;
    }	   
    
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
		    	rowData.hopdong_id = response;
		    	$("#jqxDataTable").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
		    }
	    	
	    },
	    error:function(response, status, er) {
	        
	    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);
	    }
	});
}
 function doWhenCloseWindow(){
 		    // enable jqxDataTable.
	    $("#jqxDataTable").jqxDataTable({ disabled: false });
	    //clear input data

	    $("#phapnhan_ten").jqxComboBox('clearSelection'); 
		$("#so_hop_dong").jqxInput('val', '');
		$("#nhacungcap_ten").jqxComboBox('clearSelection'); 
		$("#nhanvien_ten").jqxComboBox('clearSelection'); 
		$("#mucdoyc_ten").jqxComboBox('clearSelection'); 
		$("#tiente_ten").jqxComboBox('clearSelection'); 
		$("#ghi_chu").jqxInput('val', '');
		$("#ngay_ky_hop_dong").jqxDateTimeInput('setDate', new Date());
		$("#ngay_giao_hop_dong").jqxDateTimeInput('setDate', new Date());
		$("#ngay_het_hieu_luc_hop_dong").jqxDateTimeInput('setDate', new Date());
 }
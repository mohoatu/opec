
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm loại tiền tệ");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
}

//-------------------------------------------------------------------------------
// Sửa bản ghi
//-------------------------------------------------------------------------------
function editItem() {
	
	//var rows_selected = $("#jqxDataTable2").jqxDataTable('getSelection');
	//if(rows_selected.length <= 0)
	//	return;
		
	//rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin loại tiền tệ");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxTabs").jqxTabs({ disabled: true });
    
    $("#dialog").jqxWindow('setTitle', "Thêm hợp đồng");
    $("#dialog").jqxWindow('open');
    
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
	
	$("#jqxDataTable").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: height - 111,
		source: dmTienTe(),
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
		          { text: 'STT', datafield: 'tiente_id', width: 100 },
		          { text: 'Mã tiền tệ', datafield: 'tiente_ma' }
		]
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
	
	/*
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
	$("#eta").jqxInput({ height: 25, width: 100 });
	$("#etd").jqxInput({ height: 25, width: 100 });
	$("#hang_tau").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#agent").jqxComboBox({ displayMember: "cang_bien_ten", valueMember: "cang_bien_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#ngay_cap_cang").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: '100', height: '25', allowKeyboardDelete: true });
	$("#dem").jqxInput({ height: 25, width: 100 });
	$("#han_luu_container").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#det").jqxInput({ height: 25, width: 100 });
	$("#han_luu_vo").jqxDateTimeInput({ formatString: 'dd/MM/yyyy', width: 150, height: 25, allowKeyboardDelete: true });
	$("#so_ngay_luu_bai").jqxInput({ height: 25, width: 100 });
	$("#han_luu_bai").jqxDateTimeInput({ formatString: 'dd/MM/yyyy hh:mm', width: 150, height: 25, allowKeyboardDelete: true });
	$("#dia_diem_tra_rong").jqxInput({ height: 25, width: 100 });
	$("#local_charge").jqxInput({ height: 25, width: 100 });
	$("#pallet").jqxCheckBox({ height: 25, width: 100 });
	$("#loai_pallet").jqxInput({ height: 25, width: 100 });
	$("#so_luong").jqxInput({ height: 25, width: 100 });
	$("#ghi_chu").jqxInput({ height: 25, width: 100 });
	
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
	*/
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
}

//-------------------------------------------------------------------------------
//	Danh mục tiền tệ
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


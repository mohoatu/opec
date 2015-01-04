
var row_index;
var rowData;

//-------------------------------------------------------------------------------
// Thêm mới bản ghi
//-------------------------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm chi cục hải quan");
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
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin chi cục hải quan");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#chicuchq_ma").jqxInput('val', rowData.chicuchq_ma);
	$("#chicuchq_ten").jqxInput('val', rowData.chicuchq_ten);
	$("#dia_chi").jqxInput('val', rowData.dia_chi);
	$("#nguoi_lien_he").jqxInput('val', rowData.nguoi_lien_he);
	$("#ma_so_thue").jqxInput('val', rowData.ma_so_thue);
	$("#dien_thoai").jqxInput('val', rowData.dien_thoai);
	$("#fax").jqxInput('val', rowData.fax);
	$("#email").jqxInput('val', rowData.email);
	$("#quocgia_id").jqxComboBox('val', rowData.quocgia_id);
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
	
	var url = './dm_chi_cuc_hai_quan/delete';
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
		source: dmChiCucHaiQuan(),
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
		          { text: 'STT', datafield: 'chicuchq_id', width: 60 },
		          { text: 'Mã CCHQ', datafield: 'chicuchq_ma', width: 100 },
		          { text: 'Tên CCHQ', datafield: 'chicuchq_ten', width: 80 },
		          { text: 'STK', datafield: 'so_tai_khoan', width: 80 },
		          { text: 'Địa chỉ', datafield: 'dia_chi', width: 80 },
		          { text: 'Người liên hệ', datafield: 'nguoi_lien_he', width: 80 },
		          { text: 'Điện thoại', datafield: 'dien_thoai', width: 100 },
		          { text: 'Fax', datafield: 'fax' },
		          { text: 'Quốc gia', datafield: 'quocgia_ten' },
		          { text: 'Ghi chú', datafield: 'ghi_chu' }
		]
	});
	
	controlResize();
	
	$("#cmdSave").jqxButton({ width: '80', height: '25'});
	$("#cmdCancel").jqxButton({ width: '80', height: '25'});
	$("#cmdNew").jqxButton({ width: '80', height: '25'});
	$("#cmdEdit").jqxButton({ width: '80', height: '25'});
	$("#cmdDelete").jqxButton({ width: '80', height: '25'});
	$("#cmdExport").jqxButton({ width: '80', height: '25'});
	
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
	
	
	$("#cmdCancel").mousedown(function () {
	    $("#dialog").jqxWindow('close');
	});
	
	$("#cmdSave").mousedown(function () {
		
		$('#dialog').jqxValidator('validate');
	    $("#dialog").jqxWindow('close');
	    
	    var editRow = parseInt($("#dialog").attr('data-row'));
	    
	    if(editRow == -1) {
	    	rowData = {};
	    	rowData.chicuchq_id = 0;
	    }
	    
	    rowData.chicuchq_ma = $("#chicuchq_ma").jqxInput('val');
	    rowData.chicuchq_ten = $("#chicuchq_ten").jqxInput('val');
	    rowData.dia_chi = $("#dia_chi").jqxInput('val');
	    rowData.nguoi_lien_he = $("#nguoi_lien_he").jqxInput('val');
	    rowData.ma_so_thue = $("#ma_so_thue").jqxInput('val');
	    rowData.dien_thoai = $("#dien_thoai").jqxInput('val');
	    rowData.fax = $("#fax").jqxInput('val');
	    rowData.email = $("#email").jqxInput('val');
	    
	    if($("#quocgia_id").jqxComboBox('getSelectedIndex') >= 0) {
		    rowData.quocgia_id = $("#quocgia_id").jqxComboBox('getSelectedItem').value;
		    rowData.quocgia_ten = $("#quocgia_id").jqxComboBox('getSelectedItem').label;
	    }
	    
	    rowData.ghi_chu = $("#ghi_chu").jqxInput('val');
	    
	    var url = './dm_chi_cuc_hai_quan/update';
	    if(editRow == -1) {
	    	url = './dm_chi_cuc_hai_quan/insert';
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
			    	rowData.chicuchq_id = response;
			    	$("#jqxDataTable").jqxDataTable('addRow', response, rowData); // Tham so thu 2 la null thi ID++
			    }
		    	
		    },
		    error:function(response, status, er) {
		        
		    	alert("Lỗi: " + response + " trạng thái: " + status + " er:" + er);

		    }
		});
	});
}




//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	$("#chicuchq_ma").jqxInput({ height: 25, width: 100 });
	$("#chicuchq_ten").jqxInput({ height: 25, width: 300 });
	$("#dia_chi").jqxInput({ height: 25, width: 450 });
	$("#nguoi_lien_he").jqxInput({ height: 25, width: 300 });
	$("#ma_so_thue").jqxInput({ height: 25, width: 150 });
	$("#dien_thoai").jqxInput({ height: 25, width: 100 });
	$("#fax").jqxInput({ height: 25, width: 100 });
	$("#email").jqxInput({ height: 25, width: 100 });
	$("#quocgia_id").jqxComboBox({ source:dmQuocGia(), displayMember: "quocgia_ten", valueMember: "quocgia_id", width: 250, height: 25, autoDropDownHeight: true});
	$("#ghi_chu").jqxInput({ height: 25, width: 450 });
	
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
		$("#jqxDataTable").jqxDataTable({ disabled: false });
	});
}

function controlResize() {
	
	var height = $(window).height();
	height = height - 55;
	
}

//-------------------------------------------------------------------------------
//	Danh mục chi cục hải quan
//-------------------------------------------------------------------------------
function dmChiCucHaiQuan() {
	
	var key = "";
	var url = "./dm_chi_cuc_hai_quan/get";
	
	// prepare the data
	var source =
	{
			dataType: "json",
			dataFields: [
			             { name: 'chicuchq_id', type: 'int' },
			             { name: 'chicuchq_ma', type: 'string' },
			             { name: 'chicuchq_ten', type: 'string' },
			             { name: 'tai_khoan', type: 'string' },
			             { name: 'dia_chi', type: 'string' },
			             { name: 'nguoi_lien_he', type: 'string' },
			             { name: 'dien_thoai', type: 'string' },
			             { name: 'fax', type: 'string' },
			             { name: 'ma_so_thue', type: 'string' },
			             { name: 'quocgia_id', type: 'int' },
			             { name: 'quocgia_ten', map: 'objQuocGia>quocgia_ten', type: 'string' }
			             ],
			id: 'cangbien_id',
			url: url
	 };
	
	 var dataAdapter = new $.jqx.dataAdapter(source);
	 return dataAdapter;
	 		
}


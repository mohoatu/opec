
var row_index;
var rowData;


//----------------------------------------------------------------
// Thêm mới bản ghi
//----------------------------------------------------------------
function newItem() {
	
	$("#dialog").jqxWindow('setTitle', "Thêm mới nhà cung cấp");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', -1);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    
    $("#nhacungcap_id").val(0);
    $("#nhacungcap_ma").val("");
    $("#nhacungcap_ten").val("");
    $("#dia_chi").val("");
    $("#nguoi_lien_he").val("");
    $("#dien_thoai").val("");
    $("#fax").val("");

}

//----------------------------------------------------------------
// Sửa bản ghi
//----------------------------------------------------------------
function editItem() {
	
	var rows_selected = $("#jqxDataTable").jqxDataTable('getSelection');
	if(rows_selected.length <= 0)
		return;
		
	rowData = rows_selected[0];
	
	$("#dialog").jqxWindow('setTitle', "Sửa thông tin nhà cung cấp");
    $("#dialog").jqxWindow('open');
    $("#dialog").attr('data-row', row_index);
    $("#jqxDataTable").jqxDataTable({ disabled: true });
    
    $("#nhacungcap_id").val(rowData.nhacungcap_id);
    $("#nhacungcap_ma").val(rowData.nhacungcap_ma);
    $("#nhacungcap_ten").val(rowData.nhacungcap_ten);
    $("#dia_chi").val(rowData.dia_chi);
    $("#nguoi_lien_he").val(rowData.nguoi_lien_he);
    $("#dien_thoai").val(rowData.dien_thoai);
    $("#fax").val(rowData.fax);
    $("#quoc_tich").jqxComboBox('val', rowData.quocgia_id);
}

//----------------------------------------------------------------
// Xóa bản ghi
//----------------------------------------------------------------
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
	
	var url = './data/dm_ncc/delete';
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
// Xuất dữ liệu sang Excel
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
	    	rowData = {"nhacungcap_id":0,
	    			"nhacungcap_ma":"",
	    			"nhacungcap_ten":"",
	    			"dia_chi":"",
	    			"nguoi_lien_he":"",
	    			"dien_thoai":"",
	    			"fax":""
	    			};
	    }
	    
	    rowData.nhacungcap_ma = $("#nhacungcap_ma").val();
	    rowData.nhacungcap_ten = $("#nhacungcap_ten").val();
	    rowData.dia_chi = $("#dia_chi").val();
	    rowData.nguoi_lien_he = $("#nguoi_lien_he").val();
	    rowData.dien_thoai = $("#dien_thoai").val();
	    rowData.fax = $("#fax").val();
	    var item = $("#quoc_tich").jqxComboBox('getSelectedItem'); 
	    if (item != undefined) {
	    	rowData.quocgia_id = item.value;
	    	rowData.quocgia_ten = item.label;
	    }
	    else
	    	rowData.quocgia_id = 0;
	    
	    var url = './data/dm_ncc/update';
	    if(editRow == -1) {
	    	url = './data/dm_ncc/insert';
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
			    	// Thêm mới thì cập nhật ID tự sinh từ SQL
			    	rowData.nhacungcap_id = response;
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
	           { input: '#nhacungcap_ten', message: 'Trường này phải nhập!', action: 'keyup, blur', rule: 'required' }
		]
	});
	
	$("#dialog").on('close', function () {
	    // enable jqxDataTable.
	    $("#jqxDataTable").jqxDataTable({ disabled: false });
	});
	
	$("#dialog").jqxWindow({
		theme: 'energyblue', //'orange',
		showCollapseButton: false, 
        maxHeight: 400, maxWidth: 700, 
        minHeight: 200, minWidth: 200, 
        height: 500, width: 700,
        isModal : true,
	    resizable: true,
	    animationType: 'combined', // none, fade, slide, combined
	    showAnimationDuration: 500,
	    //position: { left: $("#table").offset().left + 75, top: $("#table").offset().top + 35 },
	    autoOpen: false
	});
	$("#dialog").css('visibility', 'visible');
	
}

//-------------------------------------------------------------------------------
// Thiết lập DataTable và Load dữ liệu
//-------------------------------------------------------------------------------
function dmNcc() {
	
	var key = "";
	var url = "./data/dm_ncc";
	
	// prepare the data
    var source =
    {
        dataType: "json",
        dataFields: [
            { name: 'nhacungcap_id', type: 'int' },
            { name: 'nhacungcap_ma', type: 'string' },
            { name: 'nhacungcap_ten', type: 'string' },
            { name: 'dia_chi', type: 'string' },
            { name: 'dien_thoai', type: 'string' },
            { name: 'fax', type: 'string' },
            { name: 'nguoi_lien_he', type: 'string' },
            { name: 'quocgia_id', type: 'int' },
            { name: 'quocgia_ten', map: 'objQuocGia>quocgia_ten', type: 'string' }
        ],
        id: 'nhacungcap_id',
        url: url
    };

    var dataAdapter = new $.jqx.dataAdapter(source);
	
	// jqxDataTable initialization
	$("#jqxDataTable").jqxDataTable(
	{
		theme: 'energyblue',
		width: "100%",
		height: 500,
		source: dataAdapter,
		pageable: true,
		pagerMode: 'advanced',
		altRows: true,
		columnsResize: true,
		columnsReorder: true,
		filterable: true,
		filtermode: 'simple',
		sortable: true,
		localization: gridLocalization(),
		pageSize: 20,
		columns: [
		          { text: 'ID', datafield: 'nhacungcap_id', pinned: true, width: 40 },
		          { text: 'Mã', datafield: 'nhacungcap_ma', pinned: true, width: 100 },
		          { text: 'Tên nhà cung cấp', datafield: 'nhacungcap_ten', pinned: true, width: 250 },
		          { text: 'Địa chỉ', datafield: 'dia_chi' },
		          { text: 'Điện thoại', datafield: 'dien_thoai', width: 130 },
		          { text: 'Fax', datafield: 'fax' , width: 130},
		          { text: 'Người liên hệ', datafield: 'nguoi_lien_he', width: 150 },
		          { text: 'Quốc gia', datafield: 'quocgia_ten', width: 100 }
		]
	});
	
}


//-------------------------------------------------------------------------------
//Thiết lập dữ liệu tại các ComboBox
//-------------------------------------------------------------------------------
function initDanhmuc() {
	
	// Create a jqxComboBox
    $("#quoc_tich").jqxComboBox({ source: dmQuocGia(), displayMember: "quocgia_ten", valueMember: "quocgia_id", width: '200', height: '25'});
    $("#quoc_tich").jqxComboBox({ autoComplete: true });
    $("#quoc_tich").jqxComboBox({ searchMode: 'containsignorecase' });
    
    //var index = $("#quoc_tich").jqxComboBox('getSelectedIndex');
    //var item = $("#quoc_tich").jqxComboBox('getSelectedItem'); 
    //if (args != undefined)
    
    $('#quoc_tich').on('select', function (event) {
        var args = event.args;
        if (args != undefined) {
            var item = event.args.item;
            if (item != null) {
                
            }
        }
    });
    
    var source = [
                  "Samsung",
                  "Apple",
                  "Nokia",
                  "LG",
                  "HTC",
                  "Sky"
		        ];
	
    $("#nhacungcap_ten").jqxInput({placeHolder: "Nhập tên nhà cung cấp", height: 25, width: 300, minLength: 1,  source: source });
    
    $("#save").jqxButton({ width: '100', height: '30'});
	$("#cancel").jqxButton({ width: '100', height: '30'});
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
}
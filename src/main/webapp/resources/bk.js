function loadPage(url) {
    $.get(url, function (data) {
    	
        $('#windowContent').html(data); //load the page inside content div
        
    });
}

$('#jqxInputSearch').on('change', 
	function () { 
		//var value = $('#jqxInputSearch').val();
		//alert(value);
}); 

 $("#jqxInputSearch").keyup(function () {
	var value = $('#jqxInputSearch').val();
	//alert(value);
});
 
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

$("#jqxwindow").on("open", function (event) {
    
	loadPage('./update/dm_ncc'); 
	
});



function initXmlMenu() {
	
	//prepare the data
	// XML menu
	var source =
	{
	    datatype: "xml",
	    datafields: [
			{ name: 'id' },
	        { name: 'parentid' },
	        { name: 'name' },
	        { name: 'func' },
	        { name: 'subMenuWidth' }
	    ],
	    record: "item",
	    id: 'id',
	    url: "./resources/menu.xml",
	    async: false
	};
	// create data adapter.	
	var dataAdapter = new $.jqx.dataAdapter(source);
	// perform Data Binding.
	dataAdapter.dataBind();
	
	var mapItems = new Array();
	for(var i=0; i<dataAdapter.records.length; i++)
		mapItems[dataAdapter.records[i].id] = dataAdapter.records[i];
	
	var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', 
			[{ name: 'name', map: 'label'}]);
	
	$('#jqxMenu').jqxMenu({ source: records, mode: 'horizontal',  width: '100%'});	
	$("#jqxMenu").on('itemclick', function (event) {
		
		if(mapItems[event.args.id].func.trim() != "") {
			
			var elem = document.getElementById("ref");
			elem.src = mapItems[event.args.id].func;
			//window.location.hef = "./" + mapItems[event.args.id].func;
			
		}
    });
	$('#jqxMenu').jqxMenu({autoSizeMainItems: false});
	
}


function initMenu() {
	
	var source =
	{
	    datatype: "json",
	    datafields: [
			{ name: 'id' },
	        { name: 'parentid' },
	        { name: 'name' },
	        { name: 'func' },
	        { name: 'subMenuWidth' },
	        { name: 'fullscreen' }
	    ],
	    id: 'id',
	    url: "./sys_menu/get",
	    async: false
	};
	// create data adapter.	
	var dataAdapter = new $.jqx.dataAdapter(source);
	// perform Data Binding.
	dataAdapter.dataBind();
	
	var mapItems = new Array();
	for(var i=0; i<dataAdapter.records.length; i++)
		mapItems[dataAdapter.records[i].id] = dataAdapter.records[i];
	
	var records = dataAdapter.getRecordsHierarchy('id', 'parentid', 'items', 
			[{ name: 'name', map: 'label'}]);
	
	$('#jqxMenu').jqxMenu({ source: records, mode: 'horizontal',  width: '100%'});	
	$("#jqxMenu").on('itemclick', function (event) {
		
		if(mapItems[event.args.id].func.trim() != "") {
			if(mapItems[event.args.id].fullscreen)
				window.location.href = "./" + mapItems[event.args.id].func;
			else {
				var elem = document.getElementById("ref");
				elem.src = mapItems[event.args.id].func;
			}
		}
    });
	$('#jqxMenu').jqxMenu({autoSizeMainItems: false});
	
}


function activeModule(module) {
	
	var elem = document.getElementById("ref");
	
	if(module == '010101') {
		
		elem.src = "xnk_nk_hop_dong";
		
	}
	else if(module == '010102') {
		
		elem.src = "xnk_nk_code_hop_dong";
		
		var rect = elem.getBoundingClientRect();
		console.log(rect.top, rect.right, rect.bottom, rect.left);
	}
	// Ngân hàng
	else if(module == '010201') {
		
		elem.src = "xnk_nk_ngan_hang_lc";
		
	}
	else if(module == '030101') {
		
		elem.src = "dm_ncc";
		
	} 
	else if(module == '030102') {
		
		elem.src = "dm_nsx";
		
	}
}
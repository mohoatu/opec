function getDataThongTinThanhToan()
{
var getAdapter = function () {
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
	return dataAdapter;
        }

        // initialize jqxGrid
        $("#jqxgrid").jqxGrid(
        {
            width: 1000,
            height: 150,
            pagesize :1,
            pageable : true,
            source: getAdapter(),               
            showstatusbar: true,
            renderstatusbar: function (statusbar) {
                // appends buttons to the status bar.
                var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'></div>");
                var addButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/add.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Add</span></div>");
                var deleteButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/close.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Delete</span></div>");
                var reloadButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/refresh.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Reload</span></div>");
                var searchButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/search.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Find</span></div>");
                var addThongTinNH = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/add.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Update Thông Tin Ngân Hàng</span></div>");                
                container.append(addButton);
                container.append(deleteButton);
                container.append(reloadButton);
                container.append(searchButton);
                container.append(addThongTinNH);
                statusbar.append(container);
                addButton.jqxButton({  width: 60, height: 20 });
                deleteButton.jqxButton({  width: 65, height: 20 });
                reloadButton.jqxButton({  width: 65, height: 20 });
                searchButton.jqxButton({  width: 50, height: 20 });
                addThongTinNH.jqxButton({  width: 250, height: 20 });
                // add new row.
                addButton.click(function (event) {
                    var datarow = generatedata(1);
                    $("#jqxgrid").jqxGrid('addrow', null, datarow[0]);
                });
                // delete selected row.
                deleteButton.click(function (event) {
                    var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
                    var rowscount = $("#jqxgrid").jqxGrid('getdatainformation').rowscount;
                    var id = $("#jqxgrid").jqxGrid('getrowid', selectedrowindex);
                    $("#jqxgrid").jqxGrid('deleterow', id);
                });
                // reload grid data.
                reloadButton.click(function (event) {
                    $("#jqxgrid").jqxGrid({ source: getAdapter() });
                });
                addThongTinNH.click(function (event) {
                    var offset = $("#jqxgrid").offset();
                    $("#jqxwindow1").jqxWindow('open');
                   // $("#jqxwindow1").jqxWindow('move', offset.left + 30, offset.top + 30);
                });
            },
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
        
        
        // initialize jqxGrid
        $("#jqxgrid2").jqxGrid(
        {
            width: 1000,
            height: 150,
            source: getAdapter(),               
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
        // create jqxWindow.
        $("#jqxwindow1").jqxWindow({ resizable: false,  autoOpen: false, width: 210, height: 180 });
        // create find and clear buttons.
        $("#findButton").jqxButton({ width: 70});
        $("#clearButton").jqxButton({ width: 70});
        if (theme != "") {
            $("#inputField").addClass('jqx-input-' + theme);
        }

        // clear filters.
        $("#clearButton").click(function () {
            $("#jqxgrid").jqxGrid('clearfilters');
        });

        // find records that match a criteria.
        $("#findButton").click(function () {
            $("#jqxgrid").jqxGrid('clearfilters');
            var searchColumnIndex = $("#dropdownlist").jqxDropDownList('selectedIndex');
            var datafield = "";
            switch (searchColumnIndex) {
                case 0:
                    datafield = "firstname";
                    break;
                case 1:
                    datafield = "lastname";
                    break;
                case 2:
                    datafield = "productname";
                    break;
                case 3:
                    datafield = "quantity";
                    break;
                case 4:
                    datafield = "price";
                    break;
            }

            var searchText = $("#inputField").val();
            var filtergroup = new $.jqx.filter();
            var filter_or_operator = 1;
            var filtervalue = searchText;
            var filtercondition = 'contains';
            var filter = filtergroup.createfilter('stringfilter', filtervalue, filtercondition);
            filtergroup.addfilter(filter_or_operator, filter);
            $("#jqxgrid").jqxGrid('addfilter', datafield, filtergroup);
            // apply the filters.
            $("#jqxgrid").jqxGrid('applyfilters');
        }); 
        
        var countries = new Array("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic", "Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Greenland", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Mongolia", "Morocco", "Monaco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Samoa", "San Marino", " Sao Tome", "Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
        // create jqxInput
        $("#inputHopDong").jqxInput({ width: '250px', height: '25px'});
        $("#inputNhapKhau").jqxInput({ width: '250px', height: '25px'});      
}
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jQuery Tabs, Tabs Widget, TabView">
    <meta name="description" content="jqxTabs enables you to simplify input tasks by creating a series of pages with validation.">
    <title id="Description">jqxTabs enables you to simplify input tasks by creating a series of pages with validation.</title>
    <link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css" type="text/css">
    <script type="text/javascript" src="./resources/jqwidgets/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="./resources/jqwidgets/demos.js"></script>
    <script type="text/javascript" src="./resources/jqwidgets/jqx-all.js"></script>
    <script type="text/javascript" src="./resources/jqwidgets/generatedata.js"></script>
    <script type="text/javascript" src="./resources/opec/dm_common.js"></script>
    <script type="text/javascript" src="./resources/opec/thongtinthanhtoan.js"></script>    
    <script type="text/javascript">
        $(document).ready(function() {
            //Creating wizard module
            var wizard = (function() {

                //Adding event listeners
                var _addHandlers = function() {
                    $('#passwordInput').keyup(function() {
                        wizard.validate(true);
                    });
                    $('.nextButton').click(function() {
                        wizard.validate(true);
                        $('#jqxTabs').jqxTabs('next');
                    });
                    $('.backButton').click(function() {
                        wizard.validate(true);
                        $('#jqxTabs').jqxTabs('previous');
                    });
                };

                //Checking if any product have been selected
                var _isItemSelected = function(array) {
                    var count = array.length;
                    if (count === 0) {
                        return false;
                    }
                    while (count) {
                        count -= 1;
                        if (array[count] !== -1 &&
                            typeof array[count] !== 'undefined') {
                            return true;
                        }
                    }
                    return false;
                };

                return {

                    //Listbox's source
                    config: {
                        source: [{
                            html: "<div style='height: 20px; float: left;'><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>TT</span></div>",
                            title: 'Thanh toan truc tiep: '
                        }, {
                            html: "<div style='height: 20px; float: left;'><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>LC</span></div>",
                            title: 'Thanh toan cham LC:'
                        }, {
                            html: "<div style='height: 20px; float: left;'><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>DP</span></div>",
                            title: 'Thanh toan cham DP:'
                        }]
                    },

                    //Initializing the wizzard - creating all elements, adding event handlers and starting the validation
                    init: function() {
                        $('#jqxTabs').jqxTabs({
                            height: 580,
                            width: 1200,
                            keyboardNavigation: false
                        });
                        $('#nextButtonInfo').jqxButton({
                            width: 200
                        });
                        $('#nextButtonBasket').jqxButton({
                            width: 50
                        });
                        $('#backButtonBasket').jqxButton({
                            width: 50
                        });
                        $('#backButtonReview').jqxButton({
                            width: 50
                        });
                        _addHandlers();
                        this.validate();
                        this.showHint('Validation hints.');
                    },

                    //Validating all wizard tabs
                    validate: function(notify) {
                        if (!this.firstTab(notify)) {
                            $('#jqxTabs').jqxTabs('disableAt', 1);
                            $('#jqxTabs').jqxTabs('disableAt', 2);
                            $('#jqxTabs').jqxTabs('disableAt', 3);
                            return;
                        } else {
                            $('#jqxTabs').jqxTabs('enableAt', 1);
                        }
                        if (!this.secondTab(notify)) {
                            $('#jqxTabs').jqxTabs('disableAt', 2);
                            $('#jqxTabs').jqxTabs('disableAt', 3);
                            return;
                        } else {
                            $('#jqxTabs').jqxTabs('enableAt', 2);
                        }
                    },

                    //Displaying message to the user
                    showHint: function(message, selector) {
                        if (typeof selector === 'undefined') {
                            selector = '.hint';
                        }
                        if (message === '') {
                            message = 'You can continue.';
                        }
                        $(selector).html('<strong>' + message + '</strong>');
                    },

                    //Validating the first tab
                    firstTab: function(notify) {
                        var codeNK = $('#jqxdropdownbutton').val();
                        if (codeNK === '') {
                            this.showHint('Nhập Code Nhập Khẩu', '#hintSection');
                            return false;
                        } else {
                            this.showHint('You can continue.', '#hintSection');
                        }

                        return true;
                    },

                    //Validating the second tab
                    secondTab: function() {
                        return false;
                    },
                    thirdTab: function() {
                        return false;
                    }
                }
            }());

            //Initializing the wizard
            wizard.init();
            var key = "";
            var url = "./data/xnk_nk_hop_dong";

            // prepare the data
            var source = {
                dataType: "json",
                dataFields: [{
                    name: 'hopdong_id',
                    type: 'int'
                }, {
                    name: 'so_hop_dong',
                    type: 'string'
                }, {
                    name: 'phapnhan_id',
                    type: 'int'
                }, {
                    name: 'nhacungcap_id',
                    type: 'int'
                }, {
                    name: 'nhanvien_id',
                    type: 'int'
                }, {
                    name: 'mucdoyc_id',
                    type: 'int'
                }, {
                    name: 'don_vi_tien_te',
                    type: 'string'
                }, {
                    name: 'ngay_ky_hop_dong',
                    type: 'date'
                }, {
                    name: 'ngay_duyet_hop_dong',
                    type: 'date'
                }, {
                    name: 'ngay_giao_hop_dong',
                    type: 'date'
                }, {
                    name: 'ngay_thuc_hien_hop_dong',
                    type: 'date'
                }, {
                    name: 'ngay_het_hieu_luc_hop_dong',
                    type: 'date'
                }, {
                    name: 'ghi_chu',
                    type: 'string'
                }, {
                    name: 'user_modify',
                    type: 'string'
                }, {
                    name: 'date_modify',
                    type: 'date'
                }, {
                    name: 'trangthai_hop_dong_id',
                    type: 'int'
                }, {
                    name: 'phapnhan_ten',
                    map: 'objPhapNhan>phapnhan_ten',
                    type: 'string'
                }, {
                    name: 'nhacungcap_ten',
                    map: 'objNhaCungCap>nhacungcap_ten',
                    type: 'string'
                }, {
                    name: 'nhanvien_ten',
                    map: 'objNhanVien>nhanvien_ten',
                    type: 'string'
                }, {
                    name: 'mucdoyc_ten',
                    map: 'objMucDoYeuCau>mucdoyc_ten',
                    type: 'string'
                }],
                id: 'nhasanxuat_id',
                url: url
            };
            // var dataAdapterNK = dataCodeNkHopDong();

            var dataAdapter = new $.jqx.dataAdapter(source);

            var data = generatedata(100);

            var source1 = {
                localdata: data,
                datafields: [{
                    name: 'firstname',
                    type: 'string'
                }, {
                    name: 'lastname',
                    type: 'string'
                }, {
                    name: 'productname',
                    type: 'string'
                }, {
                    name: 'quantity',
                    type: 'number'
                }, {
                    name: 'price',
                    type: 'number'
                }],
                datatype: "array",
                updaterow: function(rowid, rowdata) {
                    // synchronize with the server - send update command   
                }
            };

            var dataAdapterNK = dataCodeNkHopDong();

            // initialize jqxGrid
            $("#jqxdropdownbutton").jqxDropDownButton({
                width: 150,
                height: 25
            });
            $("#jqGridCodeNH").jqxGrid({
                width: 850,
                height: 150,
                source: dataAdapter,
                columnsresize: true,
                columns: [{
                    text: 'Mã HĐ',
                    datafield: 'hopdong_id',
                    width: 60
                }, {
                    text: 'Pháp nhân nhập',
                    datafield: 'phapnhan_ten'
                }, {
                    text: 'Số HĐ',
                    datafield: 'so_hop_dong'
                }, {
                    text: 'Mã KH/NCC',
                    datafield: 'nhacungcap_ten'
                }, {
                    text: 'Người phụ trách',
                    datafield: 'nhanvien_ten'
                }, {
                    text: 'Ngày ký',
                    datafield: 'ngay_ky_hop_dong',
                    cellsFormat: 'dd/MM/yyyy'
                }, {
                    text: 'Ngày nhận HĐ',
                    datafield: 'ngay_giao_hop_dong',
                    cellsFormat: 'dd/MM/yyyy'
                }, {
                    text: 'Ngày dự kiến kết thúc',
                    datafield: 'ngay_het_hieu_luc_hop_dong',
                    cellsFormat: 'dd/MM/yyyy'
                }, {
                    text: 'Mức độ YC',
                    datafield: 'mucdoyc_ten'
                }, {
                    text: 'Ngoại tệ',
                    datafield: 'don_vi_tien_te'
                }, {
                    text: 'Ghi chú',
                    datafield: 'ghi_chu'
                }]
            });

            $("#jqGridCodeNH").on('rowselect', function(event) {
                var args = event.args;
                var row = $("#jqGridCodeNH").jqxGrid('getrowdata', args.rowindex);
                if (row != undefined) {
                    var dropDownContent = '<div style="position: relative; margin-left: 3px; margin-top: 5px;">' + row['hopdong_id'] + '-' + row['nhacungcap_ten'] + '</div>';
                }
                $("#jqxdropdownbutton").jqxDropDownButton('setContent', dropDownContent);
            });

            $("#jqGridCodeNH").jqxGrid('selectrow', 0);


            $("#jqxdropdownbuttonNK").jqxDropDownButton({
                width: 150,
                height: 25
            });
            $("#jqGridCodeNK").jqxGrid({
                width: 950,
                height: 150,
                source: dataAdapterNK,
                columnsresize: true,
                columns: [{
                    text: 'ID',
                    datafield: 'code_id',
                    width: 60
                }, {
                    text: 'Cảng nhập',
                    datafield: 'cangnhap_ten',
                    width: 100
                }, {
                    text: 'Code',
                    datafield: 'code',
                    width: 80
                }, {
                    text: 'Số HĐ',
                    datafield: 'so_hop_dong',
                    width: 80
                }, {
                    text: 'Nhóm hàng',
                    datafield: 'nhom_hang',
                    width: 90
                }, {
                    text: 'Mã hàng',
                    datafield: 'ma_hang',
                    width: 80
                }, {
                    text: 'Phương thức thanh toán',
                    datafield: 'phuongthuctt_ma',
                    width: 100
                }, {
                    text: 'Phương thức giá',
                    datafield: 'phuongthucgia_ma',
                    width: 80
                }, {
                    text: 'Số lượng',
                    datafield: 'so_luong_hang_du_kien',
                    width: 80
                }, {
                    text: 'CV phụ trách',
                    datafield: 'nhanvien_ma',
                    width: 100
                }, {
                    text: 'Ghi chú',
                    datafield: 'ghi_chu'
                }]
            });

            $("#jqGridCodeNK").on('rowselect', function(event) {
                var args = event.args;
                var row = $("#jqGridCodeNK").jqxGrid('getrowdata', args.rowindex);
                if (row != undefined) {
                    $("#jqxdatetimeinput").val(row['ngay_hen_giao_hang']);
                    $("#inputHopDong").val(row['so_hop_dong']);
                    $("#inputNhapKhau").val(row['code']);                  
                    var dropDownContent = '<div style="position: relative; margin-left: 3px; margin-top: 5px;">' + row['code_id'] + '-' + row['nhom_hang'] + '</div>';
                    $("#jqxdropdownbuttonNK").jqxDropDownButton('setContent', dropDownContent);
                }
            });

            $("#jqGridCodeNK").jqxGrid('selectrow', 0);


            var source1 = {
                localdata: generatedata(500),
                datafields: [{
                    name: 'firstname',
                    type: 'string'
                }, {
                    name: 'lastname',
                    type: 'string'
                }, {
                    name: 'productname',
                    type: 'string'
                }, {
                    name: 'quantity',
                    type: 'number'
                }, {
                    name: 'price',
                    type: 'number'
                }, {
                    name: 'total',
                    type: 'number'
                }],
                datatype: "array"
            };

            var dataAdapter = new $.jqx.dataAdapter(source1);
            var columns = [{
                text: 'Mã hàng',
                dataField: 'ma_hang',
                width: 130
            }, {
                text: 'Nhóm Hàng',
                dataField: 'nhom_hang',
                width: 130
            }, {
                text: 'Số lượng',
                dataField: 'so_luong_hang_du_kien',
                width: 180
            }, {
                text: 'Đơn vị tính',
                dataField: 'don_vi_tinh',
                width: 80,
                cellsalign: 'right'
            }, {
                text: 'Đơn giá NT',
                dataField: 'don_gia_ngoai_te',
                width: 90,
                cellsalign: 'right',
                cellsformat: 'c2'
            }, {
                text: 'Trị giá NT',
                dataField: 'ty_gia_ngoai_te',
                cellsalign: 'right',
                minwidth: 100,
                cellsformat: 'c2'
            }, {
                text: 'Tỉ giá',
                dataField: 'price',
                width: 90,
                cellsalign: 'right',
                cellsformat: 'c2'
            }, {
                text: 'Trị giá VNĐ',
                dataField: 'tri_gia_vnd',
                width: 90,
                cellsalign: 'right',
                cellsformat: 'c2'
            }];


            // create data grid.
            $("#grid").jqxGrid({
                width: 950,
                height: 100,
                pagesize :1,
                pageable : true,
                source: dataAdapterNK,
                columns: columns
            });
            $("#grid1").jqxGrid({
                width: 950,
                height: 100,
                pagesize :1,
                pageable : true,
                source: dataAdapterNK,
                columns: columns
            });

            $("#jqxdatetimeinput").jqxDateTimeInput({
                width: '250px',
                height: '25px'
            });
            
            $("#btnNewHD").jqxButton({
                width: 200
            });
            $("#btnNewCodeNK").jqxButton({
                width: 200
            });
            $("#nextVanChuyenButtonInfo").jqxLinkButton({ width: '200', height: '25'});
            getDataThongTinThanhToan();
                       
        });
    </script>
    <style type="text/css">
        #form {
            height: 100px;
            float: left;
            margin-top: 30px;
            margin-left: 20px;
        }
        .inputContainer {
            width: 150px;
        }
        .formInput {
            width: 150px;
            outline: none;
        }
        #hintWrapper {
            height: 130px;
            float: left;
        }
        #hintSection {
            float: right;
            margin-top: 30px;
            margin-right: 20px;
            padding: 5px;
            width: 225px;
        }
        #checkBoxWrapper {
            float: left;
            margin-left: 20px;
            margin-top: 30px;
        }
        #section {
            margin: 5px;
        }
        #sectionButtonsWrapper {
            float: left;
            margin-right: 10px;
            width: 115px;
            margin-top: 160px;
        }
        #testWrapper {
            margin-left: 20px;
            margin-right: 10px;
            width: 115px;
        }
        #hintBasket {
            margin-left: 5px;
            margin-top: 7px;
            float: left;
            padding: 5px;
        }
        .basket div {
            position: relative;
        }
        .nextButton {
            float: left;
            margin-right: 5px;
        }
        .backButton {
            float: left;
            margin-left: 0px;
        }
        #basketButtonsWrapper {
            float: right;
            margin-top: 30px;
            margin-right: 10px;
            width: 115px;
        }
        #selectedProductsHeader {
            margin-left: 20px;
            float: left;
            width: 200px;
        }
        #selectedProductsButtonsWrapper {
            float: right;
            margin-right: 10px;
            width: 115px;
            margin-top: 160px;
        }
        #products {
            border: none;
        }
    </style>
</head>

<body class='default'>
    <div id='jqxWidget'>
        <H1>Quy Trình Nhập Khẩu</H1>
        <div id='jqxTabs'>
            <ul>
                <li style="margin-left: 30px;">Thông tin HĐ/Thông tin CODE hàng/Giá trị & Số lượng</li>
                <li>Kế toán YC Ngân Hàng/Lịch sử Thanh Toán</li>
                <li>Phương Thức Thanh Toán CODE/Ký Hậu</li>
                <li>Duyệt</li>
            </ul>
            <div class="section">
                <div id="form">
                <div class="hint" id="hintSection">
                </div>                            
                    Code Hợp Đồng:
                    <div id="jqxdropdownbutton" class="inputContainer">
                        <div style="border-color: transparent;" id="jqGridCodeNH" class="formInput">
                        </div>
                    </div>
                    Code Nhập Khẩu:
                    <div id="jqxdropdownbuttonNK" class="inputContainer">
                        <div style="border-color: transparent;" id="jqGridCodeNK" class="formInput">
                        </div>
                    </div>                  
                    Giá trị & Số lượng Lúc ký HĐ:
                    <div id="grid">
                    </div>
                    Giá trị & Số lượng Thực Tế:
                    <div id="grid1">
                    </div>
                    Ngày Giao Hàng Muộn Nhất :
                    <div id='jqxdatetimeinput'></div>
                    <div style="margin-top: 10px;">
                        <input type="button" value="Thêm Mới Hợp Đồng" id="btnNewHD"/>
                        <input type="button" value="Thêm Mới Code Nhập Khẩu" id="btnNewCodeNK"/>                    
                        <input type="button" value="Thông Tin Thanh Toán" class="nextButton" id="nextButtonInfo" />
                		<a href="./xnk_nk_van_tai" id='nextVanChuyenButtonInfo'>Thông Tin Vận Chuyển</a>                                            
                    </div>
                </div>

            </div>
            <div class="section">
                                 
                     <br/>
                    <div style="margin-top: 10px;">
                     Code Hợp Đồng: <input type="text" id="inputHopDong" disabled="disabled"/>
                     </div>
                                          <br/>                  
                     
                     <div>
                    Code Nhập Khẩu:<input type="text" id="inputNhapKhau" disabled="disabled"/>                                           
                    </div>            
            Phương Thức Thanh Toán CODE:
                                 <br/>
                     <br/>
            
		        <div id="jqxgrid">
		        </div> 
        <div id="jqxwindow1">
            <div>
                Update Thông Tin Ngân Hàng</div>
            <div style="overflow: hidden;">
                <div>
                    Ngân Hàng:</div>
                <div style='margin-top:5px;'>
                    <input id='inputField' type="text" class="jqx-input" style="width: 200px; height: 23px;" />
                </div>
                <div>
                    <input type="button" style='margin-top: 15px; margin-left: 50px; float: left;' value="Update" id="findButton" />
                    <input type="button" style='margin-left: 5px; margin-top: 15px; float: left;' value="Cancel" id="clearButton" />
                </div>
            </div>
        </div>	        
		         
		                          <br/>
                     <br/>        
            Lịch Sử Thanh Toán:
                                 <br/>
                     <br/>
            
		        <div id="jqxgrid2"></div>		        
                <div class="hint" id="hintBasket">
                </div>
                <div id="basketButtonsWrapper">
                    <input type="button" value="Back" class="backButton" id="backButtonBasket" />
                    <input type="button" value="Next" class="nextButton" id="nextButtonBasket" />
                </div>
            </div>
            <div class="section">
                <div id="selectedProductsHeader">
                    <h4>Selected products</h4>
                    <div id="orderContainer">
                    </div>
                </div>
                <div id="selectedProductsButtonsWrapper">
                    <input type="button" value="Back" id="backButtonReview" class="backButton" />
                </div>
            </div>
            <div class="section">
                <div id="selectedProductsHeaderFinal">
                    <h4>Selected products</h4>
                    <div id="orderContainer">
                    </div>
                </div>
                <div id="selectedProductsButtonsWrapper">
                    <input type="button" value="Back" id="backButtonReview" class="backButton" />
                </div>
            </div>
        </div>
    </div>
</body>

</html>

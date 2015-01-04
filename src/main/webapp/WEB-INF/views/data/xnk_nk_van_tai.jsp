<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="shortcut icon" href="favicon.ico">
<script src="./resources/jqm/1.4.4/demos/js/jquery.js"></script>
 
<script src="./resources/jqwidgets/jqx-all.js"></script>
<!-- <script src="./resources/jqwidgets/jqxcore.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxtabs.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxbuttons.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxinput.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdata.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcombobox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxlistbox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxscrollbar.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdatetimeinput.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcalendar.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcheckbox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxwindow.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdatatable.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdata.export.js"></script> -->
<!-- --------------------------------------------------------- -->
<script src="./resources/jqwidgets/globalization/globalize.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.energyblue.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.office.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.orange.css">
<link rel="stylesheet" href="./resources/opec.css">

</head>

<body>



<div id='jqxWidget'>
        <div id='jqxTabs'>
            <ul>
                <li style="margin-left: 5px;"><spring:message code="van_tai.tab1"/></li>
                <li><spring:message code="van_tai.tab2"/></li>
            </ul>
            
            <div style='height:"100%";'>
	            <div id='jqxWidget' class='content_db' style=" font-size: 14px; font-family: Verdana; height: 30px; margin: 0px; padding: 2px 2px; border-radius: 2px;">
				    <button class="jqx-rc-all" style='width:80px; height:30px' id="cmdNew" onclick="newItem()"><spring:message code="db.new"/></button>
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdEdit" onclick="editItem()"><spring:message code="db.edit"/></button>
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdDelete" onclick="deleteItem()"><spring:message code="db.del"/></button>
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdExport" onclick="exportXls()"><spring:message code="db.export"/></button>
				</div>
				
	           	<div id="jqxDataTable1" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
				</div>
            </div>
            
            <div id="jqxDataTable2" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
			</div>
			
            
        </div> 
</div>

<!-- Giao dien Dialog dung cho viec them moi/chinh sua du lieu -->
<div style="overflow: hidden; visibility: hidden;" id="dialog">
	<div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_db'>
         
         <table style="table-layout: fixed; border-style: none;">
             <tr>
                 <td align="right"><spring:message code="van_tai.code"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='code'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.so_hop_dong"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_hop_dong'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.ma_hang"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='ma_hang'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.so_luong"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_luong'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.loai_container"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='loai_container'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.so_luong_container"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_luong_container'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.cang_nhap"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='cang_nhap'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.cang_xuat"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='cang_xuat'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.cang_xuat"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='cang_xuat_cbo'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.cang_den_cuoi"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='cang_den_cuoi'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.so_bill"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_bill'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.ngay_bill"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_bill'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.eta"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='eta'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.etd"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='etd'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.hang_tau"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='hang_tau'/>
                     <!-- 
                     <div style='float: left; margin-top: 2px;' id='browse_hang_tau'>
                     	<div style="border-color: transparent;" id="jqxgrid">
            			</div>
                     </div>
                     -->
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.agent"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='agent'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.ngay_cap_cang"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_cap_cang'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.dem"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_dem'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.han_luu_container"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_container'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.det"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_det'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.han_luu_vo"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_vo'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.so_ngay_luu_bai"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_ngay_luu_bai'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.han_luu_bai"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_bai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.dia_diem_tra_rong"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='dia_diem_tra_rong'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.local_charge"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='local_charge'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.pallet"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 8px;' id='pallet'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.loai_pallet"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='pallet_loai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="van_tai.so_luong"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='pallet_so_luong'/>
                 </td>
                 
                 <td align="right"><spring:message code="van_tai.ghi_chu"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='ghi_chu'/>
                 </td>
             </tr>
             
                          
             <tr>
                 <td colspan="4" align="right">
                      <button id="cmdSave"><spring:message code="db.save"/></button> 
                      <button id="cmdCancel" style="margin-left: 5px; margin-top: 5px;"><spring:message code="db.cancel"/></button>
                  </td>                    
              </tr>
         </table>
     </div>
</div>
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/dm_hang_tau_bien.js"></script>
<script src="./resources/opec/dm_don_vi_van_tai.js"></script>
<script src="./resources/opec/xnk_nk_van_tai.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		xnk_nk_van_tai();
		
		/*
		$("#jqxgrid").jqxDataTable(
		{
			theme: 'energyblue',
			width: 'auto',
			height: 'auto',
			source: dmHangTauBien(),
			pageable: true,
			pagerMode: 'default',
			altRows: false,
			columnsResize: true,
			columnsReorder: true,
			columnsheight: 50,
			filterable: true,
			filtermode: 'simple',
			sortable: true,
			localization: gridLocalization(),
			pageSize: 20,
			columns: [
			          { text: 'STT', datafield: 'hangtau_id', width: 60 },
			          { text: 'Mã HT', datafield: 'hangtau_ma', width: 100 },
			          { text: 'Tên hãng tàu', datafield: 'hangtau_ten' },
			          { text: 'Quốc gia', datafield: 'quocgia_ten', width: 100 },
			]
		});
		*/
		
	});
  
</script>


</html>
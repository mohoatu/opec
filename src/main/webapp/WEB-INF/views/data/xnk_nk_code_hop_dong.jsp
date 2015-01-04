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
<script src="./resources/jqwidgets/globalization/globalize.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.energyblue.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.office.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.orange.css">
<link rel="stylesheet" href="./resources/opec.css">

</head>

<body>

<div id='jqxWidget' class="jqx-rc-all"  style='margin: 5px;'>
    <button class="jqx-rc-all" style='width:80px; height:30px' id="cmdNew" onclick="newItem()"><spring:message code="db.new"/></button>
    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdEdit" onclick="editItem()"><spring:message code="db.edit"/></button>
    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdDelete" onclick="deleteItem()"><spring:message code="db.del"/></button>
    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdExport" onclick="exportXls()"><spring:message code="db.export"/></button>
</div>

<!--  Bang du lieu -->
<div id="jqxDataTable" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
</div>

<!-- Giao dien Dialog dung cho viec them moi/chinh sua du lieu -->
<div style="overflow: hidden; visibility: hidden;" id="dialog">
	<div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_db'>
		  
         <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_db_item'>
         	<table style="table-layout: fixed; border-style: none;">
	             <tr>
	                 <td align="right"><spring:message code="code_hd.code"/></td>
	                 <td align="left">
	                     <input id='code' type="text"/>
	                 </td>
	             </tr>
	             
	             <tr>
	             	 <td align="right"><spring:message code="code_hd.so_hop_dong"/></td>
	                 <td colspan="2" align="left">
	                     <input id='so_hop_dong' type="text"/>
	                 </td>
	             </tr>
	             
	             <tr>
	             	 <td align="right"><spring:message code="code_hd.ten_hang"/></td>
	                 <td colspan="2" align="left">
	                     <div id='ten_hang'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.nhom_hang"/></td>
	                 <td align="left">
	                     <input id='nhom_hang' type="text"/>
	                 </td>
	             </tr>
	          </table>
         </div>
         
         <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_db_item'>
	         <table style="table-layout: fixed; border-style: none;">
	             <tr>
	                 <td align="right"><spring:message code="code_hd.so_luong"/></td>
	                 <td align="left">
	                     <div id='so_luong'> </div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.don_vi_tinh"/></td>
	                 <td align="left">
	                     <input id='don_vi_tinh' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.don_gia_nt"/></td>
	                 <td align="left">
	                     <div id='don_gia_ngoai_te'></div>
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="code_hd.ty_gia_nt"/></td>
	                 <td align="left">
	                     <div id='ty_gia_ngoai_te'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.tri_gia_nt"/></td>
	                 <td align="left">
	                     <div id='tri_gia_ngoai_te'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.thanh_tien_vnd"/></td>
	                 <td align="left">
	                     <div id='tri_gia_vnd' />
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="code_hd.phuong_thuc_gia"/></td>
	                 <td align="left">
	                     <div id='phuong_thuc_gia'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.dung_sai"/></td>
	                 <td align="left">
	                     <input id='dung_sai' type="text"/>
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="code_hd.loai_container"/></td>
	                 <td align="left">
	                     <div id='loai_container'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.so_luong_container"/></td>
	                 <td align="left">
	                     <div id='so_luong_container'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.han_giao_hang"/></td>
	                 <td align="left">
	                     <div id='ngay_hen_giao_hang'></div>
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="code_hd.cang_nhap"/></td>
	                 <td align="left">
	                     <div id='cang_nhap'></div>
	                 </td>
	                 <td align="right"><spring:message code="code_hd.cang_xuat"/></td>
	                 <td align="left">
	                     <div id='cang_xuat'></div>
	                 </td>
	             </tr>
	             
	             <tr>
	             	<td align="right"><spring:message code="code_hd.ghi_chu"/></td>
	                 <td colspan="5" align="left">
	                     <input id='ghi_chu' type="text"/>
	                 </td>
	             </tr>
	             
	          </table>
	        </div>
	        
	        <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana; " class='content_db_item'>
	            <table style="table-layout: fixed; border-style: none;">
	              
	             <tr>
	                 <td align="right" style="white-space: nowrap;"><spring:message code="code_hd.so_lan_thanh_toan"/></td>
	                 <td align="left" width="100%">
	                     <div id='so_lan_thanh_toan'></div>
	                 </td>
	             </tr>
	             
	             <tr>
	             	<td colspan="2" align="left">
	             		<div id="jqxDataTT" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
						</div>
	             	</td>
	             </tr>
	             
	             <tr>
	                 <td colspan="2" align="right">
	                      <br />
	                      <button id="cmdSave"><spring:message code="db.save"/></button> 
	                      <button  id="cmdCancel" style="margin-left: 5px;"><spring:message code="db.cancel"/></button>
	                  </td>                    
	              </tr>
	         </table>
         </div>
     </div>
</div>
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/xnk_nk_code_hop_dong.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
		
		xnk_nk_code_hop_dong();
		initControl();
		initDanhmuc();
		
	});
	  
</script>


</html>
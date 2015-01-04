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
	                 <td align="right"><spring:message code="ky_hau.code"/></td>
	                 <td align="left">
	                     <input id='code' type="text"/>
	                 </td>
	             </tr>
	             <tr>
	             	 <td align="right"><spring:message code="ky_hau.so_hop_dong"/></td>
	                 <td align="left">
	                     <input id='so_hop_dong' type="text"/>
	                 </td>
	             </tr>
	             <tr>
	             	 <td align="right"><spring:message code="ky_hau.ma_hang"/></td>
	                 <td align="left">
	                     <div id='ma_hang'></div>
	                 </td>
	             </tr>
	          </table>
         </div>
         
         <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_db_item'>
	         <table style="table-layout: fixed; border-style: none;">
	             <tr>
	                 <td align="right"><spring:message code="ky_hau.so_luong"/></td>
	                 <td align="left">
	                      <input id='so_luong' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="ky_hau.don_gia_nt"/></td>
	                 <td align="left">
	                     <input id='don_gia_ngoai_te' type="text"/>
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="ky_hau.ty_gia_nt"/></td>
	                 <td align="left">
	                     <input id='ty_gia_ngoai_te' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="ky_hau.tri_gia_nt"/></td>
	                 <td align="left">
	                     <input id='tri_gia_ngoai_te' type="text"/>
	                 </td>
<%-- 	                 <td align="right"><spring:message code="ky_hau.thanh_tien_vnd"/></td>
	                 <td align="left">
	                     <input id='tri_gia_vnd' type="text"/>
	                 </td> --%>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="ky_hau.ngan_hang"/></td>
	                 <td align="left">
	                     <input id='ngan_hang' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="ky_hau.so_ngay_tra_cham"/></td>
	                 <td align="left">
	                     <input id='so_ngay_tra_cham' type="text"/>
	                 </td>
	             </tr>
	             
	             <tr>
	                 <td align="right"><spring:message code="ky_hau.gia_tri_thuc_te"/></td>
	                 <td align="left">
	                    <input id='gia_tri_thuc_te' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="ky_hau.so_tien_tt_bang_von_tu_co"/></td>
	                 <td align="left">
	                     <input id='tien_thanh_toan_von_tu_co' type="text"/>
	                 </td>
	             </tr>
	             <tr>
	                 <td align="right"><spring:message code="ky_hau.so_tien_no"/></td>
	                 <td align="left">
	                     <input id='tien_no' type="text"/>
	                 </td>
	                 <td align="right"><spring:message code="ky_hau.thoi_han_thanh_toan"/></td>
	                 <td align="left">
	                     <input id='thoi_han_thanh_toan' type="text"/>
	                 </td>
	          <%--        <td align="right"><spring:message code="ky_hau.ho_so_ky_hau_da_chuyen"/></td>
	                 <td align="left">
	                     <div id='ho_so_goc_da_chuyen'></div>
	                 </td> --%>
	             </tr>
	             <tr>

	             	<td align="right"><spring:message code="ky_hau.ghi_chu"/></td>
	                 <td  align="left">
	                     <input id='ghi_chu' type="text"/>
	                 </td>
	                <td align="right"><spring:message code="ky_hau.ho_so_ky_hau_da_chuyen"/></td>
	                 <td align="left">
	                     <input id='ho_so_goc_da_chuyen' type="text"/>
	                 </td>
	             </tr>
	             <tr>
	                 <td align="right" style="white-space: nowrap;"><spring:message code="code_hd.so_lan_thanh_toan"/></td>
	                 <td align="left" width="100%">
	                     <input id='so_lan_thanh_toan' type="text"/>
	                 </td>
	             </tr>
<%-- 	             <tr>
	                 <td colspan="2" align="right">
	                      <br />
	                      <button id="cmdSave"><spring:message code="db.save"/></button> 
	                      <button  id="cmdCancel" style="margin-left: 5px;"><spring:message code="db.cancel"/></button>
	                  </td>                    
	              </tr> --%>
	          </table>
	        </div>
	      
     </div>
</div> 
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/xnk_nk_ky_hau.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		
		xnk_nk_ky_hau();
 		initControl();
		initDanhmuc();
	});
  
</script>


</html>
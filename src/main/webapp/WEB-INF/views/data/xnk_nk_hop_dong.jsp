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
		 <div style='margin: 10px;'>
            <h3><spring:message code="hd.title"/></h3>
            <hr>
         </div>
         
         <table style="table-layout: fixed; border-style: none;">
             <tr>
                 <td align="right"><spring:message code="hd.phapnhan_ten"/></td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='phapnhan_ten'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="hd.so_hop_dong"/>*</td>
                 <td align="left">
                     <input id='so_hop_dong' type="text"/>
                 </td>
             </tr>
            
             <tr>
                 <td align="right"><spring:message code="hd.nhacungcap_ten"/>*</td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='nhacungcap_ten'/>
                 </td>
             </tr>
                 
             <tr>
                 <td align="right"><spring:message code="hd.nhanvien_ten"/>*</td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='nhanvien_ten'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="hd.mucdoyc_ten"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='mucdoyc_ten'/>
                 </td>
                 
                 <td align="right"><spring:message code="hd.tiente_ten"/>*</td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='tiente_ten'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="hd.ngay_ky_hop_dong"/>*</td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_ky_hop_dong'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="hd.ngay_giao_hop_dong"/>*</td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_giao_hop_dong'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="hd.ngay_het_hieu_luc_hop_dong"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_het_hieu_luc_hop_dong'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="hd.ghi_chu"/></td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='ghi_chu' />
                 </td>
             </tr>
             
             <tr>
                 <td colspan="4" align="right">
                      <button id="save"><spring:message code="db.save"/></button> 
                      <button style="margin-left: 5px; margin-top: 5px;" id="cancel"><spring:message code="db.cancel"/></button>
                  </td>                    
              </tr>
         </table>
     </div>
</div>
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/xnk_nk_hop_dong.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		
		xnk_nk_hop_dong();
		initControl();
		initDanhmuc();
	});
  
</script>


</html>
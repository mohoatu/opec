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



<div id='jqxWidget'>
        <div id='jqxTabs'>
            <ul>
                <li style="margin-left: 5px;"><spring:message code="thue.tab1"/></li>
                <li><spring:message code="thue.tab2"/></li>
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
                 <td align="right"><spring:message code="thue.code"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='code'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.so_to_khai_hq"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_to_khai_hq'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.ngay_to_khai_hq"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_to_khai_hq'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.thue_suat_nhap_khau"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='thue_suat_nhap_khau'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.thue_suat_vat"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='thue_suat_vat'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.cuoc_bien"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='cuoc_bien'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.bao_hiem"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='bao_hiem'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.ty_gia_nop"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ty_gia_nop'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.so_tien_nop"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_tien_nop'/>
                 </td>
             </tr>
            
             <tr>
                 <td align="right"><spring:message code="thue.tien_thue_nhap_khau"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='tien_thue_nhap_khau'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.tien_thue_vat"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='tien_thue_vat'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.thoi_han_nop"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='thoi_han_nop'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.tien_nop_thuc_te"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='tien_nop_thuc_te'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.ngay_nop_thuc_te"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_nop_thuc_te'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="thue.nguoi_nop"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='nguoi_nop'/>
                 </td>
                 
                 <td align="right"><spring:message code="thue.da_nop"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='da_nop'/>
                 </td>
             </tr>
            
             <tr>
                 <td align="right"><spring:message code="thue.ghi_chu"/></td>
                 <td colspan="3" align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='ghi_chu'/>
                 </td>
             </tr>
             
             <tr>
                 <td colspan="4" align="right">
                      <button id="cmdSave"><spring:message code="db.save"/></button> 
                      <button id="cmdCancel" style="margin-left: 5px; margin-top: 5px;" ><spring:message code="db.cancel"/></button>
                  </td>                    
              </tr>
         </table>
     </div>
</div>
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/xnk_nk_thue.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		xnk_nk_thue();
		
	});
  
</script>


</html>
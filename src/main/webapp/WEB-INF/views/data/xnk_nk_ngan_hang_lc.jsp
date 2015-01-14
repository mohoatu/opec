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
                <li style="margin-left: 5px;"><spring:message code="nganhang_lc.tab1"/></li>
                <li><spring:message code="nganhang_lc.tab2"/></li>
                <li><spring:message code="nganhang_lc.tab3"/></li>
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
             <div style='height:"100%";'>
	            <div id='jqxWidget1' class='content_db' style=" font-size: 14px; font-family: Verdana; height: 30px; margin: 0px; padding: 2px 2px; border-radius: 2px;">
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdEdit1" onclick="editItem()"><spring:message code="db.edit"/></button>
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdExport1" onclick="exportXls()"><spring:message code="db.export"/></button>
				</div>				             
            <div id="jqxDataTable2" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
			</div>
			</div>
			 <div style='height:"100%";'>
			 	<div id='jqxWidget2' class='content_db' style=" font-size: 14px; font-family: Verdana; height: 30px; margin: 0px; padding: 2px 2px; border-radius: 2px;">
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdEdit2" onclick="editItem()"><spring:message code="db.edit"/></button>
				    <button class="jqx-rc-all" style='width:80px; height:30px'id="cmdExport2" onclick="exportXls()"><spring:message code="db.export"/></button>
				</div>
			<div id="jqxDataTable3" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
			</div>
			</div>
            
        </div> 
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
                 <td align="right">Id Thanh Toan</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' id='thanhtoan_id'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right">Code ID></td>
                 <td align="left">
                     <input id='code_id' type="text"/>
                 </td>
             </tr>
            
             <tr>
                 <td align="right">Thanh Toan Thu Tu</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' id='thanhtoan_thu_tu'/>
                 </td>
             </tr>
                 
             <tr>
                 <td align="right">Phuong Thuc Thanh TOan ID</td>
                 <td colspan="3" align="left">
                     <div id='phuongthuctt_id'></div>
                 </td>
             </tr>
             
             <tr>
                 <td align="right">ngay_han_mo</td>
                 <td align="left">
                      <div id='ngay_han_mo'></div>
                 </td>
                 
                 <td align="right">so_ngay_tra_cham</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' id='so_ngay_tra_cham'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right">nganhang_id</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' id='nganhang_id'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right">ngay_han_muc_vay</td>
                 <td align="left">
                      <div id='ngay_han_muc_vay'></div>
                 </td>
             </tr>
             
             <tr>
                 <td align="right">so_tien_vay_no</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' id='so_tien_vay_no'/>
                 </td>
             </tr>
             
             <tr>
             	 <td align="right">lai_suat_vay_no</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='lai_suat_vay_no' />
                 </td>
             </tr>
               <tr>
             	 <td align="right">ngay_chung_tu_gui_ngan_hang</td>
                 <td colspan="3" align="left">
                   <div id='ngay_chung_tu_gui_ngan_hang'></div>
                 </td>
             </tr>
              <tr>
             	 <td align="right">so_luong_hang_thuc_te</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='so_luong_hang_thuc_te' />
                 </td>
             </tr>
             
                           <tr>
             	 <td align="right">tri_gia_thuc_te</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='tri_gia_thuc_te' />
                 </td>
             </tr>
                <tr>
             	 <td align="right">so_tien_tu_thanh_toan</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='so_tien_tu_thanh_toan' />
                 </td>
             </tr>
               <tr>
             	 <td align="right">so_tien_ky_no</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='so_tien_ky_no' />
                 </td>
             </tr>
                            <tr>
             	 <td align="right">ngay_thanh_toan_thuc_te</td>
                 <td colspan="3" align="left">
                  <div id='ngay_thanh_toan_thuc_te'></div>
                 </td>
             </tr>
                 <tr>
             	 <td align="right">so_tien_thanh_toan_thuc_te</td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='so_tien_thanh_toan_thuc_te' />
                 </td>
             </tr>
               <tr>
             	 <td align="right">ghi_chu</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='ghi_chu' />
                 </td>
           	 <td align="right">ngay_mo_lc</td>
                 <td align="left">
                    <div id='ngay_mo_lc'></div>
                 </td>
             </tr>
                                         <tr>
             	 <td align="right">so_lc</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='so_lc' />
                 </td>
             	 <td align="right">phapnhan_ten</td>
                 <td align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='phapnhan_ten' />
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
<script src="./resources/opec/xnk_nk_ngan_hang.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		xnk_nk_ngan_hang_lc();
		initDanhmuc(); 
		initControl();
	/* 	initControl();
		initDanhmuc(); */
	});
  
</script>


</html>
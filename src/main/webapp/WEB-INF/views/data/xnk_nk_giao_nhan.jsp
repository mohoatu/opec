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
                <li style="margin-left: 5px;"><spring:message code="giao_nhan.tab1"/></li>
                <li><spring:message code="giao_nhan.tab2"/></li>
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
                 <td align="right"><spring:message code="giao_nhan.code"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='code'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.cang_nhap"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='cang_nhap'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.nhom_hang"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='nhom_hang'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.ma_hang"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='ma_hang'/>
                 </td>
             </tr>
            
             <tr>
                 <td align="right"><spring:message code="giao_nhan.so_luong"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_luong'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.so_luong_con_lai"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_luong_con_lai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.han_luu_container"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_container'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.han_luu_bai"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_bai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.han_luu_vo"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='han_luu_vo'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.so_container_con_lai"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_container_con_lai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.loai_container"/></td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='loai_container'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.don_vi_van_tai"/></td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='don_vi_van_tai'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.khach_hang"/></td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='khach_hang'/>
                 </td>
             </tr>    
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.dia_chi"/></td>
                 <td colspan="3" align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='dia_chi'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.so_luong_giao_yeu_cau"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_luong_giao_yeu_cau'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.so_luong_giao_thuc_te"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_luong_giao_thuc_te'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.ngay_yc_keo_container_khoi_cang"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_yc_keo_container_khoi_cang'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.ngay_giao_hang_thuc_te"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='ngay_giao_hang_thuc_te'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.so_luong_container"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='so_luong_container'/>
                 </td>
                 <td align="right"><spring:message code="giao_nhan.da_giao_xong_code"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='da_giao_xong_code'/>
                 </td>
             </tr>
             
             <tr>
                 <td align="right"><spring:message code="giao_nhan.ghi_chu"/></td>
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
<script src="./resources/opec/xnk_nk_giao_nhan.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		xnk_nk_giao_nhan();
		
	});
  
</script>


</html>
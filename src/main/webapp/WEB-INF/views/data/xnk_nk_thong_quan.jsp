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
                <li style="margin-left: 5px;"><spring:message code="thong_quan.tab1"/></li>
                <li><spring:message code="thong_quan.tab2"/></li>
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
                 <td align="right"><spring:message code="thong_quan.code"/></td>
                 <td align="left">
                     <input type='text'  style='float: left; margin-top: 2px;' id='code'/>
                 </td>
                 
                 <td align="right"><spring:message code="thong_quan.so_hop_dong"/></td>
                 <td align="left">
                     <input type='text' id='so_hop_dong' />
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="thong_quan.loai_hinh_nhap_khau"/></td>
                 <td colspan="3" align="left">
                     <div  style='float: left; margin-top: 2px;' id='loai_hinh_nhap_khau' />
                 </td>
             </tr>
            
             <tr>
                 <td align="right"><spring:message code="thong_quan.so_to_khai_hq"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id='so_to_khai_hq'/>
                 </td>
                 
                 <td align="right"><spring:message code="thong_quan.ngay_to_khai_hq"/></td>
                 <td align="left">
                     <div  style='float: left; margin-top: 2px;' id='ngay_to_khai_hq' />
                 </td>
             </tr>
                 
             <tr>
                 <td align="right"><spring:message code="thong_quan.phan_luong_to_khai"/></td>
<!--                  <td colspan="3" align="left"> -->
<!--                      <div  style='float: left; margin-top: 2px;' id='phan_luong_to_khai' /> -->
<!--                  </td> -->
				 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id=phan_luong_to_khai_txt />
                 </td>
              </tr>
              
              <tr>   
                 <td align="right"><spring:message code="thong_quan.chi_cuc_hai_quan"/></td>
                 <td colspan="3" align="left">
                     <div  style='float: left; margin-top: 2px;' id='chi_cuc_hai_quan' />
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="thong_quan.don_vi_khai"/></td>
                 <td colspan="3" align="left">
                     <div style='float: left; margin-top: 2px;' id='don_vi_khai' />
                 </td>
             </tr>
             
             <tr>
             	 <td align="right"><spring:message code="thong_quan.ghi_chu"/></td>
                 <td colspan="3" align="left">
                     <input style='float: left; margin-top: 2px;' type="text" id='ghi_chu' />
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
<script src="./resources/opec/dm_chi_cuc_hai_quan.js"></script>
<script src="./resources/opec/dm_loai_hinh_xnk.js"></script>
<script src="./resources/opec/dm_don_vi_van_tai.js"></script>
<script src="./resources/opec/xnk_nk_thong_quan.js"></script>

<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		xnk_nk_thong_quan();
		
	});
  
</script>


</html>
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

<div id='jqxWidget' class="jqx-rc-all" align="right" style='margin: 5px;'>
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
		<div>
			<h3><spring:message code="dm_ncc.title"/></h3>
			<hr>
		</div>
        <table style="table-layout: fixed; border-style: none;">
             <tr>
                 <td align="left"><spring:message code="dm_ncc.id"/></td>
                 <td align="left">
                     <input id="nhacungcap_id" type="text" readonly="true" disabled="disabled" style="width:100px;" />
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.ma"/></td>
                 <td align="left">
                     <input id="nhacungcap_ma" type="text" style="width:100px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.ten"/></td>
                 <td align="left">
                     <input id="nhacungcap_ten" type="text" style="width:300px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.dia_chi"/></td>
                 <td align="left">
                     <input id="dia_chi" type="text" style="width:300px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.nguoi_lien_he"/></td>
                 <td align="left">
                     <input id="nguoi_lien_he" type="text" style="width:200px; margin-top: 5px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.dien_thoai"/></td>
                 <td align="left">
                     <input id="dien_thoai" type="text" style="width:100px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.fax"/></td>
                 <td align="left">
                     <input id="fax" type="text" style="width:100px;"/>
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_ncc.quoc_tich"/></td>
                 <td align="left">
                     <div style='float: left; margin-top: 2px;' id='quoc_tich'/>
                 </td>
             </tr>
             <tr>
                 <td colspan="2" align="right">
                      <br />
                      <button id="cmdSave"><spring:message code="db.save"/></button> 
                      <button id="cmdCancel" style="margin-left: 5px;" ><spring:message code="db.cancel"/></button>
                  </td>                    
              </tr>
         </table>
     </div>
</div>
<!-- Ket thuc giao dien Dialog dung cho viec them moi/chinh sua du lieu -->

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/dm_trang_thai_giao_hang.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
	
		initControl();
		initDanhmuc();
	});
  
</script>


</html>
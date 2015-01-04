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
		
        <table style="table-layout: fixed; border-style: none;">
             <tr>
                 <td align="left"><spring:message code="dm_phanloaihanghoa.phanloai_ma"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id="phanloai_ma" />
                 </td>
             </tr>
             <tr>
                 <td align="left"><spring:message code="dm_phanloaihanghoa.phanloai_ten"/></td>
                 <td align="left">
                     <input type='text' style='float: left; margin-top: 2px;' id="phanloai_ten" />
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
<script src="./resources/opec/dm_phan_loai_hang_hoa.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
	
		initControl();
		initDanhmuc();
	});
  
</script>


</html>
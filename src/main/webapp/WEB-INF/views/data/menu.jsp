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

<div id='jqxWidget' style=" font-size: 14px; font-family: Verdana;" class='content_title'>
	<h3><spring:message code="module.menu"/></h3>
</div>

<div id='jqxWidget' class="jqx-rc-all" align="left" style='margin: 5px;'>
    <button class="jqx-rc-all" id="cmdNew" onclick="newItem()"><spring:message code="db.new"/></button>
    <button class="jqx-rc-all" id="cmdEdit" onclick="editItem()"><spring:message code="db.edit"/></button>
    <button class="jqx-rc-all" id="cmdDelete" onclick="deleteItem()"><spring:message code="db.del"/></button>
    <button class="jqx-rc-all" id="cmdXml" onclick="loadXml()">Xml</button>
    <button class="jqx-rc-all" id="cmdImport" onclick="importXml()">Import</button>
</div>

<!--  Bang du lieu -->
<div id="jqxTreeGrid" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
</div>


</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/menu.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		
	});
  
</script>


</html>

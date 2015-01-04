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
	<h3><spring:message code="module.user"/></h3>
</div>

  
<div id="mainSplitter">
    <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana; width: 200px;" class='content_db'>
        <div id="tableUser"></div>
    </div>
    <div>
        <div class="jqx-hideborder jqx-hidescrollbars" id="tabswidget">
            <ul>
                <li style="margin-left: 30px;"><spring:message code="user.tab1"/></li>
                <li><spring:message code="user.tab2"/></li>
                <li>Tree Widget</li>
                <li><spring:message code="user.tab3"/></li>
            </ul>
            
            <!-- TAB 1 -->
            <div id='jqxWidget' style=" font-size: 14px; font-family: Verdana; height:100%;" class='content_db_item'>
                <table style="table-layout: fixed; border-style: none;">
		             <tr>
		                 <td align="right"><spring:message code="user.username"/></td>
		                 <td align="left">
		                     <input type='text' style='float: left; margin-top: 2px;' id="username" />
		                 </td>
		             </tr>
		             <tr>
		                 <td align="right"><spring:message code="user.password"/></td>
		                 <td align="left">
		                     <input type='password' style='float: left; margin-top: 2px;' id="password" />
		                 </td>
		             </tr>
		             <tr>
		                 <td align="right"><spring:message code="user.fullname"/></td>
		                 <td align="left">
		                     <input type='text' style='float: left; margin-top: 2px;' id="fullname" />
		                 </td>
		             </tr>
		             <tr>
		                 <td align="right"><spring:message code="user.donvi"/></td>
		                 <td align="left">
		                     <div style='float: left; margin-top: 2px;' id="donvi" />
		                 </td>
		             </tr>
		             <tr>
		                 <td align="right"><spring:message code="user.enabled"/></td>
		                 <td align="left">
		                     <div style='float: left; margin-top: 2px;' id="enabled" />
		                 </td>
		             </tr>
		             
		         </table>
            </div>
            
            <!-- TAB 2 -->
            <div id="tableUserMenu" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
			</div>
            
            <!-- TAB 3 -->
            <div id="treeWidget" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
                
            </div>
            
            <!-- TAB 4 -->
            <div id="content1">
                Content 2
            </div>
        </div>
    </div>
</div>
    

<div id='jqxWidget' class="jqx-rc-all" align="right" style='margin: 5px;'>
    <button class="jqx-rc-all" id="cmdNew" onclick="newItem()"><spring:message code="db.new"/></button>
    <button class="jqx-rc-all" id="cmdEdit" onclick="editItem()"><spring:message code="db.edit"/></button>
    <button class="jqx-rc-all" id="cmdSave" onclick="newItem()"><spring:message code="db.save"/></button>
    <button class="jqx-rc-all" id="cmdCancel" onclick="newItem()"><spring:message code="db.cancel"/></button>
    <button class="jqx-rc-all" id="cmdDelete" onclick="deleteItem()"><spring:message code="db.del"/></button>
    <button class="jqx-rc-all" id="cmdExport" onclick="exportXls()"><spring:message code="db.export"/></button>
</div>

</body>

<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/menu.js"></script>
<script src="./resources/opec/user.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
		
		initControl();
		initDanhmuc();
		
	});
  
</script>


</html>
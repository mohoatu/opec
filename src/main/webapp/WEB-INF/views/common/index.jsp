<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.title"/></title>

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="./resources/jqm/1.4.4/demos/css/themes/default/jquery.mobile-1.4.4.min.css">
<link rel="stylesheet" href="./resources/jqm/1.4.4/demos/_assets/css/jqm-demos.css">
<script src="./resources/jqm/1.4.4/demos/js/jquery.js"></script>
<script src="./resources/jqm/1.4.4/demos/_assets/js/index.js"></script>
<script src="./resources/jqm/1.4.4/demos/js/jquery.mobile-1.4.4.min.js"></script> 
<!-- <link rel="stylesheet" href="./resources/mobile.css"> -->
<script src="./resources/jqwidgets/jqx-all.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.energyblue.css">
<link rel="stylesheet" href="./resources/opec.css">
<script src="./resources/opec.js"></script> 

</head>

<body>


<div id='content' style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px;'>
       
    <%@include file="header.jsp"%>       
	
	<iframe id="ref" src="./intro" seamless="" height="630" width="100%"></iframe>
	
	<%@include file="footer.jsp"%>
	
</div>

</body>

 <script type="text/javascript">
    
 $(document).ready(function () {
        
     //$("#jqxLogin").jqxButton({ width: 80, height: 25});

     var height = $(window).height();
	 document.getElementById('ref').style.height = (height - 125).toString() + 'px';
	 
	 
 });
 
</script>


</html>
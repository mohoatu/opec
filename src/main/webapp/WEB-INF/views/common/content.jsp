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
<link rel="stylesheet" href="./resources/jqm/1.4.4/demos/css/themes/default/jquery.mobile-1.4.4.min.css">
<link rel="stylesheet" href="./resources/jqm/1.4.4/demos/_assets/css/jqm-demos.css">
<script src="./resources/jqm/1.4.4/demos/js/jquery.js"></script>
<script src="./resources/jqm/1.4.4/demos/_assets/js/index.js"></script>
<script src="./resources/jqm/1.4.4/demos/js/jquery.mobile-1.4.4.min.js"></script> 
<link rel="stylesheet" href="./resources/mobile.css">
<script src="./resources/jqwidgets/jqx-all.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/opec.css">


</head>

<body>


<div id="contentview" style="left: 10px; top: 10px">
	
	<table>
	<tr>
	<td>
	<div>
         <div class="contentitem">
           <div style="height: 100%; position: relative; overflow: hidden;">

                 <img src="./resources/images/jqwidgets-intro.png" />
                 <div class="browsers" style="height: 30px; position: absolute; left: 25px; bottom: 15px; font-size: 10px;">Works with:</div>
                 <img class="browsers" style="height: 30px; position: absolute; left: 20px; bottom: 0px;" src="./resources/images/browserpcandmobileIcons.png" />

             </div>
         </div>
     </div>
     </td>
     </tr>
     
     <tr>
     <td>
	<div>
         <div class="contentitem">
           <div style="height: 100%; position: relative; overflow: hidden;">
 
                 <img src="./resources/images/jqwidgets-intro.png" />
                 <div class="browsers" style="height: 30px; position: absolute; left: 25px; bottom: 15px; font-size: 10px;">Works with:</div>
                 <img class="browsers" style="height: 30px; position: absolute; left: 20px; bottom: 0px;" src="./resources/images/browserpcandmobileIcons.png" />

             </div>
         </div>
     </div>
     </td>
     
     </tr>
     </table>     
</div>

</body>

 <script type="text/javascript">
    
 $(document).ready(function () {
        
    	var width = $(window).width(); //900;
        var height = 310;

        $("#contentview").jqxPanel({ width: 500, height: height, theme: "arctic" });
        $("#contentview").jqxPanel('refresh');
        $("#contentview").css('margin-left', 'auto');
        $("#contentview").css('margin-right', 'auto');
        
 });
 
</script>


</html>
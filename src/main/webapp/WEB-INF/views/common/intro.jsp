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
<!-- <link rel="stylesheet" href="./resources/mobile.css"> -->

<script src="./resources/jqwidgets/jqx-all.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/opec.css">


</head>

<body>


<div id="scrollview" style="left: 5px; top: 5px">
     <div>
         <div class="content">
           <div style="height: 510px; position: relative; overflow: hidden;">
                 <img src="./resources/images/cloudComputing.png" />
                 <div class="browsers" style="height: 30px; position: absolute; left: 25px; bottom: 15px; font-size: 10px;">Works with:</div>
                 <img class="browsers" style="height: 30px; position: absolute; left: 20px; bottom: 0px;" src="./resources/images/browserpcandmobileIcons.png" />
             </div>
         </div>
     </div>
     <div>
         <div class="content">
             <div>
                 <img height="402" src="./resources/images/jqwidgets-intro.png" />
             </div>
             <div>
                 Powerful Datagrid widget built entirely with open web standards. It offers rich functionality, easy to use APIs and works across devices and browsers. jqxGrid delivers advanced data visualization features and support for client and server paging, editing, sorting and filtering.
             </div>
         </div>
     </div>
     <div>
         <div class="content">
             <div>
                 <img height="402" src="./resources/images/jqwidgets-intro-chart.png" />
             </div>
             <div>
                 Beautiful Chart with the ability to render SVG, HTML5 and VML. Ideal choice for adding charting capabilities in your web applications. No browser plug-ins are required! Optimal chart rendering performance and high quality visualization across browsers and devices!
             </div>
         </div>
     </div>
     <div>
         <div class="content">
             <div>
                 <img height="402" src="./resources/images/jqwidgets-intro-treegrid.png" />
             </div>
             <div>
                  Smarter and Simple TreeGrid. The jQWidgets TreeGrid is a lightweight jQuery widget which represents data in a tree-like structure. The TreeGrid widget supports multi column display of hierarchical data, data paging, sorting and filtering, data editing and more! 
              </div>
         </div>
     </div>
 </div>
	
</div>

</body>

 <script type="text/javascript">
    
 $(document).ready(function () {
        
    	var width = $(window).width(); //900;
        var height = 550;
        if ($.jqx.response) {
            var response = new $.jqx.response();
            if (response.device.type != "Desktop") {
                $("img").css('max-width', '530px');
                $("img").css('max-height', '400px');
                if (response.device.type == "Phone") {
                    $("img").css('width', '100%');
                    $("img").css('height', '100%');
                }

                $(".browsers").addClass('browsers-mobile');
                $(".content").addClass('content-mobile');
                $("div").css('height', 'auto');
                height = Math.min(530, $(window).width());
                //width = Math.min(900, $(window).width());
                $("#scrollview").css('margin-left', 'auto');
                $("#scrollview").css('margin-right', 'auto');
            }
            $(window).on('orientationchange', function () {
                setTimeout(function () {
                    height = Math.min(530, $(window).width());
                    //width = Math.min(900, $(window).width());
                    $("#scrollview").jqxScrollView({ width: width, height: height });
                    $("#scrollview").jqxScrollView('refresh');
                    $("#scrollview").css('margin-left', 'auto');
                    $("#scrollview").css('margin-right', 'auto');
                }, 0);//25);
            });
        }
        $("#scrollview").jqxScrollView({ width: width, height: height, theme: "arctic", slideShow: false, slideDuration: 10000 });
        
 });
 
</script>


</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>

<title>Insert title here</title>

<link rel="stylesheet" href="./resources/opec-login.css">

</head>
<body>
	
	<div class="container">
			
			<header>
			
				<h1><spring:message code="app.login.h1"/></h1>
				<!-- <h2><spring:message code="app.login.h2"/></h2> -->
				
			</header>
			
			<section class="main">
				<form class="form-login" action="j_spring_security_check" method="post">
					<p class="field">
						<input type="text" id="j_username" name="j_username" placeholder="<spring:message code="app.login.username"/>">
						<i class="icon-user icon-large"></i>
					</p>
						<p class="field">
							<input type="password" id="j_password" name="j_password" placeholder="<spring:message code="app.login.password"/>">
							<i class="icon-lock icon-large"></i>
					</p>
					<p class="submit">
						<button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
					</p>
				</form>
				
			</section>
        </div>
        
</body>
</html>

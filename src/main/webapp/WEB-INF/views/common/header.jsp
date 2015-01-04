<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<script src="./resources/opec.js"></script> 
<link rel="stylesheet" href="./resources/opec.css">

<!-- TABLE -->
<table class='jqxTop' style="border-collapse: collapse; color: #777777; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 10px; width:100%; margin: 0px auto;"> 
	<tr style="height:10px;">
		<td>
			<a href="./home"><img src="./resources/images/logo.png" alt="opecPlastics"/></a>
		</td>
	
		<td style="width: 100px" align="left" valign="center">
			
			<c:if test="<%=SecurityContextHolder.getContext().getAuthentication() != null %>">
    			<p>
    			<h3><%=SecurityContextHolder.getContext().getAuthentication().getName()%></h3>
    			</p>
			</c:if>
			 
		</td>
		
		<!-- 
		<td style="width: 600px; height: 60px;" align="right" valign="center">
			<form class="form-login" action="j_spring_security_check" method="post" >
				<table>
					<tr>
						<td>Username:</td>
				        <td><input style="width: 120px;" type="text" name="user" /></td>
				        <td>Password:</td>
				        <td><input style="width: 120px;" type="password" name="password" /></td>
				        <td><input type="submit" name="submit" value="Sign in"></td>
					</tr>
				</table>
			</form>
		</td>
		 -->
		 
	</tr>
</table>

<!-- MENU -->
<div id='jqxMenu' class="jqx-rc-all" style='font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; width:"100%";'></div>
 
<script>

	initMenu();
	
</script>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>sign up form</title>
<link href="file:///G|/Workspace/spring-web/WebContent/static/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #878282;
}
</style>
</head>

<body>
	<s:form action="${pageContext.request.contextPath}/newUser" method="post" modelAttribute="user">
	<table width="50%" border="2" align="center" cellpadding="5" cellspacing="2">
  <tbody>
	  
    
	  <tr align="center" valign="middle" bgcolor="#F3E9E9">
	    <td colspan="2"><h2>New User</h2></td>
      </tr>
	  <tr>
      <td valign="middle" bgcolor="#F3E9E9"><label for="username">Username</label>
					</td>
      <td valign="middle"><s:input type="text" name="username" id="username" path="username"/>
					<s:errors path="username" class="error"></s:errors></td>
    </tr>
    <tr>
      <td valign="middle" bgcolor="#F3E9E9"><label for="email">Email</label>
					</td>
      <td valign="middle"><s:input type="text" name="email" id="email" path="email"/>
					<s:errors path="email" class="error"></s:errors></td>
    </tr>
    <tr>
      <td valign="middle" bgcolor="#F3E9E9"><label for="password">Password</label>
					</td>
      <td valign="middle"><s:input type="password" name="password" id="password" path="password"/>
					<s:errors path="password" class="error"></s:errors></td>
    </tr>
    <tr>
      <td valign="middle" bgcolor="#F3E9E9"><label for="passwordRepeat">Repeat Password</label>
					</td>
      <td valign="middle"><input type="password" name="passwordRepeat" id="passwordRepeat" /></td>
    </tr>
    <tr>
      <td valign="middle" bgcolor="#F3E9E9"><input type="submit" value="Register" /></td>
      <td valign="middle"><a href="#">I am already a
								member</a></td>
    </tr>
  <tr valign="middle" bgcolor="#F3E9E9"></tbody>
</table>
</s:form>
</body>

</html>

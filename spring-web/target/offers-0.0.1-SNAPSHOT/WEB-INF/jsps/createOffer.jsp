<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/CSS/style.css"
	rel="stylesheet" type="text/css">
<title>Add Your Service</title>
</head>
<body>

	<s:form method="post" action="${pageContext.request.contextPath}/addOffer" modelAttribute ="offers">
		Name <s:input type="text" name="name" path="name"/><br /><br> 
		<s:errors path="name" class="error"></s:errors><br>
		Email <s:input type="text" name="email" path="email" /><br /><br> 
		<s:errors path="email" class="error"></s:errors><br>
		Text <s:textarea rows="5" cols="25" name="text" path="text" class="error"></s:textarea><br /><br>
		<s:errors path="text"></s:errors><br>
		 <input type="submit" value="Submit" /><br />
	</s:form>
</body>
</html>
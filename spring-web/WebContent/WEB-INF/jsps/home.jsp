<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Home Page

	
	<table border="2">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Service</th>
	</tr>	
	<c:forEach var="row" items="${offers}">
	<tr>
   <td>${row.id}</td>
    <td>${row.name}</td>
    <td>${row.email}</td>
    <td>${row.text}</td>
    
     </tr>
</c:forEach>
</table>
	<p>
		<c:out value="${name}"></c:out>
	</p>
</body>
</html>
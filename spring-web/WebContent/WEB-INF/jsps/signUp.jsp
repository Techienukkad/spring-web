<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>sign up form</title>
</head>

<body>

	<div class="signup__container">
		<div class="container__child signup__thumbnail">
			<div class="thumbnail__logo">
				<h1 class="logo__text">Sign Up here</h1>
			</div>
			
			<div class="signup__overlay"></div>
		</div>
		<div class="container__child signup__form">
			<s:form action="${pageContext.request.contextPath}/newUser" method="post" modelAttribute="user">
				<div class="form-group">
					<label for="username">Username</label>
					<s:input class="form-control" type="text" name="username" id="username" path="username"/>
					<s:errors path="username" class="error"></s:errors>
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<s:input class="form-control" type="text" name="email" id="email" path="email"/>
					<s:errors path="email" class="error"></s:errors>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<s:input class="form-control" type="password" name="password" id="password" path="password"/>
					<s:errors path="password" class="error"></s:errors>
				</div>
				<div class="form-group">
					<label for="passwordRepeat">Repeat Password</label>
					<input class="form-control" type="password" name="passwordRepeat" id="passwordRepeat" />
				</div>
				<div class="m-t-lg">
					<ul class="list-inline">
						<li><input class="btn btn--form" type="submit" value="Register" /></li>
						<li><a class="signup__link" href="#">I am already a
								member</a></li>
					</ul>
				</div>
			</s:form>
		</div>
	</div>


</body>

</html>

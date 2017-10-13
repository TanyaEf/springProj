<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Login Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/common_styles.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/form_styles.css" />"
	rel="stylesheet">
<script
	src="<c:url value="/resources/javascript/jquery/jquery-2.1.4.min.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery.validate.min.js" />"></script>
	<script
	src="<c:url value="/resources/javascript/form-validation.js" />"></script>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="container">
		<div class="form-container">

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form id="loginForm" name='loginForm' action="j_spring_security_check" method='POST'>

				<div class="form-title">
					<label for="login">Login</label>
				</div>
				<input class="form-field" type='text' name='login' value=''>
				<div class="form-title">
					<label for="Password">Password</label>
				</div>

				<input class="form-field" type='password' name='password' />
				<div class="rememberme-container">
					<input id="j_remember_me" name="_spring_security_remember_me"
						type="checkbox" /> <label for="remember_me">Remember me</label>
				</div>
				<div class="submit-container">
					<input type="submit" class="submit-button" value="LogIn">
				</div>

				<div class="link_container">
					<a class="link" href="user/add">Register me</a>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</form>
		</div>
	</div>
</body>
</html>
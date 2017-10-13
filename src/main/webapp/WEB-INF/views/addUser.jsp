<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>StudyApp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/common_styles.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/form_styles.css" />"
	rel="stylesheet">
<script
	src="<c:url value="/resources/javascript/jquery/jquery-2.1.4.min.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery.validate.min.js" />"></script>
<script src="<c:url value="/resources/javascript/form-validation.js" />"></script>
</head>
<body onload='document.userForm.login.focus();'>
	<div class="container">
		<sec:authorize access="isAuthenticated()">
			<div class="head-logout-container">
				<div class=logout-containert>
					<div class="logout-text">You entered as:</div>
					<div class="username-container">
						<sec:authentication property="principal.username" />
					</div>
					<div class="logout-link">
						<a href="<c:url value="/logout" />"> logout </a>
					</div>
				</div>
			</div>
		</sec:authorize>
		<div class="form-container">
			<h1>Enter user's data</h1>

			<c:if test="${!empty error}">
				<div class="error">
					<c:out value="${error}"></c:out>
				</div>
			</c:if>

			<form:form name="userForm" method="post" commandName="user"
				action="add">

				<div class="form-title">
					<form:label path="login">Login</form:label>
				</div>
				<form:errors path="login" class="error" />

				<form:input path="login" class="form-field" />

				<div class="form-title">
					<form:label path="password">Password</form:label>
				</div>
				<form:errors path="password" class="error" />
				<form:password path="password" class="form-field" />
				<div class="form-title">
					<form:label path="password">Confirm password</form:label>
				</div>
				<input type="password" class="form-field" name="passconf" />



				<sec:authorize access="isAuthenticated()">
					<div id="checkbox-container">
						<form:checkboxes items="${roles}" path="roles" itemValue="roleId"
							itemLabel="name" />
					</div>
				</sec:authorize>

				<div class="submit-container">
					<input type="submit" class="submit-button" value="Submit">
				</div>


			</form:form>

		</div>

	</div>
</body>
</html>
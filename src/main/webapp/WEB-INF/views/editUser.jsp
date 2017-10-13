
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
</head>
<body>
	<div class="container">
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
		<div class="form-container">
			<h1>Enter new data</h1>
			<br>
			<c:if test="${!empty error}">
				<div class="error">

					<c:out value="${error}"></c:out>
				</div>
			</c:if>

			<form:form method="post" commandName="user"
				action="edit?id=${user.userId}">

				<div class="form-title">
					<form:label path="login">Login</form:label>
				</div>
				<form:hidden path="userId" name="userId" value="${user.userId}"/>
				<form:errors path="login" class="error" />
				<form:input path="login" class="form-field"
					defaultValue="${user.login}"></form:input>
				

				<div class="form-title">
					<form:label path="password">Password</form:label>
				</div>
				<form:errors path="password" class="error" />
				<form:input path="password" class="form-field"
					defaultValue="${user.password}" />
				
				<form:errors path="roles" class="error" />
				<form:checkboxes items="${roles}" path="roles" itemValue="roleId" itemLabel="name" />

				<div class="submit-container">
					<input type="submit" class="submit-button" value="Submit">
				</div>

			</form:form>
		</div>
	</div>
</body>
</html>
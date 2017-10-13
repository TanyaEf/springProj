<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link href="<c:url value="/resources/css/common_styles.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/table_styles.css" />"
	rel="stylesheet" />

<link href="<c:url value="/resources/css/metro/darkgray/jtable.css" />"
	rel="stylesheet" />

<link href="<c:url value="/resources/css/jquery-ui.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/validationEngine.jquery.css" />"
	rel="stylesheet" />



<script
	src="<c:url value="/resources/javascript/jquery/jquery-2.1.4.min.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery-ui.min.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery.jtable.min.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery.validationEngine.js" />"></script>
<script
	src="<c:url value="/resources/javascript/jquery/jquery.validationEngine-en.js" />"></script>

<script src="<c:url value="/resources/javascript/script.js" />"></script>

<script>var ctx = "${pageContext.request.contextPath}"</script>

<title>All users</title>
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
		<div class="content-container">
			<div class="left-container">
				<div class="button_container">
					<input id="allUsers" type="button" value="Users JSON">
				</div>

				<div class="button_container">
					<input id="allUsersjTable" type="button" value="Users jTable">
				</div>
				
				<div class="button_container">
					<input id="adminLog" type="button" value="View admin log">
				</div>

			</div>


			<div class="right-container" id="right-container">
				<div id="user-table-container"></div>
				<div id="admin-log-container"></div>
				<div id="right-content">
					<h3>Users (java-way)</h3>

					<a class="link" href="user/add">Add new user</a>

					<c:if test="${!empty users}">
						<table id="users-table">
							<tr>
								<th>User ID</th>
								<th>User name</th>
								<th>user password</th>
								<th>user roles</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
							<c:forEach items="${users}" var="user">
								<tr>
									<td>${user.userId}</td>
									<td>${user.login}</td>
									<td>${user.password}</td>
									<td><c:forEach items="${user.roles}" var="role">
						${role.name} <br>
										</c:forEach></td>

									<td><a href="delete?id=${user.userId}">Delete</a></td>
									<td><a href="edit?id=${user.userId}">Edit</a></td>


								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
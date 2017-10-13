<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/common_styles.css" />"
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
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<div class="link_container">
					<a href="admin">Admin page</a>
				</div>
			</sec:authorize>
		</div>
		<div id="pagecontent-container">
			<h1>
				Hello,
				<sec:authentication property="principal.username" />
				.
			</h1>
		</div>
		<div id="user-table-container"></div>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><s:message code="<%=titleCode%>" /></title>
<style type="text/css">
table.menu {
	border: black 1px solid;
	background: #3399ff;
	margin: 0;
}

table.menu th {
	padding: 2px;
	padding-left: 5px;
	padding-right: 5px;
	margin: 0;
	text-align: center;
	padding-right: 5px;
}

table.menu td {
	padding: 1px;
	margin: 0;
	background: #cce5ff;
	border: black 1px solid;
}

table.menu ul {
	padding: 0;
	margin: 0;
	list-style-type: none;
	background: #3399ff;
}

table.menu ul li {
	background: #cce5ff;
	margin: 0;
}

table.menu a {
	display: block;
	padding: 2px;
}

span.error {
	color: red;
}

div.errors {
	background-color: #ffcccc;
	border: 2px solid red;
}

label.error {
	color: red;
}

input.error {
	background-color: #ffcccc;
}
</style>
</head>
<body>
	<table class="menu">
		<tr>
			<th>Home</th>
			<th>ChatUser</th>
			<th>ChatRoom</th>
		</tr>
		<tr>
			<td>
				<ul>
					<li><a href="<s:url value='/'/>">Home</a></li>
					<security:authorize access="!isAuthenticated()">
						<li><a href="<s:url value='/login'/>">Login</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href="<s:url value='/logout'/>">Logout</a></li>
					</security:authorize>
				</ul>
			<td><security:authorize access="hasRole('ADMIN')">
					<ul>
						<li><a href="<s:url value='/chatUser/show'/>">List
								chatUsers</a></li>

						<li><a href="<s:url value='/chatUser/register'/>">Register</a></li>
					</ul>
				</security:authorize></td>
			<td>
				<ul>
					<li><a href="<s:url value='/chatRoom/show'/>">List chatRooms</a></li>
				</ul>
			</td>
		</tr>
		<security:authorize access="isAuthenticated()">
			<tr>
				<td colspan="4">Hello <security:authentication
						property="principal.username" />!
			</tr>
		</security:authorize>
	</table>

	<h1>
		<s:message code="<%=titleCode%>" />
		
	</h1>

</body>
</html>
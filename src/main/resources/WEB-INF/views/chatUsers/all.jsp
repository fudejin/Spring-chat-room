<%!String titleCode = "chatUsers.all.title";%>
<%@ include file="../header.jsp"%>


<table border="1">
	<tr>
		<th><s:message code="chatUsers.name" /></th>
		<th><s:message code="chatUsers.password" /></th>
	</tr>
	<c:forEach items="${chatUsers}" var="chatUser">
		<tr>
			<td><c:out value="${chatUser.name}" /></td>
			<td><c:out value="${chatUser.password}" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../footer.jsp"%>

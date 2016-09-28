<%!String titleCode = "chatUsers.show.title";%>
<%@ include file="../header.jsp"%>

<ul>
	<li><s:message code="chatUsers.name" />: <c:out
			value="${chatUser.name}" /></li>
	<li><s:message code="chatUsers.password" />: <c:out
			value="${chatUser.password}" /></li>
</ul>


<%@ include file="../footer.jsp"%>

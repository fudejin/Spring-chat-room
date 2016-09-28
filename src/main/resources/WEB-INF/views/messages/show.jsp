<%!String titleCode = "messages.show.title";%>
<%@ include file="../header.jsp"%>

<ul>
	<li><s:message code="messages.ipuser" />: <c:out
			value="${message.ipuser}" /></li>
	<li><s:message code="messages.date" />: <c:out
			value="${message.date}" /></li>
	<li><s:message code="messages.msg" />: <c:out
			value="${message.msg}" /></li>
</ul>


<%@ include file="../footer.jsp"%>

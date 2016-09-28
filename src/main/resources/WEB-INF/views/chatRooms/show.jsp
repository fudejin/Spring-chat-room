<%!String titleCode = "chatRooms.show.title";%>
<%@ include file="../header.jsp"%>

<ul>
	<li><s:message code="chatRooms.name" />: <c:out
			value="${chatRoom.name}" /></li>
</ul>


<%@ include file="../footer.jsp"%>

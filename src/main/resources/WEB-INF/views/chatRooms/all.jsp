<%!String titleCode = "chatRooms.all.title";%>
<%@ include file="../header.jsp"%>


<table border="1">
	<tr>
		<th><s:message code="chatRooms.name" /></th>
	</tr>
	<c:forEach items="${chatRooms}" var="chatRoom">
		<tr>
			<td><c:out value="${chatRoom.name}" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../footer.jsp"%>

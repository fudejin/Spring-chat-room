<%!String titleCode = "chatUsers.register.title";%>
<%@ include file="../header.jsp"%>

<sf:form method="POST" commandName="chatUser">
	<sf:label path="name" cssErrorClass="error">
		<s:message code="chatUsers.name" />:
		</sf:label>
	<sf:input path="name" cssErrorClass="error" />
	<sf:errors path="name" cssClass="error" />
	<br />
	<sf:label path="password" cssErrorClass="error">
		<s:message code="chatUsers.password" />:
		</sf:label>
	<sf:password path="password" cssErrorClass="error" />
	<sf:errors path="password" cssClass="error" />
	<br />
	<input type="submit" value="Register" />
</sf:form>


<%@ include file="../footer.jsp"%>

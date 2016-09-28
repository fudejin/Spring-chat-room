 <%!String titleCode = "messages.register.title";%>
<%@ include file="../header.jsp"%>

<sf:form method="POST" commandName="message">
	<sf:label path="ipuser" cssErrorClass="error">
		<s:message code="messages.ipuser" />:
		</sf:label>
	<sf:input path="ipuser" cssErrorClass="error" />
	<sf:errors path="ipuser" cssClass="error" />
	<br />
	<textarea cols='50' rows='30'>
	</textarea>
	<br>
	<sf:label path="date" cssErrorClass="error">
		<s:message code="messages.date" />:
		</sf:label>
	<sf:input path="date" cssErrorClass="error" />
	<sf:errors path="date" cssClass="error" />
	<br />
	<sf:label path="msg" cssErrorClass="error">
		<s:message code="messages.msg" />:
		</sf:label>
	<sf:input path="msg" cssErrorClass="error" />
	<sf:errors path="msg" cssClass="error" />
	<br />
	<input type="submit" value="Register" />
</sf:form>


<%@ include file="../footer.jsp"%>
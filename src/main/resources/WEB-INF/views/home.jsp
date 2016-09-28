<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%!String titleCode = "home.title";%>
<%@ include file="header.jsp"%>

<center><s:message code="home.welcome"/></center>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <ul>
				<center>
				<font size="+2" color="#FFFFFF" style="margin-top:50px">	
					<a href="<s:url value='/message/show'/>">
					Cliquez ici pour entrer dans la salle de chat publique——“World”
					</a>
				</font>
				</center>
		</ul>


<%@ include file="footer.jsp"%>
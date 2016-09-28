<%!String titleCode = "messages.all.title";%>
<%@ include file="../header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>world</title>
        
        <style>
		.message_show{
			width:600px;
			height:300px;
		    background-color:#F3EACB
		}
		 .user_count{
			 width:150px;
			 height:300px;
			 background-color:#DDCCDF
		}
		textarea{
			resize:none;
		}
        </style>
    </head>
    
    <body ">
    
    <bgsound src="play.mid"loop="-1"> 
    	<center><font color="#6D35B3" size="+3">Welcome to Whisperer&nbsp;</font></center>
    	<center><a href="<s:url value='/message/show'/>">Rafraîchir les messages</a></center>
        <div class="space" style="height:50px"><div align="right"><a class="leave" href="/">Quitter</a></div></div>
        <table border="0" align="center" cellpadding="0" cellspacing="0" width="750px">
        	<tr bgcolor="#5A00B3" style="width:100%">
            	<td width="78%" colspan="2">
           			 <div class="title"><center><font size="+2" color="#FFFFFF" style="margin-top:50px">Message</font></center></div>
            	</td>
            </tr>
            <font color="#6D35B3" size="+5">
            <label>
            	<c:out value="${room}"></c:out>
            </label>
            </font>
            
      		<tr>
            	<td>
                	<textarea readonly cols="10" row=20 class="message_show" value=dfgdfad>
                		<c:forEach items="${messages}" var="message">
						<c:out value="${message.ipuser}(${message.date}):" />
						<c:out value="                              ${message.msg}"/>
						</c:forEach>
						<c:out  value="${SysMsg }"/>
                	</textarea>
                </td>
                <td>
                	<textarea readonly cols="50" class="user_count">
                		<c:forEach items="${userRoomList}" var="String">
						<c:out value="${String}" />
						</c:forEach>
                             	
                	</textarea>
                </td>
            </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" align="center" width="750">
        	 <tr>
               
                <td width="195">
                	<span class="alert" style="color:#F00"></span>
                </td>
                <td width="115" align="right">
                	<span id="count" class="count" style="color:#F00">Message</span>
                </td>
            </tr>
            <tr>
            	<td colspan="4">
            	
<sf:form method="POST" commandName="message">
	<sf:textarea  style="width:750px" onKeyUp="limit()" onKeyDown="limit()" onClick="disappear()" path="msg" cssErrorClass="error" />
	<sf:errors path="msg" cssClass="error" />
	<br />
	<td align="right">
	<input type="submit" value="Envoyer" />
	</td>
</sf:form>
                </td>
            </tr>
            
        </table>
    </body>	
</html>

<%@ include file="../footer.jsp"%>

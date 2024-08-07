<%@page import="utils.stringutils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/welcome.css" />
</head>
<body>
	<%
		String userSession = (String) session.getAttribute(stringutils.username);
		
		String cookieUsername  = null;
		String cookieSessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals(stringutils.USER)) cookieUsername = cookie.getValue();
				if(cookie.getName().equals(stringutils.JSESSIONID)) cookieSessionID = cookie.getValue();
			}
		}
	%>
	<div class="welcome-container">
		<h1>Hello <%=cookieUsername %>. Welcome to our page!</h1>
		<a href="<%=contextPath %>/index.jsp">
			<button class="home-button">Continue to Home Page</button>
		</a>
	</div>
</body>
</html>
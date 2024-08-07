<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="utils.stringutils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String contextPath = request.getContextPath();
    String errMsg = (String) request.getAttribute(stringutils.MESSAGE_ERROR);
    String successMsg = (String) request.getAttribute(stringutils.MESSAGE_SUCCESS);
    String username = (String) request.getAttribute(stringutils.username);
    String successParam = request.getParameter(stringutils.SUCCESS);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/login.css" />
 <link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/header.css"/> 
 <link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/footer.css"/> 
<style>
    <%-- Define your styles here --%>
    .success-msg {
        color: white;
        font-size: 22px;
          position: absolute;
           top: 2%;
        left: 29%;
    }

    .error-msg {
        color: red;
        font-size: 17px;
    }
</style>
</head>
<body> 

<%
    HttpSession userSession = request.getSession();
%>
     
<div class="wrap">
    <form action="<%=contextPath + stringutils.SERVLET_URL_LOGIN%>" method="post">
        <% if (successMsg != null) { %>
            <div class="success-msg"><%= successMsg %></div>
            <%-- Redirect to index page after a delay --%>
            <script>
                setTimeout(function() {
                    window.location.href = '<%= request.getContextPath() + stringutils.URL_INDEX%>';
                }, 2000); // Redirect after 2 seconds
            </script>
		<%
		}
		%>
        <%-- Display error message if available --%>
        <% if (errMsg != null) { %>
            <div class="error-msg"><%= errMsg %></div>
        <%} %>
        
        <h1>Login</h1>
       
        <div class="input-box">
            <input type="text" placeholder="Username" id="username" name="username" 
            value="<%= (username != null && !username.isEmpty()) ? username : "" %>" required>
            <i class='bx bxs-user'></i>
        </div>
        <div class="input-box">
            <input type="password" placeholder="Password" id="password" name="password" required>
            <i class='bx bxs-lock-alt'></i>
        </div>
        <div class="remember-forgot">
            <label>
                <input type="checkbox" name="remember"> Remember me
            </label>
            <a href="#">Forgot Password</a>
        </div>
        <button type="submit" class="btn">Login</button>
    </form>
    <div class="register-link">
        <p>
            Don't have an account? <a href="<%=contextPath + stringutils.PAGE_URL_REGISTER%>">Register</a>
        </p>
    </div>
</div>

</body>
</html>

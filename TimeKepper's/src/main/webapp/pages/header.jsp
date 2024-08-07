<%@page import="utils.stringutils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/header.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
    integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style type="text/css">

.profile_sections {
  margin-top: -18px !important;
  width: 120px !important;
  height: 60px;
}

.profile_sections{
  margin-left: 50px;
  display: flex;
  align-items: center;
  width: 100%;
}

.profile_sections .user_pic{
  width: 57px;
  height: 57px !important;
  border-radius: 50%;
  cursor: pointer;
  border: 2px solid whitesmoke;
  object-fit:cover;
}

.icons:hover .Image_menu{
  display: block;
}

.profile_section .user_pic{
  width: 60px;
  border-radius: 50%;
  cursor: pointer;
  border: 2px solid whitesmoke;
   height:60px;
}

.Image_menu{
  position: absolute;
  top: 100px;
  right: 10px;
  width: 350px;
   display: none; 
  
}

.menu_content{
  background-color: #BFCBCE;
  padding: 20px;
  margin: 10px;
  border-radius: 20px;
}



.profile_section{
  margin-top: 5px;
  display: flex;
  align-items: center;
  width: 300px !important;
  height:70px;
}
.profile_section h5{
  margin-left: 18px;
}

.profile_section hr{
  border: 0;
  height: 1px;
  width: 100%;
  background-color: #111;
  margin: 15px 0 10px;
}

.menu_link{
  display: flex;
  margin: 6px;
  padding: 8px;
  color: black;
  height:40px;
  
}

.menu_link i{
  font-size: 20px;
  
}

.icons i{
  margin: 0px;
}

.icons{
margin-top:35px;
}

.menu_link p{
  margin-left: 16px;
  width: 100%;
  font-size: 15px;
  text-align: left;
  margin-top: 2px;
  
}
.menu_link span{
  font-size: 16px;
  color: #333;
  opacity: 0.7;
  margin-top:2px;
}

</style>
<% 
String userName= (String) session.getAttribute(stringutils.username);
String role = (String) session.getAttribute(stringutils.ROLE);
String name = (String) session.getAttribute(stringutils.FULL_NAME);
String image = (String) session.getAttribute(stringutils.IMAGE);
%>
<body>
    <%@page import="javax.servlet.http.HttpServletRequest"%>
    <% String contextPath = request.getContextPath(); %>
    <nav>
        <div class="logo">
            <img src="../resources/images/logo.png" alt="">
        </div>
        <div class="icon">
            <span class="toggle">☰</span>
        </div>
        <div class="items">
            <ul class="list-item">
                <li><a href="#">Home</a></li>
                <% if("user".equals(role)) { %>
                    <li><a href="product.jsp">Product</a></li>
                <% } 
                else {%>
                <li><a href="operation.jsp">Operation</a></li>
                <%} %>
                <li><a href="#">About us</a></li>
                <li><a href="#">Contact us</a></li>
            </ul>
        </div>
        <div class="icons">
            <i class="fa-solid fa-cart-shopping"></i>
            <div class="profile_sections">
                <img class="user_pic" src="<%=contextPath%>/resources/DBimage/user/<%=image%>" alt="">
            </div>
            <div class="Image_menu">
                <div class="menu_content">
                    <div class="profile_section">
                        <img class="user_pic" src="<%=contextPath%>/resources/DBimage/user/<%=image%>" alt="">
                        <h5><%=name%></h5>
                    </div>
                    <hr>
                    <a href="#" class="menu_link">
                        <i class="fa-solid fa-user"></i>
                        <p>Edit profile</p>
                        <span>></span>
                    </a>
                    <a href="#" class="menu_link">
                        <i class="fa-solid fa-user"></i>
                        <p>Setting & Privacy</p>
                        <span>></span>
                    </a>
                    <a href="#" class="menu_link">
                        <i class="fa-solid fa-user"></i>
                        <p>Help & Support</p>
                        <span>></span>
                    </a>
                    <form action="<%
                        // Conditionally set the action URL based on user session
                        if (userName != null) {
                            out.print(contextPath + stringutils.SERVLET_URL_LOGOUT);
                        } else {
                            out.print(contextPath + stringutils.PAGE_URL_LOGIN);
                        }
                    %>" method="post">
                        <input type="submit" value="<%
                            // Conditionally set the button label based on user session
                            if (userName != null) {
                                out.print(stringutils.LOGOUT);
                            } else {
                                out.print(stringutils.LOGIN);
                            }
                        %>"/>
                    </form>
                </div>
            </div>
        </div>
    </nav>
</body>

</html>
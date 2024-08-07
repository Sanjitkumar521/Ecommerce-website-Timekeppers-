<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/aboutus.css" />
</head>
<body>
 <%@page import="javax.servlet.http.HttpServletRequest"%>
    <% HttpSession userSession = request.getSession(); %>
    <% String contextPath = request.getContextPath(); %>
    
    <div class="about">
        <div class="inner-section">
            <h1>About Us</h1>
            <p class="text">
                At Timekeeper, we believe that a watch is more than just a timepiece; it's a statement of style, a symbol of craftsmanship, and a companion for life's journey. Our passion for watches goes beyond mere appreciation; it's a dedication to curating timepieces that reflect the diverse tastes and personalities of our discerning customers.
            </p>
            <div class="skills">
                <button>Contact Us</button>
            </div>
        </div>
    </div>
</body>
</html>
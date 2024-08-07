<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/contactus.css" />
 <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
 <%@page import="javax.servlet.http.HttpServletRequest"%>
    <% HttpSession userSession = request.getSession(); %>
    <% String contextPath = request.getContextPath(); %>
  <section class="contact">
        <div class="content">
            <h2>Contact Us</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem at eum dolorum tempora odit incidunt
                mollitia sed cumque, enim iure inventore, ullam nulla repudiandae porro quibusdam libero quos quisquam
                molestias?</p>
        </div>
        <div class="container">
            <div class="contactInfo">
                <div class="box">
                    <div class="icon"><i class='bx bxs-map'></i></div>
                    <div class="text">
                        <h3>Address</h3>
                        <p>4671 Sugar Camp Road,<br>Nepal,Minna,<br>55060</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class='bx bxs-phone'></i></div>
                    <div class="text">
                        <h3>Phone</h3>
                        <p>9828774450</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class='bx bxs-envelope'></i></div>
                    <div class="text">
                        <h3>Email</h3>
                        <p>chysanjit13@gmail.com</p>
                    </div>
                </div>
            </div>
            <div class="contactForm">
                <form>
                    <h2>Send Message</h2>
                    <div class="InputBox">
                        <input type="text" name="" required="required">
                        <span>Full Name</span>
                    </div>
                    <div class="InputBox">
                        <input type="text" name="" required="required">
                        <span>Email</span>
                    </div>
                    <div class="InputBox">
                        <textarea required="required"></textarea>
                        <span>Type your Message...</span>
                    </div>
                    <div class="InputBox">
                        <input type="submit" name="" value="Send">
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>
</html>
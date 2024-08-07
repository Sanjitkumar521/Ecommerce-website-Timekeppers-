
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="utils.stringutils"%>
<% String contextPath = request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String userName= (String) session.getAttribute(stringutils.username);
String role = (String) session.getAttribute(stringutils.ROLE);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/index.css" />
 <link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/header.css"/> 
 <link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/footer.css"/> 
</head>
<body>
  <jsp:include page="/pages/header.jsp"/>  
  <section class="slider_container">
      <div class="image1">
     <img src="../resources/images/hm_slider.png" alt=""> 
      </div>
      <div class="button_part">
        <div class="slider_title">
          <h1>Join with us</h1>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid modi at vero quasi, distinctio eaque vitae
            eos fugiat! Laborum, praesentium!</p>
        </div>
        <div class="button_portion">
          <img src="../resources/images/line.webp" alt="">
          <button type="submit"><a href="#">Shop Now</a></button>
          <img src="../resources/images/line.webp" alt="">
        </div>
      </div>
    </section>
 
  <section>
    <div class="banner">
      <div class="banner1">
        <img src="../resources/images/bannerV4-img1.webp" alt="">
        <div class="box-info">
          <h4 style="color: #fff" class="title-banner"> DRESS WATCHES</h4>
          <button><a href="/collections/all" class="button-main1 " tabindex="0"> Shop Now</a></button>
        </div>
      </div>
      <div class="banner1">
        <img src="../resources/images/bannerV4-img2.jpg" alt="">
        <div class="box-info">
          <h4 style="color: #fff" class="title-banner"> SPORT WATCHES</h4>
          <button><a href="/collections/all" class="button-main1 " tabindex="0"> Shop Now</a></button>
        </div>
      </div>
      <div class="banner1">
        <img src="../resources/images/bannerV4-img3.webp" alt="">
        <div class="box-info">
          <h4 style="color: #fff" class="title-banner">SMART WATCHES</h4>
          <button><a href="/collections/all" class="button-main1 " tabindex="0"> Shop Now</a></button>
        </div>
      </div>
  </div>
  </section>
  <section>
    <div class="text_center">
      <h3 class="block-title title_heading" style="color : #222222">Best Seller</h3>
      <img src="../resources/images/line.webp" alt="">
      <span class="sub_heading" style="color: #666666">Best Seller Product This Week!</span>
    </div>
  </section>
  <section>
    <div class="main_header">
    <div class="header1">
      <img src="../resources/images/watch1.webp" alt="">
 
    </div>
    <div class="header1">
      <img src="../resources/images/watch2.webp" alt="">
    </div>
    <div class="header1">
      <img src="../resources/images/watch3.webp" alt="">
    </div>
    <div class="header1">
     <img src="../resources/images/watch 4.webp" alt="">
    </div>
    </div>
  </section>

  <section>
    <div class="main_header2">
    <div class="header2">
      <img src="../resources/images/watch5.webp" alt="">
    </div>
    <div class="header2">
      <img src="../resources/images/watch6.webp" alt="">
    </div>
    <div class="header2">
      <img src="../resources/images/watch7.webp" alt="">
    </div>
    <div class="header2">
     <img src="../resources/images/watch 8.webp" alt="">
    </div>
    </div>
  </section>
  <section>
    <div class="view_product">
      <a href="/collections/all" class="text-center">ALL PRODUCTS</a>
    </div>
  </section>
 
 
<section>
  <div class="container5">
    <i class="fa-solid fa-envelope"></i>
    <h3 style="color: #000" class="title-newsletter">
      Newsletter Signup
    </h3>
    <p style="color: #000" class="desc">
      Join our list and get 15% off your first purchase!
    </p>
    <input type="email" name="EMAIL" class="form-control" placeholder="Your email address..." required="">
    <button class="btn submit-newsletter" type="submit">SUBSCRIBE</button>
  </div>
</section>

 <jsp:include page="/pages/footer.jsp"/>  
</body>
</html>
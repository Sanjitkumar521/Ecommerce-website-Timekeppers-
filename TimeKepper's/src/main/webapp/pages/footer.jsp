<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/footer.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
    integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<footer id="picassoFooter">
    <div class="footer-navigation">
        <h3>Quick Links</h3>
        <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#about">About Us</a></li>
            <li><a href="#services">Services</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>
    </div>
    <div class="footer-contact">
        <h3>Contact Us</h3>
        <p>Email: info@example.com</p>
        <p>Phone: +123 456 7890</p>
    </div>
    <div class="footer-social">
        <h3>Follow Us</h3>
        <div class="social-icons">
            <a href="https://facebook.com" target="_blank" class="social-icon">FB</a>
            <a href="https://twitter.com" target="_blank" class="social-icon">TW</a>
            <a href="https://instagram.com" target="_blank" class="social-icon">IG</a>
        </div>
    </div>
    <div class="footer-art">
        <canvas id="picassoCanvas"></canvas>
    </div>
</footer>

</body>
</html>
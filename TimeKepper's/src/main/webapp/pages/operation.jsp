<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/operation.css" />
<body>
    

    <main>
        <section class="profile-section">
            <div class="profile-details">
                <h3>Name: John Doe</h3>
                <p>Email: john@example.com</p>
                <p>Role: Administrator</p>
            </div>
        </section>
        <section class="crud-section">
            <h2>Manage Product</h2>
           <div class="crud-buttons">
                <button class="add-btn"><a href="${pageContext.request.contextPath}/pages/productform.jsp" >Add user</a></button>
                
                <button class="update-btn"><a href="${pageContext.request.contextPath}/pages/updateinput.jsp">Update User</a></button>
                <button class="delete-btn"><a href="${pageContext.request.contextPath}/pages/DeleteInput.jsp">Delete User</a></button>
            </div>
        </section>

        
    </main>
</body>
</html>
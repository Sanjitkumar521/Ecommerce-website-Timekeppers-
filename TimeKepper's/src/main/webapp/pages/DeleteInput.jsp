<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="utils.stringutils"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .update_input{
            width: 100%;
            background-color: white;
        }

        .update_form_input{
            width: 500px;
            height: 150px;
            margin-left: 400px;
            margin-top: 180px;
            padding: 100px;
            background-color: whitesmoke;
        }
        .update_form_input input{
            margin-top: 40px;
            width: 100%;
            height: 40px;
        }
        
        .update_form_input button{
            margin-top: 10px;
            margin-left: 70%;
            width: 120px;
            height: 40px;
        }

        
    </style>
    <% String contextPath = request.getContextPath(); %>
</head>
<body>
    <div class="update_input">
        <form action="<%=contextPath + stringutils.SERVLET_URL_DELETEPRODUCT%>" method="post">
            <div class="update_form_input">
            <label for="update">Enter Model Number :</label>
            <input type="text" placeholder="Model Number" name="deleteModelNumber">
            <button type="submit">Delete</button>
        </div>
        </form>
    </div>
</body>
</html>
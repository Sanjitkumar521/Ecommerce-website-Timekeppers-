<%@page import="utils.stringutils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
	  <% String contextPath = request.getContextPath(); %>
	 <div class="update_input">
	        <form id="updateForm" action="<%=contextPath + stringutils.SERVLET_URL_UPDATEPRODUCT%>" method="post">
	            <div class="update_form_input">
	            <label for="update">Enter Model Number :</label>
	            <input type="text" placeholder="Model Number" name="updateModelNumber">
	            <button type="submit" >Update</button>
	        </div>
	        </form>
	    </div>
										
</body>
</html>
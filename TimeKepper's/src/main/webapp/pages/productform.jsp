<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/productform.css" />
</head>

<%@page import="utils.stringutils"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% HttpSession userSession = request.getSession(); %>
<% String contextPath = request.getContextPath(); %>
<%
String openForm = (String) request.getAttribute("update");
%>
<body>
    <div class="container">
    <%if("openProductForm".equals(openForm)) {
    %>
 		<h2>Update Product</h2>
 		<%
 		 	
    	}else{ %>
 		<h2>Add Product</h2>
 		<%} %>
        <c:set var="product" value="${product }"></c:set>
        <form action="<%=contextPath + stringutils.SERVLET_URL_ADDPRODUCT%>" method="post" enctype="multipart/form-data"">
        	<% 
		    String successMsg = (String) request.getAttribute(stringutils.MESSAGE_ERROR);
		    if (successMsg != null) {
		%>
		
		<div class="alert success-msg alert-warning" role="alert" id="myAlert">
		    <strong> <%= successMsg %> </strong> 
		    <button type="button" class="btn-close" aria-label="Close" onclick="closeAlert()">X</button>
		</div>	
		
		<%
		if(successMsg.equals("Successfully Registered!"))
		{
			%>
            <script>
                setTimeout(function() {
                    window.location.href = '<%= request.getContextPath() + stringutils.PAGE_URL_LOGIN %>';
                }, 2000); // Redirect after 3 seconds
            </script>
            <% 
		}
		    }
		%>
            <div class="form-group">
                <label for="model-no">Model No:</label>
                <input type="text" id="model-no" name="modelno" value="${product.modelNo}" required>
            </div>
            <div class="form-group">
                <label for="color">Color:</label>
                <input type="text" id="color" name="colour" value="${product.colour}" required>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" value="${product.quantity}" required>
            </div>
            <div class="form-group">
                <label for="brandname">Brand Name:</label>
                <input type="text" id="brandname" name="brandname"  value="${product.brandName}" required>
            </div>
            <div class="form-group">
                <label for="watchtype">Watch Type:</label>
                <select id="watchtype" name="watchType" required>
                    <option value="Select Watch Type" ${product.watchType == 'Select Watch Type' ? 'selected' : ''}>Select Watch Type</option>
                   <option value="Analog" ${product.watchType == 'Analog' ? 'selected' : ''}>Analog</option>
                   <option value="Digital" ${product.watchType == 'Digital' ? 'selected' : ''}>Digital</option>
                </select>         
            </div>
            <div class="form-group">
                <label for="case-material">Case Material:</label>
                <select id="case-material" name="caseMaterial" required>
                    <option value="Stainless Steel" ${product.caseMaterial == 'Stainless Steel' ? 'selected' : ''}>Stainless Steel</option>
                    <option value="Aluminum" ${product.caseMaterial == 'Aluminum' ? 'selected' : ''}>Aluminum</option>
                    <option value="Titanium" ${product.caseMaterial == 'Titanium' ? 'selected' : ''}>Titanium</option>
                    <option value="Plastic" ${product.caseMaterial == 'Plastic' ? 'selected' : ''}>Plastic</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="weight">Weight (g):</label>
                <input type="number" id="weight" name="weight" value="${product.weight}"required>
            </div>
            
            <div class="form-group">
                <label for="price">Price ($):</label>
                <input type="number" id="price" name="price" step="0.01" value="${product.price}" required>
            </div>
            
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                   <option value="Men" ${product.gender == 'Men' ? 'selected' : ''}>Men</option>
					<option value="Women" ${product.gender == 'Women' ? 'selected' : ''}>Women</option>
					<option value="Unisex" ${product.gender == 'Unisex' ? 'selected' : ''}>Unisex</option>
                </select>
            </div>
            
            
            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file" id="image" name="image" accept="image/*">
            </div>
            <%if("openProductForm".equals(openForm)) {%>
 		<button name="action" type="submit" value="Save">Save</button>
 		<%}else{ %>
 		<button name="action" type="submit" Value="Add">Add</button>
 		<%} %>
            

        </form>
        <%
		String errMsg = (String) request.getAttribute(stringutils.MESSAGE_ERROR);

		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}
		%>
    </div>
    <script>
    // JavaScript function to handle form submission based on button clicked
    function handleSubmit(button) {
        if (button === 'Save') {
            document.getElementById('productForm').action = "<%=contextPath + stringutils.SERVLET_URL_ADDPRODUCT%>?action=Save";
        } else if (button === 'Add') {
            document.getElementById('productForm').action = "<%=contextPath + stringutils.SERVLET_URL_ADDPRODUCT%>?action=Add";
        }
        document.getElementById('productForm').submit();
    }
</script>
</body>
</html>

<%@page import="utils.stringutils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/Register.css" />
</head>
<body>
<%@page import="javax.servlet.http.HttpServletRequest"%>
    <% HttpSession userSession = request.getSession(); %>
    <% String contextPath = request.getContextPath(); %>
 <div class="wrapper">
       <form action="<%=contextPath + stringutils.SERVLET_URL_REGISTER%>" method="post" enctype="multipart/form-data">
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
			
			<%-- Redirect to index page after a delay --%>
            <script>
                setTimeout(function() {
                    window.location.href = '<%= request.getContextPath() + stringutils.PAGE_URL_LOGIN %>';
                }, 2000); // Redirect after 3 seconds
            </script>
            <% 
		}
		    }
		%>
		
           <h1>Registration</h1>
           <div class="input-box">
            <div class="input-field">
                <input type="text" placeholder="username" name="username" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-field">
                <input type="text" placeholder="Fullname" name="Fullname" required>
                <i class='bx bxs-user'></i>
            </div>
           </div>
           <div class="input-box">
            <div class="input-field">
                <input type="text" placeholder="Email" name="Email" required>
                <i class='bx bxs-envelope'></i>
            </div>
            <div class="input-field">
                <input type="text" placeholder="Phone Number" name="PhoneNumber" required>
                <i class='bx bxs-phone'></i>
            </div>
           </div>

           <div class="input-box">
            <div class="input-field">
                <input type="text" placeholder="Password" name="password" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="input-field">
                <input type="text" placeholder="confirm Password" name="ConfirmPassword" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
           </div>
           
           <div class="input-box">
                <div class="gender_radio ">
                    <div class="first_row">
                        <p>Role : </p>
                    </div>
                    <div class="gender_items">
                        <input type="radio" id="html" value="user" name="role">
                        <label for="html">user</label><br>
                        <input type="radio" id="css" value="Seller" name="role">
                        <label for="css">Seller</label><br>
                        <!-- <input type="radio" id="javascript" name="Role_type" value="JavaScript">
                        <label for="javascript">JavaScript</label> -->
                    </div>


                </div>
                <div class="input-field">
                    <input class="shopid" type="text" placeholder="Shop ID" name="shopID" required> 
               </div>
           <div class="image_box">
                <div id="imagePreview" class="image-preview"></div>
                <label for="fileInput" class="add-icon">
                    Add Image
                </label>
                <input type="file" id="fileInput" class="file-input" accept="image/*" name="image">

            </div>
           <label><input type="checkbox">I hereby declare that the above information provided is true and correct</label>
           <button type="submit" class="btn">Register</button>
           
           
            
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
    
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var roleRadios = document.getElementsByName('role');
        var shopIDInput = document.querySelector('.shopid[placeholder="Shop ID"]');

        // Function to toggle visibility of shop name input based on selected role
        function toggleShopInputs() {
            if (roleRadios[1].checked) { // If Seller radio button is selected
            	shopIDInput.style.display = 'block';
            	shopIDInput.setAttribute('required', 'required'); // Add required attribute
            } else {
            	shopIDInput.style.display = 'none';
            	shopIDInput.removeAttribute('required'); // Remove required attribute
            }
        }

        // Initially hide shop name input
        toggleShopInputs();

        // Add event listener to role radios to toggle inputs visibility
        roleRadios.forEach(function (radio) {
            radio.addEventListener('change', toggleShopInputs);
        });
    });
</script>



    
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var addIcon = document.querySelector('.add-icon');
            var fileInput = document.querySelector('.file-input');

            addIcon.addEventListener('click', function () {
                fileInput.clicked(); // Trigger file input click when add icon is clicked
            });

            fileInput.addEventListener('change', function (e) {
                var file = e.target.files[0];
                var reader = new FileReader();

                reader.onload = function (event) {
                    var img = document.createElement('img');
                    img.src = event.target.result;

                    var imagePreview = document.getElementById('imagePreview');
                    imagePreview.innerHTML = '';
                    imagePreview.appendChild(img);
                };

                reader.readAsDataURL(file);
                // addIcon.style.display = 'none';
            });
        });
        // addIcon.display="none";

    </script>
    
     <script type="text/javascript">
    function closeAlert() {
    	  var alert = document.getElementById('myAlert');
    	  alert.style.display = 'none';
    	}

    </script>
</body>
</html>
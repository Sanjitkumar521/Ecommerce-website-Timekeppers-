package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.database.DBController;
import model.UserModel;
import utils.stringutils;
import utils.validationUtils;

/**
 * Servlet implementation class RegistrationServlet
 */
import javax.servlet.annotation.MultipartConfig;

@WebServlet(asyncSupported = true, urlPatterns = { stringutils.SERVLET_URL_REGISTER })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DBController dbController;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
    	
        super();
        dbController = new DBController();
       
    }

    /**
     * Handles HTTP POST requests for student registration.
     * @param request  The HttpServletRequest object containing registration form data.
     * @param response The HttpServletResponse object for sending responses.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract student information from request parameters
        String username = request.getParameter(stringutils.username);
        String fullname = request.getParameter(stringutils.FULL_NAME);
        String email = request.getParameter(stringutils.EMAIL);
        String phoneNumber = request.getParameter(stringutils.PHONE_NUMBER);
        String password = request.getParameter(stringutils.PASSWORD);
        String confirmPassword = request.getParameter(stringutils.CONFIRM_PASSWORD);
        String role = request.getParameter(stringutils.ROLE).toLowerCase();
        String shopid = null;
        if ("seller".equals(role)) {
            shopid = request.getParameter(stringutils.SHOP_ID);
        }
      
        
        Part image = request.getPart(stringutils.IMAGE);
        
        
        StringBuilder errorMessage = new StringBuilder();
		if (!validationUtils.isTextOnly(fullname)) {
	        errorMessage.append("Invalid fullname. ");
	    }
	   
	    if (!validationUtils.isAlphanumeric(username)) {
	        errorMessage.append("Invalid username. ");
	    }
	    if (!validationUtils.isEmail(email)) {
	        errorMessage.append("Invalid email. ");
	    }
	    if (!validationUtils.isNumbersOnly(phoneNumber)) {
	        errorMessage.append("Invalid phone number. ");
	    }
	    if (!validationUtils.isTextOnly(role)) {
	        errorMessage.append("role. ");
	    }
	    if(role=="seller")
	    {
		    if (!validationUtils.isNumbersOnly(shopid)) {
		        errorMessage.append("shopid. ");
		    }
	    }
	    
	    
	   

	    if (errorMessage.length() > 0) {
	        request.setAttribute(stringutils.MESSAGE_ERROR, errorMessage.toString());
	        request.getRequestDispatcher(stringutils.PAGE_URL_REGISTER).forward(request, response);
	        return; // Exit method if there are validation errors 
	        }
        
    
   
        UserModel user = new UserModel(username, fullname, email, phoneNumber, password, confirmPassword,role,shopid,image);
        
        int result = dbController.registerStudent(user);
      
        
        String errorMessages=null;
        switch (result) {
            case 1:
            	errorMessages = stringutils.MESSAGE_SUCCESS_REGISTER;
                break;
            case 2:
            	errorMessages = "Email already exists!";
                break;
       
            case 3:
            	errorMessages = "Phone Number already exists!";
                break;
            case 4:
            	errorMessages = "Username already exists!";
                break;
            case 5:
            	errorMessages = "Shop Number already exists!";
                break;
            case 0:
            	errorMessages = stringutils.MESSAGE_ERROR_REGISTER;
                break;
            default:
            	errorMessages = stringutils.MESSAGE_ERROR_SERVER;
        }

        request.setAttribute(stringutils.MESSAGE_ERROR, errorMessages);
        request.getRequestDispatcher(stringutils.PAGE_URL_REGISTER).forward(request, response);

    

      
    }
}


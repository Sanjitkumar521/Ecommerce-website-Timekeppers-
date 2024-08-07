package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.LoginModel;
import model.ProductModel;
import model.UserModel;
import utils.stringutils;


/**
 * Servlet implementation class LoginServlets
 */
@WebServlet(urlPatterns = stringutils.SERVLET_URL_LOGIN, asyncSupported = true)
public class LoginServlets extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final DBController dbController;

   
    public LoginServlets() {
        this.dbController = new DBController();
    }
	    /**
	     * Handles HTTP POST requests for login.
	     *
	     * @param request The HttpServletRequest object containing login form data.
	     * @param response The HttpServletResponse object for sending responses.
	     * @throws ServletException if a servlet-specific error occurs.
	     * @throws IOException if an I/O error occurs.
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    		       
	        String userName = request.getParameter(stringutils.username);
	        String password = request.getParameter(stringutils.PASSWORD);
	       
	        LoginModel loginModel = new LoginModel(userName, password);
	        int loginResult = dbController.getStudentLoginInfo(loginModel);
	        if (loginResult == 1) {
	        	HttpSession userSession = request.getSession();
				UserModel user = null;
				try {
					user = dbController.getUserByUsername(userName);
				} catch (SQLException | ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				userSession.setAttribute(stringutils.username, user.getUsername());
				System.out.println(user.getUsername());
				userSession.setAttribute(stringutils.ROLE, user.getRole());
				userSession.setAttribute(stringutils.FULL_NAME,user.getFullname());
				userSession.setAttribute(stringutils.IMAGE, user.getImageUrlFromPart());
				System.out.println(user.getImageUrlFromPart());
			
				Cookie userCookie= new Cookie(stringutils.USER, userName);
				userCookie.setMaxAge(30*60);
				response.addCookie(userCookie);
	            request.setAttribute(stringutils.MESSAGE_SUCCESS, stringutils.MESSAGE_SUCCESS_LOGIN);
	            request.getRequestDispatcher(stringutils.PAGE_URL_LOGIN).forward(request, response);
	        } else if (loginResult == 0) {
	         
	            request.setAttribute(stringutils.MESSAGE_ERROR, stringutils.MESSAGE_ERROR_LOGIN);
				request.setAttribute(stringutils.username, userName);
	            request.getRequestDispatcher(stringutils.PAGE_URL_LOGIN).forward(request, response);
	        } else if (loginResult == -1) {
	        
	            request.setAttribute(stringutils.MESSAGE_ERROR, stringutils.MESSAGE_ERROR_CREATE_ACCOUNT);
				request.setAttribute(stringutils.username, userName);
	            request.getRequestDispatcher(stringutils.PAGE_URL_LOGIN).forward(request, response);
	        } else {
	            // Internal server error
	            request.setAttribute(stringutils.MESSAGE_ERROR, stringutils.MESSAGE_ERROR_SERVER);
				request.setAttribute(stringutils.username, userName);
	            request.getRequestDispatcher(stringutils.PAGE_URL_LOGIN).forward(request, response);
       
	}
	    }
}



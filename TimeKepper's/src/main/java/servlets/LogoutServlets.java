package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.stringutils;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class LogoutServlets
 */
@WebServlet(asyncSupported = true, urlPatterns = stringutils.SERVLET_URL_LOGOUT)
public class LogoutServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    try {
		        for (Cookie cookie : cookies) {
		            
		            cookie.setMaxAge(0);
		            response.addCookie(cookie);
		        }
		    } catch (Exception e) {
		 
		        e.printStackTrace(); 
		    }
		}

		// 2. Invalidate user session (if it exists)
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect(request.getContextPath() + stringutils.PAGE_URL_LOGIN);
	}
}


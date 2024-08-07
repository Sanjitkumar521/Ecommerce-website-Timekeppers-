package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import utils.stringutils;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(urlPatterns = stringutils.SERVLET_URL_DELETEPRODUCT, asyncSupported = true)
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        this.dbController = new DBController();
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
		// TODO Auto-generated method stub
		
		String deleteModelNumber= request.getParameter("deleteModelNumber");
		
		int result = dbController.deleteProductByModelNo(deleteModelNumber);
		
		if(result==1)
		{
			request.setAttribute(stringutils.MESSAGE_SUCCESS, "Successfully Deleted");
			
			request.getRequestDispatcher(stringutils.PAGE_URL_OPERATION).forward(request,response);
		}
		doGet(request, response);
	}

}

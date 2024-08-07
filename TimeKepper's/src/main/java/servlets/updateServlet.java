package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.ProductModel;
import utils.stringutils;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet(urlPatterns = stringutils.SERVLET_URL_UPDATEPRODUCT, asyncSupported = true)
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		
		String updateModelNumber= request.getParameter("updateModelNumber");
		
		System.out.println(updateModelNumber);
		ProductModel product =null;
		int result=0;
		
		try {
			product = dbController.getProductByModelNumber(updateModelNumber);
			System.out.println(product);
			result=1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		if(result==1)
		{
			request.setAttribute("product", product);
			//request.setAttribute(StringUtils.MODEL_NUMBER, product.getModelNumber());
			
			request.setAttribute("update", "openProductForm");
			
			
			
			request.getRequestDispatcher(stringutils.PRODUCT_URL_FORM).forward(request,response);
		}
		
		//request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
		
		
		
		doGet(request, response);
	}

}

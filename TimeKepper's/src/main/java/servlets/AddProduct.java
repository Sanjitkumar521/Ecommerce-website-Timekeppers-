package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.database.DBController;
import model.ProductModel;
import utils.stringutils;
import utils.validationUtils;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private final DBController dbController;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        dbController = new DBController();
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
		
			HttpSession session = request.getSession();
	        String username = (String) session.getAttribute(stringutils.username);
		    String modelno = request.getParameter(stringutils.MODEL_NO);
		   
	        String colour = request.getParameter(stringutils.COLOUR);
	        
	        String quantity = request.getParameter(stringutils.QUANTITY);
	      
	        String brandname = request.getParameter(stringutils.BRAND_NAME);
	       
	        String watchtype = request.getParameter(stringutils.WATCH_TYPE);
	       
	        String casematerial = request.getParameter(stringutils.CASE_MATERIAL);
	     
	        String weight = request.getParameter(stringutils.WEIGHT);
	       
	        String price = request.getParameter(stringutils.PRICE);
	     
	        String gender = request.getParameter(stringutils.GENDER);
	     
	       
	        Part image = request.getPart(stringutils.IMAGE_PRODUCT);
	      
	        
	        
	        
	        StringBuilder errorMessage = new StringBuilder();
			if (!validationUtils.isAlphanumeric(modelno)) {
		        errorMessage.append("Invalid modelNO. ");
		    }
		   
		    if (!validationUtils.isTextOnly(colour)) {
		        errorMessage.append("Invalid colour. ");
		    }
		    if (!validationUtils.isAlphanumeric(quantity)) {
		        errorMessage.append("Invalid quantity. ");
		    }
		    if (!validationUtils.isTextOnly(brandname)) {
		        errorMessage.append("Invalid brandname. ");
		    }
		    if (!validationUtils.isTextOnly(watchtype)) {
		        errorMessage.append("Invalid watchtype. ");
		    }
		    if (!validationUtils.isTextOnly(casematerial)) {
		        errorMessage.append("Invalid caseMaterial. ");
		    }
		    if (!validationUtils.isNumbersOnly(weight)) {
		        errorMessage.append("Invalid weight. ");
		    }
		    if (!validationUtils.isNumbersOnly(price)) {
		        errorMessage.append("Invalid price. ");
		    }
		    if (!validationUtils.isTextOnly(gender)) {
		        errorMessage.append("Invalid gender. ");
		    }
		   
		    
		    if (errorMessage.length() > 0) {
		        request.setAttribute(stringutils.MESSAGE_ERROR, errorMessage.toString());
		        request.getRequestDispatcher(stringutils.PRODUCT_URL_FORM).forward(request, response);
		 
		        return;
		        }
	 
	
	       ProductModel product = new ProductModel(modelno, colour, quantity, brandname, watchtype, casematerial,weight,price,gender,image);
	       int userID = 0;
			try {
				userID = dbController.getUserIDByUsername(username);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int result=0;
		   String action = request.getParameter("action");
		   if ("Save".equals(action)) {
				 
				 if(product.getModelNo().equals(modelno)) {
					// Code to update product
				        result = dbController.updateProduct(product);
				 }else
				 {
					
				        result = dbController.addProduct(product, userID);
				 }
			        
			      
			    } else if ("Add".equals(action)) {
			        
			        result = dbController.addProduct(product, userID);
			        //System.out.println("res");
			        // Further processing for registration
			}
	     
	        String errorMessages=null;
	        switch (result) {
	            case 1:
	            	 if ("Save".equals(action)) {
	            		 errorMessages = "Product updated successfully.";
	                 } else if ("Add".equals(action)) {
	                	 errorMessages = "Product added successfully."; 
	                 }
	                 break;
	            case 2:
	            	errorMessages = "ModelNo Already Exist!!";
	                break;
	      
	            case 0:
	            	errorMessages = stringutils.MESSAGE_ERROR_REGISTER;
	                break;
	            default:
	            	errorMessages = stringutils.MESSAGE_ERROR_SERVER;
	        }

	        request.setAttribute(stringutils.MESSAGE_ERROR, errorMessages);
	        request.getRequestDispatcher(stringutils.PRODUCT_URL).forward(request, response);
	        
	        
		
	}

}

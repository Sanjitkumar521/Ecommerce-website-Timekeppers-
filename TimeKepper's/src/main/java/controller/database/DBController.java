package controller.database;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;

import model.LoginModel;
import model.UserModel;
import model.PasswordEncryptionWithAes;
import model.ProductModel;
import utils.stringutils;

public class DBController {

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		Class.forName(stringutils.DRIVER_NAME);

		// Create a connection to the database using the provided credentials
		return DriverManager.getConnection(stringutils.LOCALHOST_URL, stringutils.LOCALHOST_USERNAME,
				stringutils.LOCALHOST_PASSWORD);
	}

	public int registerStudent(UserModel user) {

		try {

			if (checkEmailIfExists(user.getEmail())) {
				return 2; // Email already exists
			}

			// Check if phone number already exists
			if (checkNumberIfExists(user.getPhoneNumber())) {
				return 3; // Phone number already exists
			}

			// Check if username already exists
			if (checkUsernameIfExists(user.getUsername())) {
				return 4; // Username already exists
			}
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(stringutils.QUERY_REGISTER_STUDENT);

			// Set the student information in the prepared statement
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getFullname());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getRole());
			if ("seller".equals(user.getRole())) {
				stmt.setString(6, user.getShopID());
			} else {
				stmt.setString(6, "");
			}
			stmt.setString(7, user.getImageUrlFromPart());
			System.out.println(user.getImageUrlFromPart());
			stmt.setString(8, PasswordEncryptionWithAes.encrypt(user.getUsername(), user.getPassword()));
			stmt.setString(9, PasswordEncryptionWithAes.encrypt(user.getUsername(), user.getConfirmPassword()));

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}

	/**
	 * This method attempts to validate a student login by checking the username and
	 * password against a database.
	 * 
	 * @param username The username provided by the user attempting to log in.
	 * @param password The password provided by the user attempting to log in.
	 * @return An integer value indicating the login status: - 1: Login successful -
	 *         0: Username or password mismatch - -1: Username not found in the
	 *         database - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int getStudentLoginInfo(LoginModel loginModel) {

		try {

			PreparedStatement st = getConnection().prepareStatement(stringutils.QUERY_LOGIN_USER_CHECK);

			st.setString(1, loginModel.getUsername());

			ResultSet result = st.executeQuery();

			if (result.next()) {

				String userDb = result.getString(stringutils.username);

				// Get the password from the database
				String encryptedPwd = result.getString(stringutils.PASSWORD);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
				
				if (userDb.equals(loginModel.getUsername()) && decryptedPwd.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// Username or password mismatch, return 0
					return 0;
				}
			} else {
				// Username not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}

	
	
	
	public int getUserIDByUsername(String username) throws SQLException, ClassNotFoundException{
	    int userID = -1; // Default value
	    
	    try {
	        PreparedStatement st = getConnection().prepareStatement("SELECT UserID FROM usertable WHERE username = ?");
	        st.setString(1, username);
	        ResultSet resultSet = st.executeQuery();
	        
	        if (resultSet.next()) {
	            userID = resultSet.getInt("UserID");
	        }
	    } catch (SQLException |ClassNotFoundException e) {
	        // Handle database errors
	        e.printStackTrace(); // This will print the error trace for debugging purposes
	    }
	    
	    return userID;
	}



	public Boolean checkNumberIfExists(String number) {
		try {
			PreparedStatement stmt = getConnection()
					.prepareStatement("SELECT COUNT(*) FROM usertable WHERE PhoneNumber = ?");
			stmt.setString(1, number);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// Method to check if username exists in the database
	public Boolean checkUsernameIfExists(String username) {

		try {
			PreparedStatement stmt = getConnection()
					.prepareStatement("SELECT COUNT(*) FROM usertable WHERE username = ?");
			stmt.setString(1, username);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public Boolean checkEmailIfExists(String email) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM usertable WHERE Email = ?");
			stmt.setString(1, email);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public Boolean checkModelNoIfExists(String modelNo) {
	    try {
	        PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM product WHERE ModelNo = ?");
	        stmt.setString(1, modelNo);
	        ResultSet resultSet = stmt.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}


	
	
	public int addProduct(ProductModel product,int userID) {
		
		try {
			if (checkModelNoIfExists(product.getModelNo())) {
				return 2; 
			}
			

			PreparedStatement st = getConnection().prepareStatement(stringutils.QUERY_ADD_PRODUCT);
		
			st.setString(1, product.getModelNo());
			st.setString(2, product.getColour());
			st.setString(3, product.getQuantity());
			st.setString(4, product.getBrandName());
			st.setString(5, product.getWatchType());
			st.setString(6, product.getCaseMaterial());
			st.setString(7, product.getWeight());
			st.setString(8, product.getPrice());
			st.setString(9, product.getGender());
			st.setString(10, product.getImageUrlFromPart());
			st.setInt(11, userID);
		
			int result = st.executeUpdate();

			if (result > 0) {
				return 1; // Product add succesfully
			} else {
				return 0; // Product Failed 
			}
		
	}
		catch(ClassNotFoundException | SQLException ex){
			ex.printStackTrace();
			return -1; 
	}
		
		
		
}
	
	public UserModel getUserByUsername(String username) throws SQLException, ClassNotFoundException {
		PreparedStatement statement = getConnection().prepareStatement("select username,Role,FullName,Image,Email,PhoneNumber,Password,ConfirmPassword from usertable where username=?");
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();
		UserModel user = new UserModel();
		if (resultSet.next()) {

			user.setUsername(resultSet.getString("username"));
			user.setRole(resultSet.getString("Role"));
			user.setFullname(resultSet.getString("FullName"));
			user.setImageUrlFromDB(resultSet.getString("Image"));
			user.setEmail(resultSet.getString("Email"));
			user.setPhoneNumber(resultSet.getString("PhoneNumber"));
			user.setPassword(resultSet.getString("Password"));
			user.setConfirmPassword(resultSet.getString("ConfirmPassword"));

		}
		return user;

	}
	
	
	public ProductModel getProductByModelNumber(String modelNumber) throws SQLException,ClassNotFoundException {
    	
    	if(checkModelNumberMatches(modelNumber))
    	{
    		
    	
			PreparedStatement statement = getConnection().prepareStatement("select * from product where ModelNo=?");
			statement.setString(1, modelNumber);
			ResultSet resultSet =statement.executeQuery();
			ProductModel product=new ProductModel();
			if(resultSet.next())
			{
				product.setModelNo(resultSet.getString("ModelNo"));
				product.setColour(resultSet.getString("Colour"));
				product.setQuantity(resultSet.getString("Quantity"));
				product.setBrandName(resultSet.getString("BrandName"));
				product.setWatchType(resultSet.getString("WatchType"));
				product.setCaseMaterial(resultSet.getString("CaseMaterial"));
				product.setWeight(resultSet.getString("weight"));
				product.setPrice(resultSet.getString("Price"));
				product.setGender(resultSet.getString("Gender"));
				
			}
			return product;
			
    	}else
    	{
    		return null;
    	}
		
		
		
		
	}
	
	public Boolean checkModelNumberMatches(String modelNumber) {
	    try {
	        PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM product WHERE ModelNo = ?");
	        stmt.setString(1, modelNumber);
	        ResultSet resultSet = stmt.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return true;
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	
	public int updateProduct(ProductModel product) {

		try {
			
			if (checkModelNumberMatches(product.getModelNo())) {
				
				PreparedStatement stmt = getConnection().prepareStatement(stringutils.QUERY_UPDATE_PRODUCT);
				stmt.setString(9, product.getModelNo());
				stmt.setString(1, product.getColour());	
				stmt.setString(2, product.getQuantity());	
				stmt.setString(3, product.getBrandName());	
				stmt.setString(4, product.getWatchType());	
				stmt.setString(5, product.getCaseMaterial());	
				stmt.setString(6, product.getWeight());	
				stmt.setString(7, product.getPrice());	
				stmt.setString(8, product.getGender());	
				
				
				
				int result = stmt.executeUpdate();
				
				//System.out.println("12345");

				// Check if the update was successful (i.e., at least one row affected)
				if (result > 0) {
					return 1; // Registration successful
				} else {
					return 0; // Registration failed (no rows affected)
				}
			}
			else
			{
				return 3;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	
	public int deleteProductByModelNo(String modelNo) {
	    try {
	        PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM product WHERE ModelNo = ?");
	        stmt.setString(1, modelNo);
	        int result = stmt.executeUpdate();
	        if (result > 0) {
	            return 1;
	        } else {
	            return 0;
	        }
	    } catch (ClassNotFoundException | SQLException ex) {
	        ex.printStackTrace();
	        return -1;
	    }
	}
	
	


}

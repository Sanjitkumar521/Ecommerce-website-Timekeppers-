package utils;

public class stringutils {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/timekeppers";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";

	public static final String IMAGE_ROOT_PATH = "C:\\Users\\sanji\\eclipse-workspace\\TimeKepper's\\src\\main\\webapp\\resources\\DBImages";
	
	
	public static final String IMAGE_DIR_USER = IMAGE_ROOT_PATH +"\\user\\";

	public static final String QUERY_REGISTER_STUDENT = "INSERT INTO usertable ("
			+ "username, FullName, Email, PhoneNumber, Role, shopID,Image, Password, confirmPassword) "
			+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
	public static final String QUERY_ADD_PRODUCT = "INSERT INTO product ("
			+ "ModelNo, Colour, Quantity, BrandName, WatchType, CaseMaterial,weight, Price, Gender,ProductImage,UserID) "
			+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_PRODUCT = "UPDATE product SET "
	        + "Colour = ?, Quantity = ?, BrandName = ?, WatchType = ?, CaseMaterial = ?, "
	        + "Weight = ?, Price = ?, Gender = ? WHERE ModelNo = ?";



	
	public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM usertable WHERE username = ?";
	public static final String QUERY_GET_ALL_STUDENTS = "SELECT * FROM usertable";
	public static final String QUERY_GET_USER_ID = "SELECT userID FROM usertable WHERE username = ?";
	public static final String QUERY_DELETE_USER = "DELETE FROM usertable WHERE username = ?";
	public static final String GET_ALL_PRODUCT = "SELECT * FROM product";

	public static final String username = "username";
	public static final String FULL_NAME = "Fullname";
	public static final String EMAIL = "Email";
	public static final String PHONE_NUMBER = "PhoneNumber";
	public static final String PASSWORD = "password";
	public static final String CONFIRM_PASSWORD= "ConfirmPassword";
	public static final String ROLE = "role";
	public static final String SHOP_ID = "shopID";
	public static final String IMAGE = "image";
	
	
	public static final String MODEL_NO = "modelno";
	public static final String COLOUR = "colour";
	public static final String 	QUANTITY = "quantity";
	public static final String BRAND_NAME = "brandname";
	public static final String WATCH_TYPE = "watchType";
	public static final String CASE_MATERIAL= "caseMaterial";
	public static final String WEIGHT = "weight";
	public static final String PRICE = "price";
	public static final String GENDER = "gender";
	public static final String IMAGE_PRODUCT = "image";
	public static final String USER_ID = "user";

	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_SUCCESS_PRODUCT = "Product Added Successfully";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";

	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	// Other Messages
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
	
	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	// End: Validation Messages

	// Start: JSP Route
	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/Register.jsp";
	public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
	public static final String PAGE_URL_FOOTER = "/pages/footer.jsp";
	public static final String PAGE_URL_HEADER = "/pages/header.jsp";
	public static final String URL_LOGIN = "/login.jsp";
	public static final String URL_INDEX = "/pages/index.jsp";
	public static final String UPDATE_PROFILE = "/pages/UpdateProfile.jsp";
	public static final String PRODUCT_URL_FORM = "/pages/productform.jsp";
	public static final String PAGE_URL_OPERATION= "/pages/operation.jsp";
	public static final String PRODUCT_URL = "/pages/product.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/Login";
	public static final String SERVLET_URL_REGISTER = "/Registration";
	public static final String SERVLET_URL_LOGOUT = "/Logout";
	public static final String SERVLET_URL_HOME = "/home";
	public static final String SERVLET_URL_UPDATEPRODUCT = "/update";
	public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
	public static final String SERVLET_URL_ADDPRODUCT = "/AddProduct";
	public static final String SERVLET_URL_DELETEPRODUCT="/Delete";
	//public static final String SERVLET_URL_UPDATE = "/update";
	
	// End: Servlet Route

	// Start: Normal Text
	public static final String USER = "user";
	public static final String SUCCESS = "success";
	public static final String TRUE = "true";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	public static final String STUDENT_MODEL = "studentModel";
	public static final String STUDENT_LISTS = "studentLists";
	public static final String SLASH= "/";
	public static final String DELETE_ID= "deleteId";
	public static final String UPDATE_ID= "updateId";
	
	

}

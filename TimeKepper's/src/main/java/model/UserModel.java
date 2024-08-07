package model;

import java.io.File;


import javax.servlet.http.Part;

import utils.stringutils;

public class UserModel {

	private String username;
	private String fullname;
	private String email;
	private String phoneNumber;
	private String password;
	private String confirmPassword;
	private String Role;
	private String shopID;
	private String imageUrlFromPart;
	
	/**
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param password
	 * @param confirmPassword
	 */
	public UserModel() {
	}

	/**
	 * @param username
	 * @param fullname
	 * @param email
	 * @param phoneNumber
	 * @param password
	 * @param confirmPassword
	 * @param role
	 * @param shopID
	 * @param imageURLFromPart
	 */
	public UserModel(String username, String fullname, String email, String phoneNumber, String password,
			String confirmPassword, String role, String shopID, Part imagePart) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.Role = role;
		this.shopID = shopID;
		this.imageUrlFromPart = getImageUrl(imagePart);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}
	
	public void setImageUrlFromPart(Part part) {
		this.imageUrlFromPart = getImageUrl(part);
	}

	public void setImageUrlFromDB(String imageUrl) {
		this.imageUrlFromPart = imageUrl;
	}

	
	/**
	 * This method extracts the image file name from the request part containing the uploaded image.
	 * 
	 * @param part The request part containing the uploaded image data.
	 * @return The extracted image file name, or "download.jpg" if no file name is found.
	 * @throws IOException If an error occurs while accessing the part data.
	 */
	private String getImageUrl(Part part) {
		// Define the directory path to store uploaded user images. This path should be configured elsewhere in the application.
	    String savePath = stringutils.IMAGE_DIR_USER;

	    // Create a File object representing the directory to store uploaded images.
	    File fileSaveDir = new File(savePath);

	    // Initialize the variable to store the extracted image file name.
	    String imageUrlFromPart = null;

	    // Check if the directory to store uploaded images already exists.
	    if (!fileSaveDir.exists()) {
	        // If the directory doesn't exist, create it.
	    	// user mkdirs() method to create multiple or nested folder
	        fileSaveDir.mkdir();
	    }

	    // Get the Content-Disposition header from the request part. This header contains information about the uploaded file, including its filename.
	    String contentDisp = part.getHeader("content-disposition");

	    // Split the Content-Disposition header into individual parts based on semicolons.
	    String[] items = contentDisp.split(";");

	    // Iterate through each part of the Content-Disposition header.
	    for (String s : items) {
	        // Check if the current part starts with "filename" (case-insensitive trim is used).
	        if (s.trim().startsWith("filename")) {
	            // Extract the filename from the current part.
	            // The filename is assumed to be enclosed in double quotes (").
	            // This part removes everything before the equal sign (=) and the double quotes surrounding the filename.
	            imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
	            break; // Exit the loop after finding the filename
	        }
	    }

	    // If no filename was extracted from the Content-Disposition header, set a default filename.
	    if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
	        imageUrlFromPart = "default_user.jpg";
	    }

	    // Return the extracted or default image file name.
	    return imageUrlFromPart;
	}
	
}

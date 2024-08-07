package model;

import java.io.File;

import javax.servlet.http.Part;

import utils.stringutils;

public class ProductModel {
	
	    private String modelNo;
	    private String colour;
	    private String quantity;
	    private String brandName;
	    private String watchType;
	    private String caseMaterial;
	    private String weight;
	    private String price;
	    private String gender;
	    private String imageUrlFromPart;
	    /**
		 * @param modelNo
		 * @param colour
		 * @param quantity
		 * @param brandName
		 * @param watchType
		 * @param caseMaterial
		 * @param weight
		 * @param price
		 * @param gender
		 * @param imageUrlFromPart
		 * @param userID
		 */
		public ProductModel()
		{
		}
		
		public ProductModel(String modelNo, String colour, String quantity, String brandName, String watchType,
				String caseMaterial, String weight, String price, String gender, Part imagePart) {
			super();
			this.modelNo = modelNo;
			this.colour = colour;
			this.quantity = quantity;
			this.brandName = brandName;
			this.watchType = watchType;
			this.caseMaterial = caseMaterial;
			this.weight = weight;
			this.price = price;
			this.gender = gender;
			this.imageUrlFromPart = getImageUrl(imagePart);
		}
		public String getModelNo() {
			return modelNo;
		}
		public void setModelNo(String modelNo) {
			this.modelNo = modelNo;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		public String getWatchType() {
			return watchType;
		}
		public void setWatchType(String watchType) {
			this.watchType = watchType;
		}
		public String getCaseMaterial() {
			return caseMaterial;
		}
		public void setCaseMaterial(String caseMaterial) {
			this.caseMaterial = caseMaterial;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getImageUrlFromPart() {
			return imageUrlFromPart;
		}
		
		public void setImageUrlFromPart(Part part) {
			this.imageUrlFromPart = getImageUrl(part);
		}
	
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

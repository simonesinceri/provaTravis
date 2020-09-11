package logic.model;

import javafx.scene.image.Image;

public class User {
	
	private String userName;
	private String userPassword;
	private String userReviewsTable;
	private Image userImage;
	private boolean userIsLogged = false;
	
	private static User istance = null;
	
	public static User getIstance() {
		if (istance == null) {
			istance = new User();
		}
		return istance;
	}

	private User() {
		this.userName = "";
		this.userPassword ="";

	}
	
	public User(String username, String password) {
		this.userName = username;
		this.userPassword = password;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public void setUserPassword(String password) {
		this.userPassword = password;
	}
	
	public boolean getUserLogged() {
		return userIsLogged;
	}

	public void setUserLogged(boolean isLogged) {
		this.userIsLogged = isLogged;
	}

	public Image getUserImage() {
		return userImage;
	}

	public void setUserImage(Image profileImage) {
		this.userImage = profileImage;
	}

	public String getUserReviewsTable() {
		return userReviewsTable;
	}

	public void setUserReviewsTable(String reviewsTable) {
		this.userReviewsTable = reviewsTable;
	}
	
	 
}

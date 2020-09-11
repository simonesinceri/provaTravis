package logic.model;

import javafx.scene.image.Image;

public class UserWeb {
	
	private String useWebName;
	private String userWebPassword;
	private String userWebReviewsTable;
	private Image uerWebImage;
	private boolean userWebIsLogged = false;

	public UserWeb() {
		this.useWebName = "";
		this.userWebPassword ="";
	}
	
	public UserWeb(String username, String password) {
		this.useWebName = username;
		this.userWebPassword = password;
	}
	
	public String getUsername() {
		return this.useWebName;
	}
	
	public String getPassword() {
		return this.userWebPassword;
	}
	
	public void setUsername(String username) {
		this.useWebName = username;
	}
	
	public void setPassword(String password) {
		this.userWebPassword = password;
	}
	
	public boolean getLogged() {
		return userWebIsLogged;
	}

	public void setLogged(boolean isLogged) {
		this.userWebIsLogged = isLogged;
	}

	public Image getImage() {
		return uerWebImage;
	}

	public void setImage(Image profileImage) {
		this.uerWebImage = profileImage;
	}

	public String getReviewsTable() {
		return userWebReviewsTable;
	}

	public void setReviewsTable(String reviewsTable) {
		this.userWebReviewsTable = reviewsTable;
	}
	
	 
}

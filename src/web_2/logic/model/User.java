package web_2.logic.model;

import javafx.scene.image.Image;

public class User {
	
	private String username;
	private String password;
	private String reviewsTable;
	private Image image;
	// attributo per vedere se utente loggato
	private boolean isLogged = false;
	
	private static User istance = null;
	
	public static User getIstance() {
		if (istance == null) {
			istance = new User();
		}
		return istance;
	}

	private User() {
		this.username = "";
		this.password ="";

	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image profileImage) {
		this.image = profileImage;
	}

	public String getReviewsTable() {
		return reviewsTable;
	}

	public void setReviewsTable(String reviewsTable) {
		this.reviewsTable = reviewsTable;
	}
	
	 
}

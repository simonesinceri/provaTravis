package logic.model;

import javafx.scene.image.Image;

public class Owner {

	private String ownerUsername;
	private String ownerPassword;
	private String ownerStructures;
	private Image ownerImage;
	private boolean ownerIsLogged = false;
	
	private static Owner istance = null;
	
	public static Owner getIstance() {
		if (istance == null) {
			istance = new Owner();
		}
		return istance;
	}

	private Owner() {
		this.ownerUsername = "";
		this.ownerPassword = "";
		this.ownerStructures = "";
	}
	
	public Owner(String username, String password, String structure) {
		this.ownerUsername = username;
		this.ownerPassword = password;
		this.ownerStructures = structure;
	}
	
	public String getOwnerUsername() {
		return this.ownerUsername;
	}
	
	public String getOwnerPassword() {
		return this.ownerPassword;
	}
	
	public void setOwnerUsername(String username) {
		this.ownerUsername = username;
	}
	
	public void setOwnerPassword(String password) {
		this.ownerPassword = password;
	}
	
	public boolean getOwnerLogged() {
		return ownerIsLogged;
	}

	public void setOwnerLogged(boolean isLogged) {
		this.ownerIsLogged = isLogged;
	}

	public String getOwnerStructures() {
		return ownerStructures;
	}

	public void setOwnerStructures(String structures) {
		this.ownerStructures = structures;
	}

	public Image getOwnerImage() {
		return ownerImage;
	}

	public void setOwnerImage(Image image) {
		this.ownerImage = image;
	}	 
}
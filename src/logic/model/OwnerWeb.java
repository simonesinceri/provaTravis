package logic.model;

import javafx.scene.image.Image;


public class OwnerWeb {
	
	private String ownerWebName;
	private String ownerWebPassword;
	private String ownerWebStructures;
	private Image ownerWebImage;
	private boolean ownerWebIsLogged = false;

	public OwnerWeb() {
		this.ownerWebName = "";
		this.ownerWebPassword = "";
		this.ownerWebStructures = "";
	}
	
	public OwnerWeb(String username, String password, String structure) {
		this.ownerWebName = username;
		this.ownerWebPassword = password;
		this.ownerWebStructures = structure;
	}
	
	public String getUsername() {
		return this.ownerWebName;
	}
	
	public String getPassword() {
		return this.ownerWebPassword;
	}
	
	public void setUsername(String username) {
		this.ownerWebName = username;
	}
	
	public void setPassword(String password) {
		this.ownerWebPassword = password;
	}
	
	public boolean getLogged() {
		return ownerWebIsLogged;
	}

	public void setLogged(boolean isLogged) {
		this.ownerWebIsLogged = isLogged;
	}

	public String getStructures() {
		return ownerWebStructures;
	}

	public void setStructures(String structures) {
		this.ownerWebStructures = structures;
	}

	public Image getImage() {
		return ownerWebImage;
	}

	public void setImage(Image image) {
		this.ownerWebImage = image;
	}

}

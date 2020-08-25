package web_2.logic.model;

import javafx.scene.image.Image;


public class OwnerWeb {
	
	private String username;
	private String password;
	private String structures;
	private Image image;
	private boolean isLogged = false;
	
	/*
	private static Owner istance = null;
	
	public static Owner getIstance() {
		if (istance == null) {
			istance = new Owner();
		}
		return istance;
	}
*/
	//private Owner() {
	public OwnerWeb() {
		this.username = "";
		this.password = "";
		this.structures = "";
	}
	
	public OwnerWeb(String username, String password, String structure) {
		this.username = username;
		this.password = password;
		this.structures = structure;
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

	public String getStructures() {
		return structures;
	}

	public void setStructures(String structures) {
		this.structures = structures;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}

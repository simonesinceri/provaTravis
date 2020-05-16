package logic.model;

public class Owner {

	private String username;
	private String password;
	private String structures;
	private boolean isLogged = false;

	public Owner() {
		this.username = "";
		this.password = "";
		this.structures = "";
	}
	
	public Owner(String username, String password, String structure) {
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
}
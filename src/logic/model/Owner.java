package logic.model;

import java.util.Vector;

public class Owner {  //volendo si poteva fare che Owner extends User

	private String username;
	private String password;
	private boolean isLogged = false;
	private Vector<String> listStructure; //lista delle strutture do owner
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Vector<String> getListStructure() {
		return listStructure;
	}
	
	public void setListStructure(Vector<String> listStructure) {
		this.listStructure = listStructure;
	}
	
	public void addStructure(String structure) {
		this.listStructure.add(structure);
		//penso che a ogni modifica di oggetti del model occora un update su DAO->DB
	}
	
	public void removeStructure(String structure) {
		this.listStructure.removeElement(structure);
	}
	
	public boolean getLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
}

	
	
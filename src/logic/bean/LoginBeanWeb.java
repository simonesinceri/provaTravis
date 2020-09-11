package logic.bean;

import java.util.ArrayList;
import java.util.List;

import logic.model.Experience;
import logic.model.OwnerWeb;
import logic.model.Structure;
import logic.model.UserWeb;

public class LoginBeanWeb {
	
	private String username;
	private String password;
	private boolean result;
	
	private UserWeb userWebLog;
	private OwnerWeb ownerWebLog;
	private List<Experience> expList;
	private int booked;
	private int review;
	private List<Structure> structList;
	private int structures;
	
	public LoginBeanWeb() {
		this.expList = new ArrayList<>();
		this.structList = new ArrayList<>();
	}
	
	
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
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public UserWeb getUserWebLog() {
		return userWebLog;
	}
	public void setUserWebLog(UserWeb userWebLog) {
		this.userWebLog = userWebLog;
	}
	public OwnerWeb getOwnerWebLog() {
		return ownerWebLog;
	}
	public void setOwnerWebLog(OwnerWeb ownerWebLog) {
		this.ownerWebLog = ownerWebLog;
	}
	public List<Experience> getExpList() {
		return expList;
	}
	public void setExpList(List<Experience> expList) {
		this.expList = expList;
	}
	public List<Structure> getStructList() {
		return structList;
	}
	public void setStructList(List<Structure> structList) {
		this.structList = structList;
	}
	public int getBooked() {
		return booked;
	}
	public void setBooked(int booked) {
		this.booked = booked;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getStructures() {
		return structures;
	}
	public void setStructures(int structures) {
		this.structures = structures;
	}
}

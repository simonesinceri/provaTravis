package logic.controller;

import javafx.scene.layout.AnchorPane;
import logic.bean.LoginBean;
import logic.model.Login;
import logic.model.Owner;
import logic.model.User;
import logic.view.LogWindow;
import logic.view.ProfileScene;
import logic.view.UserScene_2;

public class LoginController {

	private ProfileScene profileScene;
	private UserScene_2 userScene;
	private LogWindow window;
	private AnchorPane pane;
	private Login login;
	private LoginBean bean;
	private User user;
	private Owner owner;
	
	public LoginController(AnchorPane pane) {
		this.login = new Login();
		this.bean = new LoginBean();
		this.user = new User();
		this.owner = new Owner();
		this.pane = pane;
	}
	
	public void login() {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		this.user = login.checkUser(username, password);
		
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			bean.setResult(true);
		} else {
			this.owner = login.checkOwner(username, password);
			if (owner.getUsername().equals(username) && owner.getPassword().equals(password)) {
				bean.setResult(true);
			} else {			
				bean.setResult(false);
			}
		}
	}
	
	public boolean registerUser() {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		boolean result = false;
		
		if (login.registerUserString(username, password)) {
			result = true;
		}		
		
		return result;
	}
	
	public boolean registerOwner() {
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		boolean result = false;
		
		if (login.registerOwnerString(username, password)) {
			result = true;
		}		
		
		return result;
	}
	
	public void changeScene() {
		
		if (!user.getLogged()) {
			if (!owner.getLogged()) {
				
				profileScene = new ProfileScene(this);
				
				pane.getChildren().clear();
				pane.getChildren().add(profileScene);
			} else {
				this.loggedScene(owner.getUsername());
			}
		} else {
			this.loggedScene(user.getUsername());
		}
	}
	
	public void openLogWindow() {
		window = new LogWindow();
		window.Log(this,bean);
	}
	
	public boolean openRegisterWindow() {
		window = new LogWindow();
		return window.Register(this,bean);
	}
	
	public void loggedScene(String username) {
		
		userScene = new UserScene_2(username);
		
		pane.getChildren().clear();
		pane.getChildren().add(userScene);
	}
}
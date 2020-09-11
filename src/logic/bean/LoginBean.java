package logic.bean;

public class LoginBean {
	
	private String usernameBean;
	private String passwordBean;
	private boolean resultBean;
	
	public String getUsername() {
		return usernameBean;
	}
	public void setUsername(String username) {
		this.usernameBean = username;
	}
	public String getPassword() {
		return passwordBean;
	}
	public void setPassword(String password) {
		this.passwordBean = password;
	}
	public boolean getResult() {
		return resultBean;
	}
	public void setResult(boolean result) {
		this.resultBean = result;
	}
}

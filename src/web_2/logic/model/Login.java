package web_2.logic.model;

import web_2.logic.dao.OwnerDao;
import web_2.logic.dao.User;
import web_2.logic.dao.UserDao;

public class Login {
	
	private UserWeb userLoggatoWeb;
	private User userLoggato;
	private Owner ownerLoggato;
	
	public Login() {
		userLoggato = User.getIstance();
		userLoggatoWeb = new UserWeb();
		ownerLoggato = new Owner();
	}
	
	//ritorna un boolean: true se la registrazione è avvenuta	
	public boolean registerUserString(String username, String password ){
		
		boolean result = false;
		
		try {
			result = UserDao.setUser(username, password);
		} catch (Exception e) {
			System.out.println("# User_Dao registration error! #");
	        System.out.println(e);
		} 
		return result;			
	}
	
	public boolean registerOwnerString(String username, String password ){
		
		boolean result = false;
		
		try {
			result = OwnerDao.setOwner(username, password);
		} catch (Exception e) {
			System.out.println("# User_Dao registration error! #");
	        System.out.println(e);
		} 
		return result;			
	}
	
	// ritorna un user che dice se è presente o no nel DB	
	public User checkUser(String username, String password) {
		 
		try {
			userLoggato = UserDao.getUser(username);
		} catch (Exception e) {
			System.out.println("# User_Dao login error! #");
	        System.out.println(e);
		}
		 return userLoggato;
	}
	
	public UserWeb checkUserWeb(String username, String password) {
		 
		try {
			userLoggatoWeb = UserDao.getUserWeb(username);
		} catch (Exception e) {
			System.out.println("# User_Dao login error! #");
	        System.out.println(e);
		}
		 return userLoggatoWeb;
	}
	
	public Owner checkOwner(String username, String password) {
		 
		try {
			ownerLoggato = OwnerDao.getOwner(username);
		} catch (Exception e) {
			System.out.println("# User_Dao login error! #");
	        System.out.println(e);
		}
		 return ownerLoggato;
	}
}
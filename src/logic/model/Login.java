package logic.model;

import logic.dao.OwnerDao;
import logic.dao.UserDao;
import logic.dao.UserWebDao;
import logic.exceptions.ExistingOwnerException;
import logic.exceptions.ExistingUsernameException;


public class Login {
	
	private User userLoggato;
	private Owner ownerLoggato;
	private OwnerWeb ownerLoggatoWeb;
	private UserWeb userLoggatoWeb;
	
	public Login() {
		userLoggato = User.getIstance();
		ownerLoggato = Owner.getIstance();
		ownerLoggatoWeb = new OwnerWeb();
		userLoggatoWeb = new UserWeb();
	}
		
	public boolean registerUserString(String username, String password ) throws ExistingUsernameException{
		
		boolean result = false;
		
		try {
			result = UserDao.setUser(username, password);
		} catch (ExistingUsernameException e) {
			throw e;
		} catch(Exception a) {
			a.printStackTrace();
		}
		return result;			
	}
	
	public boolean registerOwnerString(String username, String password ) throws ExistingOwnerException{

		boolean result = false;
		
		try {
			result = OwnerDao.setOwner(username, password);
		} catch(ExistingOwnerException e){
			throw e;
		}catch (Exception a) {
			a.printStackTrace();
		} 
		return result;			
	}
	
	public User checkUser(String username) {
		 
		try {
			userLoggato = UserDao.getUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return userLoggato;
	}
	
	public Owner checkOwner(String username) {
		 
		try {
			ownerLoggato = OwnerDao.getOwner(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return ownerLoggato;
	}
	public OwnerWeb checkOwnerWeb(String username) {
		 
		try {
			ownerLoggatoWeb = OwnerDao.getOwnerWeb(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return ownerLoggatoWeb;
	}
	
	public UserWeb checkUserWeb(String username) {
		 
		try {
			userLoggatoWeb = UserWebDao.getUserWeb(username);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		 return userLoggatoWeb;
	}
}
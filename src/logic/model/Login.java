package logic.model;

public class Login {
	
	private User userLoggato;
	private Owner ownerLoggato;
	
	public Login() {
		userLoggato = new User();
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
/*
 * Autore: Simone Sinceri
 * */

package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import logic.exceptions.ExistingOwnerException;
import logic.exceptions.ExistingUsernameException;
import logic.model.Login;
import logic.model.Owner;
import logic.model.User;

class TestLogin {

	@Test
	void testCheckUserRegisteredUser() {
		
		Login login = new Login();
		String username = "Simone";
		
		User user = login.checkUser(username);
		
		assertEquals(username, user.getUserName());
	}
	
	@Test
	void testCheckUserNotRegisteredUser() {
		
		Login login = new Login();
		String username = "franco89";
		
		User user = login.checkUser(username);
		
		assertNotEquals(username, user.getUserName());
	}
	

	
	@Test
	void testCheckOwnerRegisteredOwner() {
		
		Login login = new Login();
		String usernameOwner = "Mario";
		
		Owner owner = login.checkOwner(usernameOwner);
		
		assertEquals(usernameOwner, owner.getOwnerUsername());
	}
	
	@Test
	void testCheckOwnerNotRegisteredOwner() {
		
		Login login = new Login();
		String usernameOwner = "ownermario";
		
		Owner owner = login.checkOwner(usernameOwner);
		
		assertNotEquals(usernameOwner, owner.getOwnerUsername());
	}
	
	@Test
	void testRegisterUserStringUserExisting() {
		
		Login login = new Login();
		String username = "Simone";
		String password = "asfsvf";
		boolean result = true;
		
		try {
			result = login.registerUserString(username, password); 
		}catch(ExistingUsernameException e) {
			result = false;
		}
		assertEquals(false,result);
		
	}
	
	@Test
	void testRegisterOwnerStringOwnerExisting() {
		
		Login login = new Login();
		String usernameOwner = "Riccardo";
		String password = "riccardo";
		boolean result = true;
		
		try {
			result = login.registerOwnerString(usernameOwner, password); 
		}catch(ExistingOwnerException e) {
			result = false;
		}
		assertEquals(false,result);
	}
	
	

}

 package logic.exceptions;

/*
 * Author: Pierpaolo Spaziani
 */
 
public class UsernameException  extends Exception {

	private static final long serialVersionUID = 1L;

	public UsernameException () {
		super("An Exception has been thrown cause Username insert was too long");
	}
}

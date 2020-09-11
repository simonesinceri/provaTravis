/*
 * Author: Simone Sinceri
 * */
package logic.exceptions;

public class ExistingOwnerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ExistingOwnerException() {
		
	}
	
	public ExistingOwnerException(Throwable cause) {
		super(cause);
	}
	public ExistingOwnerException(String message) {
		super("ExistingOwnerException: " + message);
	}
}

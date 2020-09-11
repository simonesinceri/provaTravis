package logic.exceptions;

/*
 * Author: Pierpaolo Spaziani
 */

public class ExceptionSearchHotels extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionSearchHotels () {
		super("An Exception has been thrown searching Hotels");
	}
}

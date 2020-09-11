package logic.exceptions;

/*
 * Author: Pierpaolo Spaziani
 */

public class ExceptionSearchReview extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionSearchReview () {
		super("An Exception has been thrown searching Reviews");
	}
}

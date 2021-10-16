package exception;

public class UnderageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnderageException() {
		super("The minors are not allowed to get in");
	}

}

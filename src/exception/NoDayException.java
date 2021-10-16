package exception;

public class NoDayException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int date;
	private int number;
	public NoDayException(int dat,int num) {
		super("You are not authorized to buy today");
		date=dat;
		number=num;
	}

	public int getDate() {
		return date;
	}

	public int getNumber() {
		return number;
	}
}

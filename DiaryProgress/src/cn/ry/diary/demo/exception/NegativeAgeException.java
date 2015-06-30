package cn.ry.diary.demo.exception;

public class NegativeAgeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeAgeException() {
	}

	public NegativeAgeException(String message) {
		super(message);
	}
	
}

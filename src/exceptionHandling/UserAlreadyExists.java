package exceptionHandling;

public class UserAlreadyExists extends Exception {

	public UserAlreadyExists() {
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExists(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExists(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

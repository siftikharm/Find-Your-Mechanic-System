package exceptionHandling;

@SuppressWarnings("serial")
public class InvalidLoginCredentials extends Exception {

	public InvalidLoginCredentials() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginCredentials(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginCredentials(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginCredentials(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginCredentials(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

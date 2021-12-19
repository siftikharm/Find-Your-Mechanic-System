package exceptionHandling;

public class DatabaseNotFoundException extends Exception {

	public DatabaseNotFoundException() {
	}

	public DatabaseNotFoundException(String message) {
		super(message);
	}

	public DatabaseNotFoundException(Throwable cause) {
		super(cause);
	}

	public DatabaseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

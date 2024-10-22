package tema1.ejercicio2.service;

public class ClienteServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8227139597444881605L;

	public ClienteServiceException() {
	}

	public ClienteServiceException(String message) {
		super(message);
	}

	public ClienteServiceException(Throwable cause) {
		super(cause);
	}

	public ClienteServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

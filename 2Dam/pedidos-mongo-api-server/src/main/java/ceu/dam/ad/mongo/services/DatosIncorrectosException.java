package ceu.dam.ad.mongo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DatosIncorrectosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3954603390615775830L;

	public DatosIncorrectosException() {
	}

	public DatosIncorrectosException(String message) {
		super(message);
	}

	public DatosIncorrectosException(Throwable cause) {
		super(cause);
	}

	public DatosIncorrectosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatosIncorrectosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package ceu.dam.ad.mongo.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.mongo.services.DatosIncorrectosException;

@ControllerAdvice
public class DatosIncorrectosExceptionHandler {

	@ExceptionHandler(DatosIncorrectosException.class)
	public ResponseEntity<String> handle(DatosIncorrectosException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage());
	}

}

package ceu.dam.ad.mongo.api.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest().body(e.getFieldError().getField() + ": " + e.getFieldError().getDefaultMessage());
	}
}

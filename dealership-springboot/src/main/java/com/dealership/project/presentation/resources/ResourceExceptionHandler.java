package com.dealership.project.presentation.resources;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dealership.project.presentation.exceptions.AssociationInUseException;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //interceptar as exceções para executar o possível tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request) {
	    String error = "Invalid argument";
	    HttpStatus status = HttpStatus.BAD_REQUEST; // Escolha o status apropriado
	    StandardError err = new StandardError(
	        Instant.now(), 
	        status.value(), 
	        error, 
	        e.getMessage(), 
	        request.getRequestURI()
	    );
	    return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(AssociationInUseException.class)
	public ResponseEntity<StandardError> classInAssociation(AssociationInUseException e, HttpServletRequest request) {
		String error = "The resource cannot be removed or changed because it is in use by another entity.";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
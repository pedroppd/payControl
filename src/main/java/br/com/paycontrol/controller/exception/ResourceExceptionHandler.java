package br.com.paycontrol.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.paycontrol.service.exception.ResourceIntegrityViolationException;
import br.com.paycontrol.service.exception.ResourceNoSuchElementException;

@ControllerAdvice
public class ResourceExceptionHandler 
{

	@ExceptionHandler(ResourceIntegrityViolationException.class)
	public ResponseEntity<StandardError> integrityViolationException(ResourceIntegrityViolationException e, HttpServletRequest request)
	{
		String error = "Integrity Violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()));
	}
	
	@ExceptionHandler(ResourceNoSuchElementException.class)
	public ResponseEntity<StandardError> noSuchElementException(ResourceNoSuchElementException e, HttpServletRequest request)
	{
		String error = "Element not exist";
		HttpStatus status = HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()));
	}
	
	public ResourceExceptionHandler() 
	{
		
	}
}

package br.com.paycontrol.service.exception;

public class ResourceNoSuchElementException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNoSuchElementException(Object value) 
	{
		super(String.format("The element %s not found", value));
	}

}

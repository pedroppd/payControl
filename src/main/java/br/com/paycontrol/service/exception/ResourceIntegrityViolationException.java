package br.com.paycontrol.service.exception;

public class ResourceIntegrityViolationException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;

	public ResourceIntegrityViolationException(Object value) 
	{
		super(String.format("The object %s cannot be deleted", value));
	}
}

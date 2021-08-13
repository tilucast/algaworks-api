package com.algaworks.algaworksapi.exceptionhandler;

public class ValidationRulesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidationRulesException(String message) {
		super(message);
	}
}

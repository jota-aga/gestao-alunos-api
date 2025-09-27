package com.gestaoAlunosapi.demo.exceptions;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException(String entity) {
		super(entity + " id is not in system!");
	}
	
}

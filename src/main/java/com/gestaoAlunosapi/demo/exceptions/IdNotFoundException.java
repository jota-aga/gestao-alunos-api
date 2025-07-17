package com.gestaoAlunosapi.demo.exceptions;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException() {
		super("Id is not in system!");
	}
	
}

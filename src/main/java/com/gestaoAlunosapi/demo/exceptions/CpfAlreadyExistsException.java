package com.gestaoAlunosapi.demo.exceptions;

public class CpfAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfAlreadyExistsException(){
		super("This CPF already exists");
	}

}

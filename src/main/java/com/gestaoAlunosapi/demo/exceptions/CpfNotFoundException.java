package com.gestaoAlunosapi.demo.exceptions;

public class CpfNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfNotFoundException() {
		super("Cpf is not in system!");
	}
	
}

package com.gestaoAlunosapi.demo.enums;

public enum Status {
	
	APROVADO("Aprovado"),
	REPROVADO("Reprovado"),
	EM_PROCESSO("Em processo");
	
	private String status;
	
	Status(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}

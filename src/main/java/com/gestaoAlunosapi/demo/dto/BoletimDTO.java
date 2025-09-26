package com.gestaoAlunosapi.demo.dto;

import org.hibernate.validator.constraints.Range;
import com.gestaoAlunosapi.demo.models.Boletim;
import jakarta.validation.constraints.NotNull;

public class BoletimDTO {
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min= 0, max= 10, message = "Nota deve estar entre 0 a 10")
	private double firstTest;
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min= 0, max= 10, message = "Nota deve estar entre 0 a 10")
	private double secondTest;
	
	public BoletimDTO(double firstTest, double secondTest) {
		this.firstTest = firstTest;
		this.secondTest = secondTest;
	}
	
	public Boletim changeTestsValue(Boletim boletim) {
		boletim.setFirstTest(firstTest);
		boletim.setSecondTest(secondTest);
		
		return boletim;
	}

	public double getFirstTest() {
		return firstTest;
	}

	public void setFirstTest(double firstTest) {
		this.firstTest = firstTest;
	}

	public double getSecondTest() {
		return secondTest;
	}

	public void setSecondTest(double secondTest) {
		this.secondTest = secondTest;
	}
	
	

}

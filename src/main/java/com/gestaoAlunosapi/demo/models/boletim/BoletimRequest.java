package com.gestaoAlunosapi.demo.models.boletim;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record BoletimRequest (
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min= 0, max= 10, message = "Nota deve estar entre 0 a 10")
	double firstTest,
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min= 0, max= 10, message = "Nota deve estar entre 0 a 10")
	double secondTest
	)
{}
	
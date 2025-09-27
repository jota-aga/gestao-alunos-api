package com.gestaoAlunosapi.demo.models.report_card;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotNull;

public record ReportCardRequest (
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min = 0, max = 10, message = "Nota deve estar entre 0 e 10")
	BigDecimal firstTest,
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min = 0, max = 10, message = "Nota deve estar entre 0 e 10")
	BigDecimal secondTest
	)
{}
	
package com.gestaoAlunosapi.demo.models.boletim;

import java.math.BigDecimal;

import com.gestaoAlunosapi.demo.enums.Status;



public record BoletimResponse (
		
		BigDecimal firstTest,

		BigDecimal secondTest,
		
		BigDecimal media,
		
		Status status
		)
	{}

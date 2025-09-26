package com.gestaoAlunosapi.demo.models.boletim;

import com.gestaoAlunosapi.demo.enums.Status;



public record BoletimResponse (
		
		double firstTest,

		double secondTest,
		
		double media,
		
		Status status
		)
	{}

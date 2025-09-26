package com.gestaoAlunosapi.demo.dto;

import com.gestaoAlunosapi.demo.enums.StatusEnum;



public record BoletimResponse (
		
		double firstTest,

		double secondTest,
		
		double media,
		
		StatusEnum status
		)
	{}

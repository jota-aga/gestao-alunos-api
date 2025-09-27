package com.gestaoAlunosapi.demo.models.report_card;

import java.math.BigDecimal;

import com.gestaoAlunosapi.demo.enums.Status;



public record ReportCardResponse (
		
		BigDecimal firstTest,

		BigDecimal secondTest,
		
		BigDecimal media,
		
		Status status
		)
	{}

package com.gestaoAlunosapi.demo.models.report_card;

import java.math.BigDecimal;

public record ReportCardRequest (
		
	BigDecimal firstTest,

	BigDecimal secondTest
	)
{}
	
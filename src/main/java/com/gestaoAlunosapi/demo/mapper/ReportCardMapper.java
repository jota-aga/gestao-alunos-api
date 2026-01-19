package com.gestaoAlunosapi.demo.mapper;

import com.gestaoAlunosapi.demo.models.report_card.ReportCard;
import com.gestaoAlunosapi.demo.models.report_card.ReportCardResponse;

public class ReportCardMapper {
	
	public static ReportCardResponse toDTO(ReportCard reportCard) {
		reportCard.setMedia();
		reportCard.setStatus();
		ReportCardResponse dto = new ReportCardResponse(reportCard.getFirstTest(), reportCard.getSecondTest(), reportCard.getMedia(), reportCard.getStatus());
		
		return dto;
	}
}

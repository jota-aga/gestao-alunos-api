package com.gestaoAlunosapi.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoAlunosapi.demo.enums.Status;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.models.report_card.ReportCard;
import com.gestaoAlunosapi.demo.models.report_card.ReportCardRequest;
import com.gestaoAlunosapi.demo.repository.ReportCardRepository;

@Service
public class ReportCardService {
	@Autowired
	ReportCardRepository repo;
	
	public void saveReportCard(ReportCard reportCard) {
		repo.save(reportCard);
	}
	
	public ReportCard findReportCardByStudentId(int studentId) {
		Optional<ReportCard> reportCard = repo.findByStudent_Id(studentId);
		
		return reportCard.orElseThrow(() -> new IdNotFoundException("Report Card"));
	}
	
	public ReportCard findReportCardById(int id) {
		Optional<ReportCard> reportCard = repo.findById(id);
		
		return reportCard.orElseThrow(() -> new IdNotFoundException("Report Card"));
	}
	
	public ReportCard editReportCard(ReportCardRequest reportCardDTO, ReportCard reportCard) {
		reportCard.setFirstTest(reportCardDTO.firstTest());
		reportCard.setSecondTest(reportCardDTO.secondTest());
		
		BigDecimal media = (reportCard.getFirstTest().add(reportCard.getSecondTest())).divide(BigDecimal.TWO);
		
		reportCard.setMedia(media);
		
		if(media.compareTo(BigDecimal.valueOf(7)) == 0 || media.compareTo(BigDecimal.valueOf(7)) == 1) {
			reportCard.setStatus(Status.APROVADO);
		}
		else {
			reportCard.setStatus(Status.REPROVADO);
		}
		
		return reportCard;
	}
	
}

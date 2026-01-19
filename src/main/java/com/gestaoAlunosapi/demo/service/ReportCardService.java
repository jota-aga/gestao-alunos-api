package com.gestaoAlunosapi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Optional<ReportCard> reportCard = repo.findByStudentId(studentId);
		
		return reportCard.orElseThrow(() -> new IdNotFoundException("Report Card"));
	}
	
	public ReportCard findReportCardById(int id) {
		Optional<ReportCard> reportCard = repo.findById(id);
		
		return reportCard.orElseThrow(() -> new IdNotFoundException("Report Card"));
	}
	
	public void editReportCard(ReportCardRequest reportCardDTO, Integer id) {
		ReportCard reportCard = findReportCardById(id);
		
		reportCard.setFirstTest(reportCardDTO.firstTest());
		reportCard.setSecondTest(reportCardDTO.secondTest());
		
		saveReportCard(reportCard);
	}
	
}

package com.gestaoAlunosapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoAlunosapi.demo.mapper.Mapper;
import com.gestaoAlunosapi.demo.models.report_card.ReportCard;
import com.gestaoAlunosapi.demo.models.report_card.ReportCardRequest;
import com.gestaoAlunosapi.demo.models.report_card.ReportCardResponse;
import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.service.ReportCardService;
import com.gestaoAlunosapi.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("report-card")
public class ReportCardController {
	@Autowired
	ReportCardService reportCardService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("student_id/{studentId}")
	public ResponseEntity<ReportCardResponse> findByStudentId(@PathVariable int studentId){
		Student student = studentService.findStudentById(studentId);
		ReportCard reportCard = student.getReportCard();
		ReportCardResponse reportCardResponse = Mapper.toDTO(reportCard);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(reportCardResponse);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ReportCardResponse> findByReportCardById(@PathVariable int id){
		ReportCard reportCard = reportCardService.findReportCardById(id);
		ReportCardResponse reportCardResponse = Mapper.toDTO(reportCard);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(reportCardResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReportCardResponse> editReportCard(@PathVariable int id, @Valid @RequestBody ReportCardRequest reportCardRequest){
		ReportCard reportCard = reportCardService.findReportCardById(id);
		reportCard = reportCardService.editReportCard(reportCardRequest, reportCard);
		reportCardService.saveReportCard(reportCard);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

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

import com.gestaoAlunosapi.demo.dto.BoletimRequest;
import com.gestaoAlunosapi.demo.dto.BoletimResponse;
import com.gestaoAlunosapi.demo.models.Boletim;
import com.gestaoAlunosapi.demo.models.Student;
import com.gestaoAlunosapi.demo.service.BoletimService;
import com.gestaoAlunosapi.demo.service.StudentService;

@RestController
@RequestMapping("boletim")
public class BoletimController {
	@Autowired
	BoletimService boletimService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/{studentId}")
	public ResponseEntity<BoletimResponse> findByStudentId(@PathVariable int id){
		Student student = studentService.findStudentById(id);
		Boletim boletim = student.getBoletim();
		BoletimResponse boletimResponse = new BoletimResponse(boletim.getFirstTest(), boletim.getSecondTest(), boletim.getMedia(), boletim.getStatus());
		
		return ResponseEntity.status(HttpStatus.FOUND).body(boletimResponse);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BoletimResponse> findByBoletim(@PathVariable int id){
		Boletim boletim = boletimService.findBoletimById(id);
		BoletimResponse boletimResponse = new BoletimResponse(boletim.getFirstTest(), boletim.getSecondTest(), boletim.getMedia(), boletim.getStatus());
		
		return ResponseEntity.status(HttpStatus.FOUND).body(boletimResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BoletimResponse> findByBoletim(@PathVariable int id, @RequestBody BoletimRequest boletimRequest){
		Boletim boletim = boletimService.findBoletimById(id);
		boletim = boletimService.editBoletim(boletimRequest, boletim);
		boletimService.saveBoletim(boletim);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

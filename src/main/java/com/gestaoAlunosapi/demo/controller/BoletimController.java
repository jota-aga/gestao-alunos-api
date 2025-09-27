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

import com.gestaoAlunosapi.demo.Mapper;
import com.gestaoAlunosapi.demo.models.boletim.Boletim;
import com.gestaoAlunosapi.demo.models.boletim.BoletimRequest;
import com.gestaoAlunosapi.demo.models.boletim.BoletimResponse;
import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.service.BoletimService;
import com.gestaoAlunosapi.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("boletim")
public class BoletimController {
	@Autowired
	BoletimService boletimService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("student_id/{studentId}")
	public ResponseEntity<BoletimResponse> findByStudentId(@PathVariable int studentId){
		Student student = studentService.findStudentById(studentId);
		Boletim boletim = student.getBoletim();
		BoletimResponse boletimResponse = Mapper.toDTO(boletim);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(boletimResponse);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BoletimResponse> findByBoletimById(@PathVariable int id){
		Boletim boletim = boletimService.findBoletimById(id);
		BoletimResponse boletimResponse = Mapper.toDTO(boletim);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(boletimResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BoletimResponse> editBoletim(@PathVariable int id, @Valid @RequestBody BoletimRequest boletimRequest){
		Boletim boletim = boletimService.findBoletimById(id);
		boletim = boletimService.editBoletim(boletimRequest, boletim);
		boletimService.saveBoletim(boletim);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

package com.gestaoAlunosapi.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoAlunosapi.demo.dto.RequestBoletim;
import com.gestaoAlunosapi.demo.dto.StudentDto;
import com.gestaoAlunosapi.demo.models.Boletim;
import com.gestaoAlunosapi.demo.models.Student;
import com.gestaoAlunosapi.demo.service.BoletimService;
import com.gestaoAlunosapi.demo.service.StudentService;
import jakarta.validation.Valid;

@RestController
public class Controller {
	@Autowired
	StudentService studentService;
	
	@Autowired
	BoletimService boletimService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	
	@GetMapping("/students/cpf")
	public Student findByCpf(@RequestParam String cpf) {
		return studentService.findStudentByCpf(cpf);
	}
	
	@PostMapping("/students/add")
	public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDto studentDto) {
			Student student = studentDto.cast();
			Boletim boletim = new Boletim(student);
			studentService.saveStudent(student);
			boletimService.saveBoletim(boletim);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@PutMapping("/students/edit/{id}")
	public ResponseEntity<String> editStudent(@PathVariable int id, @Valid @RequestBody StudentDto studentDto){
		Student student = studentService.findStudentById(id);
		student = studentDto.editStudent(student);
		studentService.saveStudentEdited(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/students/{id}")
	public Student findById(@PathVariable int id) {
		return studentService.findStudentById(id);
	}
	
	@PutMapping("/students/boletim/edit/{id}")
	public ResponseEntity<String> editBoletimByStudentId(@PathVariable int id, @Valid @RequestBody RequestBoletim boletimDto) {
		Boletim boletim = boletimService.findBoletimByStudentId(id);
		
		boletim = boletimDto.changeTestsValue(boletim);
		boletimService.editBoletim(boletim);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/students/boletim/{id}")
	public Boletim boletimByStudentId(@PathVariable int id) {
		Boletim boletim = boletimService.findBoletimByStudentId(id);
		
		return boletim;
	}
}

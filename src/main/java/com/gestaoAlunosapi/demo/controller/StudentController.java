package com.gestaoAlunosapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gestaoAlunosapi.demo.dto.StudentRequest;
import com.gestaoAlunosapi.demo.models.Boletim;
import com.gestaoAlunosapi.demo.models.Student;
import com.gestaoAlunosapi.demo.service.BoletimService;
import com.gestaoAlunosapi.demo.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	BoletimService boletimService;
	
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	
	@GetMapping("/cpf")
	public Student findByCpf(@RequestParam String cpf) {
		return studentService.findStudentByCpf(cpf);
	}
	
	@PostMapping()
	public ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
			Student student = new Student(studentRequest.name(), studentRequest.cpf());
			Boletim boletim = new Boletim(student);
			studentService.saveStudent(student);
			boletimService.saveBoletim(boletim);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> editStudent(@PathVariable int id, @Valid @RequestBody StudentRequest studentRequest){
		Student student = studentService.findStudentById(id);
		student = studentService.editStudent(studentRequest, student);
		studentService.saveStudent(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable int id) {
		Student student = studentService.findStudentById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}

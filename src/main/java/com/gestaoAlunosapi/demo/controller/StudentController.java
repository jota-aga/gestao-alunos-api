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

import com.gestaoAlunosapi.demo.mapper.StudentMapper;
import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.models.student.StudentDTO;
import com.gestaoAlunosapi.demo.service.ReportCardService;
import com.gestaoAlunosapi.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	ReportCardService reportCardService;
	
	@GetMapping()
	public ResponseEntity<List<StudentDTO>> getAllStudents(){
		List<Student> students = studentService.getAllStudents();
		
		List<StudentDTO> studentsDTO = StudentMapper.toListDTO(students);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentsDTO);
	}
	
	
	@GetMapping("/cpf")
	public ResponseEntity<StudentDTO> findByCpf(@RequestParam String cpf) {
		Student student = studentService.findStudentByCpf(cpf);
		
		StudentDTO studentDTO = StudentMapper.toDTO(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentDTO);
	}
	
	@PostMapping()
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
			studentService.createStudent(studentDTO);
			
			return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@PathVariable int id, @Valid @RequestBody StudentDTO studentDTO){
		studentService.editStudent(id, studentDTO);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable int id) {
		Student student = studentService.findStudentById(id);
		
		StudentDTO studentDTO = StudentMapper.toDTO(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentDTO);
	}
}

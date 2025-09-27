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

import com.gestaoAlunosapi.demo.mapper.Mapper;
import com.gestaoAlunosapi.demo.models.report_card.ReportCard;
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
		List<StudentDTO> studentsDTO = Mapper.toDTO(students);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentsDTO);
	}
	
	
	@GetMapping("/cpf")
	public ResponseEntity<StudentDTO> findByCpf(@RequestParam String cpf) {
		Student student = studentService.findStudentByCpf(cpf);
		StudentDTO studentResponse = Mapper.toDTO(student);
		return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
	}
	
	@PostMapping()
	public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDTO studentRequest) {
			Student student = Mapper.toEntity(studentRequest);
			ReportCard reportCard = new ReportCard(student);
			studentService.saveStudent(student);
			reportCardService.saveReportCard(reportCard);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> editStudent(@PathVariable int id, @Valid @RequestBody StudentDTO studentRequest){
		Student student = studentService.findStudentById(id);
		student = studentService.editStudent(studentRequest, student);
		studentService.saveStudent(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable int id) {
		Student student = studentService.findStudentById(id);
		StudentDTO studentResponse = Mapper.toDTO(student);
		return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
	}
}

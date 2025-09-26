package com.gestaoAlunosapi.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoAlunosapi.demo.exceptions.CpfNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.models.student.StudentDTO;
import com.gestaoAlunosapi.demo.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	public void saveStudent(Student student) {
		repo.save(student);
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		
		students = repo.findAll();
		return students;
	}
	
	public Student findStudentByCpf(String cpf){
		Optional<Student> student = repo.findByCpf(cpf);
		
		return student.orElseThrow(() -> new CpfNotFoundException());
	}
	
	public Student findStudentById(int id) {
		Optional<Student> student = repo.findById(id);
		
		return student.orElseThrow(() -> new IdNotFoundException("Student"));		
	}
	
	public void deleteStudentById(int id) {
		repo.deleteById(id);
	}

	public Student editStudent( StudentDTO studentDTO, Student student) {
		student.setName(studentDTO.name());
		student.setCpf(studentDTO.cpf());
		
		return student;
	}	
}

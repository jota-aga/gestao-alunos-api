package com.gestaoAlunosapi.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestaoAlunosapi.demo.exceptions.CpfAlreadyExistsException;
import com.gestaoAlunosapi.demo.exceptions.CpfNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.models.Student;
import com.gestaoAlunosapi.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	public void saveStudent(Student student) {
		
		Optional<Student> studentRepeat = repo.findByCpf(student.getCpf());
		if(studentRepeat.isPresent()) {
			throw new CpfAlreadyExistsException();
		}
		repo.save(student);
	}
	
	public void saveStudentEdited(Student student) {
		Optional<Student> studentRepeat = repo.findByCpf(student.getCpf());
		
		if(studentRepeat.isPresent() && studentRepeat.get().getId() != student.getId()) {
			throw new CpfAlreadyExistsException();
		}
		
		repo.save(student);
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		
		students = repo.findAll();
		return students;
	}
	
	public Student findStudentByCpf(String cpf){
		Optional<Student> student = repo.findByCpf(cpf);
		
		if(student.isEmpty()) {
			throw new CpfNotFoundException();
		}
		
		return student.get();
	}
	
	public Student findStudentById(int id) {
		Optional<Student> student = repo.findById(id);
		
		if(student.isEmpty()) {
			throw new IdNotFoundException();
		}
		
		return student.get();
		
	}
	
	public void deleteStudentById(int id) {
		if(repo.findById(id).isEmpty()) {
			throw new IdNotFoundException();
		}
		repo.deleteById(id);
	}	
}

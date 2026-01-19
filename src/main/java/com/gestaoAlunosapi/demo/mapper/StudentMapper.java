package com.gestaoAlunosapi.demo.mapper;

import java.util.List;

import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.models.student.StudentDTO;

public class StudentMapper {
	public static Student toNewEntity(StudentDTO DTO) {
		Student student = new Student(DTO.cpf(), DTO.name());
		
		return student;
	}
	
	public static Student toExistEntity(StudentDTO DTO, Student student) {
		student.setName(DTO.name());
		student.setCpf(DTO.cpf());
		
		return student;
	}
	
	public static StudentDTO toDTO(Student student) {
		StudentDTO dto = new StudentDTO(student.getCpf(), student.getName());
		
		return dto;
	}
	
	public static List<StudentDTO> toListDTO(List<Student> students){
		List<StudentDTO> dto = students.stream()
									  .map(student -> new StudentDTO(student.getCpf(), student.getName()))
									  .toList();
		
		return dto;
	}
}

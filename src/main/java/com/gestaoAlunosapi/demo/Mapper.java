package com.gestaoAlunosapi.demo;

import java.util.List;

import com.gestaoAlunosapi.demo.models.boletim.Boletim;
import com.gestaoAlunosapi.demo.models.boletim.BoletimResponse;
import com.gestaoAlunosapi.demo.models.student.Student;
import com.gestaoAlunosapi.demo.models.student.StudentDTO;

public class Mapper {
	
	public static Student toEntity(StudentDTO DTO) {
		Student student = new Student(DTO.cpf(), DTO.name());
		
		return student;
	}
	
	public static StudentDTO toDTO(Student student) {
		StudentDTO dto = new StudentDTO(student.getCpf(), student.getName());
		
		return dto;
	}
	
	public static List<StudentDTO> toDTO(List<Student> students){
		List<StudentDTO> dto = students.stream()
									  .map(student -> new StudentDTO(student.getCpf(), student.getName()))
									  .toList();
		
		return dto;
	}
	
	public static BoletimResponse toDTO(Boletim boletim) {
		BoletimResponse dto = new BoletimResponse(boletim.getFirstTest(), boletim.getSecondTest(), boletim.getMedia(), boletim.getStatus());
		
		return dto;
	}
}

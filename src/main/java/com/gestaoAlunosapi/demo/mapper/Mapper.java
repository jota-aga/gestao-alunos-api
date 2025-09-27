package com.gestaoAlunosapi.demo.mapper;

import java.util.List;

import com.gestaoAlunosapi.demo.models.report_card.ReportCard;
import com.gestaoAlunosapi.demo.models.report_card.ReportCardResponse;
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
	
	public static ReportCardResponse toDTO(ReportCard reportCard) {
		ReportCardResponse dto = new ReportCardResponse(reportCard.getFirstTest(), reportCard.getSecondTest(), reportCard.getMedia(), reportCard.getStatus());
		
		return dto;
	}
}

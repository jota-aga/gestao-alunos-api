package com.gestaoAlunosapi.demo.dto;

import com.gestaoAlunosapi.demo.models.Student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class StudentDto {
	private int id;
	@NotBlank(message = "Campo CPf está vazio")
	@Size(min = 11, max = 11, message = "Cpf deve conter 11 dígitos")
	private String cpf;
	
	@NotBlank(message = "Campo nome está vazio")
	@Size(min = 3, message= "Nome inválido")
	private String name;


	public StudentDto(@NotBlank String cpf, @NotBlank String name) {
		
		this.cpf = cpf;
		this.name = name;
	}
	
	public Student cast() {
		Student student = new Student(cpf, name);
		return student;
	}
	
	public Student editStudent(Student student) {
		student.setCpf(this.cpf);
		student.setName(this.name);
		
		return student;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}

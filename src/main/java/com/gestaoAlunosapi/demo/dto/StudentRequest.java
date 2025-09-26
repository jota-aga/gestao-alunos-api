package com.gestaoAlunosapi.demo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record StudentRequest (
	@NotBlank(message = "Campo CPf está vazio")
	@Size(min = 11, max = 11, message = "Cpf deve conter 11 dígitos")
	String cpf,
	
	@NotBlank(message = "Campo nome está vazio")
	@Size(min = 3, message= "Nome inválido")
	String name
	)
{}


package com.gestaoAlunosapi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoAlunosapi.demo.dto.BoletimRequest;
import com.gestaoAlunosapi.demo.enums.StatusEnum;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.models.Boletim;
import com.gestaoAlunosapi.demo.repository.BoletimRepository;

@Service
public class BoletimService {
	@Autowired
	BoletimRepository repo;
	
	public void saveBoletim(Boletim boletim) {
		repo.save(boletim);
	}
	
	public Boletim findBoletimByStudentId(int studentId) {
		Optional<Boletim> boletim = repo.findByStudent_Id(studentId);
		
		return boletim.orElseThrow(() -> new IdNotFoundException("Boletim"));
	}
	
	public Boletim findBoletimById(int id) {
		Optional<Boletim> boletim = repo.findById(id);
		
		return boletim.orElseThrow(() -> new IdNotFoundException("Boletim"));
	}
	
	public Boletim editBoletim(BoletimRequest boletimDTO, Boletim boletim) {
		boletim.setFirstTest(boletimDTO.getFirstTest());
		boletim.setSecondTest(boletimDTO.getSecondTest());
		
		double media = (boletim.getFirstTest() + boletim.getSecondTest()) / 2;
		
		boletim.setMedia(media);
		
		if(media >= 7) {
			boletim.setStatus(StatusEnum.APROVADO);
		}
		else {
			boletim.setStatus(StatusEnum.REPROVADO);
		}
		
		return boletim;
	}
	
}

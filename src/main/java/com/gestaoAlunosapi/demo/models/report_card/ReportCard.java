package com.gestaoAlunosapi.demo.models.report_card;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Transient;

import com.gestaoAlunosapi.demo.enums.Status;
import com.gestaoAlunosapi.demo.models.student.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class ReportCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min = 0, max = 10, message = "Nota deve estar entre 0 e 10")
	@Column
	private BigDecimal firstTest;
	
	@NotNull(message = "Nota não pode ser vazia")
	@Range(min = 0, max = 10, message = "Nota deve estar entre 0 e 10")
	@Column
	private BigDecimal secondTest;
	
	@Transient
	private BigDecimal media;
	
	@Transient
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	
	public ReportCard() {
		super();
	}

	public ReportCard(Student student) {
		this.student = student;
	}

	public BigDecimal getFirstTest() {
		return firstTest;
	}

	public void setFirstTest(BigDecimal firstTest) {
		this.firstTest = firstTest;
	}

	public BigDecimal getSecondTest() {
		return secondTest;
	}

	public void setSecondTest(BigDecimal secondTest) {
		this.secondTest = secondTest;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia() {
		if(firstTest == null || secondTest == null) {
			media = BigDecimal.ZERO;
		}
		else {
			BigDecimal soma = firstTest.add(secondTest);
			
			media = soma.divide(BigDecimal.TWO);
		}
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus() {
		if(firstTest == null || secondTest == null) {
			status = Status.EM_PROCESSO;
		}
		else if(getMedia().compareTo(new BigDecimal(7)) >= 0) {
			status = Status.APROVADO;
		}
		else {
			status = Status.REPROVADO;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}

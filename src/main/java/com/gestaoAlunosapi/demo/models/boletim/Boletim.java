package com.gestaoAlunosapi.demo.models.boletim;

import java.math.BigDecimal;

import com.gestaoAlunosapi.demo.enums.Status;
import com.gestaoAlunosapi.demo.models.student.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Boletim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private BigDecimal firstTest;
	
	@Column
	private BigDecimal secondTest;
	
	@Column
	private BigDecimal media;
	
	@Column
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	
	public Boletim() {
		super();
	}

	public Boletim(Student student) {
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

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

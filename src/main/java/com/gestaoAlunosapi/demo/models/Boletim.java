package com.gestaoAlunosapi.demo.models;

import com.gestaoAlunosapi.demo.enums.StatusEnum;

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
	private double firstTest;
	
	@Column
	private double secondTest;
	
	@Column
	private double media;
	
	@Column
	private StatusEnum status;
	
	@OneToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	
	public Boletim() {
		super();
	}

	public Boletim(Student student) {
		this.student = student;
	}

	public double getFirstTest() {
		return firstTest;
	}

	public void setFirstTest(double firstTest) {
		this.firstTest = firstTest;
	}

	public double getSecondTest() {
		return secondTest;
	}

	public void setSecondTest(double secondTest) {
		this.secondTest = secondTest;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
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

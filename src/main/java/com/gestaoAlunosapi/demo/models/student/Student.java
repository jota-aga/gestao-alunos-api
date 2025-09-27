package com.gestaoAlunosapi.demo.models.student;

import com.gestaoAlunosapi.demo.models.report_card.ReportCard;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String cpf;
	
	@Column
	private String name;
	
	@OneToOne(mappedBy="student", cascade = CascadeType.ALL)
	private ReportCard reportCard;
	
	
	
	public Student(String cpf, String name) {
		this.cpf = cpf;
		this.name = name;
	}


	public Student() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public ReportCard getReportCard() {
		return reportCard;
	}


	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
	}
	
	
}

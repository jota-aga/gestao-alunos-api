package com.gestaoAlunosapi.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoAlunosapi.demo.models.report_card.ReportCard;

public interface ReportCardRepository extends JpaRepository<ReportCard, Integer> {
	Optional<ReportCard> findByStudent_Id(int id);
}

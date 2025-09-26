package com.gestaoAlunosapi.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoAlunosapi.demo.models.student.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByCpf(String cpf);
}

package com.gestaoAlunosapi.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaoAlunosapi.demo.models.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {
	Optional<Boletim> findByStudent_Id(int id);
}

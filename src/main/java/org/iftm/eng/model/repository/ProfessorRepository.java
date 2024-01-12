package org.iftm.eng.model.repository;

import java.util.List;

import org.iftm.eng.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	   public List<Professor> findByNomeContains(String nome);
}

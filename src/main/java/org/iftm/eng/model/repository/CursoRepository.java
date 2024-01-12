package org.iftm.eng.model.repository;

import java.util.List;

import org.iftm.eng.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	   public List<Curso> findByDescricaoContains(String descricao);
}

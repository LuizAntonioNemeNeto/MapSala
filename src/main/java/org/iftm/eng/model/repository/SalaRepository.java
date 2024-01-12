package org.iftm.eng.model.repository;

import java.util.List;

import org.iftm.eng.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

	   public List<Sala> findByNumsalaContains(String numsala);
	}
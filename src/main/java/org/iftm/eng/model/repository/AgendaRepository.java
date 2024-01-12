package org.iftm.eng.model.repository;

import java.util.List;

import org.iftm.eng.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    List<Agenda> findByDiaContains(String dia);
	
}

package org.iftm.eng.controller;

import java.util.List;
import java.util.Optional;

import org.iftm.eng.model.Agenda;
import org.iftm.eng.model.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeAgendaController {
	@Autowired
	private AgendaRepository agendaRepository;


	@GetMapping("/homeAgenda")
	public String home(@RequestParam(value = "dia", required = false) Optional<String> dia, Model model) {
		List<Agenda> agendas;
		if (dia.isPresent()) {
			agendas = agendaRepository.findByDiaContains(dia.get());
		} else {
			agendas = agendaRepository.findAll();
		}
		model.addAttribute("agendas", agendas);
		return "homeAgenda";
	}
}

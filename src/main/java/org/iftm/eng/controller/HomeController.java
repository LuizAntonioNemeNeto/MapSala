package org.iftm.eng.controller;

import java.util.List;
import java.util.Optional;

import org.iftm.eng.model.Sala;
import org.iftm.eng.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	
	@Autowired
	private SalaRepository salaRepository;


	@GetMapping("/home")
	public String home(@RequestParam(value = "numsala", required = false) Optional<String> numsala, Model model) {
		List<Sala> salas;
		if (numsala.isPresent()) {
			salas = salaRepository.findByNumsalaContains(numsala.get());
		} else {
			salas = salaRepository.findAll();
		}
		model.addAttribute("salas", salas);
		return "home";
	}
}

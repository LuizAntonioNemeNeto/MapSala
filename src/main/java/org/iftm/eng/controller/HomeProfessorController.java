package org.iftm.eng.controller;

import java.util.List;
import java.util.Optional;

import org.iftm.eng.model.Professor;
import org.iftm.eng.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeProfessorController {

		@Autowired
		private ProfessorRepository professorRepository;

	
		@GetMapping("/homeDoc")
		public String home(@RequestParam(value = "nome", required = false) Optional<String> nome, Model model) {
			List<Professor> professores;
			if (nome.isPresent()) {
				professores = professorRepository.findByNomeContains(nome.get());
			} else {
				professores = professorRepository.findAll();
			}
			model.addAttribute("professores", professores);
			return "homeDoc";
		}
}

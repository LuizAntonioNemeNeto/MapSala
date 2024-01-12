package org.iftm.eng.controller;

import java.util.List;
import java.util.Optional;

import org.iftm.eng.model.Curso;
import org.iftm.eng.model.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeCursoController {
	@Autowired
	private CursoRepository cursoRepository;


	@GetMapping("/homeCurso")
	public String home(@RequestParam(value = "descricao", required = false) Optional<String> descricao, Model model) {
		List<Curso> cursos;
		if (descricao.isPresent()) {
			cursos = cursoRepository.findByDescricaoContains(descricao.get());
		} else {
			cursos = cursoRepository.findAll();
		}
		model.addAttribute("cursos", cursos);
		return "homeCurso";
	}
}

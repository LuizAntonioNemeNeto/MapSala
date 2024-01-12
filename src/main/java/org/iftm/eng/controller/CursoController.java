package org.iftm.eng.controller;

import java.util.Optional;

import org.iftm.eng.model.Curso;
import org.iftm.eng.model.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CursoController {
	 @Autowired
	    private CursoRepository cursoRepository;

 
	    @GetMapping("/findCurso")
	    public String cursosFind(Model model) {
	    	return "findCursoForm"; 	
	    }
	    
	    
	
	    @GetMapping("/formCurso")
	    public String cursosForm(Curso curso) {    	
	        return "addCursoForm";
	    }

	  
	    @PostMapping("/addCurso")
	    public String novo(Curso curso) {
	        cursoRepository.save(curso);
	        return "redirect:/homeCurso";
	    }

	    
	    @GetMapping("formCurso/{idcurso}")
	    public String updateForm(Model model, @PathVariable int idcurso) {
	    	Optional<Curso> curso = cursoRepository.findById(idcurso);
	    	if (curso.isPresent()) {
	    		model.addAttribute("curso", curso.get());
	    		return "atualizaCursoForm";
	    	}else {
	    		return "redirect:/homeCurso";
	    	}
	    }

	
	    @PostMapping("updateCurso/{idcurso}")
	    public String alterarCurso(Curso curso, @PathVariable int idcurso) {
	        cursoRepository.save(curso);
	        return "redirect:/homeCurso";
	    }

	    @GetMapping("deleteCurso/{idcurso}")
	    public String delete(@PathVariable int idcurso) {  
	    	Optional<Curso> curso = cursoRepository.findById(idcurso);
	    	if (curso.isPresent()) {
	            cursoRepository.delete(curso.get());
	    	}        
	        return "redirect:/homeCurso";
	    }
}

package org.iftm.eng.controller;

import java.util.Optional;

import org.iftm.eng.model.Professor;
import org.iftm.eng.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

  
    @GetMapping("/findDoc")
    public String professorFind(Model model) {
    	return "findDocForm"; 	
    }
    
    

    @GetMapping("/formDoc")
    public String professorForm(Professor professor) {    	
        return "addDocForm";
    }


    @PostMapping("/addDoc")
    public String novo(Professor professor) {
        professorRepository.save(professor);
        return "redirect:/homeDoc";
    }


    @GetMapping("formDoc/{idprofessor}")
    public String updateForm(Model model, @PathVariable int idprofessor) {
    	Optional<Professor> professor = professorRepository.findById(idprofessor);
    	if (professor.isPresent()) {
    		model.addAttribute("professor", professor.get());
    		return "atualizaDocForm";
    	}else {
    		return "redirect:/homeDoc";
    	}
    }


    @PostMapping("updateDoc/{idprofessor}")
    public String alterarProfessor(Professor professor, @PathVariable int idprofessor) {
        professorRepository.save(professor);
        return "redirect:/homeDoc";
    }

    @GetMapping("deleteDoc/{idprofessor}")
    public String delete(@PathVariable int idprofessor) {  
    	Optional<Professor> professor = professorRepository.findById(idprofessor);
    	if (professor.isPresent()) {
            professorRepository.delete(professor.get());
    	}        
        return "redirect:/homeDoc";
    }
}

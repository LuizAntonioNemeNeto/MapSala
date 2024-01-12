package org.iftm.eng.controller;

import java.util.Optional;

import org.iftm.eng.model.Sala;
import org.iftm.eng.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

  
    @GetMapping("/find")
    public String salasFind(Model model) {
    	return "findSalaForm"; 	
    }
    
    

    @GetMapping("/form")
    public String salasForm(Sala sala) {    	
        return "addSalaForm";
    }


    @PostMapping("/add")
    public String novo(Sala sala) {
        salaRepository.save(sala);
        return "redirect:/home";
    }


    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable int id) {
    	Optional<Sala> sala = salaRepository.findById(id);
    	if (sala.isPresent()) {
    		model.addAttribute("sala", sala.get());
    		return "atualizaSalaForm";
    	}else {
    		return "redirect:/home";
    	}
    }


    @PostMapping("update/{id}")
    public String alterarProduto(Sala sala, @PathVariable int id) {
        salaRepository.save(sala);
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {  
    	Optional<Sala> sala = salaRepository.findById(id);
    	if (sala.isPresent()) {
            salaRepository.delete(sala.get());
    	}        
        return "redirect:/home";
    }
}

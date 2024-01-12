package org.iftm.eng.controller;

import java.util.Optional;

import org.iftm.eng.model.Agenda;
import org.iftm.eng.model.repository.AgendaRepository;
import org.iftm.eng.model.repository.CursoRepository;
import org.iftm.eng.model.repository.ProfessorRepository;
import org.iftm.eng.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendaController {
	@Autowired
    private AgendaRepository agendaRepository;
	@Autowired
    private ProfessorRepository professorRepository;
	@Autowired
    private SalaRepository salaRepository;
	@Autowired
    private CursoRepository cursoRepository;


    @GetMapping("/findAgenda")
    public String agendaFind(Model model) {
    	return "findAgendaForm"; 	
    }
    
    

    @GetMapping("/formAgenda")
    public String agendaForm(Agenda agenda) {    	
        return "addAgendaForm";
    }

  
    @PostMapping("/addAgenda")
    public String novo(Agenda agenda) {        
        agenda.setProfessor(professorRepository.findByNomeContains(agenda.getProfessor().getNome()).get(0));
        agenda.setSala(salaRepository.findByNumsalaContains(agenda.getSala().getNumsala()).get(0));
        agenda.setCurso(cursoRepository.findByDescricaoContains(agenda.getCurso().getDescricao()).get(0));
        agendaRepository.save(agenda);
        return "redirect:/homeAgenda";
    }

    
    @GetMapping("formAgenda/{idagenda}")
    public String updateForm(Model model, @PathVariable int idagenda) {
    	Optional<Agenda> agenda = agendaRepository.findById(idagenda);
    	if (agenda.isPresent()) {
    		model.addAttribute("agenda", agenda.get());
    		return "atualizaAgendaForm";
    	}else {
    		return "redirect:/homeAgenda";
    	}
    }


    @PostMapping("updateAgenda/{idagenda}")
    public String alterarAgenda(Agenda agenda, @PathVariable int idagenda) {
        agendaRepository.save(agenda);
        return "redirect:/homeAgenda";
    }

    @GetMapping("deleteAgenda/{idagenda}")
    public String delete(@PathVariable int idagenda) {  
    	Optional<Agenda> agenda = agendaRepository.findById(idagenda);
    	if (agenda.isPresent()) {
            agendaRepository.delete(agenda.get());
    	}        
        return "redirect:/homeAgenda";
    }
}

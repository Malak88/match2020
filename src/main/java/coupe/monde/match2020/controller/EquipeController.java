package coupe.monde.match2020.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupe.monde.match2020.entities.Equipe;
import coupe.monde.match2020.repository.EquipeRepository;
import coupe.monde.match2020.service.EquipeService;


@RestController
@RequestMapping("/api")
public class EquipeController {
	
	@Autowired 
	EquipeService eqs;
	
	@Autowired 
	EquipeRepository e;
	
	@GetMapping("/equipes")
	public List<Equipe> getAllEquipe() {
		List<Equipe> pro = eqs.getAllEquipe();
	
        return pro;
	    
	}
	
	@PostMapping("/addequipe")
	public Equipe createEquipe(@Valid @RequestBody Equipe equi) {
	    return eqs.saveEquipe(equi);
	}

	@PutMapping("/putequipe/{id}")
	public Equipe editEquipe(Equipe newEquipe, @PathVariable Long id) {
		return eqs.editEquipe(id, newEquipe);
		
	}
	@DeleteMapping("/deleteequipe/{id}")
	public void deleteequipe(@PathVariable Long id) {
		eqs.deleteequipe(id);
	}
}

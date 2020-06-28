package coupe.monde.match2020.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/test")
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
	
	@GetMapping("/equipes/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Equipe getEquipeById(@PathVariable(value = "id") Long Id) {
	    return eqs.getEquipeById(Id);
	}
	
	@PostMapping("/addEquipe")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Equipe createEquipe(@Valid @RequestBody Equipe equi) {
	    return eqs.saveEquipe(equi);
	}

	@PutMapping("/editEquipe/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Equipe editEquipe( @PathVariable(value = "id") Long id,
			@Valid @RequestBody Equipe newEquipe) {
		return eqs.editEquipe(id, newEquipe);
		
	}
	@DeleteMapping("/deleteEquipe/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public void deleteequipe(@PathVariable Long id) {
		eqs.deleteequipe(id);
	}
}

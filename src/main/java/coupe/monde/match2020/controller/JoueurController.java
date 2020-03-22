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
import coupe.monde.match2020.entities.Joueur;
import coupe.monde.match2020.repository.EquipeRepository;
import coupe.monde.match2020.repository.JoueurRepository;
import coupe.monde.match2020.service.JoueurService;

@RestController
@RequestMapping("/api")
public class JoueurController {
	
	@Autowired 
	JoueurService eqs;
	JoueurRepository jo;
	EquipeRepository e;
	
	@GetMapping("/joueurs")
	public List<Joueur> getAllJoueur() {
		List<Joueur> pro = eqs.getAllJoueur();
        return pro;
	    
	}
	
	@GetMapping("/user/{id}")
	public Joueur getJoueurById(@PathVariable(value = "id") Long Id) {
	    return jo.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	@PostMapping("/addjoueur")
	public Joueur createJoueur(@Valid @RequestBody Joueur joueur) {
	    return eqs.createJoueur(joueur);
	}

	@PutMapping("/putjoueur/{id}")
	public Joueur editJoueur(@Valid @RequestBody Joueur newJoueur, @PathVariable Long id) {
		return eqs.editJoueur(newJoueur, id);
		
	}
	
	@PutMapping("/affecterArt/{uid}/{pid}")
	public void affecterArt(@PathVariable("uid") Long Id,
			@PathVariable("pid") Long Idp) {
		
		   Joueur jou = jo.findById(Id).get();
		   Equipe equ=e.findById(Idp).get();
		     
		   jou.setEquipe(equ);
		 
		   jo.save(jou);
	
	}
	
	@DeleteMapping("/deletejoueur/{id}")
	public void deletejoueur(@PathVariable Long id) {
		eqs.deletejoueur(id);
	}

}

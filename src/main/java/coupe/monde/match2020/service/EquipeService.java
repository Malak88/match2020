package coupe.monde.match2020.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import coupe.monde.match2020.entities.Equipe;
import coupe.monde.match2020.repository.EquipeRepository;

@Service
public class EquipeService{
	
	@Autowired 
	EquipeRepository eqs;
	
	public List<Equipe> getAllEquipe() {
		
		List<Equipe> pro = eqs.findAll();
        return pro;   
	}
	
   public Equipe getEquipeById(Long Id) {
		
	    return eqs.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	public Equipe saveEquipe(Equipe equipe) {
		
	    return eqs.save(equipe);
	}
	
	public Equipe editEquipe( Long Id,Equipe equipeDetails) {
		
		   Equipe equipe = eqs.findById(Id).orElseThrow(null);
		    
		    equipe.setName(equipeDetails.getName());
		    equipe.setCountry(equipeDetails.getCountry());
		    equipe.setJoueur(equipeDetails.getJoueur());
		    equipe.setMatches(equipeDetails.getMatches());
		    equipe.setStaff(equipeDetails.getStaff());
		   
           Equipe editEquipe=eqs.save(equipeDetails);
           
           return editEquipe;
           
	}
	public void deleteequipe(@PathVariable Long id) {
		eqs.deleteById(id);
	}
}

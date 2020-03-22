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
	
	public Equipe saveEquipe(Equipe equipe) {
		
	    return eqs.save(equipe);
	}
	
	public Equipe editEquipe(Equipe newEquipe, @PathVariable Long id) {
		
		return eqs.findById(id).map(equipe -> {
			equipe.setId(newEquipe.getId());
			equipe.setJoueur(newEquipe.getJoueur());
            equipe.setStaff(newEquipe.getStaff());
            equipe.setEname(newEquipe.getEname());
            return eqs.save(equipe);
        }).orElseGet(() -> {
            newEquipe.setId(id);
            return eqs.save(newEquipe);
        });
		
	}
	public void deleteequipe(@PathVariable Long id) {
		eqs.deleteById(id);
	}
}

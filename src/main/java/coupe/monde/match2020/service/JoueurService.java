package coupe.monde.match2020.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import coupe.monde.match2020.entities.Joueur;
import coupe.monde.match2020.repository.JoueurRepository;


@Service
public class JoueurService {

	@Autowired 
	JoueurRepository eqs;
	public List<Joueur> getAllJoueur() {
		List<Joueur> pro = eqs.findAll();

        return pro;
	    
	}
	public Joueur createJoueur(Joueur joueur) {
	    return eqs.save(joueur);
	}
	
	public Joueur editJoueur(Joueur newJoueur, @PathVariable Long id) {
		return eqs.findById(id).map(joueur-> {
			joueur.setId(newJoueur.getId());
			
			joueur.setName(newJoueur.getName());
			joueur.setLname(newJoueur.getLname());
			joueur.setTelephone(newJoueur.getTelephone());
			joueur.setEmail(newJoueur.getEmail());
			joueur.setEquipe(newJoueur.getEquipe());
			
            return eqs.save(joueur);
        }).orElseGet(() -> {
            newJoueur.setId(id);
            return eqs.save(newJoueur);
        });
		
	}
	public void deletejoueur(@PathVariable Long id) {
		eqs.deleteById(id);
	}
}

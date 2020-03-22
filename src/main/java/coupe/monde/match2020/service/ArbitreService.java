package coupe.monde.match2020.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coupe.monde.match2020.entities.Arbitre;
import coupe.monde.match2020.entities.Matches;
import coupe.monde.match2020.repository.arbitreRepository;
import coupe.monde.match2020.repository.matchesRepository;

@Service
public class ArbitreService {/*implements IarbitreService si on utile interface*/
	
	@Autowired
	arbitreRepository arepos;
	
	@Autowired
	matchesRepository mrepos;
	
	//@Override si on utilise Interface + import
	public List<Arbitre> findAllArbitres() {
		// TODO Auto-generated method stub
		return arepos.findAll();
	}
   
	public Arbitre saveArbitre(Arbitre arbitre) {
		// TODO Auto-generated method stub
		return arepos.save(arbitre);
	}

  
	public Arbitre editArbitre(Long Id, Arbitre arbitreDetails) {

	    Arbitre arbitre = arepos.findById(Id).orElseThrow(null);
	    
	    arbitre.setName(arbitreDetails.getName());
	    arbitre.setTelephone(arbitreDetails.getTelephone());
	    arbitre.setEmail(arbitreDetails.getEmail());
	   
	    Arbitre editarbitre = arepos.save(arbitre);
	    return editarbitre;
	}
   
  
   public void affecterArbitre( Long Id,Long Ida) {
	   
		   Arbitre arb = arepos.findById(Id).get();
		   Matches match=mrepos.findById(Ida).get();
		  
		   arb.setMatches(match);
		
		  arepos.save(arb);
	}
   
   
   
   public ResponseEntity<?> deleteArbitre(Long arbitreId) {
		
	    Arbitre arbitre = arepos.findById(arbitreId).orElseThrow(null);
	   //.orElseThrow(() -> new ResourceNotFoundException("arbitre", "id", arbitreId));

	   // arbitreRepository.deleteById(arbitreId);
	    arepos.delete(arbitre);

	    return ResponseEntity.ok().build();
	}
   
   /*@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long Id) {
	    return userv.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}*/
   
   /*@PutMapping("/affecter/{uid}/{pid}")
	public void affecterUser(@PathVariable(value = "uid") Long Id,
			@PathVariable(value = "pid") Long Idp,@Valid  Project pro) {

	    
	   List<User> list=new ArrayList<>();
		   User user = userv.findById(Id).get();
		   Project proj=pserv.findById(Idp).get();
		   list.add(user);
		   proj.setUsers(list);
		  //User affecterUser= 
		   pserv.save(proj);
		//return affecterUser;
	

	}*/
}

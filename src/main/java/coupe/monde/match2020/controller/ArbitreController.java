package coupe.monde.match2020.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import coupe.monde.match2020.entities.Arbitre;
import coupe.monde.match2020.service.ArbitreService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/test")
public class ArbitreController {
	
	@Autowired 
	ArbitreService aserv;
	
	@GetMapping("/arbitres")
	public List<Arbitre> getAllArbitre() {
		
		List<Arbitre> arb = aserv.findAllArbitres();
		return arb;
	    
	}
	
	@GetMapping("/arbitres/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Arbitre getArbitreById(@PathVariable(value = "id") Long Id) {
	    return aserv.getArbitreById(Id);
	}
	
	@PostMapping("/addArbitre")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Arbitre createArbitre(@Valid @RequestBody Arbitre arb) {
	    return aserv.saveArbitre(arb);
	}
	
	@PutMapping("/editArbitre/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public Arbitre editArbitre(@PathVariable(value = "id") Long Id,
			@Valid @RequestBody Arbitre arbitreDetails) {
		
		return aserv.editArbitre(Id, arbitreDetails);
	}
	
	@PutMapping("/affecterArbitre/{aid}/{mid}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public void affecterArbitre(@PathVariable("aid") Long Id,
			@PathVariable("mid") Long Ida) {
		
		aserv.affecterArbitre(Id, Ida);
		
	}
	
	
	@DeleteMapping("/deleteArbitre/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<?> deleteArbitre(@PathVariable(value = "id") Long arbitreId) {
		
	   return  aserv.deleteArbitre(arbitreId);
	    
	}
	
}

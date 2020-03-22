package coupe.monde.match2020.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupe.monde.match2020.entities.Matches;
import coupe.monde.match2020.service.MatchesService;

@RestController
@RequestMapping("/api")
public class MatchesController {

	@Autowired
	MatchesService mserv;
	
	@GetMapping("/matches")
	public List<Matches> getAllMatches() {
		
		List<Matches> mat = mserv.findAllMatches();

        return mat;   
	}
	@GetMapping("/matches/{id}")
	public Matches getMatches(@PathVariable(value = "id") Long Id) {
		
		Matches mat = mserv.findMatchesById(Id);

        return mat;   
	}
	
	@PostMapping("/addMatches")
	public Matches createMatch(@Valid @RequestBody Matches mat) {
	    return mserv.saveMatches(mat);
	}
	
	@PutMapping("/editMatches/{id}")
	public Matches editMatches(@PathVariable(value = "id") Long Id,
			@Valid @RequestBody Matches matchesDetails) {
		
		return mserv.editMatches(Id, matchesDetails);
	}
	
	@DeleteMapping("/deleteMatches/{id}")
	public ResponseEntity<?> deleteMatches(@PathVariable(value = "id") Long MatchesId) {
		
	    return mserv.deleteMatches(MatchesId);
	}
	
	

}

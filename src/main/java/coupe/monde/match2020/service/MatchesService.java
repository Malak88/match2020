package coupe.monde.match2020.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coupe.monde.match2020.entities.Matches;

import coupe.monde.match2020.repository.matchesRepository;

@Service
public class MatchesService {
	
	@Autowired
	matchesRepository mrepos;

	public List<Matches> findAllMatches() {
		// TODO Auto-generated method stub
		return mrepos.findAll();
	}
	
	public Matches saveMatches(Matches matches) {
		// TODO Auto-generated method stub
		return mrepos.save(matches);
	}
	
	public Matches findMatchesById(Long Id) {
		
	    return mrepos.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	/*public Matches findMatchesByName(String name) {
		
	    return mrepos.
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}*/
	
	public Matches editMatches(Long Id, Matches MatchesDetails) {

	    Matches matches = findMatchesById(Id);
	    
	    matches.setName(MatchesDetails.getName());
	    matches.setDate(MatchesDetails.getDate());
	    matches.setEquipes(MatchesDetails.getEquipes());
	    matches.setStade(MatchesDetails.getStade());
	   
	    Matches editMatches = mrepos.save(matches);
	    return editMatches;
	}
	
	public ResponseEntity<?> deleteMatches(Long MatchesId) {
		
	    Matches matches = mrepos.findById(MatchesId).orElseThrow(null);
	   //.orElseThrow(() -> new ResourceNotFoundException("Matches", "id", MatchesId));

	   // MatchesRepository.deleteById(MatchesId);
	    mrepos.delete(matches);

	    return ResponseEntity.ok().build();
	}
	
	

}

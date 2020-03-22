package coupe.monde.match2020.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import coupe.monde.match2020.entities.Staff;
import coupe.monde.match2020.service.StaffService;

@RestController

public class StaffController {
	
	@Autowired 
	StaffService eqs;
	
	@GetMapping("/staffs")
	public List<Staff> getAllStaff() {
		List<Staff> pro = eqs.getAllStaff();
        return pro;
	    
	}
	
	@PostMapping("/addstaff")
	public Staff createStaff(Staff staff) {
	    return eqs.createStaff(staff);
	}

	@PutMapping("/putstaff/{id}")
	public Staff editStaff(Staff newStaff, @PathVariable Long id) {
		return eqs.editStaff(newStaff, id);
		
	}
	@DeleteMapping("/deletestaff/{id}")
	public void deletestaff(@PathVariable Long id) {
		eqs.deletestaff(id);
	}
	

}

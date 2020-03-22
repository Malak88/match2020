package coupe.monde.match2020.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import coupe.monde.match2020.entities.Staff;
import coupe.monde.match2020.repository.StaffRepository;;

@Service
public class StaffService {

	@Autowired 
	StaffRepository eqs;
	public List<Staff> getAllStaff() {
		List<Staff> pro = eqs.findAll();

        return pro;
	    
	}
	public Staff createStaff(Staff staff) {
	    return eqs.save(staff);
	}
	
	public Staff editStaff(Staff newStaff, @PathVariable Long id) {
		return eqs.findById(id).map(staff-> {
			staff.setId(newStaff.getId());
			staff.setEquipe(newStaff.getEquipe());
			staff.setFname(newStaff.getFname());
			staff.setLname(newStaff.getLname());
            return eqs.save(staff);
        }).orElseGet(() -> {
            newStaff.setId(id);
            return eqs.save(newStaff);
        });
		
	}
	public void deletestaff(@PathVariable Long id) {
		eqs.deleteById(id);
	}

}

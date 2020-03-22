package coupe.monde.match2020.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="equipeid")
	private Long id;
	private String ename;
	
	@OneToMany(mappedBy="equipe",cascade = CascadeType.ALL)
	private Set<Joueur> joueur;
	
	@OneToMany(mappedBy="equipe",cascade = CascadeType.ALL)
	private Set<Staff> staff;
	
	@JsonIgnore
	@ManyToOne
	private Matches matches;
	
	public Equipe(Long id, String name, Set<Joueur> joueur,Set<Staff> staff, Matches matches) {
		super();
		this.id = id;
		this.ename = name;
		this.joueur = joueur;
		this.staff=staff;
		this.matches= matches;
	}
	public Equipe() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String name) {
		this.ename = name;
	}
	public Set<Joueur> getJoueur() {
		return joueur;
	}
	public void setJoueur(Set<Joueur> joueur) {
		this.joueur = joueur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Set<Staff> getStaff() {
		return staff;
	}
	public void setStaff(Set<Staff> joueur1) {
		this.staff = joueur1;
	}
	
	public Matches getMatches() {
		return matches;
	}
	public void setMatches(Matches matches) {
		this.matches = matches;
	}
	
	

}

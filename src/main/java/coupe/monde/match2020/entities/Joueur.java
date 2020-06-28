package coupe.monde.match2020.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Joueur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="joueurid")
	private Long id;
	private String name;
	private String lname;
	private Long telephone;
	private String email;
	
	@JsonIgnore
	@ManyToOne
    private Equipe equipe;

	public Joueur(Long id, String name, String lname, Equipe equipe) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.equipe = equipe;
	}

	public Joueur() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String fname) {
		this.name = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + lname + ", fname" + name 
				+",telephone"+telephone+",Email"+email+", equipe=" + equipe + "]";
	}



}

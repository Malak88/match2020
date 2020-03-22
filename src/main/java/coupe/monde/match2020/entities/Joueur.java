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
	private String fname;
	private String lname;
	
	@JsonIgnore
	@ManyToOne
    private Equipe equipe;

	public Joueur(Long id, String fname, String lname, Equipe equipe) {
		super();
		this.id = id;
		this.fname = fname;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + lname + ", fname" + fname + ", equipe=" + equipe + "]";
	}

}

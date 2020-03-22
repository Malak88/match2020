package coupe.monde.match2020.entities;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Matches implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="matchId")
	private Long id;
	private String name;
	private Date date;
	private String  stade; 
	
	/*@OneToMany(mappedBy="matches",cascade = CascadeType.ALL)
	private Set<Spectateur> spectateurs;*/
	
	@OneToMany(mappedBy="matches",cascade = CascadeType.ALL)
	private Set<Arbitre> arbitres;
	
	@OneToMany(mappedBy="matches",cascade = CascadeType.ALL)
	private Set<Equipe> equipes;

	/**
	 * 
	 */
	

	public Matches() {
		super();
	}

	public Matches(Long id, String name, Date date, String stade,
			Set<Arbitre> arbitres,Set<Equipe> equipes) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.stade = stade;
		//this.spectateurs = spectateurs;
		this.arbitres = arbitres;
		this.equipes =equipes;
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

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}


	/*public Set<Spectateur> getSpectateurs() {
		return spectateurs;
	}

	public void setSpectateurs(Set<Spectateur> spectateurs) {
		this.spectateurs = spectateurs;
	}*/

	public Set<Arbitre> getArbitres() {
		return arbitres;
	}

	public void setArbitres(Set<Arbitre> arbitres) {
		this.arbitres = arbitres;
	}
	
	public Set<Equipe> getEquipes() {
		return equipes;
	}
	
	
	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	
	

}

package com.speedcovoit.model;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Trajet.findAll", query="SELECT t FROM Trajet t")
public class Trajet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long idTrajet;
	
	@OneToOne
	private Position depart;
	
	@OneToOne
	private Position arrivee;
	
	@OneToMany
	private ArrayList<Position> points;
	
	@ManyToMany
	private ArrayList<User> passagers;
	
	@OneToOne
	private User conducteur;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToOne
	private Voiture voiture;
	
	public Trajet() {
		this.passagers = new ArrayList<User>();
	}
	
	public long getId() {
		return idTrajet;
	}

	public void setId(long id) {
		this.idTrajet = id;
	}

	public Position getDepart() {
		return depart;
	}

	public void setDepart(Position depart) {
		this.depart = depart;
	}

	public Position getArrivee() {
		return arrivee;
	}

	public void setArrivee(Position arrivee) {
		this.arrivee = arrivee;
	}

	public ArrayList<User> getPassagers() {
		return passagers;
	}

	public void setPassagers(ArrayList<User> passagers) {
		this.passagers = passagers;
	}

	public User getConducteur() {
		return conducteur;
	}

	public void setConducteur(User conducteur) {
		this.conducteur = conducteur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}

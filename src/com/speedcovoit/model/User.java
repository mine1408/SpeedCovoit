package com.speedcovoit.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String mdp;
	
	@OneToOne(mappedBy="user")
	private Position position;
	
	private ArrayList<String> centresInterets;
	
	private ArrayList<String> preferences;
	
	public User() {
		this.centresInterets = new ArrayList<String>();
		this.preferences = new ArrayList<String>();
	}
	
	public User(long id, String nom, String prenom, String email, String mdp, Position position, ArrayList<String> centresInterets, ArrayList<String> preferences) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.position = position;
		this.centresInterets = centresInterets;
		this.preferences = preferences;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public ArrayList<String> getCentresInterets() {
		return centresInterets;
	}

	public void setCentresInterets(ArrayList<String> centresInterets) {
		this.centresInterets = centresInterets;
	}

	public ArrayList<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	
	public long addOneToId() {
		return this.id += 1;
	}

}
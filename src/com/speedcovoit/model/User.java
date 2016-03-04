package com.speedcovoit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUser;
	
	private String email;
	
	private String mdp;

	//OK
	@OneToOne
	private Position position;
	
	private Collection<String> centresInteret;
	
	private Collection<String> preferences;
	
	public User() {
		this.centresInteret = new ArrayList<String>();
		this.preferences = new ArrayList<String>();
	}
	
	public User(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
		this.centresInteret = new ArrayList<String>();
		this.preferences = new ArrayList<String>();
	}

	public long getId() {
		return idUser;
	}

	public void setId(long id) {
		this.idUser = id;
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

	public Collection<String> getCentresInterets() {
		return centresInteret;
	}

	public void setCentresInterets(Collection<String> centresInterets) {
		this.centresInteret = centresInterets;
	}

	public Collection<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(Collection<String> preferences) {
		this.preferences = preferences;
	}
	
	public long addOneToId() {
		return this.idUser += 1;
	}

}
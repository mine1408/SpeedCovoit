package com.speedcovoit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	private float latitute;
	
	private float longitude;
	
	private String nom;
	
	@OneToOne
	@JoinColumn(name="position")
	private User user;
	
	public Position() {
	}

	public float getLatitute() {
		return latitute;
	}

	public void setLatitute(float latitute) {
		this.latitute = latitute;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

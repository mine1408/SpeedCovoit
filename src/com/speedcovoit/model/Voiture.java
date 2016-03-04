package com.speedcovoit.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Voiture")
//@NamedQuery(name="Voiture.findAll", query="SELECT v FROM Voiture v")
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idVoiture;
	
	private int nbPlaces;
	
	private String modele;
	
	private int annee;
	
	public Voiture() {
	}

	public long getId() {
		return idVoiture;
	}

	public void setId(long id) {
		this.idVoiture = id;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
}
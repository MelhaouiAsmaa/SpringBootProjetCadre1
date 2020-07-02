package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class JourFerie {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ferie")
	private Long idJourFerie;
	
	@Column
	private String libelleJourFerie;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dateFin;

	public JourFerie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JourFerie(Long idJourFerie, String libelleJourFerie, Date dateDebut, Date dateFin) {
		super();
		this.idJourFerie = idJourFerie;
		this.libelleJourFerie = libelleJourFerie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdJourFerie() {
		return idJourFerie;
	}

	public void setIdJourFerie(Long idJourFerie) {
		this.idJourFerie = idJourFerie;
	}

	public String getLibelleJourFerie() {
		return libelleJourFerie;
	}

	public void setLibelleJourFerie(String libelleJourFerie) {
		this.libelleJourFerie = libelleJourFerie;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "JourFerie [idJourFerie=" + idJourFerie + ", libelleJourFerie=" + libelleJourFerie + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
}

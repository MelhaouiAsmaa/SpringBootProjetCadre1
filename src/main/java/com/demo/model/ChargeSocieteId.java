package com.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ChargeSocieteId implements Serializable {
	@Column 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datedebut;
	@ManyToOne 
	@JoinColumn(name="id_charge")
	private Charge charge;
	@ManyToOne 
	@JoinColumn(name="idsociete")
	private Societe societe;
	public ChargeSocieteId()
	{
		
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Charge getCharge() {
		return charge;
	}
	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charge == null) ? 0 : charge.hashCode());
		result = prime * result + ((datedebut == null) ? 0 : datedebut.hashCode());
		result = prime * result + ((societe == null) ? 0 : societe.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargeSocieteId other = (ChargeSocieteId) obj;
		if (charge == null) {
			if (other.charge != null)
				return false;
		} else if (!charge.equals(other.charge))
			return false;
		if (datedebut == null) {
			if (other.datedebut != null)
				return false;
		} else if (!datedebut.equals(other.datedebut))
			return false;
		if (societe == null) {
			if (other.societe != null)
				return false;
		} else if (!societe.equals(other.societe))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChargeSocieteId [datedebut=" + datedebut + ", charge=" + charge + ", societe=" + societe + "]";
	}

	
	
}

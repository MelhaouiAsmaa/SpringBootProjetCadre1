package com.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ChargeDepartement implements Serializable{

	@Id 
	private ChargeDepartementId pk_chargedep;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date Date_Fin;
	
	@Column
	private Float montant;
	
@Column 
private Boolean archive;
	
public ChargeDepartement()
{}

public ChargeDepartement(ChargeDepartementId pk_chargedep, Date date_Fin, Float montant, Boolean archive) {
	super();
	this.pk_chargedep = pk_chargedep;
	Date_Fin = date_Fin;
	this.montant = montant;
	this.archive = archive;
}

public ChargeDepartementId getPk_chargedep() {
	return pk_chargedep;
}

public void setPk_chargedep(ChargeDepartementId pk_chargedep) {
	this.pk_chargedep = pk_chargedep;
}

public Date getDate_Fin() {
	return Date_Fin;
}

public void setDate_Fin(Date date_Fin) {
	Date_Fin = date_Fin;
}

public Float getMontant() {
	return montant;
}

public void setMontant(Float montant) {
	this.montant = montant;
}

public Boolean getArchive() {
	return archive;
}

public void setArchive(Boolean archive) {
	this.archive = archive;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Date_Fin == null) ? 0 : Date_Fin.hashCode());
	result = prime * result + ((archive == null) ? 0 : archive.hashCode());
	result = prime * result + ((montant == null) ? 0 : montant.hashCode());
	result = prime * result + ((pk_chargedep == null) ? 0 : pk_chargedep.hashCode());
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
	ChargeDepartement other = (ChargeDepartement) obj;
	if (Date_Fin == null) {
		if (other.Date_Fin != null)
			return false;
	} else if (!Date_Fin.equals(other.Date_Fin))
		return false;
	if (archive == null) {
		if (other.archive != null)
			return false;
	} else if (!archive.equals(other.archive))
		return false;
	if (montant == null) {
		if (other.montant != null)
			return false;
	} else if (!montant.equals(other.montant))
		return false;
	if (pk_chargedep == null) {
		if (other.pk_chargedep != null)
			return false;
	} else if (!pk_chargedep.equals(other.pk_chargedep))
		return false;
	return true;
}

//@Override
//public String toString() {
//	return "ChargeDepartement [pk_chargedep=" + pk_chargedep.toString() + ", Date_Fin=" + Date_Fin + ", montant=" + montant
//			+ ", archive=" + archive + "]";
//}

	
}

package com.demo.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class ChargeSociete implements Serializable {
	@Id 
	private ChargeSocieteId pkchargesociete;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_fin;
	@Column 
	private Float montant;
	@Column 
	private Boolean archive;
	public ChargeSociete()
	{}
	
	public ChargeSociete(ChargeSocieteId pkchargesociete, Date date_fin, Float montant, Boolean archive) {
		super();
		this.pkchargesociete = pkchargesociete;
		this.date_fin = date_fin;
		this.montant = montant;
		this.archive = archive;
	}

	public ChargeSocieteId getPkchargesociete() {
		return pkchargesociete;
	}
	public void setPkchargesociete(ChargeSocieteId pkchargesociete) {
		this.pkchargesociete = pkchargesociete;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
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
		result = prime * result + ((archive == null) ? 0 : archive.hashCode());
		result = prime * result + ((date_fin == null) ? 0 : date_fin.hashCode());
		result = prime * result + ((montant == null) ? 0 : montant.hashCode());
		result = prime * result + ((pkchargesociete == null) ? 0 : pkchargesociete.hashCode());
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
		ChargeSociete other = (ChargeSociete) obj;
		if (archive == null) {
			if (other.archive != null)
				return false;
		} else if (!archive.equals(other.archive))
			return false;
		if (date_fin == null) {
			if (other.date_fin != null)
				return false;
		} else if (!date_fin.equals(other.date_fin))
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		if (pkchargesociete == null) {
			if (other.pkchargesociete != null)
				return false;
		} else if (!pkchargesociete.equals(other.pkchargesociete))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChargeSociete [pkchargesociete=" + pkchargesociete + ", date_fin=" + date_fin + ", montant=" + montant
				+ ", archive=" + archive + "]";
	}
	
	

}

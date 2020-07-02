package com.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ChargeDepartementId implements Serializable {

	@Column 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_Debut;
	@ManyToOne 
	@JoinColumn(name="id_charges")
	private Charge charge;
	@ManyToOne
	@JoinColumn(name="iddepartement")
	private Departement departement;
	
	public Date getDate_Debut() {
		return date_Debut;
	}
	public void setDate_Debut(Date date_Debut) {
		this.date_Debut = date_Debut;
	}
	public Charge getCharge() {
		return charge;
	}
	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charge == null) ? 0 : charge.hashCode());
		result = prime * result + ((date_Debut == null) ? 0 : date_Debut.hashCode());
		result = prime * result + ((departement == null) ? 0 : departement.hashCode());
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
		ChargeDepartementId other = (ChargeDepartementId) obj;
		if (charge == null) {
			if (other.charge != null)
				return false;
		} else if (!charge.equals(other.charge))
			return false;
		if (date_Debut == null) {
			if (other.date_Debut != null)
				return false;
		} else if (!date_Debut.equals(other.date_Debut))
			return false;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		return true;
	}
//	@Override
//	public String toString() {
//		return "ChargeDepartementId [date_Debut=" + date_Debut + ", charge=" + charge.toString() + ", departement=" + departement.toString()
//				+ "]";
//	}
	
	
}

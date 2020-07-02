package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pointage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_pointage;
	@Column 
	private int mois;
	@Column 
	private int annee;
	@Column 
	private Boolean archive;
	

	@ManyToOne
	@JoinColumn(name="matricule")
	private Employee employee;
	public Pointage()
	{}
	public Pointage(int id_pointage, int mois, int annee, Boolean archive, Employee employee) {
		super();
		this.id_pointage = id_pointage;
		this.mois = mois;
		this.annee = annee;
		this.archive = archive;
		this.employee = employee;
	}
	public int getId_pointage() {
		return id_pointage;
	}
	public void setId_pointage(int id_pointage) {
		this.id_pointage = id_pointage;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((archive == null) ? 0 : archive.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id_pointage;
		result = prime * result + mois;
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
		Pointage other = (Pointage) obj;
		if (annee != other.annee)
			return false;
		if (archive == null) {
			if (other.archive != null)
				return false;
		} else if (!archive.equals(other.archive))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id_pointage != other.id_pointage)
			return false;
		if (mois != other.mois)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pointage [id_pointage=" + id_pointage + ", mois=" + mois + ", annee=" + annee + ", archive=" + archive
				+ ", employee=" + employee + "]";
	}
	
	
}

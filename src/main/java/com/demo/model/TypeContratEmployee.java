package com.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TypeContratEmployee  {
	
	
	@Id 
	private TypeContratEmployeeId pkContrat;
	
	@Column 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_Debut;
	@Column(columnDefinition = "Date default '2100/01/01'")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_Fin;
	@Column 
	private Float Salaire_initial;
	@Column(columnDefinition = "char(30) default 'Pas de Motif'")
	private String motif;
	@Column
	private Boolean archive;
	public TypeContratEmployee()
	{}
	public TypeContratEmployee(TypeContratEmployeeId pkContrat, Date date_Debut, Date date_Fin, Float salaire_initial,
			String motif, Boolean archive) {
		super();
		this.pkContrat = pkContrat;
		this.date_Debut = date_Debut;
		this.date_Fin = date_Fin;
		Salaire_initial = salaire_initial;
		this.motif = motif;
		this.archive = archive;
	}
	public TypeContratEmployeeId getPkContrat() {
		return pkContrat;
	}
	public void setPkContrat(TypeContratEmployeeId pkContrat) {
		this.pkContrat = pkContrat;
	}
	public Date getDate_Debut() {
		return date_Debut;
	}
	public void setDate_Debut(Date date_Debut) {
		this.date_Debut = date_Debut;
	}
	public Date getDate_Fin() {
		return date_Fin;
	}
	public void setDate_Fin(Date date_Fin) { 
		this.date_Fin = date_Fin;
	}
	public Float getSalaire_initial() {
		return Salaire_initial;
	}
	public void setSalaire_initial(Float salaire_initial) {
		Salaire_initial = salaire_initial;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
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
		result = prime * result + ((Salaire_initial == null) ? 0 : Salaire_initial.hashCode());
		result = prime * result + ((archive == null) ? 0 : archive.hashCode());
		result = prime * result + ((date_Debut == null) ? 0 : date_Debut.hashCode());
		result = prime * result + ((date_Fin == null) ? 0 : date_Fin.hashCode());
		result = prime * result + ((motif == null) ? 0 : motif.hashCode());
		result = prime * result + ((pkContrat == null) ? 0 : pkContrat.hashCode());
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
		TypeContratEmployee other = (TypeContratEmployee) obj;
		if (Salaire_initial == null) {
			if (other.Salaire_initial != null)
				return false;
		} else if (!Salaire_initial.equals(other.Salaire_initial))
			return false;
		if (archive == null) {
			if (other.archive != null)
				return false;
		} else if (!archive.equals(other.archive))
			return false;
		if (date_Debut == null) {
			if (other.date_Debut != null)
				return false;
		} else if (!date_Debut.equals(other.date_Debut))
			return false;
		if (date_Fin == null) {
			if (other.date_Fin != null)
				return false;
		} else if (!date_Fin.equals(other.date_Fin))
			return false;
		if (motif == null) {
			if (other.motif != null)
				return false;
		} else if (!motif.equals(other.motif))
			return false;
		if (pkContrat == null) {
			if (other.pkContrat != null)
				return false;
		} else if (!pkContrat.equals(other.pkContrat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TypeContratEmployee [pkContrat=" + pkContrat + ", date_Debut=" + date_Debut + ", date_Fin=" + date_Fin
				+ ", Salaire_initial=" + Salaire_initial + ", motif=" + motif + ", archive=" + archive + "]";
	}
	
	
}

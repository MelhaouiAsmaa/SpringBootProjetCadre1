package com.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Societe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsociete;
	@Column
	private String raison_social;
	@Column
	private String type;
	@Column
	private String headquarter;
	@Column
	private Boolean archive;
	
	@JsonIgnore
	@OneToMany(mappedBy="pkchargesociete.societe")
	private Set<ChargeSociete> chargesociete=new HashSet<ChargeSociete>();
	public Societe()
	{}
	
	public int getIdsociete() {
		return idsociete;
	}
	public void setIdsociete(int idsociete) {
		this.idsociete = idsociete;
	}
	public String getRaison_social() {
		return raison_social;
	}
	public Set<ChargeSociete> getChargesociete() {
		return chargesociete;
	}
	public void setChargesociete(Set<ChargeSociete> chargesociete) {
		this.chargesociete = chargesociete;
	}
	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHeadquarter() {
		return headquarter;
	}
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archive == null) ? 0 : archive.hashCode());
		result = prime * result + ((chargesociete == null) ? 0 : chargesociete.hashCode());
		result = prime * result + ((headquarter == null) ? 0 : headquarter.hashCode());
		result = prime * result + idsociete;
		result = prime * result + ((raison_social == null) ? 0 : raison_social.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Societe other = (Societe) obj;
		if (archive == null) {
			if (other.archive != null)
				return false;
		} else if (!archive.equals(other.archive))
			return false;
		if (chargesociete == null) {
			if (other.chargesociete != null)
				return false;
		} else if (!chargesociete.equals(other.chargesociete))
			return false;
		if (headquarter == null) {
			if (other.headquarter != null)
				return false;
		} else if (!headquarter.equals(other.headquarter))
			return false;
		if (idsociete != other.idsociete)
			return false;
		if (raison_social == null) {
			if (other.raison_social != null)
				return false;
		} else if (!raison_social.equals(other.raison_social))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "Societe [idsociete=" + idsociete + ", raison_social=" + raison_social + ", type=" + type
				+ ", headquarter=" + headquarter + ", archive=" + archive + "]";
	}
	
	

}

package com.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="type_contrat")
public class TypeContrat implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_typeC;
	@Column
	private String libelle_C;
	@Column 
	private Boolean archive;
	@JsonIgnore
	@OneToMany(mappedBy="pkContrat.contrat")
	private Set<TypeContratEmployee> relationCE=new HashSet<TypeContratEmployee>();
	public TypeContrat()
	{}
	public TypeContrat(int id_typeC, String libelle_C, Boolean archive) {
		super();
		this.id_typeC = id_typeC;
		this.libelle_C = libelle_C;
		this.archive = archive;
	}
	public int getId_typeC() {
		return id_typeC;
	}
	public void setId_typeC(int id_typeC) {
		this.id_typeC = id_typeC;
	}
	public String getLibelle_C() {
		return libelle_C;
	}
	public void setLibelle_C(String libelle_C) {
		this.libelle_C = libelle_C;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Set<TypeContratEmployee> getRelationCE() {
		return relationCE;
	}
	public void setRelationCE(Set<TypeContratEmployee> relationCE) {
		this.relationCE = relationCE;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeContrat other = (TypeContrat) obj;
		if (archive == null) {
			if (other.archive != null)
				return false;
		} else if (!archive.equals(other.archive))
			return false;
		if (id_typeC != other.id_typeC)
			return false;
		if (libelle_C == null) {
			if (other.libelle_C != null)
				return false;
		} else if (!libelle_C.equals(other.libelle_C))
			return false;
		if (relationCE == null) {
			if (other.relationCE != null)
				return false;
		} else if (!relationCE.equals(other.relationCE))
			return false;
		return true;
	}
	

	
	

}

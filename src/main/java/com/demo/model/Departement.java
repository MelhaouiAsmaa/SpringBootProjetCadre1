package com.demo.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Departement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	@Column
	private String nomDepartement;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pkResponsable.departement",fetch = FetchType.LAZY)
    Set<Responsable> responsable;
//	
//	@OneToMany(mappedBy="pk_chargedep.departement")
//   	private Set<ChargeDepartement> Chargedept=new HashSet<ChargeDepartement>();
	
//	@JsonIgnore
//	@OneToMany(fetch= FetchType.LAZY, mappedBy="pk_chargedep.departement")
//   	private Set<ChargeDepartement> charge;
	
	private boolean archive;
	

	public Departement() {
		
	}
	


	public Departement(Long idDepartement, String nomDepartement, Set<Responsable> responsable, boolean archive) {
		super();
		this.idDepartement = idDepartement;
		this.nomDepartement = nomDepartement;
		this.responsable = responsable;
		this.archive = archive;
	}



//	public Set<ChargeDepartement> getCharge() {
//		return charge;
//	}
//
//
//
//	public void setCharge(Set<ChargeDepartement> charge) {
//		this.charge = charge;
//	}



	public Long getIdDepartement() {
		return idDepartement;
	}


	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}


	public String getNomDepartement() {
		return nomDepartement;
	}


	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}


	public Set<Responsable> getResponsable() {
		return responsable;
	}


	public void setResponsable(Set<Responsable> responsable) {
		this.responsable = responsable;
	}
//
//
//	public Set<ChargeDepartement> getChargedept() {
//		return Chargedept;
//	}
//
//
//	public void setChargedept(Set<ChargeDepartement> chargedept) {
//		Chargedept = chargedept;
//	}


//	@Override
//	public String toString() {
//		return "Departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement + "]";
//	}


	public boolean isArchive() {
		return archive;
	}


	public void setArchive(boolean archive) {
		this.archive = archive;
	}		
	
	
}

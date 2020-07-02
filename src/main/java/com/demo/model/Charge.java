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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Charge implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCharges;
	@Column 
	private String typeCharge;
	
	@Column
	private boolean archive;
	
	@JsonIgnore
	@OneToMany(fetch= FetchType.LAZY, mappedBy="chargeS")
   	private Set<ChargeEmployee> employees;
	
//	@JsonIgnore
//	@OneToMany(fetch= FetchType.LAZY, mappedBy="pk_chargedep.charge")
//   	private Set<ChargeDepartement> Chargedept;
	
//	public Set<ChargeDepartement> getChargedept() {
//		return Chargedept;
//	}
//	public void setChargedept(Set<ChargeDepartement> chargedept) {
//		Chargedept = chargedept;
//	}
	
	public Charge() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Charge(Long idCharges, String typeCharge, boolean archive, Set<ChargeEmployee> employees,
		Set<ChargeDepartement> chargedept) {
	super();
	this.idCharges = idCharges;
	this.typeCharge = typeCharge;
	this.archive = archive;
	this.employees = employees;
//	Chargedept = chargedept;
}







	public Long getIdCharge() {
		return idCharges;
	}

	public void setIdCharge(Long idCharge) {
		this.idCharges = idCharge;
	}

	public String getTypeCharge() {
		return typeCharge;
	}

	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
	}

	public Set<ChargeEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<ChargeEmployee> employees) {
		this.employees = employees;
	}
	

//	public Set<ChargeDepartement> getChargedept() {
//		return Chargedept;
//	}
//
//
//
//	public void setChargedept(Set<ChargeDepartement> chargedept) {
//		Chargedept = chargedept;
//	}
	
	public boolean isArchive() {
		return archive;
	}







	public void setArchive(boolean archive) {
		this.archive = archive;
	}




//	@Override
//	public String toString() {
//		return "Charge [idCharge=" + idCharges + ", typeCharge=" + typeCharge + "]";
//	}
	
	
	
}

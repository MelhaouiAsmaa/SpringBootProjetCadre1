package com.demo.model;

import java.io.Serializable;  
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

public class Fonction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fonction")
	private Long idFct;
	
	@Column(unique = true)
	private String libelleFct;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fonction")
    Set<EmployeeFonction> employees;
	
	private boolean archive;

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(Long idFct, String libelleFct, Set<EmployeeFonction> employees,boolean archive) {
		super();
		this.idFct = idFct;
		this.libelleFct = libelleFct;
		this.employees = employees;
		this.archive = archive;
	}

	public Long getIdFct() {
		return idFct;
	}

	public void setIdFct(Long idFct) {
		this.idFct = idFct;
	}

	public String getLibelleFct() {
		return libelleFct;
	}

	public void setLibelleFct(String libelleFct) {
		this.libelleFct = libelleFct;
	}

	public Set<EmployeeFonction> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeFonction> employees) {
		this.employees = employees;
	}
	
	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "Fonction [idFct=" + idFct + ", libelleFct=" + libelleFct +"]";
	}

	

}

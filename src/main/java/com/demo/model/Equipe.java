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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Equipe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEquipe;
	
	@Column(unique = true)
	private String nomEquipe;
	@ManyToOne
	@JoinColumn(name="id_departement")
	private Departement departement;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipe")
    Set<EmployeeEquipe> employees;
	
	private boolean archive;

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(Long idEquipe, String nomEquipe, Departement departement, Set<EmployeeEquipe> employees,
			boolean archive) {
		super();
		this.idEquipe = idEquipe;
		this.nomEquipe = nomEquipe;
		this.departement = departement;
		this.employees = employees;
		this.archive = archive;
	}

	public Long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<EmployeeEquipe> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEquipe> employees) {
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
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + "]";
	}


}	
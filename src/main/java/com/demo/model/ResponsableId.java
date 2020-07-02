package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ResponsableId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDebutRes;
	@ManyToOne 
	@JoinColumn(name="matricule")
	private Employee employee;
	@ManyToOne 
	@JoinColumn(name="idDepartement")
	private Departement departement;
	
	
	
	
	
	public ResponsableId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponsableId(Date date_debut_res, Employee employee, Departement departement) {
		super();
		this.dateDebutRes = date_debut_res;
		this.employee = employee;
		this.departement = departement;
	}
	public Date getDate_debut_res() {
		return dateDebutRes;
	}
	public void setDate_debut_res(Date date_debut_res) {
		this.dateDebutRes = date_debut_res;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "ResponsableId [dateDebutRes=" + dateDebutRes + ", employee=" + employee + ", departement=" + departement
				+ "]";
	}
	
	
	
}

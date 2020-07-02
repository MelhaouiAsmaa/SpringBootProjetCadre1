package com.demo.model;

import java.io.Serializable;  
import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employe_equipe")
public class EmployeeEquipe implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeEquipeId pkEmpequipe;
	
	@ManyToOne
	@MapsId("empId")
	@JoinColumn(name="matricule")
	private Employee employee;
	
	@ManyToOne
	@MapsId("equipeId")
	@JoinColumn(name="id_equipe")
	private Equipe equipe;
	
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateFinA;
	
	@Column(name = "est_responsable")
	private boolean responsable;

	public EmployeeEquipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEquipe(EmployeEquipeId pkEmpequipe, Employee employee, Equipe equipe, Date dateFinA,
			boolean responsable) {
		super();
		this.pkEmpequipe = pkEmpequipe;
		this.employee = employee;
		this.equipe = equipe;
		this.dateFinA = dateFinA;
		this.responsable = responsable;
	}

	public EmployeEquipeId getPkEmpequipe() {
		return pkEmpequipe;
	}

	public void setPkEmpequipe(EmployeEquipeId pkEmpequipe) {
		this.pkEmpequipe = pkEmpequipe;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Date getDateFinA() {
		return dateFinA;
	}

	public void setDateFinA(Date dateFinA) {
		this.dateFinA = dateFinA;
	}

	public boolean getResponsable() {
		return responsable;
	}

	public void setResponsable(boolean responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "EmployeeEquipe [pkEmpequipe=" + pkEmpequipe.toString() + ", employee=" + employee.toString() + ", equipe=" + equipe.toString()
				+ ", dateFinA=" + dateFinA + ", responsable=" + responsable + "]";
	}
	
	
	
}

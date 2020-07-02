package com.demo.model;

import java.io.Serializable;  

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employe_fonction")
public class EmployeeFonction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private EmployeeFonctionId pkFonctionemp;
	
	@ManyToOne
	@MapsId("empId")
	@JoinColumn(name = "matricule")
	private Employee employeef;
	
	@ManyToOne
	@MapsId("fctId")
	@JoinColumn(name = "fonctionId")
	private Fonction fonction;
	
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	Date dateFinR;

	public EmployeeFonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeFonction(EmployeeFonctionId pkFonctionemp, Employee employeef, Fonction fonction, Date dateFinR) {
		super();
		this.pkFonctionemp = pkFonctionemp;
		this.employeef = employeef;
		this.fonction = fonction;
		this.dateFinR = dateFinR;
	}

	public EmployeeFonctionId getPkFonctionemp() {
		return pkFonctionemp;
	}

	public void setPkFonctionemp(EmployeeFonctionId pkFonctionemp) {
		this.pkFonctionemp = pkFonctionemp;
	}

	public Employee getEmployeef() {
		return employeef;
	}

	public void setEmployeef(Employee employeef) {
		this.employeef = employeef;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Date getDateFinR() {
		return dateFinR;
	}

	public void setDateFinR(Date dateFinR) {
		this.dateFinR = dateFinR;
	}

	@Override
	public String toString() {
		return "EmployeeFonction [pkFonctionemp=" + pkFonctionemp.toString() + ", employeef=" + employeef.toString() + ", fonction="
				+ fonction.toString() + ", dateFinR=" + dateFinR + "]";
	}

	

	
	
	
}

package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employeeCharge")
public class ChargeEmployee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private ChargeEmployeeId pkChargeemp;
	
	@ManyToOne
	@MapsId("empId")
	@JoinColumn(name="matricule")
	private Employee employeec;
	
	@ManyToOne
	@MapsId("chargeId")
	@JoinColumn(name="id_charges")
	private Charge chargeS;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateFinC;
	
	@Column 
	private Float montant;
	
	
	public ChargeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ChargeEmployee(ChargeEmployeeId pkChargeemp, Employee employeec, Charge chargeS, Date dateFinC,
			Float montant) {
		super();
		this.pkChargeemp = pkChargeemp;
		this.employeec = employeec;
		this.chargeS = chargeS;
		this.dateFinC = dateFinC;
		this.montant = montant;
	}



	public ChargeEmployeeId getPkChargeemp() {
		return pkChargeemp;
	}



	public void setPkChargeemp(ChargeEmployeeId pkChargeemp) {
		this.pkChargeemp = pkChargeemp;
	}



	public Employee getEmployeec() {
		return employeec;
	}



	public void setEmployeec(Employee employeec) {
		this.employeec = employeec;
	}



	public Charge getChargeS() {
		return chargeS;
	}



	public void setChargeS(Charge chargeS) {
		this.chargeS = chargeS;
	}



	public Date getDateFinC() {
		return dateFinC;
	}



	public void setDateFinC(Date dateFinC) {
		this.dateFinC = dateFinC;
	}



	public Float getMontant() {
		return montant;
	}



	public void setMontant(Float montant) {
		this.montant = montant;
	}



	@Override
	public String toString() {
		return "ChargeEmployee [pkChargeemp=" + pkChargeemp.toString() + ", employeec=" + employeec.toString() 
		+ ", chargeS=" + chargeS.toString() + ", dateFinC=" + dateFinC + ", montant=" + montant + "]";
	}
	
}

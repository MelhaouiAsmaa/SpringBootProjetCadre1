package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Conge implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConge;
	@Column 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDepart;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_retour")
	private Date dateRetours;
	@Column
	private String cause;
	@Column 
	private String type;
	@Column 
	private String certificat;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDemande;
	@Column
	private String etat;
	@Column
	private int remplaçant;
	
	@ManyToOne
	@JoinColumn(name="matricule")
	private Employee employee;
	
	
	
	public Conge() {
		
	}
	public Conge(Long idConge, Date dateDepart, Date dateRetour, String cause, String type, String certificat,
			Date dateDemande, String etat, int remplaçant, Employee employee) {
		super();
		this.idConge = idConge;
		this.dateDepart = dateDepart;
		this.dateRetours = dateRetour;
		this.cause = cause;
		this.type = type;
		this.certificat = certificat;
		this.dateDemande = dateDemande;
		this.etat = etat;
		this.remplaçant = remplaçant;
		this.employee = employee;
	}
	public Long getId_Conge() {
		return idConge;
	}
	public void setId_Conge(Long id_Conge) {
		this.idConge = id_Conge;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateRetours() {
		return dateRetours;
	}
	public void setDateRetours(Date dateRetour) {
		this.dateRetours = dateRetour;
	}
	public String getcause() {
		return cause;
	}
	public void setcause(String cause) {
		this.cause = cause;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public String getcertificat() {
		return certificat;
	}
	public void setcertificat(String certificat) {
		this.certificat = certificat;
	}
	public Date getdateDemande() {
		return dateDemande;
	}
	public void setdateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getetat() {
		return etat;
	}
	public void setetat(String etat) {
		this.etat = etat;
	}
	public int getremplaçant() {
		return remplaçant;
	}
	public void setremplaçant(int remplaçant) {
		this.remplaçant = remplaçant;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Conge [idConge=" + idConge + ", dateDepart=" + dateDepart + ", dateRetour=" + dateRetours + ", cause="
				+ cause + ", type=" + type + ", certificat=" + certificat + ", dateDemande=" + dateDemande + ", etat="
				+ etat + ", remplaçant=" + remplaçant + "]";
	}
	
	
	
}

package com.demo.model;

import java.io.Serializable; 
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricule;
	@Column
    private String nom;
	@Column
    private String prenom;
	@Column
    private Date datenaissance;
	@Column
    private String cin;
	@Column
	private Integer soldeConge;
	@Column
    private String adresse;
	@Column
    private String telephone;
	@Column
    private Integer annee_experience;
	@Column
    private String photo;
  
    private Boolean archive;
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeef")
    Set<EmployeeFonction> fonctions;
    
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    Set<EmployeeEquipe> equipes;
   
	@JsonIgnore
	@OneToMany(mappedBy = "pkResponsable.employee",fetch = FetchType.LAZY)
    Set<Responsable> responsable;
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="pkContrat.employee")
	private Set<TypeContratEmployee> relationCE;
//  
//
//  
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_useremp", referencedColumnName = "id")
    private User user;
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="employeec")
   	private Set<ChargeEmployee> charges;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(Long matricule, String nom, String prenom, Date datenaissance, String cin, Integer soldeConge,
			String adresse, String telephone, Integer annee_experience, String photo, Boolean archive,
			Set<EmployeeFonction> fonctions, Set<EmployeeEquipe> equipes, Set<Responsable> responsable,
			Set<TypeContratEmployee> relationCE, User user, Set<ChargeEmployee> charges) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.cin = cin;
		this.soldeConge = soldeConge;
		this.adresse = adresse;
		this.telephone = telephone;
		this.annee_experience = annee_experience;
		this.photo = photo;
		this.archive = archive;
		this.fonctions = fonctions;
		this.equipes = equipes;
		this.responsable = responsable;
		this.relationCE = relationCE;
		this.user = user;
		this.charges = charges;
	}







	public Long getMatricule() {
		return matricule;
	}


	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}


	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}

	

	public Integer getSoldeConge() {
		return soldeConge;
	}

	public void setSoldeConge(Integer soldeConge) {
		this.soldeConge = soldeConge;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Integer getAnnee_experience() {
		return annee_experience;
	}


	public void setAnnee_experience(Integer annee_experience) {
		this.annee_experience = annee_experience;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Set<EmployeeFonction> getFonctions() {
		return fonctions;
	}


	public void setFonctions(Set<EmployeeFonction> fonctions) {
		this.fonctions = fonctions;
	}


	public Boolean isArchive() {
		return archive;
	}


	public void setArchive(Boolean archive) {
		this.archive = archive;
	}





	public Set<EmployeeEquipe> getEquipes() {
		return equipes;
	}





	public void setEquipes(Set<EmployeeEquipe> equipes) {
		this.equipes = equipes;
	}
	
	
	

//	public Set<EmployeeEquipe> getEmployeeequipe() {
//		return employeeequipe;
//	}
//
//
//	public void setEmployeeequipe(Set<EmployeeEquipe> employeeequipe) {
//		this.employeeequipe = employeeequipe;
//	}
//
//
//	public Set<Responsable> getResponsable() {
//		return responsable;
//	}
//
//
//	public void setResponsable(Set<Responsable> responsable) {
//		this.responsable = responsable;
//	}
//
//
//	public Set<TypeContratEmployee> getRelationCE() {
//		return relationCE;
//	}
//
//
//	public void setRelationCE(Set<TypeContratEmployee> relationCE) {
//		this.relationCE = relationCE;
//	}
//
//
//	public Set<ChargeEmployee> getChargeempl() {
//		return Chargeempl;
//	}
//
//
//	public void setChargeempl(Set<ChargeEmployee> chargeempl) {
//		Chargeempl = chargeempl;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Employee [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance="
//				+ datenaissance + ", cin=" + cin + ", adresse=" + adresse + ", telephone=" + telephone
//				+ ", annee_experience=" + annee_experience + ", photo=" + photo + ", fonctions=" + fonctions
//				+ ", employeeequipe=" + employeeequipe + ", responsable=" + responsable + ", relationCE=" + relationCE
//				+ ", Chargeempl=" + Chargeempl + "]";
//	}
	
	

	
	public Set<ChargeEmployee> getCharges() {
		return charges;
	}



	public Set<Responsable> getResponsable() {
		return responsable;
	}



	public void setResponsable(Set<Responsable> responsable) {
		this.responsable = responsable;
	}



	public Set<TypeContratEmployee> getRelationCE() {
		return relationCE;
	}



	public void setRelationCE(Set<TypeContratEmployee> relationCE) {
		this.relationCE = relationCE;
	}



	public void setCharges(Set<ChargeEmployee> charges) {
		this.charges = charges;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Employee [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
    
    
}

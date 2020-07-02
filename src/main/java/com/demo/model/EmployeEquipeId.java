package com.demo.model;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class EmployeEquipeId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Long empId;
	
	@Column
	private Long equipeId;
	
	@Column
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateDebutA;

	public EmployeEquipeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeEquipeId(Long empId, Long equipeId, Date dateDebutA) {
		super();
		this.empId = empId;
		this.equipeId = equipeId;
		this.dateDebutA = dateDebutA;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getEquipeId() {
		return equipeId;
	}

	public void setEquipeId(Long equipeId) {
		this.equipeId = equipeId;
	}

	public Date getDateDebutA() {
		return dateDebutA;
	}

	public void setDateDebutA(Date dateDebutA) {
		this.dateDebutA = dateDebutA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutA == null) ? 0 : dateDebutA.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((equipeId == null) ? 0 : equipeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeEquipeId other = (EmployeEquipeId) obj;
		if (dateDebutA == null) {
			if (other.dateDebutA != null)
				return false;
		} else if (!dateDebutA.equals(other.dateDebutA))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (equipeId == null) {
			if (other.equipeId != null)
				return false;
		} else if (!equipeId.equals(other.equipeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeEquipeId [empId=" + empId + ", equipeId=" + equipeId + ", dateDebutA=" + dateDebutA + "]";
	}
	
	
//	@ManyToOne 
//	@JoinColumn(name="matricule")
//	private Employee employee;
//	
//	@ManyToOne 
//	@JoinColumn(name="id_equipe")
//	private Equipe equipe;
	
	

	
	
	
}

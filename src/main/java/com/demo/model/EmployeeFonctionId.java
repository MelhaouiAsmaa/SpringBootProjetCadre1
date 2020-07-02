package com.demo.model;

import java.io.Serializable;   
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
 
@Embeddable
public class EmployeeFonctionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Long empId;
	
	@Column
	private Long fctId;
	
	@Column
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@Temporal(TemporalType.DATE)
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date dateDebutR;

	public EmployeeFonctionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeFonctionId(Date dateDebutR, Long empId, Long fctId) {
		super();
		this.dateDebutR = dateDebutR;
		this.empId = empId;
		this.fctId = fctId;
	}

	public Date getDateDebutR() {
		return dateDebutR;
	}

	public void setDateDebutR(Date dateDebutR) {
		this.dateDebutR = dateDebutR;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getFctId() {
		return fctId;
	}

	public void setFctId(Long fctId) {
		this.fctId = fctId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutR == null) ? 0 : dateDebutR.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((fctId == null) ? 0 : fctId.hashCode());
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
		EmployeeFonctionId other = (EmployeeFonctionId) obj;
		if (dateDebutR == null) {
			if (other.dateDebutR != null)
				return false;
		} else if (!dateDebutR.equals(other.dateDebutR))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (fctId == null) {
			if (other.fctId != null)
				return false;
		} else if (!fctId.equals(other.fctId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeFonctionId [dateDebutR=" + dateDebutR + ", empId=" + empId + ", fctId=" + fctId + "]";
	}
	
	
	

}

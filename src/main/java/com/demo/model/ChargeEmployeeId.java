package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ChargeEmployeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Long empId;
	
	@Column
	private Long chargeId;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateDebutC;

	public ChargeEmployeeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChargeEmployeeId(Long empId, Long chargeId, Date dateDebutC) {
		super();
		this.empId = empId;
		this.chargeId = chargeId;
		this.dateDebutC = dateDebutC;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public Date getDateDebutC() {
		return dateDebutC;
	}

	public void setDateDebutC(Date dateDebutC) {
		this.dateDebutC = dateDebutC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chargeId == null) ? 0 : chargeId.hashCode());
		result = prime * result + ((dateDebutC == null) ? 0 : dateDebutC.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
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
		ChargeEmployeeId other = (ChargeEmployeeId) obj;
		if (chargeId == null) {
			if (other.chargeId != null)
				return false;
		} else if (!chargeId.equals(other.chargeId))
			return false;
		if (dateDebutC == null) {
			if (other.dateDebutC != null)
				return false;
		} else if (!dateDebutC.equals(other.dateDebutC))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChargeEmployeeId [empId=" + empId + ", chargeId=" + chargeId + ", dateDebutC=" + dateDebutC + "]";
	}

	

}

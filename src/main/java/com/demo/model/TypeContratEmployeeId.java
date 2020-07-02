package com.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
@Embeddable
public class TypeContratEmployeeId implements Serializable {
	
	
	 
	 
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_Contrat;
	@ManyToOne
	@JoinColumn(name="id_typec")
	private TypeContrat contrat;
	@ManyToOne
	@JoinColumn(name="matricule")
	private Employee employee;
	public TypeContratEmployeeId()
	{}
	public TypeContratEmployeeId(Date date_Contrat, TypeContrat contrat, Employee employee) {
		super();
		this.date_Contrat = date_Contrat;
		this.contrat = contrat;
		this.employee = employee;
	}
	public Date getDate_Contrat() {
		return date_Contrat;
	}
	public void setDate_Contrat(Date date_Contrat) {
		this.date_Contrat = date_Contrat;
	}
	public TypeContrat getContrat() {
		return contrat;
	}
	public void setContrat(TypeContrat contrat) {
		this.contrat = contrat;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
		result = prime * result + ((date_Contrat == null) ? 0 : date_Contrat.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		TypeContratEmployeeId other = (TypeContratEmployeeId) obj;
		if (contrat == null) {
			if (other.contrat != null)
				return false;
		} else if (!contrat.equals(other.contrat))
			return false;
		if (date_Contrat == null) {
			if (other.date_Contrat != null)
				return false;
		} else if (!date_Contrat.equals(other.date_Contrat))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TypeContratEmployeeId [date_Contrat=" + date_Contrat + ", contrat=" + contrat + ", employee=" + employee
				+ "]";
	}
	
	
}

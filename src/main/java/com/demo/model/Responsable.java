package com.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Responsable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	public ResponsableId pkResponsable;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateFinRes;
	@Column
	private Boolean archive;
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Responsable(ResponsableId pk_responsable, Date date_fin_res,Boolean a) {
		super();
		this.pkResponsable = pk_responsable;
		this.dateFinRes = date_fin_res;
		this.archive=a;
	}
	
	public ResponsableId getPkResponsable() {
		return pkResponsable;
	}
	public void setPkResponsable(ResponsableId pkResponsable) {
		this.pkResponsable = pkResponsable;
	}
	public Date getDateFinRes() {
		return dateFinRes;
	}
	public void setDateFinRes(Date dateFinRes) {
		this.dateFinRes = dateFinRes;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "Responsable [pkResponsable=" + pkResponsable + ", dateFinRes=" + dateFinRes + "]";
	}
	
}

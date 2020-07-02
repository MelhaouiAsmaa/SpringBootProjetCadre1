package com.demo.model;

import java.io.Serializable; 
import java.util.Date;

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
	private ResponsableId pkResponsable;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateFinRes;
	
	
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Responsable(ResponsableId pk_responsable, Date date_fin_res) {
		super();
		this.pkResponsable = pk_responsable;
		this.dateFinRes = date_fin_res;
	}
	public ResponsableId getPk_responsable() {
		return pkResponsable;
	}
	public void setPk_responsable(ResponsableId pk_responsable) {
		this.pkResponsable = pk_responsable;
	}
	public Date getDate_fin_res() {
		return dateFinRes;
	}
	public void setDate_fin_res(Date date_fin_res) {
		this.dateFinRes = date_fin_res;
	}
	@Override
	public String toString() {
		return "Responsable [pkResponsable=" + pkResponsable + ", dateFinRes=" + dateFinRes + "]";
	}
	
}

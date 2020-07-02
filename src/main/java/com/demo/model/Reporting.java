package com.demo.model;

public class Reporting {
	int mois;
	Double montant;
	public Reporting()
	{}
	public Reporting(int mois, Double montant) {
		super();
		this.mois = mois;
		this.montant = montant;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mois;
		result = prime * result + ((montant == null) ? 0 : montant.hashCode());
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
		Reporting other = (Reporting) obj;
		if (mois != other.mois)
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reporting [mois=" + mois + ", montant=" + montant + "]";
	}
}

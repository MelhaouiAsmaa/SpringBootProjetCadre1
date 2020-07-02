package com.demo.iservices;

import java.sql.Date;
import java.util.List;

import com.demo.model.TypeContrat;
import com.demo.model.TypeContratEmployee;
import com.demo.model.TypeContratEmployeeId;

public interface ITypeContratEmployeeService {
	
public List<TypeContratEmployee> GetallContratEmployee(Boolean a);
public void creerContratEmploye(TypeContratEmployee e);
public void supprimer_contrat(TypeContratEmployeeId e);
public TypeContratEmployee getbyid(TypeContratEmployeeId e);
public int countPkContrat(TypeContratEmployeeId e);
public List<TypeContratEmployee> Getdetail(TypeContrat e);
public void desarchive_contrat(TypeContratEmployeeId e);
}

package com.demo.iservices;

import java.util.List;

import com.demo.model.Departement;
import com.demo.model.Employee;
import com.demo.model.Responsable;

public interface IDepartementService {
	
	public Departement saveOrupdateDep(Departement dep);
	public Departement getDepById(Long id);
	public List<Departement> getAllDeps();
	public void DeleteDep(Departement dep);
	public int trouverNom(String a);
	public List<Departement> findAllDepartementNoArchive();
	public List<Departement> findAllDepartementArchive();
	public void modifierDept(Boolean a,Long b);
	public Departement TrouverDepartement(String a);
	public Responsable listerResponsableDept(Long id);
	public List<Employee> getEmployeesByDepartment(Long id);
}

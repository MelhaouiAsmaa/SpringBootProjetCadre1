package com.demo.iservices;

import java.util.List;

import com.demo.model.Employee;
import com.demo.model.Fonction;



public interface IFonctionService {

	public Fonction saveOrupdateFonction(Fonction fct);
	public void DeleteFonction(Fonction fct);
	public List<Fonction> getAllFonctions();
	public Fonction getFonctionById(Long id);
	public Integer EmployeesNumber(Long id);
	public Integer EmployeeNumberTotal(Long id);
	public List<Long> ListEmployeesbyFunction(Long id);
	public List<Fonction> getAllArchivedFonction();
	public void desarchiverFonction(Fonction fct);
}

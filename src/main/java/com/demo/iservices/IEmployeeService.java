package com.demo.iservices;

import java.util.Date;
import java.util.List;

import com.demo.model.ChargeEmployee;
import com.demo.model.Conge;
import com.demo.model.Employee;
import com.demo.model.EmployeeFonction;
import com.demo.model.Equipe;
import com.demo.model.TypeContratEmployee;

public interface IEmployeeService {

	
	public Employee saveOrEmployee(Employee emp);
	public void DeleteEmployee(Employee emp);
	public Employee Desarchiver(Employee emp);
	public List<Employee> getAllArchived();
	public List<Employee> getAllEmployees();
	public Employee getById(Long id);
	public Long GetLatestEmpId();
	public String getActualFonctionEmployee(Long id);
	public String getActualEquipeEmployee(Long id);
	public List<EmployeeFonction> getFonctionsByEmploye(Long id);
	public List<Equipe> getEquipesByemployeeFonction(Long id, Date datedeb, Date datefin);
	public Long getActualDepartment(Long id);
	public 	List<Conge> getCongeeByEmployee(Long id);
	public List<ChargeEmployee> getChargesByEmployees(Long id);
	public Employee getUserEmployee(Long id);
	public TypeContratEmployee getActualContratEmp(Long id);

}

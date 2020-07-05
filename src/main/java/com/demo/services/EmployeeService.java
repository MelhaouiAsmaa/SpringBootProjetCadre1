package com.demo.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IEmployeeService;
import com.demo.model.ChargeEmployee;
import com.demo.model.Conge;
import com.demo.model.Employee;
import com.demo.model.EmployeeFonction;
import com.demo.model.Equipe;
import com.demo.model.TypeContratEmployee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired EmployeeRepository repo;

	 
	
	@Override
	public List<Employee> getAllEmployees() {
		return repo.getAllEmployees();
	}

	@Override
	public Employee saveOrEmployee(Employee emp) {
		// TODO Auto-generated method stub
		emp.setArchive(false);
		return repo.save(emp);
	}

	@Override
	public void DeleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		emp.setArchive(true);
		 repo.save(emp);
		 if(emp.isArchive())
				System.out.println("employe archive "+emp.isArchive());
		else
				System.out.println("archive failed :(");
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public Long GetLatestEmpId() {
		// TODO Auto-generated method stub
		return repo.GetLatestEmployeeId();
	}

	@Override
	public String getActualFonctionEmployee(Long id) {
		// TODO Auto-generated method stub
//		List<String> items = Arrays.asList(repo.getActualFonctionByEmployee(id).split("\\s*,\\s*"));
//		for(int i=0; i<items.size();i++)
//		{
//			System.out.println(items.get(i));
//		}
		System.out.println("Actual fonction: " + repo.getActualFonctionByEmployee(id));
		return repo.getActualFonctionByEmployee(id);
	}

	@Override
	public String getActualEquipeEmployee(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Actual equipe: " + repo.getActualEquipeByEmployee(id));
		return repo.getActualEquipeByEmployee(id);
	}

	@Override
	public List<EmployeeFonction> getFonctionsByEmploye(Long id) {
		// TODO Auto-generated method stub
		List<EmployeeFonction> liste = repo.getFonctionsByEmployee(id);
		for(int i=0; i<liste.size();i++)
		{
			System.out.println(liste.get(i));
		}
		
		return repo.getFonctionsByEmployee(id);
	}

	@Override
	public List<Equipe> getEquipesByemployeeFonction(Long id, Date datedeb, Date datefin) {
		// TODO Auto-generated method stub
		List<Equipe> liste = repo.getEquipesByemployeeFonct(id, datedeb, datefin);
		for(int i=0; i<liste.size();i++)
		{
			System.out.println(liste.get(i));
		}
		return repo.getEquipesByemployeeFonct(id, datedeb, datefin);
	}

	@Override
	public Long getActualDepartment(Long id) {
		// TODO Auto-generated method stub
		System.out.println("departement de matricule " + id + " : " + repo.getActualDepartement(id));
		return repo.getActualDepartement(id);
	}

	@Override
	public List<Conge> getCongeeByEmployee(Long id) {
		// TODO Auto-generated method stub
		return repo.getCongeByEmployee(id);
	}

	@Override
	public List<ChargeEmployee> getChargesByEmployees(Long id) {
		// TODO Auto-generated method stub
		return repo.getChargesByEmployee(id);
	}

	@Override
	public Employee getUserEmployee(Long id) {
		// TODO Auto-generated method stub
		return repo.getUserofEmployee(id);
	}

	@Override
	public List<Employee> getAllArchived() {
		// TODO Auto-generated method stub
		return repo.getArchivedEmployees();
	}

	@Override
	public Employee Desarchiver(Employee emp) {
		// TODO Auto-generated method stub
		emp.setArchive(false);
		return repo.save(emp);
	}

	@Override
	public TypeContratEmployee getActualContratEmp(Long id) {
		// TODO Auto-generated method stub
		return repo.getActualContrat(id);
	}

	

	

	
	
	

}

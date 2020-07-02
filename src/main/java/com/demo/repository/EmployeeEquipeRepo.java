package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.EmployeEquipeId;
import com.demo.model.Employee;
import com.demo.model.EmployeeEquipe;
import com.demo.model.Equipe;

public interface EmployeeEquipeRepo extends JpaRepository<EmployeeEquipe, EmployeEquipeId> {
	
	EmployeeEquipe findByEmployeeAndEquipe(Employee emp, Equipe equ);  

}

package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.demo.model.ChargeEmployee;
import com.demo.model.Conge;
import com.demo.model.Employee;
import com.demo.model.EmployeeFonction;
import com.demo.model.Equipe;

public interface EmployeeRepositoryCustom {
	
	@Query("SELECT coalesce(max(ch.matricule), 0) FROM Employee ch")
	Long GetLatestEmployeeId();
	
	@Query("select e from Employee e where e.archive=false")
	List<Employee> getAllEmployees();
	
	@Query("select empfct.fonction.idFct from EmployeeFonction empfct where empfct.employeef.matricule=:id "
			+ "and CURRENT_DATE < empfct.dateFinR")
	String getActualFonctionByEmployee(Long id);
	
	@Query("select empeq.equipe.idEquipe from EmployeeEquipe empeq where empeq.employee.matricule=:id "
			+ "and CURRENT_DATE < empeq.dateFinA")
	String getActualEquipeByEmployee(Long id);
	
	@Query("select empfct from EmployeeFonction empfct where empfct.employeef.matricule=:id")
	List<EmployeeFonction> getFonctionsByEmployee(Long id);
	
	@Query("select e.equipe from EmployeeEquipe e where e.employee.matricule=:id and e.pkEmpequipe.dateDebutA >= :datedeb "
			+ "and e.dateFinA <= :datefin")
	List<Equipe> getEquipesByemployeeFonct(Long id, Date datedeb, Date datefin);
	
	@Query("SELECT eq.departement.idDepartement FROM Equipe eq WHERE eq.idEquipe in (SELECT emq.equipe.idEquipe FROM EmployeeEquipe emq WHERE emq.employee.matricule=:id and current_date < emq.dateFinA)")
	Long getActualDepartement(Long id);
	
	@Query("select c from Conge c where c.employee.matricule=:id")
	List<Conge> getCongeByEmployee(Long id);
	
	@Query("select ce from ChargeEmployee ce where ce.employeec.matricule=:id")
	List<ChargeEmployee> getChargesByEmployee(Long id);
	
	@Query("select e from Employee e where e.user.id=:id")
	Employee getUserofEmployee(Long id);
	
	@Query("select e from Employee e where e.archive= true")
	List<Employee> getArchivedEmployees();
	
	
	
	
	
	
	
	
	
	
	
	
//	@Query("select e.equipe from EmployeeEquipe e where e.employee.matricule=:id and e.pkEmpequipe.dateDebutA > :datedeb + 1 "
//			+ "and e.dateFinA < :datefin + 1")
//	List<Equipe> getEquipesByemployeeFonct(Long id, Date datedeb, Date datefin);
}

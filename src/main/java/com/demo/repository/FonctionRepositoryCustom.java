package com.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.demo.model.Employee;
import com.demo.model.Fonction;


public interface FonctionRepositoryCustom {

	@Query("select count(*) from EmployeeFonction ef where ef.fonction.idFct =:id"
			+ " and CURRENT_DATE between ef.pkFonctionemp.dateDebutR and ef.dateFinR and ef.employeef.archive=false"
			+ " GROUP BY ef.fonction.idFct")
	Integer EmployeeNumber(Long id);
	
	@Query("select count(*) from EmployeeFonction ef where ef.fonction.idFct =:id GROUP BY ef.fonction.idFct")
	Integer EmployeeNumbertotal(Long id);
	
	@Query("select f from Fonction f where f.archive=false")
	List<Fonction> getAllfunctions();
	
	@Query("select ef.employeef.matricule from EmployeeFonction ef where ef.fonction.idFct =:id") 
	List<Long> ListEmployeesbyFunction(Long id);
	
	@Query("select f from Fonction f where f.archive=true")
	List<Fonction> getArchivedFonction();
	
	
	//select u from User u inner join u.company c where c.id = :id"
	//select * from employees where matricule IN ( SELECT matricule from employe_fonction where fonction_id = 13 )
}

package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.demo.model.Equipe;

public interface EquipeRepoCustom {
	
	

	@Query("select e from Equipe e where e.archive=false")
	List<Equipe> getAllEquipes();
	
	@Query("select d.nomDepartement from Departement d where d.idDepartement IN "
			+ "(select e.departement.idDepartement from Equipe e where e.idEquipe=:id)")
	String DepNameByEquipe(Long id);
	
	@Query("select em.nom,em.prenom from Employee em where em.matricule IN "
			+ "(select eq.employee.matricule from EmployeeEquipe eq where eq.equipe.idEquipe=:id and eq.responsable=true "
			+ "and CURRENT_DATE between eq.pkEmpequipe.dateDebutA and eq.dateFinA)")
	List<String> responsableEquipe(Long id);
	
	@Query("select eq from Equipe eq where eq.archive=true")
	List<Equipe> getArchivedEquipe();
	
//	@Query("select empeq.employee.matricule,empeq.pkEmpequipe.dateDebutA,empeq.dateFinA,empeq.responsable from EmployeeEquipe empeq "
//			+ "where empeq.equipe.idEquipe =:id") 
//	List<String> ListEmployeesbyEquipe(Long id);
	@Query("select empeq.employee.matricule,empeq.pkEmpequipe.dateDebutA,empeq.dateFinA,empeq.responsable,empfct.fonction.idFct from "
			+ "EmployeeFonction empfct,EmployeeEquipe empeq where empfct.employeef.matricule=empeq.employee.matricule and "
			+ "empeq.equipe.idEquipe =:id and CURRENT_DATE between empfct.pkFonctionemp.dateDebutR and empfct.dateFinR") 
	List<String> ListEmployeesbyEquipe(Long id);
	
	@Query("select eq from Equipe eq where eq.departement.idDepartement=?1")
	List<Equipe> getEquipeByDept(Long a);
}

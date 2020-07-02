package com.demo.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.TypeContrat;
import com.demo.model.TypeContratEmployee;
import com.demo.model.TypeContratEmployeeId;

public interface TypeContratEmployeeRepository extends JpaRepository<TypeContratEmployee,TypeContratEmployeeId> {
	/**@Transactional
	 @Modifying
	 @Query("Update TypeContratEmployee t set t.archive=true where t.pkContrat.contrat.id_typeC=?1 and t.pkContrat.employee.matricule= ?2 and t.pkContrat.date_Contrat= ?3")
	void archiverContratEmployee(int a,Long b, Date c);
	
	@Query("select t from TypeContratEmployee t where t.pkContrat.contrat.id_typeC= ?1 and t.pkContrat.employee.matricule= ?2 ")
	TypeContratEmployee afficher(int a,Long b);
	TypeContratEmployee findByPkContrat(TypeContratEmployeeId e);**/
	@Query("select count(*) from TypeContratEmployee t where  t.pkContrat.date_Contrat= ?1")
	int count( Date a);
	TypeContratEmployee findByPkContrat(TypeContratEmployeeId e);
int countByPkContrat(TypeContratEmployeeId e);
@Query("select t from TypeContratEmployee t where t.archive=?1")
List<TypeContratEmployee> lister_type(Boolean a);
List<TypeContratEmployee> findAllByPkContratContrat(TypeContrat c);
}

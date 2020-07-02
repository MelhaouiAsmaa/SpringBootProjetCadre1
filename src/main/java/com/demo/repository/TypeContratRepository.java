package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.*;

public interface TypeContratRepository extends  JpaRepository<TypeContrat, Integer>{

	 @Query("SELECT Count(*) FROM TypeContrat  t WHERE  t.libelle_C = ?1")
	   int findByNom(String typecontrat);
	 @Transactional
	 @Modifying
@Query("UPDATE TypeContrat t SET t.archive= ?1 WHERE t.id_typeC= ?2")
void SupprimerTypeContrat(Boolean a,int id);
	 @Query("select t from TypeContrat t where t.archive= ?1")
	 List<TypeContrat> findTypeContrat(Boolean a);
	 
	@Query("select t from TypeContrat t where t.libelle_C= ?1")
	public TypeContrat findIdArchive(String a );
}

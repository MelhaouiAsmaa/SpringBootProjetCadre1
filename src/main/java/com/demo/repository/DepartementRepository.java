package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Departement;
import com.demo.model.Responsable;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

	@Query("select count(*) from Departement d where d.nomDepartement= ?1")
	int trouverNomDepartement(String nom);
	//Fonction pour la modification de l'archive 
	@Transactional
	@Modifying
	@Query("Update Departement d set d.archive= ?1 where d.idDepartement= ?2")
	void ModifierArchive(Boolean a,Long b);
	//Afficher les departement archivés/non archivés
	@Query("Select d from Departement d where d.archive= ?1")
	List<Departement> FindDepartement(Boolean a);
	@Query("select d from Departement d where d.nomDepartement= ?1")
	Departement TrouverDept(String a);
	@Query("select t.responsable from Departement t where t.idDepartement=?1 ")
	Responsable  listerResponsableDepartement(Long id);
}

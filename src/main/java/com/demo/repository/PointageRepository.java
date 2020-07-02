package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Departement;
import com.demo.model.Pointage;

public interface PointageRepository extends JpaRepository<Pointage,Integer>{
	@Query("select p from Pointage p where p.archive=?1")
	List<Pointage> lister(Boolean a);
	@Transactional
	@Modifying
	@Query("Update Pointage p set p.archive= ?1 where p.id_pointage=?2")
	void archive_desarchive(Boolean a,int b);
}

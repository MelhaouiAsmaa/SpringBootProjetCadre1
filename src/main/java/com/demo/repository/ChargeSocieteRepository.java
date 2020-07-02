package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.ChargeSociete;
import com.demo.model.ChargeSocieteId;

public interface ChargeSocieteRepository extends JpaRepository<ChargeSociete,ChargeSocieteId>{
@Query("select c from ChargeSociete c where c.archive=?1")
List<ChargeSociete> lister(Boolean a);
@Query("select MONTH(c.pkchargesociete.datedebut) AS mois,Sum(c.montant)\r\n" + 
		"from ChargeSociete c   \r\n" + 
		"where YEAR(c.pkchargesociete.datedebut)= ?1  and c.archive=false \r\n" + 
		"group by MONTH(c.pkchargesociete.datedebut) \r\n" + 
		"order by MONTH(c.pkchargesociete.datedebut)")
List<Object> reportingSociete(int id);

}

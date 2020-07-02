package com.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.*;
public interface ChargeDepartementRepository extends JpaRepository<ChargeDepartement,ChargeDepartementId> {
@Query("select c from ChargeDepartement c where c.archive=?1")
List<ChargeDepartement> listerdept(Boolean a);
@Query("Select count(*) from ChargeDepartement c where c.pk_chargedep=?1")
int compter(ChargeDepartementId a);
@Query("select MONTH(c.pk_chargedep.date_Debut) AS mois,Sum(c.montant)\r\n" + 
		"from ChargeDepartement c   \r\n" + 
		"where YEAR(c.pk_chargedep.date_Debut)= ?1  and c.archive=false \r\n" + 
		"group by MONTH(c.pk_chargedep.date_Debut) \r\n" + 
		"order by MONTH(c.pk_chargedep.date_Debut)")
List<Object> reporting(int id);
}

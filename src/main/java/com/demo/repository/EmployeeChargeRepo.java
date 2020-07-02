package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.ChargeEmployee;
import com.demo.model.ChargeEmployeeId;

public interface EmployeeChargeRepo extends JpaRepository<ChargeEmployee, ChargeEmployeeId> {
	@Query("select MONTH(c.pkChargeemp.dateDebutC) AS mois,Sum(c.montant)\r\n" + 
			"from ChargeEmployee c   \r\n" + 
			"where YEAR(c.pkChargeemp.dateDebutC)= ?1   \r\n" + 
			"group by MONTH(c.pkChargeemp.dateDebutC) \r\n" + 
			"order by MONTH(c.pkChargeemp.dateDebutC)")
	List<Object> reporting(int id);
}

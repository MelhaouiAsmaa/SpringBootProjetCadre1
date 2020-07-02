package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

	@Query("select c from Charge c where c.archive=?1 ")
	List<Charge> listercharges(Boolean a);
	@Transactional
	@Modifying
	@Query("Update Charge c set c.archive=?1 where c.idCharges=?2")
	void modifier(Boolean a,Long b);
	@Query("select count(*) from Charge c where c.typeCharge=?1")
	int counttype(String a);
	@Query("select c from Charge c where c.typeCharge=?1")
	Charge getChargeByType(String a);
}

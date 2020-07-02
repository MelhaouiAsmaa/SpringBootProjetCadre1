package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.EmployeeFonction;
import com.demo.model.EmployeeFonctionId;

public interface EmployeeFonctionRepo extends JpaRepository<EmployeeFonction, Long> {

	@Query("select empfct from EmployeeFonction empfct where empfct.pkFonctionemp=:id")
	EmployeeFonction getOne(EmployeeFonctionId id);

}

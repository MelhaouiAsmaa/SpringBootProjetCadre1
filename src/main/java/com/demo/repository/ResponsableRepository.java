package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
@Query("select r from Responsable r where r.pkResponsable.departement.idDepartement=?1")
List<Responsable> getResponsablesByDept(Long id);
}

package com.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Responsable;
import com.demo.model.ResponsableId;

public interface ResponsableRepository extends JpaRepository<Responsable, ResponsableId> {
@Query("select r from Responsable r where r.pkResponsable.departement.idDepartement=?1")
List<Responsable> getResponsablesByDept(Long id);
@Query("select r from Responsable r where r.archive=?1")
List<Responsable> listerResponsable(Boolean a);
@Query("select r from Responsable r where r.pkResponsable.dateDebutRes<= ?1 and  r.dateFinRes>= ?1 and r.pkResponsable.departement.idDepartement=?2 and r.archive=false ")
Responsable getResponsableCourant(Date a,Long b);
@Transactional
@Modifying
@Query("Update Responsable r set r.archive=?1 where r.pkResponsable=?2")
void Modifier(Boolean a,ResponsableId b);
}

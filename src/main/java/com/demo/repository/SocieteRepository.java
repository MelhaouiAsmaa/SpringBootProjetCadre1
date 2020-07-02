package com.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.*;
public interface SocieteRepository extends JpaRepository<Societe,Integer>{
@Query("select s from Societe s where s.archive=?1")
List<Societe> lister(Boolean a);
@Transactional
@Modifying
@Query("update  Societe s set s.archive=?1 where s.idsociete=?2")
void modifier(Boolean a , int b);
}

package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Fonction;

public interface FonctionRepository extends JpaRepository<Fonction, Long>, FonctionRepositoryCustom {

}

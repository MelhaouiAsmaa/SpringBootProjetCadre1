package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>, EquipeRepoCustom {

}

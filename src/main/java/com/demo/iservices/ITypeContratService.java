package com.demo.iservices;

import java.util.List;

import com.demo.model.TypeContrat;

public interface ITypeContratService {

	public TypeContrat saveOrUpdateContrat(TypeContrat contrat);
 public TypeContrat getTypeById(Integer id);
 public List<TypeContrat> getAllTypeContrat();
 public void DeleteTypeContrat(TypeContrat type);
 public int trouverParNom(String nom);
 public List<TypeContrat> getAllTypeContratArchive();
 public void modifierArchive(Boolean a,int id);
 public TypeContrat findIdarchive(String a);
}

package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.ITypeContratService;
import com.demo.model.TypeContrat;
import com.demo.repository.TypeContratRepository;

@Service 
public class TypeContratService implements ITypeContratService{
@Autowired
TypeContratRepository contrat1;
	@Override
	public TypeContrat saveOrUpdateContrat(TypeContrat contrat) {
		
		return contrat1.save(contrat);
	}

	@Override
	public TypeContrat getTypeById(Integer id) {
		
		return contrat1.getOne(id);
	}

	@Override
	public List<TypeContrat> getAllTypeContrat() {
		// TODO Auto-generated method stub
		
		return contrat1.findTypeContrat(false);
	}

	@Override
	public void DeleteTypeContrat(TypeContrat type) {
		// TODO Auto-generated method stub
		contrat1.SupprimerTypeContrat(true,type.getId_typeC());
	}

	@Override
	public int trouverParNom(String nom) {
		// TODO Auto-generated method stub
		return contrat1.findByNom(nom);
	}

	@Override
	public List<TypeContrat> getAllTypeContratArchive() {
		// TODO Auto-generated method stub
		return contrat1.findTypeContrat(true);
	}

	@Override
	public void modifierArchive(Boolean a, int id) {
		// TODO Auto-generated method stub
		contrat1.SupprimerTypeContrat(a, id);
	}

	@Override
	public TypeContrat findIdarchive(String a) {
		// TODO Auto-generated method stub
		return contrat1.findIdArchive(a);
	}

}

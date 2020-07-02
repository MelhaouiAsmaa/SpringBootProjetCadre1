package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IDepartementService;
import com.demo.model.Departement;
import com.demo.model.Responsable;
import com.demo.repository.DepartementRepository;

@Service
public class DepartementService implements IDepartementService {

	@Autowired DepartementRepository repo;
	@Override
	public Departement saveOrupdateDep(Departement dep) {
		// TODO Auto-generated method stub
		return repo.save(dep);
	}

	@Override
	public Departement getDepById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<Departement> getAllDeps() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteDep(Departement dep) {
		// TODO Auto-generated method stub
		repo.delete(dep);
	}

	@Override
	public int trouverNom(String a) {
		// TODO Auto-generated method stub
		return repo.trouverNomDepartement(a);
	}

	@Override
	public List<Departement> findAllDepartementNoArchive() {
		// TODO Auto-generated method stub
		return repo.FindDepartement(false);
	}

	@Override
	public List<Departement> findAllDepartementArchive() {
		// TODO Auto-generated method stub
		return repo.FindDepartement(true);
	}

	@Override
	public void modifierDept(Boolean a, Long b) {
		// TODO Auto-generated method stub
		repo.ModifierArchive(a, b);
	}

	@Override
	public Departement TrouverDepartement(String a) {
		// TODO Auto-generated method stub
		return repo.TrouverDept(a);
	}

	@Override
	public Responsable listerResponsableDept(Long id) {
		// TODO Auto-generated method stub
		return repo.listerResponsableDepartement(id);
	}

}

package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IFonctionService;
import com.demo.model.Fonction;
import com.demo.repository.FonctionRepository;

@Service
public class FonctionService implements IFonctionService {

	@Autowired FonctionRepository repo;
	@Override
	public Fonction saveOrupdateFonction(Fonction fct) {
		// TODO Auto-generated method stub
		fct.setArchive(false);
		return repo.save(fct);
	}

	@Override
	public void DeleteFonction(Fonction fct) {
		// TODO Auto-generated method stub
//		repo.delete(fct);
		fct.setArchive(true);
		repo.save(fct);
		if(fct.isArchive())
			System.out.println("fct archive !" + fct.isArchive());
		else
			System.out.println("archivage failed :(");
	}

	@Override
	public List<Fonction> getAllFonctions() {
		// TODO Auto-generated method stub
//		return repo.findAll();
		return repo.getAllfunctions();
	}

	@Override
	public Fonction getFonctionById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}
	
	@Override
	public Integer EmployeesNumber(Long id)
	{
		Fonction fct = repo.getOne(id);
		if(fct.getEmployees().isEmpty())
		{
			return 0;
		}	
		else
		{
			return repo.EmployeeNumber(id);
		}
		
	}

	
	@Override
	public List<Long> ListEmployeesbyFunction(Long id) {
		// TODO Auto-generated method stub
		List<Long> listes = repo.ListEmployeesbyFunction(id);
		if(listes.isEmpty())
			return null;
		
		return listes;
	}

	@Override
	public List<Fonction> getAllArchivedFonction() {
		// TODO Auto-generated method stub
		return repo.getArchivedFonction();
	}

	@Override
	public void desarchiverFonction(Fonction fct) {
		// TODO Auto-generated method stub
		fct.setArchive(false);
		repo.save(fct);
	}

	@Override
	public Integer EmployeeNumberTotal(Long id) {
		// TODO Auto-generated method stub
		return repo.EmployeeNumbertotal(id);
	}

}

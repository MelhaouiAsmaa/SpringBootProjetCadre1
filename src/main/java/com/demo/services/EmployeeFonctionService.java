package com.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IEmployeeFonctionService;
import com.demo.model.EmployeeFonction;
import com.demo.model.EmployeeFonctionId;
import com.demo.repository.EmployeeFonctionRepo;

@Service
public class EmployeeFonctionService implements IEmployeeFonctionService {

	@Autowired EmployeeFonctionRepo repo;
	@Override
	public EmployeeFonction saveOrupdateEmpFct(EmployeeFonction empfct) {
		// TODO Auto-generated method stub
		return repo.save(empfct);
	}

	@Override
	public List<EmployeeFonction> getAllEmpFct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteEmpFct(EmployeeFonction empfct) {
		// TODO Auto-generated method stub
		repo.delete(empfct);
	}

	@Override
	public EmployeeFonction getEmpFctById(EmployeeFonctionId id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

}

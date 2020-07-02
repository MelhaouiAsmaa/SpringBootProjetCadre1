package com.demo.services;

import java.text.SimpleDateFormat;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IEmployeeEquipeService;
import com.demo.model.EmployeEquipeId;
import com.demo.model.Employee;
import com.demo.model.EmployeeEquipe;
import com.demo.model.Equipe;
import com.demo.repository.EmployeeEquipeRepo;

@Service
public class EmployeeEquipeService implements IEmployeeEquipeService {

	
	@Autowired EmployeeEquipeRepo repo;
	
	
	@Override
	public EmployeeEquipe saveOrupdateEmpEqp(EmployeeEquipe empeqp) {
		// TODO Auto-generated method stub
		System.out.println("service: "+empeqp.toString());
		return repo.save(empeqp);
	}

	@Override
	public List<EmployeeEquipe> getAllEmpEqps() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteEmpEqp(EmployeeEquipe empeqp) {
		// TODO Auto-generated method stub
		repo.delete(empeqp);
	}

	@Override
	public EmployeeEquipe getEmpEqpById(EmployeEquipeId id) {
		// TODO Auto-generated method stub
	
		return repo.getOne(id);
	}

	@Override
	public EmployeeEquipe findByEmployeeandEquipe(Employee emp, Equipe eq) {
		// TODO Auto-generated method stub
		return repo.findByEmployeeAndEquipe(emp,eq);
	}
	
	

}

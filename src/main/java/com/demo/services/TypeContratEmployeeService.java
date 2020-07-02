package com.demo.services;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.ITypeContratEmployeeService;
import com.demo.model.TypeContrat;
import com.demo.model.TypeContratEmployee;
import com.demo.model.TypeContratEmployeeId;
import com.demo.repository.TypeContratEmployeeRepository;
@Service
public class TypeContratEmployeeService implements ITypeContratEmployeeService {
	@Autowired 
	private TypeContratEmployeeRepository rep;
	@Override
	public List<TypeContratEmployee> GetallContratEmployee(Boolean a) {
		// TODO Auto-generated method stub
		return rep.lister_type(a);
	}
	@Override
	public void creerContratEmploye(TypeContratEmployee e) {
		rep.save(e);
		
	}
	@Override
	public void supprimer_contrat(TypeContratEmployeeId e) {
		TypeContratEmployee t=new TypeContratEmployee();
		t=rep.getOne(e);
		t.setArchive(true);
		rep.save(t);
		
	}
	@Override
	public TypeContratEmployee getbyid(TypeContratEmployeeId e) {
		// TODO Auto-generated method stub
		
		return rep.findByPkContrat(e);
	}
	@Override
	public int countPkContrat(TypeContratEmployeeId e) {
		// TODO Auto-generated method stub
		return rep.countByPkContrat(e);
	}
	@Override
	public List<TypeContratEmployee> Getdetail(TypeContrat e) {
		// TODO Auto-generated method stub
		return rep.findAllByPkContratContrat(e);
	}
	@Override
	public void desarchive_contrat(TypeContratEmployeeId e) {
		TypeContratEmployee t=new TypeContratEmployee();
		t=rep.getOne(e);
		t.setArchive(false);
		rep.save(t);
		
	}

}

package com.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IEmployeeChargeService;
import com.demo.model.ChargeEmployee;
import com.demo.model.ChargeEmployeeId;
import com.demo.model.Reporting;
import com.demo.repository.EmployeeChargeRepo;

@Service
public class EmployeeChargeService implements IEmployeeChargeService {

	@Autowired EmployeeChargeRepo repo;
	
	@Override
	public ChargeEmployee saveOrupdateEmpCharge(ChargeEmployee empcharge) {
		// TODO Auto-generated method stub
		return repo.save(empcharge);
	}

	@Override
	public ChargeEmployee getEmpChargeById(ChargeEmployeeId id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<ChargeEmployee> getAllEmpCharges() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteEmpCharge(ChargeEmployee empcharge) {
		// TODO Auto-generated method stub
		repo.delete(empcharge);
	}

	@Override
	public List<Reporting> reporting(int  a) {
		// TODO Auto-generated method stub
		List<Reporting> rep=new ArrayList<Reporting>();
		List<Object> liste=repo.reporting(a);
		Iterator itr = liste.iterator();
		int i=0;
		while(itr.hasNext()){
			   Object[] obj = (Object[]) itr.next();
			   //now you have one array of Object for each row
			   int b = Integer.parseInt(String.valueOf(obj[0])); // don't know the type of column CLIENT assuming String 
			   Double c = Double.parseDouble((String.valueOf(obj[1]))); //SERVICE assumed as int
			   //same way for all obj[2], obj[3], obj[4]
			   rep.add(new Reporting(b,c));
			   i++;
			   
			}
		return rep;
	}
}

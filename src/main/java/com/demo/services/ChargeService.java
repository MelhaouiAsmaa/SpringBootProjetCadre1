package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IChargeService;
import com.demo.model.Charge;
import com.demo.repository.ChargeRepository;

@Service
public class ChargeService implements IChargeService {

	@Autowired ChargeRepository repo;
	
	@Override
	public Charge saveOrupdateCharge(Charge charge) {
		// TODO Auto-generated method stub
		return repo.save(charge);
	}

	@Override
	public Charge getChargeById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<Charge> getAllCharges() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteCharge(Charge charge) {
		// TODO Auto-generated method stub
		repo.delete(charge);
	}

	@Override
	public List<Charge> listerNonArchive(Boolean a) {
		// TODO Auto-generated method stub
		return repo.listercharges(a);
	}

	@Override
	public void archiver(boolean a, Long b) {
		// TODO Auto-generated method stub
		repo.modifier(a, b);
	}

	@Override
	public Integer calculer_type(String a) {
		// TODO Auto-generated method stub
		return repo.counttype(a);
	}

	@Override
	public Charge getType(String a) {
		// TODO Auto-generated method stub
		return repo.getChargeByType(a);
	}

}

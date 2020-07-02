package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.ICongeService;
import com.demo.model.Conge;
import com.demo.repository.CongeRepository;

@Service
public class CongeService implements ICongeService {

	@Autowired CongeRepository repo;
	
	@Override
	public Conge saveOrupdateConge(Conge conge) {
		// TODO Auto-generated method stub
		return repo.save(conge);
	}

	@Override
	public Conge getCongeById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<Conge> getAllConges() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteConge(Conge conge) {
		// TODO Auto-generated method stub
		repo.delete(conge);
	}

}

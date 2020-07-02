package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.ISocieteService;
import com.demo.model.Societe;
import com.demo.repository.SocieteRepository;
@Service
public class SocieteService implements ISocieteService {

	@Autowired 
	private SocieteRepository rep;
	@Override
	public void create(Societe s) {
		// TODO Auto-generated method stub
		rep.save(s);

	}
	@Override
	public List<Societe> lister(Boolean a) {
		// TODO Auto-generated method stub
		return rep.lister(a);
	}
	@Override
	public void modifier(Boolean a, int b) {
		// TODO Auto-generated method stub
		rep.modifier(a, b);
	}
	@Override
	public Societe getsociete(int id) {
		// TODO Auto-generated method stub
		return rep.getOne(id);
	}

}

package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IPointageService;
import com.demo.model.Pointage;
import com.demo.repository.PointageRepository;
@Service
public class PointageService implements IPointageService {

	@Autowired 
	private PointageRepository rep;
	
	@Override
	public Pointage create_pointage(Pointage p) {
		// TODO Auto-generated method stub
		return rep.save(p);
		
	}

	@Override
	public List<Pointage> lister_pointage(Boolean a) {
		
		return rep.lister(a);
	}

	@Override
	public void archive_desarchive(Boolean a, int b) {
		rep.archive_desarchive(a, b);
		
	}

	@Override
	public Pointage getPointage(int id) {
		// TODO Auto-generated method stub
		return rep.getOne(id);
	}
	

}

package com.demo.services;

import java.sql.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IResponsableService;
import com.demo.model.Responsable;
import com.demo.model.ResponsableId;
import com.demo.repository.ResponsableRepository;

@Service
public class ResponsableService implements IResponsableService {

	@Autowired ResponsableRepository repo;
	@Override
	public Responsable saveOrupdateRespo(Responsable respo) {
		// TODO Auto-generated method stub
		return repo.save(respo);
	}

	@Override
	public Responsable getRespoById(ResponsableId id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<Responsable> getAllRespo(Boolean a) {
		// TODO Auto-generated method stub
		return repo.listerResponsable(a);
	}

	@Override
	public void DeleteRespo(Responsable respo) {
		// TODO Auto-generated method stub
		repo.delete(respo);
	}

	@Override
	public List<Responsable> getResponsableByDept(Long a) {
		// TODO Auto-generated method stub
		return repo.getResponsablesByDept(a);	}

	@Override
	public Responsable getResponsableCourant(Date a, Long b) {
		// TODO Auto-generated method stub
		return repo.getResponsableCourant(a, b);
	}

	@Override
	public void Modifier(Boolean a, ResponsableId b) {
		repo.Modifier(a, b);
		
	}

}

package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IJourFerieService;
import com.demo.model.JourFerie;
import com.demo.repository.JourFerieRepository;

@Service
public class JourFerieService implements IJourFerieService {

	@Autowired JourFerieRepository repo;
	
	@Override
	public JourFerie saveOrupdateJourFerie(JourFerie jourferie) {
		// TODO Auto-generated method stub
		return repo.save(jourferie);
	}

	@Override
	public void DeleteJourFerie(JourFerie jourferie) {
		// TODO Auto-generated method stub
		repo.delete(jourferie);
	}

	@Override
	public List<JourFerie> getAllJourFeries() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public JourFerie getJourFerieById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

}

package com.demo.iservices;

import java.util.List;

import com.demo.model.Conge;


public interface ICongeService {
	
	public Conge saveOrupdateConge(Conge conge);
	public Conge getCongeById(Long id);
	public List<Conge> getAllConges();
	public void DeleteConge(Conge conge);

}

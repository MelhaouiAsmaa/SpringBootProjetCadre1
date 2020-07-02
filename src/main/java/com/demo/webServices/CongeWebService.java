package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.ICongeService;
import com.demo.model.Conge;

@RestController
@RequestMapping("api/conge")
@CrossOrigin(origins = "*")
public class CongeWebService {

	@Autowired ICongeService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Conge> getAll() {
		return service.getAllConges();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Conge Save(@RequestBody Conge conge) {
		return service.saveOrupdateConge(conge);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Conge Update(@RequestBody Conge conge) {
		return service.saveOrupdateConge(conge);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void Delete(@PathVariable Long id) {
		 service.DeleteConge(service.getCongeById(id));
	}
	
	@RequestMapping(value="/getConge/{id}", method=RequestMethod.GET)
	public Conge getConge(@PathVariable Long id)
	{
		return service.getCongeById(id);
	}
}

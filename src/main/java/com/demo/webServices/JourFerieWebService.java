package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IJourFerieService;
import com.demo.model.JourFerie;

@RestController
@RequestMapping("api/JourFerie")
@CrossOrigin(origins = "*")
public class JourFerieWebService {

	@Autowired IJourFerieService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<JourFerie> getAll() {
		return service.getAllJourFeries();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public JourFerie Save(@RequestBody JourFerie JourFerie) {
		return service.saveOrupdateJourFerie(JourFerie);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public JourFerie Update(@RequestBody JourFerie JourFerie) {
		return service.saveOrupdateJourFerie(JourFerie);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.PUT)
	public void Delete(@RequestBody Long id) {
		 service.DeleteJourFerie(service.getJourFerieById(id));
	}
	
	@RequestMapping(value="/getJourFerie/{id}", method=RequestMethod.GET)
	public JourFerie getJourFerie(@PathVariable Long id)
	{
		return service.getJourFerieById(id);
	}
	
}

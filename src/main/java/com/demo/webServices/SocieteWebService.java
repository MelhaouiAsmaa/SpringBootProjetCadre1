package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Societe;
import com.demo.services.SocieteService;

@RestController
@RequestMapping("/Societe")
@CrossOrigin(origins = "*")
public class SocieteWebService {
	@Autowired private SocieteService service;
	@RequestMapping(value="/save", method=RequestMethod.POST)
	void create(@RequestBody Societe s)
	{System.out.println("hanae");
		s.setArchive(false);
		service.create(s);
	}
	
	@RequestMapping(value="/lister", method=RequestMethod.GET)
	List<Societe> lister()
	{
		return service.lister(false);
	}
	@RequestMapping(value="/listerarchive", method=RequestMethod.GET)
	List<Societe> listeratchive()
	{
		return service.lister(true);
	}
	
	@RequestMapping(value="/archive/{id}", method=RequestMethod.DELETE)
	void archive(@PathVariable int id)
	{
		service.modifier(true, id);
	}
	
	@RequestMapping(value="/desarchive/{id}", method=RequestMethod.DELETE)
	void desarchive(@PathVariable int id)
	{
		service.modifier(false, id);
	}
	
	@RequestMapping(value="/getsociete/{id}", method=RequestMethod.GET)
	Societe get(@PathVariable int id)
	{
		System.out.println(service.getsociete(id));
		return service.getsociete(id);
	}
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	void get(@RequestBody Societe s)
	{
		service.create(s);
	}

}

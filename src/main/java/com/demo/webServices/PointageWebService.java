package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Departement;
import com.demo.model.Pointage;
import com.demo.services.PointageService;

@RestController
@RequestMapping("/Pointage")
@CrossOrigin(origins = "*")
public class PointageWebService {
	@Autowired 
	private PointageService service;
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Pointage create(@RequestBody Pointage p) {
		p.setArchive(false);
		return service.create_pointage(p);
	}
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Pointage> lister()
	{
		return service.lister_pointage(false);
	}
	@RequestMapping(value="/getAllArchive", method=RequestMethod.GET)
	public List<Pointage> listerarchive()
	{
		return service.lister_pointage(true);
	}
	@RequestMapping(value="/archive/{id}", method=RequestMethod.DELETE)
	public void archiver(@PathVariable int id)
	{
		service.archive_desarchive(true, id);
	}
	@RequestMapping(value="/desarchive/{id}", method=RequestMethod.DELETE)
	public void desarchiver(@PathVariable int id)
	{
		service.archive_desarchive(false, id);
	}
	@RequestMapping(value="/updatePointage", method=RequestMethod.PUT)
	public void modifier(@RequestBody Pointage p)
	{
		service.create_pointage(p);
	}
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public Pointage getByid(@PathVariable int id)
	{
		return service.getPointage(id);
	}
}

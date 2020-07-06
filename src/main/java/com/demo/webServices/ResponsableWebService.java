package com.demo.webServices;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IResponsableService;
import com.demo.model.Responsable;
import com.demo.model.ResponsableId;

@RestController
@RequestMapping("api/responsable")
@CrossOrigin(origins = "*")
public class ResponsableWebService {

	@Autowired IResponsableService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Responsable> getAll() {
		long millis=System.currentTimeMillis(); 
		List<Responsable> r=service.getAllRespo(false);
		Date d= new java.sql.Date(millis);
		String s1,s2;
		for(int i=0;i<r.size();i++)
		{
			s1=String.valueOf(r.get(i).getDateFinRes());
			s2=String.valueOf(d);
			if(s1.equals(s2))
				{
				
				r.get(i).setArchive(true);
			service.saveOrupdateRespo(r.get(i));
				}
		}
		return service.getAllRespo(false);
	}
	@RequestMapping(value="/getAllArchive", method=RequestMethod.GET)
	public List<Responsable> getAllArchive() {
		return service.getAllRespo(true);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Responsable Save(@RequestBody Responsable respo) {
		long millis=System.currentTimeMillis();  
		Responsable r=service.getResponsableCourant(new java.sql.Date(millis), respo.getPkResponsable().getDepartement().getIdDepartement());
	if(r!=null)
	{
		r.setArchive(true);
		r.setDateFinRes(new java.sql.Date(millis));
	}
	if(respo.pkResponsable.getDateDebutRes()==null)
		{
		
	respo.pkResponsable.setDateDebutRes(new java.sql.Date(millis));
		}
		
		respo.setArchive(false);
		return service.saveOrupdateRespo(respo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Responsable Update(@RequestBody Responsable respo) {
		return service.saveOrupdateRespo(respo);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void Delete(@PathVariable ResponsableId id) {
		 service.DeleteRespo(service.getRespoById(id));
	}
	
	@RequestMapping(value="/getResponsable", method=RequestMethod.POST)
	public Responsable getResponsable(@RequestBody ResponsableId id)
	{
		return service.getRespoById(id);
	}
	
	@RequestMapping(value="/getResponsableDepartement/{id}", method=RequestMethod.GET)
	public List<Responsable> getResponsableByDept(@PathVariable Long id)
	{
		
		return service.getResponsableByDept(id);
	}

	@RequestMapping(value="/archiver", method=RequestMethod.POST)
	public void archiver(@RequestBody ResponsableId respo) {
		Responsable r=service.getRespoById(respo);
		long millis=System.currentTimeMillis();  
		r.setDateFinRes(new java.sql.Date(millis));
		service.Modifier(true, respo);
	}
	@RequestMapping(value="/desarchiver", method=RequestMethod.POST)
	public void desarchiver(@RequestBody ResponsableId respo) {
		long millis=System.currentTimeMillis();  
		Responsable r=service.getRespoById(respo);
	Responsable r1=service.getResponsableCourant(new java.sql.Date(millis), respo.getDepartement().getIdDepartement());
	if(r1!=null)
	{r1.setArchive(true);
	r1.setDateFinRes(new java.sql.Date(millis));}
		
		r.setDateFinRes(Date.valueOf("2100-01-01"));
	service.Modifier(false, respo);
	}


	}

	


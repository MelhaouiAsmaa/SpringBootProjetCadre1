package com.demo.webServices;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IDepartementService;
import com.demo.model.Departement;
import com.demo.model.Responsable;

@RestController
@RequestMapping("api/departement")
@CrossOrigin(origins = "*")
public class DepartementWebService {
	
	@Autowired IDepartementService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Departement> getAll() {
		
		return service.findAllDepartementNoArchive();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void Save(@RequestBody Departement dep) {
		int x= service.trouverNom(dep.getNomDepartement());
		if(x==0)
		{
		service.saveOrupdateDep(dep);
		service.modifierDept(false, service.TrouverDepartement(dep.getNomDepartement()).getIdDepartement());
		}
		else {
			if(service.TrouverDepartement(dep.getNomDepartement()).isArchive()==true)
				service.modifierDept(false, service.TrouverDepartement(dep.getNomDepartement()).getIdDepartement());
		}
		
				}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Departement Update(@RequestBody Departement dep) {
		return service.saveOrupdateDep(dep);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void Delete(@PathVariable Long id) {
		 service.modifierDept(true, id);
	}
	
	@RequestMapping(value="/dessarchiver/{id}", method=RequestMethod.PUT)
	public void Desarchiver(@PathVariable Long id) {
		 service.modifierDept(false, id);
	}
	@RequestMapping(value="/getDepartement/{id}", method=RequestMethod.GET)
	public Departement getDepartement(@PathVariable Long id)
	{
		return service.getDepById(id);
	}
	@RequestMapping(value="/getAllDeptArchive", method=RequestMethod.GET)
	public List<Departement> getAllDepartementArchive()
	{
		return service.findAllDepartementArchive();
	}
	@RequestMapping(value="/getAllRespDpt", method=RequestMethod.GET)
	public Responsable getResponsableDept()
	{
		return service.listerResponsableDept(Long.parseLong("1"));
	}

}





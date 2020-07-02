package com.demo.webServices;

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

@RestController
@RequestMapping("api/responsable")
@CrossOrigin(origins = "*")
public class ResponsableWebService {

	@Autowired IResponsableService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Responsable> getAll() {
		return service.getAllRespo();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Responsable Save(@RequestBody Responsable respo) {
		return service.saveOrupdateRespo(respo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Responsable Update(@RequestBody Responsable respo) {
		return service.saveOrupdateRespo(respo);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void Delete(@PathVariable Long id) {
		 service.DeleteRespo(service.getRespoById(id));
	}
	
	@RequestMapping(value="/getResponsable/{id}", method=RequestMethod.GET)
	public Responsable getResponsable(@PathVariable Long id)
	{
		return service.getRespoById(id);
	}
	
	@RequestMapping(value="/getResponsableDepartement/{id}", method=RequestMethod.GET)
	public List<Responsable> getResponsableByDept(@PathVariable Long id)
	{
		System.out.println(service.getResponsableByDept(id));
		return service.getResponsableByDept(id);
	}

	
}

package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IFonctionService;
import com.demo.model.EmployeEquipeId;
import com.demo.model.Employee;
import com.demo.model.Fonction;

@RestController
@RequestMapping("api/fonction")
@CrossOrigin(origins = "*")
public class FonctionWebService {

@Autowired IFonctionService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Fonction> getAll() {
		return service.getAllFonctions();
	}
	
	@RequestMapping(value="/getArchived", method=RequestMethod.GET)
	public List<Fonction> getAllArchived() {
		return service.getAllArchivedFonction();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Fonction Save(@RequestBody Fonction Fonction) {
		return service.saveOrupdateFonction(Fonction);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Fonction Update(@RequestBody Fonction Fonction) {
		return service.saveOrupdateFonction(Fonction);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.PUT)
	public void Delete(@RequestBody Long id) {
		 service.DeleteFonction(service.getFonctionById(id));
	}
	
	@RequestMapping(value="/desarchiver", method=RequestMethod.PUT)
	public void desarchiverFonction(@RequestBody Long id) {
		 service.desarchiverFonction(service.getFonctionById(id));
	}
	
	@RequestMapping(value="/getFonction/{id}", method=RequestMethod.GET)
	public Fonction getFonction(@PathVariable Long id)
	{
		return service.getFonctionById(id);
	}
	@RequestMapping(value = "/getEmployeesNumb/{id}", method = RequestMethod.GET)
	public Integer GetEmpNumb(@PathVariable Long id)
	{
		return service.EmployeesNumber(id);
	}
	@RequestMapping(value = "/getEmployeesNumbtotal/{id}", method = RequestMethod.GET)
	public Integer GetEmpNumbtotal(@PathVariable Long id)
	{
		return service.EmployeeNumberTotal(id);
	}
	@RequestMapping(value = "/getListEmployees/{id}", method = RequestMethod.GET)
	public List<Long> EmployeesByFunction(@PathVariable Long id)
	{
		return service.ListEmployeesbyFunction(id);
	}
}

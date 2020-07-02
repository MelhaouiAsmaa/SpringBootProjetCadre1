package com.demo.webServices;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IEquipeService;
import com.demo.model.Equipe;

@RestController
@RequestMapping("api/equipe")
@CrossOrigin(origins = "*")
public class EquipeWebService {

@Autowired IEquipeService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Equipe> getAll() {
		return service.getAllEquipe();
	}
	
	@RequestMapping(value="/getArchived", method=RequestMethod.GET)
	public List<Equipe> getAllArchived() {
		return service.getAllArchivedEquipe();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Equipe Save(@RequestBody Equipe Equipe) {
		return service.saveOrupdateEquipe(Equipe);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Equipe Update(@RequestBody Equipe Equipe) {
		return service.saveOrupdateEquipe(Equipe);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.PUT)
	public void Delete(@RequestBody Long id) {
		 service.DeleteEquipe(id);
//		 System.out.println(service.getEquipeById(id));
	}
	
	@RequestMapping(value="/desarchiver", method=RequestMethod.PUT)
	public void desarchiverEquipe(@RequestBody Long id) {
		 service.desarchiverEquipe(service.getEquipeById(id));
	}
	
	@RequestMapping(value="/getEquipe/{id}", method=RequestMethod.GET)
	public Equipe getEquipe(@PathVariable Long id)
	{
		return service.getEquipeById(id);
	}
	
	@RequestMapping(value = "/getDepNameByEquipe/{id}", method = RequestMethod.GET)
	public String GetDepartmentNameByEquipe(@PathVariable Long id)
	{
		return service.DepartmentNameByEquipe(id);
	}
	
	@RequestMapping(value = "/getResponsableEquipe/{id}", method = RequestMethod.GET)
	public String getRespoEquipe(@PathVariable Long id)
	{
		return service.ResponsableEquipe(id);
	}
	
	@RequestMapping(value = "/getEmployeesEquipe/{id}", method = RequestMethod.GET)
	public List<LinkedHashMap<String, String>> getEmployeesByEquipe(@PathVariable Long id)
	{
		return service.ListEmployebyEquipe(id);
	}
	
	@RequestMapping(value = "/getEquipeDepartement/{id}", method = RequestMethod.GET)
	public List<Equipe> getEquipeByDept(@PathVariable Long id)
	{
		
		return service.getEquipeDept(id);
	}
	
}

package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IEmployeeFonctionService;
import com.demo.model.EmployeeFonction;
import com.demo.model.EmployeeFonctionId;

@RestController
@RequestMapping("api/Employeefonction")
@CrossOrigin(origins = "*")
public class EmployeeFonctionWebService {

@Autowired IEmployeeFonctionService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<EmployeeFonction> getAll() {
		return service.getAllEmpFct();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public EmployeeFonction Save(@RequestBody EmployeeFonction empfct) {
		return service.saveOrupdateEmpFct(empfct);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public EmployeeFonction Update(@RequestBody EmployeeFonction empfct) {
		return service.saveOrupdateEmpFct(empfct);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void Delete(@RequestBody EmployeeFonctionId id) {
		 service.DeleteEmpFct(service.getEmpFctById(id));
	}
	
	@RequestMapping(value="/getEmployeeFonction", method=RequestMethod.POST)
	public EmployeeFonction getEmployeeFonction(@RequestBody EmployeeFonctionId id)
	{
		
		return service.getEmpFctById(id);
	}

}


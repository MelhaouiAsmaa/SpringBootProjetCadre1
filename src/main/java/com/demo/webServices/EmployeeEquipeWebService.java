package com.demo.webServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IEmployeeEquipeService;
import com.demo.iservices.IEmployeeService;
import com.demo.iservices.IEquipeService;
import com.demo.model.EmployeEquipeId;
import com.demo.model.Employee;
import com.demo.model.EmployeeEquipe;
import com.demo.model.Equipe;

@RestController
	@RequestMapping("api/emloyeeequipe")
	@CrossOrigin(origins = "*")

public class EmployeeEquipeWebService {
	
	
	
		@Autowired IEmployeeEquipeService service;
		@Autowired IEmployeeService serviceemployee;
		@Autowired IEquipeService serviceequipe;
		
		@RequestMapping(value="/getAll", method=RequestMethod.GET)
		public List<EmployeeEquipe> getAll() {
			return service.getAllEmpEqps();
		}
		
		@RequestMapping(value="/save", method=RequestMethod.POST)
		public EmployeeEquipe Save(@RequestBody EmployeeEquipe empeqp) {
			System.out.println("web service: "+empeqp.toString());
			return service.saveOrupdateEmpEqp(empeqp);
		}
		
		@RequestMapping(value="/update", method=RequestMethod.PUT)
		public EmployeeEquipe Update(@RequestBody EmployeeEquipe empeqp) {
			return service.saveOrupdateEmpEqp(empeqp);
		}
		
		@RequestMapping(value="/delete", method=RequestMethod.POST)
		public void Delete(@RequestBody EmployeEquipeId id) {
			 service.DeleteEmpEqp(service.getEmpEqpById(id));
		}
		
		@RequestMapping(value="/getEmployeeEquipe", method=RequestMethod.POST)
		public EmployeeEquipe getEmployeeEquipe(@RequestBody EmployeEquipeId id)
		{
			return service.getEmpEqpById(id);
		}

		@RequestMapping(value="/findByEmployeeandEquipe/{idemp}/{ideq}", method=RequestMethod.GET)
		public EmployeeEquipe getEmployeeEquipe(@PathVariable Long idemp, @PathVariable Long ideq)
		{
			Employee emp = serviceemployee.getById(idemp);
			Equipe eq = serviceequipe.getEquipeById(ideq);
			return service.findByEmployeeandEquipe(emp, eq);
		}
	}



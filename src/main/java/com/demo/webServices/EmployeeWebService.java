package com.demo.webServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IEmployeeService;
import com.demo.model.ChargeEmployee;
import com.demo.model.Conge;
import com.demo.model.Employee;
import com.demo.model.EmployeeFonction;
import com.demo.model.Equipe;
import com.demo.model.TypeContratEmployee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeWebService {
	
	@Autowired IEmployeeService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Employee> getAll() {
		return service.getAllEmployees();
	}
	
	@RequestMapping(value="/getArchived", method=RequestMethod.GET)
	public List<Employee> getArchived() {
		return service.getAllArchived();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Employee Save(@RequestBody Employee emp) {
		return service.saveOrEmployee(emp);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Employee Update(@RequestBody Employee emp) {
		return service.saveOrEmployee(emp);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.PUT)
	public void Delete(@RequestBody Long id) {
		 service.DeleteEmployee(service.getById(id));
	}
	
	@RequestMapping(value="/desarchiver", method=RequestMethod.PUT)
	public Employee Desarchiver(@RequestBody Long id) {
		return service.Desarchiver(service.getById(id));
	}
	
	@RequestMapping(value="/getEmployee/{id}", method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable Long id)
	{
		return service.getById(id);
	}
	
	@RequestMapping(value = "/getLatestEmployee", method = RequestMethod.GET)
	public Long GetLatestEmployeeId()
	{
		return service.GetLatestEmpId();
	}
	
	@RequestMapping(value = "/getActualFonctionEmployee/{id}", method = RequestMethod.GET)
	public String getActualFonctionEmployee(@PathVariable Long id)
	{
		return service.getActualFonctionEmployee(id);
	}

	@RequestMapping(value = "/getActualEquipeEmployee/{id}", method = RequestMethod.GET)
	public String getActualEquipeEmployee(@PathVariable Long id)
	{
		return service.getActualEquipeEmployee(id);
	}
	
	@RequestMapping(value = "/getFonctionsByEmploye/{id}", method = RequestMethod.GET)
	public List<EmployeeFonction> getFonctionsByEmployee(@PathVariable Long id)
	{
		return service.getFonctionsByEmploye(id);
	}
	
	@RequestMapping(value = "/getEquipeByFonctionsEmployee/{id}/{datedeb}/{datefin}", method = RequestMethod.GET)
	public List<Equipe> getEquipesByemployeeFct(
			@PathVariable Long id, 
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date datedeb, 
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date datefin) 
	{
//		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//		String dateInString1 = datedeb;
//		Date dateDebParsed;
//		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//		String dateInString2 = datefin;
//		Date dateFinParsed;
//		try { 
//			dateDebParsed = formatter1.parse(dateInString1);
//			dateFinParsed = formatter2.parse(dateInString2);
//			return service.getEquipesByemployeeFonction(id, dateDebParsed, dateFinParsed);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		
		return service.getEquipesByemployeeFonction(id, datedeb, datefin);
	}
	
	@RequestMapping(value = "/getActualDepEmployee/{id}", method = RequestMethod.GET)
	public Long getActualDepartmentEmployee(@PathVariable Long id)
	{
		System.out.println("arrived to getActualDepEmployee Backend with id: "+id);
		return service.getActualDepartment(id);
	}
	
	@RequestMapping(value = "/getCongeByEmployee/{id}", method = RequestMethod.GET)
	public List<Conge> getCongeByEmployee(@PathVariable Long id)
	{
		return service.getCongeeByEmployee(id);
	}
	
	@RequestMapping(value = "/getChargeByEmployee/{id}", method = RequestMethod.GET)
	public List<ChargeEmployee> getChargeByEmployee(@PathVariable Long id)
	{
		return service.getChargesByEmployees(id);
	}
	
	@RequestMapping(value = "/getEmployeeUser/{id}", method = RequestMethod.GET)
	public Employee getEmployeeofUser(@PathVariable Long id)
	{
		return service.getUserEmployee(id);
	}
	
	@RequestMapping(value = "/getActualContrat/{id}", method = RequestMethod.GET)
	public TypeContratEmployee getActualContratEmp(@PathVariable Long id)
	{
		return service.getActualContratEmp(id);
	}
}

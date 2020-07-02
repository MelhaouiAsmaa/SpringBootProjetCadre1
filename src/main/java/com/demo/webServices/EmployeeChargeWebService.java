package com.demo.webServices;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IEmployeeChargeService;
import com.demo.model.ChargeEmployeeId;
import com.demo.model.Reporting;
import com.demo.model.ChargeEmployee;

@RestController
@RequestMapping("api/emloyeecharge")
@CrossOrigin(origins = "*")

public class EmployeeChargeWebService {

	@Autowired IEmployeeChargeService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<ChargeEmployee> getAll() {
		return service.getAllEmpCharges();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ChargeEmployee Save(@RequestBody ChargeEmployee empcharge) {
		// System.out.println("web service: "+empcharge.toString());
		return service.saveOrupdateEmpCharge(empcharge);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ChargeEmployee Update(@RequestBody ChargeEmployee empcharge) {
		return service.saveOrupdateEmpCharge(empcharge);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void Delete(@RequestBody ChargeEmployeeId id) {
		 service.DeleteEmpCharge(service.getEmpChargeById(id));
	}
	
	@RequestMapping(value="/getChargeEmployee", method=RequestMethod.POST)
	public ChargeEmployee getChargeEmployee(@RequestBody ChargeEmployeeId id)
	{
		return service.getEmpChargeById(id);
	}
	@RequestMapping(value="/reporting",method=RequestMethod.GET)
	public List<Reporting> reporting()
	{
	
		return service.reporting(Calendar.getInstance().get(Calendar.YEAR));
	}
}

package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.iservices.IChargeService;
import com.demo.model.Charge;

@RestController
@RequestMapping("api/charge")
@CrossOrigin(origins = "*")
public class ChargeWebService {

@Autowired IChargeService service;
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void create(@RequestBody Charge c)
	{
		int x=service.calculer_type(c.getTypeCharge());
		if(x==0)
		{
			c.setArchive(false);
			
			service.saveOrupdateCharge(c);	
		}
		else 
		{
			if(service.getType(c.getTypeCharge()).isArchive()==true)
				service.archiver(false, service.getType(c.getTypeCharge()).getIdCharge());
			
		}
		
	}
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Charge> listerNonArchive()
	{
	return service.listerNonArchive(false);
	}
	
	@RequestMapping(value="/getAllArchive",method=RequestMethod.GET)
	public List<Charge> listerArchive()
	{
	return service.listerNonArchive(true);
	}
	
	@RequestMapping(value="/archive/{id}",method=RequestMethod.DELETE)
	public void Archive(@PathVariable Long id)
	{
	 service.archiver(true, id);
	}
	
	@RequestMapping(value="/desarchive/{id}",method=RequestMethod.DELETE)
	public void desarchive(@PathVariable Long id)
	{
	 service.archiver(false, id);
	}


	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Charge Update(@RequestBody Charge charge) {
		return service.saveOrupdateCharge(charge);
	}

	
	@RequestMapping(value="/getCharge/{id}", method=RequestMethod.GET)
	public Charge getCharge(@PathVariable Long id)
	{
		return service.getChargeById(id);
	}
}

package com.demo.webServices;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Charge;
import com.demo.model.ChargeDepartement;
import com.demo.model.ChargeDepartementId;
import com.demo.model.Reporting;
import com.demo.services.ChargeDepartementService;

@RestController
@RequestMapping("/ChargeDepartement")
@CrossOrigin(origins = "*")
public class ChargeDepartementWebService {
@Autowired 
private ChargeDepartementService service;
@RequestMapping(value="/create",method=RequestMethod.POST)
public void create(@RequestBody ChargeDepartement c)
{
	service.SaveOrUpdate(c);
}
@RequestMapping(value="/getAll",method=RequestMethod.GET)
public List<ChargeDepartement> getAll()
{
	return service.lister(false);
}
@RequestMapping(value="/getAllArchive",method=RequestMethod.GET)
public List<ChargeDepartement> getAllArchive()
{
	return service.lister(true);
}
@RequestMapping(value="/archive",method=RequestMethod.POST)
public void delete(@RequestBody ChargeDepartementId a)
{
	service.archiveDesarchive(true, a);
}
@RequestMapping(value="/desarchive",method=RequestMethod.POST)
public void desarchive(@RequestBody ChargeDepartementId a)
{
	service.archiveDesarchive(false, a);
}
@RequestMapping(value="/getchargedep",method=RequestMethod.POST)
public ChargeDepartement getchargedept(@RequestBody ChargeDepartementId id)
{System.out.println(service.getCharge(id));
	return service.getCharge(id);
}
@RequestMapping(value="/reporting",method=RequestMethod.GET)
public List<Reporting> reporting()
{
	System.out.println(service.reporting(Calendar.getInstance().get(Calendar.YEAR)));
	//System.out.println(service.reporting(Calendar.getInstance().get(Calendar.YEAR)));
	return service.reporting(Calendar.getInstance().get(Calendar.YEAR));
}

}

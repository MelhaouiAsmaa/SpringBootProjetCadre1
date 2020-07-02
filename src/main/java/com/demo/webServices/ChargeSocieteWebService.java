package com.demo.webServices;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ChargeSociete;
import com.demo.model.ChargeSocieteId;
import com.demo.model.Reporting;
import com.demo.services.ChargeSocieteService;

@RestController
@RequestMapping("/ChargeSociete")
@CrossOrigin(origins = "*")
public class ChargeSocieteWebService {
@Autowired 
private ChargeSocieteService service;
@RequestMapping(value="/create",method=RequestMethod.POST)
public void create(@RequestBody ChargeSociete s)
{
s.setArchive(false);
service.create(s);
}


@RequestMapping(value="/lister",method=RequestMethod.GET)
public List<ChargeSociete> lister()
{
return service.lister();
}



@RequestMapping(value="/listerarchive",method=RequestMethod.GET)
public List<ChargeSociete> listerarchive()
{
return service.ListerArchive();
}


@RequestMapping(value="/archiver",method=RequestMethod.PUT)
public void archiver (@RequestBody ChargeSocieteId c)
{
service.archiver(c);
}


@RequestMapping(value="/desarchiver",method=RequestMethod.PUT)
public void desarchiver(@RequestBody ChargeSocieteId c)
{
service.desarchiver(c);
}

@RequestMapping(value="/get",method=RequestMethod.POST)
public ChargeSociete get(@RequestBody ChargeSocieteId c)
{
return service.get(c);
}



@RequestMapping(value="/modifier",method=RequestMethod.PUT)
public void modifier (@RequestBody ChargeSociete c)
{
service.create(c);
}

@RequestMapping(value="/reporting",method=RequestMethod.GET)
public List<Reporting> reporting()
{
System.out.println("icii");
	return service.reporting(Calendar.getInstance().get(Calendar.YEAR));
}
}

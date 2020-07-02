package com.demo.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.*;
import com.demo.iservices.ITypeContratService;

@RestController
@RequestMapping("/TypeContrat")
@CrossOrigin(origins="*")
public class TypeContratWebService {
@Autowired
ITypeContratService contrat1;

@RequestMapping(value="/getAll",method=RequestMethod.GET)
public List<TypeContrat> getAll()
{
	
	System.out.println(contrat1.getAllTypeContrat());
	return contrat1.getAllTypeContrat();
}
@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
public void Delete(@PathVariable int id)
{
	contrat1.DeleteTypeContrat(contrat1.getTypeById(id));
}
@RequestMapping(value="/dessarchiver/{id}", method=RequestMethod.PUT)
public void Desarchiver(@PathVariable Integer id) {
	 contrat1.modifierArchive(false, id);
}
@RequestMapping(value="/Create",method=RequestMethod.POST)
public void create(@RequestBody TypeContrat contrat)
{
	
	int x=contrat1.trouverParNom(contrat.getLibelle_C());
	//Au cas où le contrat n'existe pas
	if(x==0)
	{
		contrat1.saveOrUpdateContrat(contrat);
		contrat1.modifierArchive(false, contrat.getId_typeC());
	}
	else 
	{
		if(contrat1.findIdarchive(contrat.getLibelle_C()).getArchive()==true)
               contrat1.modifierArchive(false, contrat1.findIdarchive(contrat.getLibelle_C()).getId_typeC());
	}
	
}
@RequestMapping(value="/Update",method=RequestMethod.PUT)
public void updateTypeContrat(@RequestBody TypeContrat contrat )
{
	System.out.println(contrat);
	contrat1.saveOrUpdateContrat(contrat);
	}
@RequestMapping(value="/GetType/{id}",method=RequestMethod.GET)
public TypeContrat getTypeContrat(@PathVariable Integer id)
{System.out.println(id);
	return contrat1.getTypeById(id);
}

@RequestMapping(value="/getAllArchive",method=RequestMethod.GET)
public List<TypeContrat> getalltypearchive()
{
return contrat1.getAllTypeContratArchive();}

}


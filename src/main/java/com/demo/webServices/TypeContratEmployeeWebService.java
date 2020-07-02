package com.demo.webServices;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.model.TypeContrat;
import com.demo.model.TypeContratEmployee;
import com.demo.model.TypeContratEmployeeId;
import com.demo.services.EmployeeService;
import com.demo.services.TypeContratEmployeeService;
import com.demo.services.TypeContratService;

@RestController
@RequestMapping("/TypeContratEmployee")
@CrossOrigin(origins="*")
public class TypeContratEmployeeWebService {
@Autowired
private TypeContratEmployeeService service;

@Autowired
TypeContratService s1;
@Autowired
EmployeeService s;
@RequestMapping(value="/GetAll",method=RequestMethod.GET)
public List<TypeContratEmployee> getAll()
{
	
	return service.GetallContratEmployee(false);
	}
@RequestMapping(value="/create",method=RequestMethod.POST)
public TypeContratEmployee  create(@RequestBody TypeContratEmployee tc)
{
int x=service.countPkContrat(tc.getPkContrat());
if(x==0)
{
	tc.setArchive(false);
	service.creerContratEmploye(tc);
}
else {
	

		tc.setArchive(false);
		

	service.creerContratEmploye(tc);
}

return tc;
}

@RequestMapping(value="/delete",method=RequestMethod.POST)
void archiver(@RequestBody TypeContratEmployeeId id) 
{
	System.out.println(id);
	/**
	Date d=new SimpleDateFormat("yyyy-MM-dd").parse(id3);

	java.sql.Date dateSQL = new java.sql.Date(d.getTime()) ;
	TypeContratEmployee e= new TypeContratEmployee();
	
	System.out.println(dateSQL);
	
	TypeContratEmployeeId tc=new TypeContratEmployeeId();
	tc.setContrat(t);
	tc.setEmployee(emp);

	
	service.supprimer_contrat(e);
	**/

	/**TypeContratEmployeeId tc=new TypeContratEmployeeId();
	
	//Employee emp=new Employee();
	//TypeContrat t=new TypeContrat();
	//emp.setMatricule(id2);
	//t.setId_typeC(id);
	tc.setDate_Contrat(id3);
	tc.setContrat(s1.getTypeById(id));
	tc.setEmployee(s.getById(id2));
	System.out.println(service.getbyid(tc));**/
	System.out.println(service.getbyid(id));
	service.supprimer_contrat(id);
	
	
	}
@RequestMapping(value="/GetAllArchive",method=RequestMethod.GET)
public List<TypeContratEmployee> getAllarchive()
{
	return service.GetallContratEmployee(true);
	}
@RequestMapping(value="/Getcontrat",method=RequestMethod.POST)
public TypeContratEmployee getcontrat(@RequestBody TypeContratEmployeeId e)
{
	
	System.out.println(service.getbyid(e));
return service.getbyid(e);
}
@RequestMapping(value="/Update",method=RequestMethod.PUT)
public void update(@RequestBody TypeContratEmployee e)
{

	System.out.println("iciiic");
service.creerContratEmploye(e);}

@RequestMapping(value="/GetdetailCE/{id}",method=RequestMethod.GET)
public List<TypeContratEmployee> listeremp(@PathVariable Integer id)
{
	System.out.println("iccci");
	TypeContrat e=new TypeContrat();
	e=s1.getTypeById(id);
	System.out.println(service.Getdetail(e));
return service.Getdetail(e);
}
@RequestMapping(value="/dessarchiver", method=RequestMethod.PUT)
public void Desarchiver(@RequestBody TypeContratEmployeeId id) {
	service.desarchive_contrat(id);
}


}

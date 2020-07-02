package com.demo.iservices;

import java.util.List;

import com.demo.model.EmployeEquipeId;
import com.demo.model.Employee;
import com.demo.model.EmployeeEquipe;
import com.demo.model.Equipe;


public interface IEmployeeEquipeService {

	public EmployeeEquipe saveOrupdateEmpEqp(EmployeeEquipe empeqp);
	public EmployeeEquipe getEmpEqpById(EmployeEquipeId id);
	public List<EmployeeEquipe> getAllEmpEqps();
	public void DeleteEmpEqp(EmployeeEquipe empeqp);
	public EmployeeEquipe findByEmployeeandEquipe(Employee idemp, Equipe ideq);
}

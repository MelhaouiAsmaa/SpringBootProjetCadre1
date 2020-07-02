package com.demo.iservices;

import java.util.List;

import com.demo.model.EmployeeFonction;
import com.demo.model.EmployeeFonctionId;


public interface IEmployeeFonctionService {

	public EmployeeFonction saveOrupdateEmpFct(EmployeeFonction empfct);
	public EmployeeFonction getEmpFctById(EmployeeFonctionId id);
	public List<EmployeeFonction> getAllEmpFct();
	public void DeleteEmpFct(EmployeeFonction empfct);
}

package com.demo.iservices;

import java.util.List;


import com.demo.model.ChargeEmployee;
import com.demo.model.ChargeEmployeeId;
import com.demo.model.Reporting;

public interface IEmployeeChargeService {
	
	public ChargeEmployee saveOrupdateEmpCharge(ChargeEmployee empcharge);
	public ChargeEmployee getEmpChargeById(ChargeEmployeeId id);
	public List<ChargeEmployee> getAllEmpCharges();
	public void DeleteEmpCharge(ChargeEmployee empcharge);
	List<Reporting> reporting(int a);

}

package com.demo.iservices;

import java.util.List;

import com.demo.model.Charge;

public interface IChargeService {

	public Charge saveOrupdateCharge(Charge charge);
	public Charge getChargeById(Long id);
	public List<Charge> getAllCharges();
	public void DeleteCharge(Charge charge);
	public List<Charge> listerNonArchive(Boolean a);
	public void archiver(boolean a, Long b);
	public Integer calculer_type(String a);
	public Charge getType(String a);
}

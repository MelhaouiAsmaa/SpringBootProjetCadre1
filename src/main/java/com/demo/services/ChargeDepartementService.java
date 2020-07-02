package com.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IChargeDepartementService;
import com.demo.model.ChargeDepartement;
import com.demo.model.ChargeDepartementId;
import com.demo.model.Reporting;
import com.demo.repository.ChargeDepartementRepository;
@Service
public class ChargeDepartementService implements IChargeDepartementService{

	@Autowired 
	private ChargeDepartementRepository rep;
	@Override
	public void SaveOrUpdate(ChargeDepartement c) {
		if(rep.compter(c.getPk_chargedep())==0)
			c.setArchive(false);
		rep.save(c);
	}
	@Override
	public List<ChargeDepartement> lister(Boolean a) {
		// TODO Auto-generated method stub
		return rep.listerdept(a);
	}
	@Override
	public ChargeDepartement getCharge(ChargeDepartementId c) {
		// TODO Auto-generated method stub
		return rep.getOne(c);
	}
	@Override
	public void archiveDesarchive(Boolean a, ChargeDepartementId c) {
		// TODO Auto-generated method stub
		ChargeDepartement c1=new ChargeDepartement();
		c1=rep.getOne(c);
		c1.setArchive(a);
		rep.save(c1);
		
	}

	@Override
	public List<Reporting> reporting(int  a) {
		// TODO Auto-generated method stub
		List<Reporting> repo=new ArrayList<Reporting>();
		List<Object> liste=rep.reporting(a);
		Iterator itr = liste.iterator();
		int i=0;
		while(itr.hasNext()){
			   Object[] obj = (Object[]) itr.next();
			   //now you have one array of Object for each row
			   int b = Integer.parseInt(String.valueOf(obj[0])); // don't know the type of column CLIENT assuming String 
			   Double c = Double.parseDouble((String.valueOf(obj[1]))); //SERVICE assumed as int
			   //same way for all obj[2], obj[3], obj[4]
			   repo.add(new Reporting(b,c));
			   i++;
			   
			}
		return repo;
	}
}

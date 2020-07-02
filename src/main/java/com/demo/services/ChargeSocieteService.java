package com.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IChargeSocieteService;
import com.demo.model.ChargeSociete;
import com.demo.model.ChargeSocieteId;
import com.demo.model.Reporting;
import com.demo.repository.ChargeSocieteRepository;

@Service
public class ChargeSocieteService implements IChargeSocieteService {
@Autowired 
private ChargeSocieteRepository rep;
	@Override
	public void create(ChargeSociete s) {
		// TODO Auto-generated method stub
rep.save(s);
	}
	@Override
	public List<ChargeSociete> lister() {
		// TODO Auto-generated method stub
		return rep.lister(false);
	}
	@Override
	public List<ChargeSociete> ListerArchive() {
		// TODO Auto-generated method stub
		return rep.lister(true);
	}
	@Override
	public void archiver(ChargeSocieteId c) {

ChargeSociete s=new ChargeSociete();
s=rep.getOne(c);
s.setArchive(true);
rep.save(s);
	}
	@Override
	public void desarchiver(ChargeSocieteId c) {
		
		ChargeSociete s=new ChargeSociete();
		s=rep.getOne(c);
		s.setArchive(false);
		rep.save(s);
	}
	@Override
	public void update(ChargeSociete c) {
		// TODO Auto-generated method stub
		rep.save(c);
	}
	@Override
	public ChargeSociete get(ChargeSocieteId c) {
		// TODO Auto-generated method stub
		return rep.getOne(c);
	}
	@Override
	public List<Reporting> reporting(int a) {
		// TODO Auto-generated method stub
		
		List<Reporting> repo=new ArrayList<Reporting>();
		List<Object> liste=rep.reportingSociete(a);
		Iterator itr = liste.iterator();
		int i=0;
		while(itr.hasNext()){
			   Object[] obj = (Object[]) itr.next();
			   //now you have one array of Object for each row
			   int b = Integer.parseInt(String.valueOf(obj[0])); // don't know the type of column CLIENT assuming String 
			   Double c = Double.parseDouble((String.valueOf(obj[1]))); //SERVICE assumed as int
			   //same way for all obj[2], obj[3], obj[4]
			   repo.add(new Reporting(b,c));
			   System.out.println(repo.get(i));
			   i++;
			   
			}
		return repo;
	}

}

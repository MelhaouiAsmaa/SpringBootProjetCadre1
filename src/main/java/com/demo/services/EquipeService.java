package com.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.iservices.IEquipeService;
import com.demo.model.Equipe;
import com.demo.repository.EquipeRepository;

@Service
public class EquipeService implements IEquipeService {

	@Autowired EquipeRepository repo;
	@Override
	public Equipe saveOrupdateEquipe(Equipe eq) {
		// TODO Auto-generated method stub
		eq.setArchive(false);
		return repo.save(eq);
	}

	@Override
	public void DeleteEquipe(Long ideq) {
		// TODO Auto-generated method stub
		Equipe eq = repo.getOne(ideq);
		eq.setArchive(true);
		repo.save(eq);
		if(eq.isArchive())
		{
			System.out.println("equipe archive "+eq.isArchive());
		}
		else
		{
			System.out.println("archive failed :(");
		}
		//old comment
		//because delete method didn't work
	}

	@Override
	public List<Equipe> getAllEquipe() {
		// TODO Auto-generated method stub
		return repo.getAllEquipes();
	}

	@Override
	public Equipe getEquipeById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public String DepartmentNameByEquipe(Long id) {
		// TODO Auto-generated method stub
		return repo.DepNameByEquipe(id);
	}
	
	public String ResponsableEquipe(Long id)
	{
		List<String> liste = repo.responsableEquipe(id);
		String fullname = "";
		for(int i=0;i<liste.size();i++) {
			 fullname += liste.get(i);
		}
		fullname = fullname.replaceAll(",", " ");
		System.out.println("respo: "+fullname);
		return fullname;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkedHashMap<String, String>> ListEmployebyEquipe(Long id) {
		// TODO Auto-generated method stub
		List<String> items;
		List<LinkedHashMap<String, String>> list = new ArrayList<LinkedHashMap<String, String>>();
		List<String> liste = repo.ListEmployeesbyEquipe(id);
		System.out.println(liste);
		for(int i=0; i<liste.size(); i++)
		{
			LinkedHashMap<String, String> mMap = new LinkedHashMap<String,String>();
			items = Arrays.asList(liste.get(i).split("\\s*,\\s*"));
//			System.out.println(items.get(0));
			mMap.put("id", items.get(0));
			mMap.put("datedeb", items.get(1));
			mMap.put("datefin", items.get(2));
			mMap.put("respo", items.get(3));
			mMap.put("fonction", items.get(4));
//			System.out.println(mMap);
			list.add(mMap);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<Equipe> getAllArchivedEquipe() {
		// TODO Auto-generated method stub
		return repo.getArchivedEquipe();
	}

	@Override
	public void desarchiverEquipe(Equipe eq) {
		// TODO Auto-generated method stub
		eq.setArchive(false);
		repo.save(eq);
	}

	@Override
	public List<Equipe> getEquipeDept(Long a) {
		// TODO Auto-generated method stub
		return repo.getEquipeByDept(a);
	}

}

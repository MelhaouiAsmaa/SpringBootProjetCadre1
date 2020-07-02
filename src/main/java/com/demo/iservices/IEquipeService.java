package com.demo.iservices;

import java.util.LinkedHashMap;
import java.util.List;

import com.demo.model.Equipe;

public interface IEquipeService {

	public Equipe saveOrupdateEquipe(Equipe eq);
	public void DeleteEquipe(Long eq);
	public List<Equipe> getAllEquipe();
	public Equipe getEquipeById(Long id);
	public String DepartmentNameByEquipe(Long id);
	public String ResponsableEquipe(Long id);
	public List<LinkedHashMap<String, String>> ListEmployebyEquipe(Long id);
	public List<Equipe> getAllArchivedEquipe();
	public void desarchiverEquipe(Equipe eq);
	public List<Equipe> getEquipeDept(Long a);
}

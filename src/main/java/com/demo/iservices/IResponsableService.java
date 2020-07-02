package com.demo.iservices;

import java.util.List;

import com.demo.model.Responsable;


public interface IResponsableService {

	public Responsable saveOrupdateRespo(Responsable respo);
	public Responsable getRespoById(Long id);
	public List<Responsable> getAllRespo();
	public void DeleteRespo(Responsable respo);
	public List<Responsable> getResponsableByDept(Long a);
}

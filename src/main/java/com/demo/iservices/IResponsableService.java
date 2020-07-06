package com.demo.iservices;

import java.sql.Date;
import java.util.List;

import com.demo.model.Responsable;
import com.demo.model.ResponsableId;


public interface IResponsableService {

	public Responsable saveOrupdateRespo(Responsable respo);
	public Responsable getRespoById(ResponsableId id);
	public List<Responsable> getAllRespo(Boolean a);
	public void DeleteRespo(Responsable respo);
	public List<Responsable> getResponsableByDept(Long a);
	public Responsable getResponsableCourant(Date a,Long b);
	public void Modifier(Boolean a,ResponsableId b);
}

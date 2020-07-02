package com.demo.iservices;

import java.util.List;

import com.demo.model.JourFerie;

public interface IJourFerieService {

	public JourFerie saveOrupdateJourFerie(JourFerie jourferie);
	public void DeleteJourFerie(JourFerie jourferie);
	public List<JourFerie> getAllJourFeries();
	public JourFerie getJourFerieById(Long id);
}

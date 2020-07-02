package com.demo.iservices;

import java.util.List;

import com.demo.model.Societe;

public interface ISocieteService {
public void create(Societe s);
public List<Societe> lister(Boolean a);
public void modifier(Boolean a , int b);
public Societe getsociete(int id);
}

package com.demo.iservices;

import java.util.List;

import com.demo.model.Pointage;

public interface IPointageService {
Pointage create_pointage(Pointage p);
List<Pointage> lister_pointage(Boolean a);
void archive_desarchive(Boolean a,int b);
Pointage getPointage(int id);
}

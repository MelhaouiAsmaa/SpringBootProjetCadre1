package com.demo.iservices;

import java.util.List;

import com.demo.model.ChargeSociete;
import com.demo.model.ChargeSocieteId;
import com.demo.model.Reporting;

public interface IChargeSocieteService {
void create(ChargeSociete s);
List<ChargeSociete> lister();
List<ChargeSociete> ListerArchive();
void archiver(ChargeSocieteId c);
void desarchiver(ChargeSocieteId c);
void update(ChargeSociete c);
ChargeSociete get(ChargeSocieteId c);
List<Reporting> reporting(int a);
}

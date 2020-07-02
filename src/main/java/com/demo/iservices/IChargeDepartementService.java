package com.demo.iservices;

import java.util.List;

import com.demo.model.ChargeDepartement;
import com.demo.model.ChargeDepartementId;
import com.demo.model.Reporting;

public interface IChargeDepartementService {
void SaveOrUpdate(ChargeDepartement c);
List<ChargeDepartement> lister(Boolean a);
ChargeDepartement getCharge(ChargeDepartementId c);
void archiveDesarchive(Boolean a,ChargeDepartementId c);
List<Reporting> reporting(int a );

}

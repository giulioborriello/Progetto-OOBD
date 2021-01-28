package DAO;

import java.sql.Date;
import java.util.List;

import Entità.Gate;
import Entità.Tempistica;

public interface GateDAO {
	
	public Gate getGateByCodGate(String CodGate);
	public Gate getGateByCodTratta(String CodTratta, String data);
	public List<Tempistica> GetTempisticheGiorni(String mese, String anno);
	public List<Tempistica> GetTempisticheMesi(String anno);
	public List<Tempistica> GetTempisticheSettimane(String anno);
}
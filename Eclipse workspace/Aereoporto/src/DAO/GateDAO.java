package DAO;

import java.util.List;

import Entit�.Gate;
import Entit�.Tempistica;

public interface GateDAO {
	public List<Gate> getAllGate();
	public Gate getGateByNgate(int Ngate);
	public Gate getGateByCodTratta(String CodTratta);
	public List<Tempistica> GetTempisticheGiorni(String mese, String anno);
	public List<Tempistica> GetTempisticheMesi(String anno);
	public List<Tempistica> GetTempisticheSettimane(String anno);
}
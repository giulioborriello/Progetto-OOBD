package DAO;

import java.sql.Date;
import java.util.List;

import Entità.Gate;
import Entità.Tempistica;

public interface GateDAO {
	
	public List<Gate> getGateByNGate(String CodGate);
	public Gate getGateByCodTratta(String CodTratta, Date data);
	public List<Tempistica> getTempisticheGiorni(String mese, String anno);
	public List<Tempistica> getTempisticheMesi(String anno);
	public List<Tempistica> getTempisticheSettimane(String anno);
	public String insertGate(String CodGate, String Ngate, String CodTratta);
	public String deleteGate(String CodGate);
}
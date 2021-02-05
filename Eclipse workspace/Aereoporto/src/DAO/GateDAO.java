package DAO;

import java.sql.Date;
import java.util.List;

import Entità.Gate;
import Entità.Tempistica;
import Entità.Tratta;

public interface GateDAO {
	
	public List<Gate> getGateByNGate(String CodGate, Date data);
	public Gate getGateByCodGate(String CodGate);
	public Gate getGateByCodGate(String CodGate, Tratta tratta);
	public Gate getGateByCodTratta(String CodTratta);
	
	
	public List<Tempistica> getTempisticheGiorni(String Ngate, String mese, String anno);
	public List<Tempistica> getTempisticheMesi(String Ngate, String anno);
	public List<Tempistica> getTempisticheSettimane(String Ngate, String anno);
	
	
	public String insertGate(String CodGate, String CodTratta);
	
	
	public String deleteGate(String CodGate);
}
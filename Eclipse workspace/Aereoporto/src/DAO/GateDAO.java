package DAO;

import java.util.List;

import Entità.Gate;

public interface GateDAO {
	public List<Gate> getAllGate();
	public List<Gate> getGateByNgate(int Ngate);
	public List<Gate> getGateByCodTratta(String CodTratta);
	public void insertGate(int Ngate, String CodTratta);
	public void updateCodTrattaByNgate(String CodTratta, int Ngate);
}

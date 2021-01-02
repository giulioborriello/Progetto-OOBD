package DAO;

import java.util.List;

import Entità.Gate;

public interface GateDAO {
	public List<Gate> getAllGate();
	public Gate getGateByNgate(int Ngate);
	public Gate getGateByCodTratta(String CodTratta);
	public String insertGate(int Ngate, String CodTratta);
	public String updateCodTrattaByNgate(String CodTratta, int Ngate);
	public String deleteGate(int Ngate);
}

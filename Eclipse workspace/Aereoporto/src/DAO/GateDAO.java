package DAO;

import java.util.List;

import Entit�.Gate;

public interface GateDAO {
	public List<Gate> getAllGate();
	public Gate getGateByNgate(int Ngate);
	public Gate getGateByCodTratta(String CodTratta);
}

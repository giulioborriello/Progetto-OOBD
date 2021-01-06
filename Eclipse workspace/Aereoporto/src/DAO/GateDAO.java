package DAO;

import java.util.List;

import Entità.Gate;

public interface GateDAO {
	public List<Gate> getAllGate();
	public Gate getGateByNgate(int Ngate);
	public Gate getGateByCodTratta(String CodTratta);
}

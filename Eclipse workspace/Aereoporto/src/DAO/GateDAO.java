package DAO;

public interface GateDAO {
	public void getAllGate();
	public void getGateByNgate(int Ngate);
	public void getGateByCodTratta(String CodTratta);
	public void insertGate(int Ngate, String CodTratta);
	public void updateCodTrattaByNgate(String CodTratta, int Ngate);
}

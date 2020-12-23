package DAO;

import java.sql.Date;
import java.sql.Time;

public interface TrattaDAO {

	
	public void getAllTratta();
	public void getTrattaByCodTratta(String CodTratta);
	public void getTrattaByData(String Data);
	public void getTrattaNgate(String Ngate);
	public void getTrattaCodIATA(String CodIATA);
	public void getTrattaDestinazione(String Destinazione);
	public void insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali);
}

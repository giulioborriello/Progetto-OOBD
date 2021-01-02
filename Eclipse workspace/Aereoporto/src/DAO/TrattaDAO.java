package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entità.Tratta;

public interface TrattaDAO {

	
	public List<Tratta> getAllTratta();
	public Tratta getTrattaByCodTratta(String CodTratta);
	public List<Tratta> getTrattaByData(String Data);
	public List<Tratta> getTrattaNgate(String Ngate);
	public List<Tratta> getTrattaCodIATA(String CodIATA);
	public List<Tratta> getTrattaDestinazione(String Destinazione);
	public String insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali);
	public String deleteTratta(String CodTratta);
}

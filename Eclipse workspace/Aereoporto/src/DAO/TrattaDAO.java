package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entit�.Tratta;

public interface TrattaDAO {

	
	public List<Tratta> getAllTratta();
	public Tratta getTrattaByCodTratta(String CodTratta);
	public List<Tratta> getTrattaByData(String Data);
	public List<Tratta> getTrattaByNgate(String Ngate);
	public List<Tratta> getTrattaByCodIATA(String CodIATA);
	public List<Tratta> getTrattaByDestinazione(String Destinazione);
	public String insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali);
	public String deleteTratta(String CodTratta);
}

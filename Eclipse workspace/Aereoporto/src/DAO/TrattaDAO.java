package DAO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import Entità.Tratta;

public interface TrattaDAO {

	
	public Tratta getTrattaByCodTratta(String CodTratta);
	public List<Tratta> getTrattaByData(String Data);
//	public List<Tratta> getTrattaByNgate(String Ngate);
	public List<Tratta> getTrattaByCodIATA(String CodIATA, Date data);
	public List<Tratta> getTrattaByDestinazione(String Destinazione, Date data);
	public String insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali);
	public String deleteTratta(String CodTratta);
}

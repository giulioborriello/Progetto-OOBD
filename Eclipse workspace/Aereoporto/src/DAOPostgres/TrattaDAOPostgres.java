package DAOPostgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import DAO.TrattaDAO;
import Entità.Tratta;

public class TrattaDAOPostgres implements TrattaDAO{
	Connection conn = null;
	List<Tratta> listTratta = new LinkedList<Tratta>();
	private SingletonPostgres singleton;
	private CompagniaDAOPostgres compagnia;
	private GateDAOPostgres gate;
	
	
	
	public TrattaDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;
		compagnia = new CompagniaDAOPostgres(singleton);
		gate = new GateDAOPostgres(singleton);
	}
	
		
		
	public Tratta getTrattaByCodTratta(String CodTratta){
		Tratta tratta = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);	
			ResultSet rs=ps.executeQuery();
			
			tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("Orario di partenza"), 
					rs.getDate("Data"), rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
					compagnia.getCompagniaByCodIATA(rs.getString(CodTratta)),
					gate.getGateByCodGate(rs.getString("nGate")));
			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tratta;	
		
	}
	
	public List<Tratta> getTrattaByData(String Data){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("Orario di partenza"), 
						rs.getDate("Data"),rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						compagnia.getCompagniaByCodIATA(rs.getString("CodTratta")),
						gate.getGateByCodGate(rs.getString("nGate")));
				
				listTratta.add(tratta);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listTratta;	
	}
	
	public List<Tratta> getTrattaByCodIATA(String CodIATA, Date data){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodIATA\" = ?"
					+ "AND \"Data\" = ?");
			ps.setString(1, CodIATA);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("Orario di partenza"), 
						rs.getDate("Data"), rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						compagnia.getCompagniaByCodIATA(rs.getString("CodTratta")),
						gate.getGateByCodGate(rs.getString("nGate")));
				
				listTratta.add(tratta);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listTratta;	
	}
	
	public List<Tratta> getTrattaByDestinazione(String destinazione, Date data){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Destinazione\" = ? "
					+ "AND \"Data\" = ?");
			ps.setString(1, destinazione);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("Orario di partenza"), 
						rs.getDate("Data"), rs.getString("destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						compagnia.getCompagniaByCodIATA(rs.getString("CodTratta")),
						gate.getGateByCodGate(rs.getString("nGate")));
				
				listTratta.add(tratta);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
		return listTratta;	
	}
	
	
	
	public String insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Tratta\" VALUES (?, ?, ?, ?, ?, ?, ?, ?, null)");
			ps.setString(1, CodTratta);
			ps.setInt(2, Nprenotazioni);
			ps.setTime(3, OrarioDiPartenza);
			ps.setDate(4, Data);
			ps.setInt(5, Ngate);
			ps.setString(6, CodIATA);
			ps.setString(7, Destinazione);
			ps.setString(8, Scali);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Inserito Correttamente";
		} 
		
		catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deleteTratta(String CodTratta) {
		
		try {
				PreparedStatement ps = conn.prepareStatement("Delete From \"Tratta\"  WHERE \"CodTratta\" = ? ; ");
				
			ps.setString(1, CodTratta);
			ps.execute();
			ps.close();
			conn.close();
				
			return "Eliminato Correttamente";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}

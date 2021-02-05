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
import Entità.Compagnia;
import Entità.Gate;
import Entità.Tratta;

public class TrattaDAOPostgres implements TrattaDAO{
	Connection conn = null;
	List<Tratta> listTratta;
	private SingletonPostgres singleton;
	private CompagniaDAOPostgres compagnia;
	private GateDAOPostgres gate;
	
	
	
	public TrattaDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;
		
	}
	
		
	public Tratta getTrattaByCodTratta(String CodTratta){
		Tratta tratta = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);	
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			compagnia = new CompagniaDAOPostgres(singleton);
			Compagnia codIATA = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
			gate = new GateDAOPostgres(singleton);
			Gate codGate = gate.getGateByCodGate(rs.getString("CodGate"), tratta);
			
			tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
					rs.getDate("Data"), rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
					rs.getString("Ngate"),codIATA, codGate);
			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tratta;	
		
	}
	
	public List<Tratta> getTrattaByData(Date Data){
		try {
			listTratta = new LinkedList<Tratta>();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Data\" = ?");
			ps.setDate(1, Data);
			ResultSet rs=ps.executeQuery();
			
		
			
			while(rs.next()) {
				 
				compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia codIATA = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
				gate = new GateDAOPostgres(singleton);
				Tratta tratta = null;
				Gate codGate = gate.getGateByCodGate(rs.getString("CodGate"), tratta);
				
				tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"),rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						rs.getString("Ngate"),
						codIATA,
						codGate);
				
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
	
	public List<Tratta> getTrattaByCodGate(String Ngate, String data) {
		PreparedStatement ps;
		try {
			
			listTratta = new LinkedList<Tratta>();
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Ngate\" = ?"
					+ "AND \"Data\" = ?");
			
			ps.setString(1, Ngate);
			ps.setString(2, data);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia codIATA = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
				Tratta tratta = null;
				GateDAOPostgres gate = new GateDAOPostgres(singleton);
				Gate codGate = gate.getGateByCodGate(rs.getString("CodGate"), tratta);
				
				 tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						rs.getString("Ngate"),
						codIATA,
						codGate);
				
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

	public List<Tratta> getTrattaByCodIATA(String CodIATA, Date data){
		try {
			listTratta = new LinkedList<Tratta>();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodIATA\" = ?"
					+ "AND \"Data\" = ?");
			ps.setString(1, CodIATA);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia codIATA = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
				Tratta tratta = null;
				gate = new GateDAOPostgres(singleton);
				Gate codGate = gate.getGateByCodGate(rs.getString("CodGate"), tratta);
				
				 tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getString("Destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						rs.getString("Ngate"),
						codIATA,
						codGate);
				
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
	
	public List<Tratta> getTrattaByDestinazione(String destinazione, Date data){
		try {
			
			listTratta = new LinkedList<Tratta>();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Destinazione\" = ? "
					+ "AND \"Data\" = ?");
			ps.setString(1, destinazione);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia codIATA = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
				Tratta tratta = null;
				gate = new GateDAOPostgres(singleton);
				Gate codGate = gate.getGateByCodGate(rs.getString("CodGate"), tratta);
				
				 tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getString("destinazione"), rs.getString("Scali"), rs.getBoolean("Ritardo"),
						rs.getString("Ngate"),
						codIATA,
						codGate);
				
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
	
	
	
	public String insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, String CodIATA, String Destinazione, String Scali, String Ngate) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Tratta\" VALUES (?, ?, ?, ?, ?, ?, ?, null, null, ?)");
			ps.setString(1, CodTratta);
			ps.setInt(2, Nprenotazioni);
			ps.setTime(3, OrarioDiPartenza);
			ps.setDate(4, Data);
			ps.setString(5, CodIATA);
			ps.setString(6, Destinazione);
			ps.setString(7, Scali);
			ps.setString(8, Ngate);
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

package DAOPostgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import DAO.TrattaDAO;
import Entità.Tratta;

public class TrattaDAOPostgres implements TrattaDAO{
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	List<Tratta> ListTratta = new LinkedList<Tratta>();
	
	
	public TrattaDAOPostgres() {
	}
	
		
	public List<Tratta> getAllTratta() {
			try {
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
				st = conn.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM public.\"Tratta\"");
				while(rs.next()) {
					
					Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
							rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"),
							null, null, null);
					
					ListTratta.add(tratta);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ListTratta;	
		}
		
	public List<Tratta> getTrattaByCodTratta(String CodTratta){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"),
						null, null, null);
				
				ListTratta.add(tratta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListTratta;	
	}
	
	public List<Tratta> getTrattaByData(String Data){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"),
						null, null, null);
				
				ListTratta.add(tratta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListTratta;	
	}
	
	public Tratta getTrattaNgate(int nGate){
		Tratta tratta;
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Ngate\" = ?");
			ps.setInt(1, nGate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GateDAOPostgres gate = new GateDAOPostgres();
				String codTratta = rs.getString("CodTratta");
				tratta = new Tratta(codTratta, rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"), gate.getGateByCodTratta(rs.getString("CodTratta")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tratta;
	}
	
	public List<Tratta> getTrattaCodIATA(String CodIATA){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"),
						null, null, null);
				
				ListTratta.add(tratta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListTratta;	
	}
	
	public List<Tratta> getTrattaDestinazione(String Destinazione){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Destinazione\" = ?");
			ps.setString(1, Destinazione);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tratta tratta = new Tratta(rs.getString("CodTratta"), rs.getInt("Nprenotazioni"), rs.getTime("OrarioDiPartenza"), 
						rs.getDate("Data"), rs.getInt("Ngate"), rs.getString("CodIATA"), rs.getString("Destinazione"), rs.getString("Scali"),
						null, null, null);
				
				ListTratta.add(tratta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListTratta;	
	}
	
	public void insertTratta(String CodTratta, int Nprenotazioni, Time OrarioDiPartenza, Date Data, int Ngate,  String CodIATA, String Destinazione, String Scali) {
		try {
			ps = conn.prepareStatement("INSERT INTO \"Tratta\" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, CodTratta);
			ps.setInt(2, Nprenotazioni);
			ps.setTime(3, OrarioDiPartenza);
			ps.setDate(4, Data);
			ps.setInt(5, Ngate);
			ps.setString(6, CodIATA);
			ps.setString(7, Destinazione);
			ps.setString(8, Scali);
			ps.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	public void VerificaFormatoCodTratta() {
//		 try {
//			st.executeUpdate("ALTER TABLE \"Tratta\" ADD CONSTRAINT Verifica_Formato_CodTratta CHECK(\"CodTratta\" ~* '^[a-zA-Z] + [a-zA-Z] + [a-zA-Z] + % +$ ')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

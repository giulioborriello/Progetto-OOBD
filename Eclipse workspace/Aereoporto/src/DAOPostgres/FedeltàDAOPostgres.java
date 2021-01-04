package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import DAO.FedeltaDAO;
import Entit�.Fedelt�;

public class Fedelt�DAOPostgres implements FedeltaDAO {
	private Connection conn;
	private List<Fedelt�> ListFedelt� = new LinkedList<Fedelt�>();
	
	public Fedelt�DAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
	}
	
	public List<Fedelt�> getAllFedelt�() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Fedelt�\"");
			
			while(rs.next()) {
				
				Fedelt� fedelt� = new Fedelt�(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), rs.getString("CodFiscale"), rs.getInt("Punti"));
				
				ListFedelt�.add(fedelt�);
				
			}
			st.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListFedelt�;	
	}
	
	public List<Fedelt�> getFedelt�ByCentoKilometri(String Centokilometri) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt�\" WHERE \"Centokilometri\" = ?");
			ps.setString(1, Centokilometri);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Fedelt� fedelt� = new Fedelt�(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), rs.getString("CodFiscale"), rs.getInt("Punti"));
				
				ListFedelt�.add(fedelt�);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt�;	
	}
	
	public List<Fedelt�> getFedelt�ByCodIATA(String CodIATA) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt�\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Fedelt� fedelt� = new Fedelt�(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), rs.getString("CodFiscale"), rs.getInt("Punti"));
				
				ListFedelt�.add(fedelt�);
				
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt�;	
	}
	
	public List<Fedelt�> getFedelt�ByCodFiscale(String CodFiscale) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt�\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {

				Fedelt� fedelt� = new Fedelt�(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), rs.getString("CodFiscale"), rs.getInt("Punti"));
				ListFedelt�.add(fedelt�);
				
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt�;	
	}
	
	public String insertFedelt�(int CentoKilometri, String CodIATA, String CodFiscale , int Punti)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Fedelt�\"  VALUES (?, ?, ?, ?); ");
			ps.setInt(1, CentoKilometri);
			ps.setString(2, CodIATA);
			ps.setString(3, CodFiscale);
			ps.setInt(4, Punti);
			ps.execute();
			
			return "Inserito Correttamente!";
		} catch (SQLException e) {
			return e.getMessage();
		} 
	}
	
	public String updateCentoKilometriByCodFiscaleANDCodIATA(int CentoKilometri, String CodFiscale, String CodIATA)	{
			
			try {
				PreparedStatement ps = conn.prepareStatement("UPDATE \"Fedelt�\" SET \"CentoKilometri\" = ? WHERE \"CodFiscale\" = ? AND \"CodIATA\" = ? ; ");
				ps.setInt(1, CentoKilometri);
				ps.setString(2, CodFiscale);
				ps.setString(3, CodIATA);
				ps.execute();
				ps.close();
				conn.close();
				
				return "Aggiornato Correttamente!";
			} catch (SQLException e) {
				return e.getMessage();
			}
	}
	
	public String updatePuntiByCentoKilometriANDCodIATA(int Punti, int CentoKilometri, String CodIATA)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Fedelt�\" SET \"Punti\" = ? WHERE \"CentoKilometri\" = ? AND \"CodIATA\" = ?; ");
			ps.setInt(1, Punti);
			ps.setInt(2, CentoKilometri);
			ps.setString(3, CodIATA);
			ps.execute();
			ps.close();
			conn.close();
			return "Aggiornato Correttamente!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	public String deleteFedelt�(String CodFiscale) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Fedelt�\"  WHERE \"CodFiscale\" = ? ; ");
				
			ps.setString(1, CodFiscale);
			ps.execute();
			ps.close();
			conn.close();
				
			return "Eliminato correttamente";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	
	
	}

}

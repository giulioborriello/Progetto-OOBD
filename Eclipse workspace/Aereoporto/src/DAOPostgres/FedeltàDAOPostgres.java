package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.FedeltaDAO;
import Entit‡.Fedelt‡;

public class Fedelt‡DAOPostgres implements FedeltaDAO {
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	List<Fedelt‡> ListFedelt‡ = new LinkedList<Fedelt‡>();
	
	
	public Fedelt‡DAOPostgres() {
	}
	
	public List<Fedelt‡> getAllFedelt‡() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Fedelt‡\"");
			
			while(rs.next()) {
				
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), rs.getString("CodFiscale"), rs.getInt("Punti"), null, null);
				
				ListFedelt‡.add(fedelt‡);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListFedelt‡;	
	}
	
	public List<Fedelt‡> getFedelt‡ByCentoKilometri(String Centokilometri) {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"Centokilometri\" = ?");
			ps.setString(1, Centokilometri);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				CompagniaDAOPostgres compagnia= new CompagniaDAOPostgres();
				String codIATA = rs.getString("CodIATA");
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), codFiscale, rs.getInt("Punti"), cliente.getClienteByCodFiscale(codFiscale),compagnia.getCompagniaByCodIATA(codIATA) );
				
				ListFedelt‡.add(fedelt‡);
			}	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt‡;	
	}
	
	public List<Fedelt‡> getFedelt‡ByCodIATA(String CodIATA) {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				CompagniaDAOPostgres compagnia= new CompagniaDAOPostgres();
				String codIATA = rs.getString("CodIATA");
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), codFiscale, rs.getInt("Punti"), cliente.getClienteByCodFiscale(codFiscale),compagnia.getCompagniaByCodIATA(codIATA) );
				
				ListFedelt‡.add(fedelt‡);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt‡;	
	}
	
	public List<Fedelt‡> getFedelt‡ByCodFiscale(String CodFiscale) {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {

				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				CompagniaDAOPostgres compagnia= new CompagniaDAOPostgres();
				String codIATA = rs.getString("CodIATA");
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getInt("CentoKilometri"), rs.getString("CodIATA"), codFiscale, rs.getInt("Punti"), cliente.getClienteByCodFiscale(codFiscale),compagnia.getCompagniaByCodIATA(codIATA) );
				ListFedelt‡.add(fedelt‡);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListFedelt‡;	
	}
	
	public void insertFedelt‡(int CentoKilometri, String CodIATA,String CodFiscale , int Punti)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Fedelt‡\"  VALUES (?, ?, ?, ?); ");
			ps.setInt(1, CentoKilometri);
			ps.setString(2, CodIATA);
			ps.setString(3, CodFiscale);
			ps.setInt(4, Punti);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCentoKilometriByCodFiscaleANDCodIATA(int CentoKilometri, String CodFiscale, String CodIATA)	{
			
			try {
				ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"CentoKilometri\" = ? WHERE \"CodFiscale\" = ? AND \"CodIATA\" = ? ; ");
				ps.setInt(1, CentoKilometri);
				ps.setString(2, CodFiscale);
				ps.setString(3, CodIATA);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void updatePuntiByCentoKilometriANDCodIATA(int CentoKilometri, int Punti, String CodIATA)	{
		
		try {
			ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"Punti\" = ? WHERE \"CentoKilometri\" = ? AND \"CodIATA\" = ?; ");
			ps.setInt(1, Punti);
			ps.setInt(2, CentoKilometri);
			ps.setString(3, CodIATA);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

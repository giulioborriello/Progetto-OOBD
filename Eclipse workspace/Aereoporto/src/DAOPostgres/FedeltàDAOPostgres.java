package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import DAO.FedeltaDAO;
import Entit‡.Fedelt‡;

public class Fedelt‡DAOPostgres implements FedeltaDAO {
	private Connection conn;
	private List<Fedelt‡> listFedelt‡ = new LinkedList<Fedelt‡>();
	SingletonPostgres singleton;
	
	public Fedelt‡DAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp; 
	}
	
	public List<Fedelt‡> getFedelt‡ByCentoKilometri(String Centokilometri) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"Centokilometri\" = ?");
			ps.setString(1, Centokilometri);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia.getCompagniaByCodIATA(rs.getString("CodIATA")), 
								cliente.getClienteByCodFiscale(rs.getString("CodFiscale")))
						;
				
				listFedelt‡.add(fedelt‡);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listFedelt‡;	
	}
	
	public List<Fedelt‡> getFedelt‡ByCodIATA(String CodIATA) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia.getCompagniaByCodIATA(rs.getString("CodIATA")), 
						cliente.getClienteByCodFiscale(rs.getString("CodFiscale")));
				
				listFedelt‡.add(fedelt‡);
				
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listFedelt‡;	
	}
	
	public List<Fedelt‡> getFedelt‡ByCodFiscale(String CodFiscale) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {

				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia.getCompagniaByCodIATA(rs.getString("CodIATA")), 
						cliente.getClienteByCodFiscale(rs.getString("CodFiscale")));
				listFedelt‡.add(fedelt‡);
				
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listFedelt‡;	
	}
	
	public String insertFedelt‡(String CentoKilometri, String CodIATA, String CodFiscale , int Punti)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Fedelt‡\"  VALUES (?, ?, ?, ?); ");
			ps.setString(1, CentoKilometri);
			ps.setString(2, CodIATA);
			ps.setString(3, CodFiscale);
			ps.setInt(4, Punti);
			ps.execute();
			
			return "Inserito Correttamente!";
		} catch (SQLException e) {
			return e.getMessage();
		} 
	}
	
	public String updateCentoKilometriByCodFiscaleANDCodIATA(String CentoKilometri, String CodFiscale, String CodIATA)	{
			
			try {
				PreparedStatement ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"CentoKilometri\" = ? WHERE \"CodFiscale\" = ? AND \"CodIATA\" = ? ; ");
				ps.setString(1, CentoKilometri);
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
	
	public String updatePuntiByCentoKilometriANDCodIATA(String CentoKilometri, int Punti, String CodIATA)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"Punti\" = ? WHERE \"CentoKilometri\" = ? AND \"CodIATA\" = ?; ");
			ps.setInt(1, Punti);
			ps.setString(2, CentoKilometri);
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

	public String deleteFedelt‡(String CodFiscale) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Fedelt‡\"  WHERE \"CodFiscale\" = ? ; ");
				
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

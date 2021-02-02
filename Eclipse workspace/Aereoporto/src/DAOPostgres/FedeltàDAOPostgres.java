package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import DAO.FedeltaDAO;
import Entit‡.Cliente;
import Entit‡.Compagnia;
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CentoKilometri\" = ?");
			ps.setString(1, Centokilometri);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia compagnia2 = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));
				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				Cliente cliente2 = cliente.getClienteByCodFiscale(rs.getString("CodFiscale"));
						
						
				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia2, cliente2);
				
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
				Cliente cliente2 = cliente.getClienteByCodFiscale(rs.getString("CodFiscale"));
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia compagnia2 = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));

				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia2, cliente2);
				
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
				Cliente cliente2 = cliente.getClienteByCodFiscale(rs.getString("CodFiscale"));
				CompagniaDAOPostgres compagnia = new CompagniaDAOPostgres(singleton);
				Compagnia compagnia2 = compagnia.getCompagniaByCodIATA(rs.getString("CodIATA"));

				Fedelt‡ fedelt‡ = new Fedelt‡(rs.getString("CentoKilometri"), rs.getInt("Punti"), 
						compagnia2, cliente2);
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
	
	public int GetRitardi(String CentoKilometri) {
		long numeroRitardi = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  COUNT(\"CodTratta\") FROM public.\"Fedelt‡\" NATURAL JOIN public.\"Compagnia\" NATURAL JOIN  public.\"Tratta\"  WHERE \"CentoKilometri\" = ? AND \"Ritardo\" = true ; ");
			ps.setString(1, CentoKilometri);
			ResultSet rs=ps.executeQuery();
			rs.next();
			numeroRitardi = rs.getLong("COUNT");
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return (int)(numeroRitardi);

	}
		
	
	
	
	public String insertFedelt‡(String CentoKilometri, String CodIATA, String CodFiscale)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Fedelt‡\"  VALUES (?, ?, 0, ?); ");
			ps.setString(1, CodIATA);
			ps.setString(2, CodFiscale);
			ps.setString(3, CentoKilometri);
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

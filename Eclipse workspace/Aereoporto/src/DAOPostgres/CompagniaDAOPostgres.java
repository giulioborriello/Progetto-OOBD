package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.CompagniaDAO;
import Entità.Compagnia;

public class CompagniaDAOPostgres implements CompagniaDAO {
	PreparedStatement ps = null;
	Statement st = null;
	List<Compagnia> ListCompagnia = new LinkedList<Compagnia>();
	
	
	public CompagniaDAOPostgres() {
	}
	
	public List<Compagnia> getAllCompagnia() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Compagnia\"");
			while(rs.next()) {
				
				Compagnia compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
				ListCompagnia.add(compagnia);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListCompagnia;
	}
	
	
	public List<Compagnia> getCompagniaByCodIATA(String CodIATA) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Compagnia compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
				ListCompagnia.add(compagnia);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListCompagnia;
	}
	
	public List<Compagnia> getCompagniaByNomeCompagnia(String Nome) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"Nome Compagnia\" = ?");
			ps.setString(1, Nome);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Compagnia compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
				ListCompagnia.add(compagnia);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListCompagnia;
	}
	
	public void insertCompagnia(String CodIATA, String Nome_compagnia, String Sito_web)	{		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?, ?); ");
			ps.setString(1, CodIATA);
			ps.setString(2, Nome_compagnia);
			ps.setString(3, Sito_web);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
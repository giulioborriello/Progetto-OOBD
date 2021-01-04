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
import Entit�.Compagnia;

public class CompagniaDAOPostgres implements CompagniaDAO {
	Connection conn;
	List<Compagnia> ListCompagnia = new LinkedList<Compagnia>();
	SingletonPostgres singleton;

	
	public CompagniaDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;

	}
	
	public List<Compagnia> getAllCompagnia() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Compagnia\"");
			while(rs.next()) {
				
				Compagnia compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"));
				
				ListCompagnia.add(compagnia);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListCompagnia;
	}
	
	
	public Compagnia getCompagniaByCodIATA(String CodIATA) {
		Compagnia compagnia = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"));
				
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compagnia;
	}
	
	public Compagnia getCompagniaByNomeCompagnia(String Nome) {
		Compagnia compagnia = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"Nome Compagnia\" = ?");
			ps.setString(1, Nome);
			ResultSet rs=ps.executeQuery();
			
			compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"));
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return compagnia;
	}
	
	public String insertCompagnia(String CodIATA, String NomeCompagnia)	{		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?); ");
			ps.setString(1, CodIATA);
			ps.setString(2, NomeCompagnia);
			ps.execute();
			
			ps.close();
			conn.close();
			return "Inserito Correttamente!";
		} catch (SQLException e) {
			return e.getMessage();
		}
		
	}
	
	public String deleteCompagnia(String CodIATA) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Compagnia\"  WHERE \"CodIATA\" = ? ; ");
				
			ps.setString(1, CodIATA);
			ps.execute();
			ps.close();
			conn.close();
			return "Eliminato Correttamente!";

		} catch (SQLException e) {
			return e.getMessage();
		} 
	}
	
}
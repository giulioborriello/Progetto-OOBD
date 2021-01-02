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
	
	
	public CompagniaDAOPostgres(Connection connection) {
		conn = connection;
	}
	
	public List<Compagnia> getAllCompagnia() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Compagnia\"");
			while(rs.next()) {
				
				Compagnia compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
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
			
			compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
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
			
			compagnia = new Compagnia(rs.getString("CodIATA"), rs.getString("NomeCompagnia"), rs.getString("Sito web"));
				
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return compagnia;
	}
	
	public void insertCompagnia(String CodIATA, String Nome_compagnia, String Sito_web)	{		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?, ?); ");
			ps.setString(1, CodIATA);
			ps.setString(2, Nome_compagnia);
			ps.setString(3, Sito_web);
			ps.execute();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCompagnia(String CodIATA) {
		
		try {
				PreparedStatement ps = conn.prepareStatement("Delete From \"Compagnia\"  WHERE \"CodIATA\" = ? ; ");
				
				ps.setString(1, CodIATA);
				ps.execute();
				conn.close();
				ps.close();

				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
}
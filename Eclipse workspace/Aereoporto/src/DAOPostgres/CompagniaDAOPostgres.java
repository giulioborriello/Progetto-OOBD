package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.CompagniaDAO;

public class CompagniaDAOPostgres implements CompagniaDAO {
	PreparedStatement ps = null;
	Statement st = null;
	
	public CompagniaDAOPostgres() {
	}
	
	public void getAllCompagnia() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Compagnia\"");
			int i=1;
			while(rs.next()) {
				System.out.println("Compagnia numero: "+i);
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("Nome Compagnia: "+rs.getString("Nome Compagnia"));
				System.out.println("Sito web: "+rs.getString("Sito web"));
				i++;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void getCompagniaByCodIATA(String CodIATA) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("Nome Compagnia: "+rs.getString("Nome Compagnia"));
				System.out.println("Sito web: "+rs.getString("Sito web"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCompagniaByNomeCompagnia(String Nome) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"Nome Compagnia\" = ?");
			ps.setString(1, Nome);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("Nome Compagnia: "+rs.getString("Nome Compagnia"));
				System.out.println("Sito web: "+rs.getString("Sito web"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
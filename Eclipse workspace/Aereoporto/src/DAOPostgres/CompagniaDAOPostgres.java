package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompagniaDAOPostgres {
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	
	public CompagniaDAOPostgres(Connection conn) {
		this.conn = conn;
	}
	
	public void getAllCompagnia() {
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void getCompagniaByCodIATA(String CodIATA) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("Nome Compagnia: "+rs.getString("Nome Compagnia"));
				System.out.println("Sito web: "+rs.getString("Sito web"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCompagniaByNomeCompagnia(String Nome) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Compagnia\" WHERE \"Nome Compagnia\" = ?");
			ps.setString(1, Nome);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("Nome Compagnia: "+rs.getString("Nome Compagnia"));
				System.out.println("Sito web: "+rs.getString("Sito web"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertCompagnia(String CodIATA, String Nome_compagnia, String Sito_web)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?, ?); ");
			ps.setString(1, CodIATA);
			ps.setString(2, Nome_compagnia);
			ps.setString(3, Sito_web);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
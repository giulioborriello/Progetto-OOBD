package DAOPostgres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.BigliettoDAO;
import Entità.Biglietto;

public class BigliettoDAOPostgres implements BigliettoDAO {
	ResultSet rs;
	Statement st = null;
	PreparedStatement ps = null;
	List<Biglietto> ListBiglietto;
	
	public BigliettoDAOPostgres() {
		
	}
	
	
	public List<Biglietto> getAllBiglietto() {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			rs=st.executeQuery("SELECT * FROM public.\"Biglietto\"");
			int i=1;
			
			Biglietto biglietto;
			
			while(rs.next()) {
				
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				
				
				biglietto = new Biglietto(rs.getString("CodFiscale"), rs.getString("Tipo di biglietto"), rs.getString("CodBiglietto"),
						rs.getString("CodTratta"), rs.getString("Posto"), null, null);
				
				ListBiglietto.add(biglietto);
				}
			conn.close();
			return biglietto;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	public void getBigliettoByCodFiscale(String CodFiscale){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodFiscale:"+rs.getString("CodFiscale"));
				System.out.println("Tipo di biglietto:"+rs.getString("Tipo di biglietto"));
				System.out.println("CodBiglietto:"+rs.getString("CodBiglietto"));
				System.out.println("CodTratta:" + rs.getString("CodTratta"));
				System.out.println("Posto:" + rs.getString("Posto"));
				}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getBigliettoByCodTratta(String CodTratta){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodFiscale:"+rs.getString("CodFiscale"));
				System.out.println("Tipo di biglietto:"+rs.getString("Tipo di biglietto"));
				System.out.println("CodBiglietto:"+rs.getString("CodBiglietto"));
				System.out.println("CodTratta:" + rs.getString("CodTratta"));
				System.out.println("Posto:" + rs.getString("Posto"));
				}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("INSERT INTO \"Biglietto\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Tipo_di_biglietto);
			ps.setString(3, CodBiglietto);
			ps.setString(4, CodTratta);
			ps.setString(5, Posto);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
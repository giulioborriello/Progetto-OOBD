package DAOPostgres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.GateDAO;

public class GateDAOPostgres implements GateDAO{
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	
	public GateDAOPostgres() {
	}
	
	public void getAllGate() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Gate\"");
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getGateByNgate(int Ngate) {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"Ngate\" = ?");
			ps.setInt(1, Ngate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getGateByCodTratta(String CodTratta) {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertGate(int Ngate, String CodTratta)	{
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?); ");
			ps.setInt(1, Ngate);
			ps.setString(2, CodTratta);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCodTrattaByNgate(String CodTratta, int Ngate)	{
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("UPDATE \"Gate\" SET \"CodTratta\" = ? WHERE \"Ngate\" = ? ; ");
			ps.setString(1, CodTratta);
			ps.setInt(2, Ngate);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


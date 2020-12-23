package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.CodaDiImbarcoDAO;

public class CodaDiImbarcoDAOPostgres implements CodaDiImbarcoDAO{
	Statement st = null;
	PreparedStatement ps = null;
	
	public CodaDiImbarcoDAOPostgres() {
		
	}
	
	public void getAllCodaDiImbarco() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Code di imbarco\"");
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void getCodaDiImbarcoByCodCoda(String CodCoda){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCodaDiImbarcoByNgate(String Ngate){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"Ngate\" = ?");
			ps.setString(1, Ngate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCodaDiImbarcoByCodSlot(String CodSlot){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot)	{
			try {
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
				
				ps = conn.prepareStatement("INSERT INTO \"Coda di imbarco\"  VALUES (?, ?, ?, ?); ");
				ps.setInt(1, CodCoda);
				ps.setString(2, Tipo_di_coda);
				ps.setInt(3, Ngate);
				ps.setInt(4, CodSlot);
				ps.execute();
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}

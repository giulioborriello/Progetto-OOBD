package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fedelt‡DAOPostgres implements FedeltaDAO {
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	
	public Fedelt‡DAOPostgres(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public void getAllFedelt‡() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Fedelt‡\"");
			int i=1;
			while(rs.next()) {
				System.out.println("Fedelt‡ numero: "+i);
				System.out.println("Centokilometri: "+rs.getInt("Centokilometri"));
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("CodFiscale: "+rs.getString("CodFiscale"));
				System.out.println("Punti: "+rs.getInt("Punti"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getFedelt‡ByCentoKilometri(String Centokilometri) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"Centokilometri\" = ?");
			ps.setString(1, Centokilometri);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Centokilometri: "+rs.getInt("Centokilometri"));
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("CodFiscale: "+rs.getString("CodFiscale"));
				System.out.println("Punti: "+rs.getInt("Punti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getFedelt‡ByCodIATA(String CodIATA) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Centokilometri: "+rs.getInt("Centokilometri"));
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("CodFiscale: "+rs.getString("CodFiscale"));
				System.out.println("Punti: "+rs.getInt("Punti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getFedelt‡ByCodFiscale(String CodFiscale) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedelt‡\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Centokilometri: "+rs.getInt("Centokilometri"));
				System.out.println("CodIATA: "+rs.getString("CodIATA"));
				System.out.println("CodFiscale: "+rs.getString("CodFiscale"));
				System.out.println("Punti: "+rs.getInt("Punti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertFedelt‡(int CentoKilometri, String CodIATA,String CodFiscale , int Punti)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Fedelt‡\"  VALUES (?, ?, ?, ?); ");
			ps.setInt(1, CentoKilometri);
			ps.setString(2, CodIATA);
			ps.setString(3, CodFiscale);
			ps.setInt(4, Punti);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCentoKilometriByCodFiscaleANDCodIATA(int CentoKilometri, String CodFiscale, String CodIATA)	{
			
			try {
				ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"CentoKilometri\" = ? WHERE \"CodFiscale\" = ? AND \"CodIATA\" = ? ; ");
				ps.setInt(1, CentoKilometri);
				ps.setString(2, CodFiscale);
				ps.setString(3, CodIATA);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void updatePuntiByCentoKilometriANDCodIATA(int CentoKilometri, int Punti, String CodIATA)	{
		
		try {
			ps = conn.prepareStatement("UPDATE \"Fedelt‡\" SET \"Punti\" = ? WHERE \"CentoKilometri\" = ? AND \"CodIATA\" = ?; ");
			ps.setInt(1, Punti);
			ps.setInt(2, CentoKilometri);
			ps.setString(3, CodIATA);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

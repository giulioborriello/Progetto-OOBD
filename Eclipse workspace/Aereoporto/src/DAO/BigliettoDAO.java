package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BigliettoDAO {
	ResultSet rs;
	Statement st = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	public BigliettoDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public void getAllBiglietto() {
		try {
			rs=st.executeQuery("SELECT * FROM public.\"Biglietto\"");
			int i=1;

			while(rs.next()) {
				System.out.println("Numero Biglietto:"+i);
				System.out.println("CodFiscale:"+rs.getString("CodFiscale"));
				System.out.println("Tipo di biglietto:"+rs.getString("Tipo di biglietto"));
				System.out.println("CodBiglietto:"+rs.getString("CodBiglietto"));
				System.out.println("CodTratta:" + rs.getString("CodTratta"));
				System.out.println("Posto:" + rs.getString("Posto"));
				i++;
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	public void GetBigliettoByCodFiscale(String CodFiscale){
		try {
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
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void GetBigliettoByCodTratta(String CodTratta){
		try {
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
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void InsertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Biglietto\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Tipo_di_biglietto);
			ps.setString(3, CodBiglietto);
			ps.setString(4, CodTratta);
			ps.setString(5, Posto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
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
	PreparedStatement StGet = null;
	
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodFiscale\" = ?");
			StGet.setString(1, CodFiscale);
			ResultSet rs=StGet.executeQuery();
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodTratta\" = ?");
			StGet.setString(1, CodTratta);
			ResultSet rs=StGet.executeQuery();
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
	
	public void InsertBiglietto(String CodFiscale)	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
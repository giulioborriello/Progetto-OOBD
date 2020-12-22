package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coda_di_imbarco {
	Statement st = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	public void getAllCode_di_imbarco() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Code di imbarco\"");
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void getCoda_di_imbarcoByCodCoda(String CodCoda){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCoda_di_imbarcoByNgate(String Ngate){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"Ngate\" = ?");
			ps.setString(1, Ngate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getCoda_di_imbarcoByCodSlot(String CodSlot){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Tipo di coda:"+rs.getString("Tipo di coda"));
				System.out.println("Ngate:"+rs.getInt("Ngate"));
				System.out.println("CodSlot:"+rs.getInt("CodSlot"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

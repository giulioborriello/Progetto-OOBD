package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coda_di_imbarcoDAOPostgres {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertCoda_di_imbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot)	{
			
			try {
				ps = conn.prepareStatement("INSERT INTO \"Coda di imbarco\"  VALUES (?, ?, ?, ?); ");
				ps.setInt(1, CodCoda);
				ps.setString(2, Tipo_di_coda);
				ps.setInt(3, Ngate);
				ps.setInt(4, CodSlot);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}

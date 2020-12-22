package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GateDAO {
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	
	public GateDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public void getAllGate() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Gate\"");
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getGateByNgate(int Ngate) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"Ngate\" = ?");
			ps.setInt(1, Ngate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getGateByCodTratta(String CodTratta) {
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Ngate: "+rs.getInt("Ngate"));
				System.out.println("CodTratta: "+rs.getString("CodTratta"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
//	public void InsertGate(Statement st){
//		try {
//			st.executeQuery("INSERT INTO public.\"Gate\"(\"Ngate\", \"CodTratta\") VALUES (?, ?)");
//			
//		} 
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}


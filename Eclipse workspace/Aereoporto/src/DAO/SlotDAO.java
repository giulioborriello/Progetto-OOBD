package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SlotDAO {
	Statement st = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	public void getAllSlot() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			while(rs.next()) {
				System.out.println("CodSlot:"+rs.getString("CodSlot"));
				System.out.println("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
				System.out.println("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Data:" + rs.getDate("Data"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByCodSlot(String CodSlot) {
		try {
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodSlot:"+rs.getString("CodSlot"));
				System.out.println("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
				System.out.println("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Data:" + rs.getDate("Data"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

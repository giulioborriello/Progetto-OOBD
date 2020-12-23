package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SlotDAO {
	Statement st = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	
	
	public SlotDAO(Connection conn) {
		super();
		this.conn = conn;
	}

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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByCodCoda(String CodCoda) {
		try {
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodSlot:"+rs.getString("CodSlot"));
				System.out.println("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
				System.out.println("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Data:" + rs.getDate("Data"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByData(String Data) {
		try {
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodSlot:"+rs.getString("CodSlot"));
				System.out.println("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
				System.out.println("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Data:" + rs.getDate("Data"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, int CodCoda, Date Data)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setInt(1, CodSlot);
			ps.setInt(2, Tempo_di_imbarco_stimato);
			ps.setInt(3, Tempo_di_imbarco_effettivo);
			ps.setInt(4, CodCoda);
			ps.setDate(5, Data);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTempoDiImbarcoEffettivoByCodSlot(String TempoDiImbarcoEffettivo, String CodSlot)	{
		
		try {
			ps = conn.prepareStatement("UPDATE \"Slot\" SET \"TempoDiImbarcoEffettivo\" = ? WHERE \"CodSlot\" = ? ; ");
			ps.setString(1, TempoDiImbarcoEffettivo);
			ps.setString(2, CodSlot);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

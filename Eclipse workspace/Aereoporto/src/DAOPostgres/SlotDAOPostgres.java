package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.SlotDAO;
import Entità.Slot;



public class SlotDAOPostgres implements SlotDAO{

	Statement st = null;
	PreparedStatement ps = null;
	List<Slot> ListSlot = new LinkedList<Slot>();
	
	
	public SlotDAOPostgres() {
		
	}

	public List<Slot> getAllSlot() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			
			
			while(rs.next()) {
//				("CodSlot:"+rs.getString("CodSlot"));
//				("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
//				("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
//				("CodCoda" + rs.getInt("CodCoda"));
//				rs.getDate("Data"));
				
				
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), null);
				
				ListSlot.add(Slot);
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return ListSlot;
	}
	
	public List<Slot> getSlotByCodSlot(String CodSlot) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), null);
				
				ListSlot.add(Slot);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListSlot;
	}
	
	public List<Slot> getSlotByCodCoda(String CodCoda) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), null);
				
				ListSlot.add(Slot);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListSlot;
	}
	
	public List<Slot> getSlotByData(String Data) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), null);
				
				ListSlot.add(Slot);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSlot;	
	}
	
	public void insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, int CodCoda, Date Data)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setInt(1, CodSlot);
			ps.setInt(2, Tempo_di_imbarco_stimato);
			ps.setInt(3, Tempo_di_imbarco_effettivo);
			ps.setInt(4, CodCoda);
			ps.setDate(5, Data);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			ps = conn.prepareStatement("UPDATE \"Slot\" SET \"TempoDiImbarcoEffettivo\" = ? WHERE \"CodSlot\" = ? ; ");
			ps.setInt(1, TempoDiImbarcoEffettivo);
			ps.setInt(2, CodSlot);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

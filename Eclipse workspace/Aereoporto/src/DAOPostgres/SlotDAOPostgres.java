package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import DAO.SlotDAO;
import Entità.Slot;



public class SlotDAOPostgres implements SlotDAO{

	private List<Slot> ListSlot = new LinkedList<Slot>();
	private Connection conn;
	
	public SlotDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();

	}

	public List<Slot> getAllSlot() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			
			
			while(rs.next()) {
				
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"));
				
				ListSlot.add(Slot);
			}
			conn.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return ListSlot;
	}
	
	public Slot getSlotByCodSlot(int CodSlot) {
		Slot slot = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodSlot\" = ?");
			ps.setInt(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"));
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return slot;
	}
	
	public Slot getSlotByCodCoda(int codCoda) {
		Slot slot = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodCoda\" = ?");
			ps.setInt(1, codCoda);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"));
				
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return slot;
	}
	
	public List<Slot> getSlotByData(String Data) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Slot Slot = new Slot(rs.getInt("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"));
				
				ListSlot.add(Slot);
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSlot;	
	}
	
	public String insertSlot(int CodSlot, int TempoDiImbarcoStimato, int TempoDiImbarcoEffettivo,Date Data)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, ?); ");
			ps.setInt(1, CodSlot);
			ps.setInt(2, TempoDiImbarcoStimato);
			ps.setInt(3, TempoDiImbarcoEffettivo);
			ps.setDate(4, Data);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Inserito Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	
	public String updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Slot\" SET \"TempoDiImbarcoEffettivo\" = ? WHERE \"CodSlot\" = ? ; ");
			ps.setInt(1, TempoDiImbarcoEffettivo);
			ps.setInt(2, CodSlot);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Aggiornato Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	public String deleteSlot(int CodSlot) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Slot\"  WHERE \"CodSlot\" = ? ; ");
	
			ps.setInt(1, CodSlot);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Eliminato Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	
}

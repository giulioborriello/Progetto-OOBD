package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import DAO.SlotDAO;
import Entità.CodaDiImbarco;
import Entità.Slot;



public class SlotDAOPostgres implements SlotDAO{

	private List<Slot> listSlot = new LinkedList<Slot>();
	private Connection conn;
	private CodaDiImbarcoDAOPostgres coda;
	private SingletonPostgres sp;
	
	public SlotDAOPostgres(SingletonPostgres singleton) {
		conn = singleton.getConnection();
		sp = singleton;
	}

	
	public Slot getSlotByCodSlot(String CodSlot) {
		Slot slot = null;
		try {
			
			coda = new CodaDiImbarcoDAOPostgres(sp);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Slot\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				slot = new Slot(rs.getString("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getDate("Data"), 
						coda.getCodaDiImbarcoByCodCoda("CodCoda"));
				
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
	
	public Slot getSlotByCodSlot(String CodSlot, CodaDiImbarco coda) {
		Slot slot = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Slot\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			rs.next();
				
				slot = new Slot(rs.getString("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getDate("Data"),
						coda);
				
			
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return slot;
	}
	
	public Slot getSlotByCodCoda(String codCoda) {
		Slot slot = null;
		try {
			
			coda = new CodaDiImbarcoDAOPostgres(sp);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodCoda\" = ?");
			ps.setString(1, codCoda);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				slot = new Slot(rs.getString("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getDate("Data"), 
						coda.getCodaDiImbarcoByCodCoda("CodCoda"));
				
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
	
	public List<Slot> getSlotByData(Date Data) {
		try {
			
			coda = new CodaDiImbarcoDAOPostgres(sp);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"Data\" = ?");
			ps.setDate(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Slot Slot = new Slot(rs.getString("CodSlot"), rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getDate("Data"),
						coda.getCodaDiImbarcoByCodCoda("CodCoda"));
				
				listSlot.add(Slot);
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSlot;	
	}
	
	public String insertSlot(String CodSlot, int TempoDiImbarcoStimato, int TempoDiImbarcoEffettivo, String CodCoda)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, null, ?); ");
			ps.setString(1, CodSlot);
			ps.setInt(2, TempoDiImbarcoStimato);
			ps.setInt(3, TempoDiImbarcoEffettivo);
			ps.setString(4, CodCoda);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Inserito Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	
	public String updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, String CodSlot)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Slot\" SET \"TempoDiImbarcoEffettivo\" = ? WHERE \"CodSlot\" = ? ; ");
			ps.setInt(1, TempoDiImbarcoEffettivo);
			ps.setString(2, CodSlot);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Aggiornato Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	public String deleteSlot(String CodSlot) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Slot\"  WHERE \"CodSlot\" = ? ; ");
	
			ps.setString(1, CodSlot);
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

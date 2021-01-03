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

import DAO.CodaDiImbarcoDAO;
import DAO.SlotDAO;
import Entità.CodaDiImbarco;
import Entità.Slot;



public class SlotDAOPostgres implements SlotDAO{

	List<Slot> ListSlot = new LinkedList<Slot>();
	Connection conn;
	SingletonPostgres singleton;
	public SlotDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;

	}

	public List<Slot> getAllSlot() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			
			
			while(rs.next()) {
				
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres(singleton);
				int codSlot = rs.getInt("CodSlot");
				Slot Slot = new Slot(codSlot, rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), coda.getCodaDiImbarcoByCodSlot(codSlot));
				
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
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres(singleton);
				int codSlot = rs.getInt("CodSlot");
				slot = new Slot(codSlot, rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), coda.getCodaDiImbarcoByCodSlot(codSlot));
				
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
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres(singleton);
				int codSlot = rs.getInt("CodSlot");
				slot = new Slot(codSlot, rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), coda.getCodaDiImbarcoByCodSlot(codSlot));
				
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
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres(singleton);
				int codSlot = rs.getInt("CodSlot");
				Slot Slot = new Slot(codSlot, rs.getInt("TempoDiImbarcoStimato"), 
						rs.getInt("TempoDiImbarcoEffettivo"), rs.getInt("CodCoda"), rs.getDate("Data"), coda.getCodaDiImbarcoByCodSlot(codSlot));
				
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
	
	public String insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo,Date Data)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, ?); ");
			ps.setInt(1, CodSlot);
			ps.setInt(2, Tempo_di_imbarco_stimato);
			ps.setInt(3, Tempo_di_imbarco_effettivo);
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

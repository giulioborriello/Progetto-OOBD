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
	
	public SlotDAOPostgres(Connection connection) {
		conn = connection;
	}

	public List<Slot> getAllSlot() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			
			
			while(rs.next()) {
				
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres();
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
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodSlot\" = ?");
			ps.setInt(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres();
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
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"CodCoda\" = ?");
			ps.setInt(1, codCoda);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres();
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
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Slot\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres();
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
	
	public void insertSlot(int CodSlot, int Tempo_di_imbarco_stimato, int Tempo_di_imbarco_effettivo, int CodCoda, Date Data)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Slot\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setInt(1, CodSlot);
			ps.setInt(2, Tempo_di_imbarco_stimato);
			ps.setInt(3, Tempo_di_imbarco_effettivo);
			ps.setInt(4, CodCoda);
			ps.setDate(5, Data);
			ps.execute();
			conn.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTempoDiImbarcoEffettivoByCodSlot(int TempoDiImbarcoEffettivo, int CodSlot)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Slot\" SET \"TempoDiImbarcoEffettivo\" = ? WHERE \"CodSlot\" = ? ; ");
			ps.setInt(1, TempoDiImbarcoEffettivo);
			ps.setInt(2, CodSlot);
			ps.execute();
			conn.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.SlotDAO;
import Entità.Slot;



public class SlotDAOPostgres implements SlotDAO{

	Statement st = null;
	PreparedStatement ps = null;
	List<Slot> ListSlot;
	
	
	public SlotDAOPostgres() {
	}

	public List<Slot> getAllSlot() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Slot\"");
			
			
			while(rs.next()) {
				System.out.println("CodSlot:"+rs.getString("CodSlot"));
				System.out.println("Tempo di imbarco stimato:"+rs.getInt("Tempo di imbarco stimato"));
				System.out.println("Tempo di imbarco effettivo:"+rs.getTime("Tempo di imbarco effettivo"));
				System.out.println("CodCoda" + rs.getInt("CodCoda"));
				System.out.println("Data:" + rs.getDate("Data"));
				
				CodaDiImbarcoDAOPostgres coda = new CodaDiImbarcoDAOPostgres();
				
				Slot Slot = new Slot(rs.getString("CodSlot"), rs.getInt("Tempo di imbarco stimato"), 
						rs.getTime("Tempo di imbarco effettivo"), rs.getInt("CodCoda"), rs.getDate("Data"),
						coda.getCodaDiImbarcoByCodSlot(rs.getString("CodSlot")));
				
				ListSlot.add(Slot);
			}
			
			return ListSlot;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByCodSlot(String CodSlot) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
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
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByCodCoda(String CodCoda) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
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
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getSlotByData(String Data) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
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
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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

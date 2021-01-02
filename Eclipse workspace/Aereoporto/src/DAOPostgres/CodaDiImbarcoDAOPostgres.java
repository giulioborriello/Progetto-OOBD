package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.CodaDiImbarcoDAO;
import Entità.Biglietto;
import Entità.CodaDiImbarco;
import Entità.Slot;

public class CodaDiImbarcoDAOPostgres implements CodaDiImbarcoDAO{
	Connection conn;
	List<CodaDiImbarco> ListCodaDiImbarco = new LinkedList<CodaDiImbarco>();

	public CodaDiImbarcoDAOPostgres(Connection connection) {
		conn = connection;
	}
	
	public List<CodaDiImbarco> getAllCodaDiImbarco() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Code di imbarco\"");
			
			while(rs.next()) {
				SlotDAOPostgres slot = new SlotDAOPostgres(conn);
				GateDAOPostgres gate = new GateDAOPostgres(conn);
				int codCoda = rs.getInt("CodCoda");
				int ngate = rs.getInt("Ngate");
				
				CodaDiImbarco codaDiImbarco = new CodaDiImbarco(codCoda, rs.getString("TipoDiCoda"), ngate,
						rs.getInt("CodSlot"), slot.getSlotByCodCoda(codCoda), gate.getGateByNgate(ngate));
				
				ListCodaDiImbarco.add(codaDiImbarco);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListCodaDiImbarco;	
	}

	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SlotDAOPostgres slot = new SlotDAOPostgres(conn);
				GateDAOPostgres gate = new GateDAOPostgres(conn);
				int codCoda = rs.getInt("CodCoda");
				int ngate = rs.getInt("Ngate");
				
				codaDiImbarco = new CodaDiImbarco(rs.getInt("CodCoda"), rs.getString("TipoDiCoda"), rs.getInt("Ngate"),
						rs.getInt("CodSlot"), slot.getSlotByCodCoda(codCoda), gate.getGateByNgate(ngate));
			
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return codaDiImbarco;	

	}
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"Ngate\" = ?");
			ps.setString(1, Ngate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SlotDAOPostgres slot = new SlotDAOPostgres(conn);
				GateDAOPostgres gate = new GateDAOPostgres(conn);
				int codCoda = rs.getInt("CodCoda");
				int ngate = rs.getInt("Ngate");
				
				codaDiImbarco = new CodaDiImbarco(rs.getInt("CodCoda"), rs.getString("TipoDiCoda"), rs.getInt("Ngate"),
						rs.getInt("CodSlot"), slot.getSlotByCodCoda(codCoda), gate.getGateByNgate(ngate));
			
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return codaDiImbarco;	

	}
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(int codSlot){
		CodaDiImbarco codaDiImbarco = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodSlot\" = ?");
			ps.setInt(1, codSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SlotDAOPostgres slot = new SlotDAOPostgres(conn);
				GateDAOPostgres gate = new GateDAOPostgres(conn);
				int codCoda = rs.getInt("CodCoda");
				int ngate = rs.getInt("Ngate");
				
				codaDiImbarco = new CodaDiImbarco(rs.getInt("CodCoda"), rs.getString("TipoDiCoda"), rs.getInt("Ngate"),
						rs.getInt("CodSlot"), slot.getSlotByCodCoda(codCoda), gate.getGateByNgate(ngate));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codaDiImbarco;
	}
	
	public String insertCodaDiImbarco(int CodCoda, String Tipo_di_coda, int Ngate, int CodSlot)	{
			try {
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Coda di imbarco\"  VALUES (?, ?, ?, ?); ");
				ps.setInt(1, CodCoda);
				ps.setString(2, Tipo_di_coda);
				ps.setInt(3, Ngate);
				ps.setInt(4, CodSlot);
				ps.execute();
				
				ps.close();
				conn.close();
				return "Inserito Correttamente!";
			} catch (SQLException e) {
				return e.getMessage();
			}
			
	}
	
	public String deleteCodaDiImbarco(int CodCoda) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Coda di imbarco\"  WHERE \"CodCoda\" = ? ; ");
				
			ps.setInt(1, CodCoda);
			ps.execute();
			ps.close();
			conn.close();
				
			return "Eliminato Correttamente";
				
		} catch (SQLException e) {
			return e.getMessage();
		} 
	}
}

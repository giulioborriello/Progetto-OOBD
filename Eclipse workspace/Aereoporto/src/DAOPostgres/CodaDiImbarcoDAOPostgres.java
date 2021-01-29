package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.CodaDiImbarcoDAO;
import Entità.CodaDiImbarco;

public class CodaDiImbarcoDAOPostgres implements CodaDiImbarcoDAO{
	
	private Connection conn;
	private GateDAOPostgres gate;
	private SlotDAOPostgres slot;
	
	
	public CodaDiImbarcoDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		gate = new GateDAOPostgres(sp);
		slot = new SlotDAOPostgres(sp);
	}
	

	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("TipoDiCoda"), 
						gate.getGateByCodGate(rs.getString("CodGate")),
						slot.getSlotByCodSlot(rs.getString("CodSlot")));
			
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
	
	public CodaDiImbarco getCodaDiImbarcoByNgate(String Ngate, String data){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"Ngate\" = ?"
					+ "AND \"Data\" = ?");
			ps.setString(1, Ngate);
			ps.setString(2, data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("TipoDiCoda"), 
						gate.getGateByCodGate(rs.getString("CodGate")),
						slot.getSlotByCodSlot(rs.getString("CodSlot")));
			
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
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(String CodSlot, String data){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodSlot\" = ?"
					+ "AND \"Data\" = ?");
			ps.setString(1, CodSlot);
			ps.setString(2, data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("TipoDiCoda"), 
						gate.getGateByCodGate(rs.getString("CodGate")),
						slot.getSlotByCodSlot(rs.getString("CodSlot")));
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
	
	public String insertCodaDiImbarco(String CodCoda, String TipoDiCoda, String Ngate, String CodSlot)	{
			try {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Coda di imbarco\"  VALUES (?, ?, ?, ?, null); ");
				ps.setString(1, CodCoda);
				ps.setString(2, TipoDiCoda);
				ps.setString(3, Ngate);
				ps.setString(4, CodSlot);
				ps.execute();
				
				ps.close();
				conn.close();
				return "Inserito Correttamente!";
			} catch (SQLException e) {
				return e.getMessage();
			}
			
	}
	
	public String deleteCodaDiImbarco(String CodCoda) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Coda di imbarco\"  WHERE \"CodCoda\" = ? ; ");
				
			ps.setString(1, CodCoda);
			ps.execute();
			ps.close();
			conn.close();
				
			return "Eliminato Correttamente";
				
		} catch (SQLException e) {
			return e.getMessage();
		} 
	}
}

package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.CodaDiImbarcoDAO;
import Entità.CodaDiImbarco;
import Entità.Gate;
import Entità.Slot;

public class CodaDiImbarcoDAOPostgres implements CodaDiImbarcoDAO{
	
	private Connection conn;
	private GateDAOPostgres gate;
	private SlotDAOPostgres slot;
	private SingletonPostgres sp;
	
	public CodaDiImbarcoDAOPostgres(SingletonPostgres singleton) {
		conn = singleton.getConnection();
		sp = singleton;
	}
	

	public CodaDiImbarco getCodaDiImbarcoByCodCoda(String CodCoda){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodCoda\" = ?");
			ps.setString(1, CodCoda);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				gate = new GateDAOPostgres(sp);
				Gate gate2 = gate.getGateByCodGate(rs.getString("CodGate"));
				slot = new SlotDAOPostgres(sp);
				Slot slot2 = slot.getSlotByCodSlot(rs.getString("CodSlot"), codaDiImbarco);
				
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("Tipo di coda"), 
						gate2, slot2);
			
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
	
	public CodaDiImbarco getCodaDiImbarcoByCodGate(String CodGate){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodGate\" = ?");
			ps.setString(1, CodGate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gate = new GateDAOPostgres(sp);
				Gate gate2 = gate.getGateByCodGate(rs.getString("CodGate"));		
				slot = new SlotDAOPostgres(sp);
				Slot slot2 = slot.getSlotByCodSlot(rs.getString("CodSlot"));
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("Tipo di coda"), gate2, slot2);
					

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
	
	public CodaDiImbarco getCodaDiImbarcoByCodSlot(String CodSlot){
		CodaDiImbarco codaDiImbarco = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Coda di imbarco\" WHERE \"CodSlot\" = ?");
			ps.setString(1, CodSlot);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				gate = new GateDAOPostgres(sp);
				Gate gate2 = gate.getGateByCodGate(rs.getString("CodGate"));		
				slot = new SlotDAOPostgres(sp);
				Slot slot2 = slot.getSlotByCodSlot(rs.getString("CodSlot"));
				
				
				codaDiImbarco = new CodaDiImbarco(rs.getString("CodCoda"), rs.getString("Tipo di coda"), 
						gate2, slot2);
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
	
	public String insertCodaDiImbarco(String CodCoda, String TipoDiCoda, String Ngate)	{
			try {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Coda di imbarco\"  VALUES (?, ?, ?, null, null); ");
				ps.setString(1, CodCoda);
				ps.setString(2, TipoDiCoda);
				ps.setString(3, Ngate);
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

package DAOPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import DAO.GateDAO;
import Entità.Gate;
import Entità.Tempistica;

public class GateDAOPostgres implements GateDAO{
	private Connection conn;
	private Statement st;
	private List<Gate> listGate = new LinkedList<Gate>();

	
	public GateDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
	}
	
	public List<Gate> getAllGate() {
	
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Gate\"");
			while(rs.next()) {
				
				Gate gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"));
				
				listGate.add(gate);
				
			}
			conn.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return listGate;	
	}
	
	public Gate getGateByNgate(int Ngate) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"Ngate\" = ?");
			ps.setInt(1, Ngate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"));
				
			}
			conn.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gate;	
	}
	
	public Gate getGateByCodTratta(String CodTratta) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"));
				
			}
			conn.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gate;	
	}

	public List<Tempistica> GetTempisticheGiorni(String Anno, String Mese) {
		List<Tempistica> list = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"data\") AS yeard , extract(month from B.\"data\" ) AS monthd, extract(day from B.\"data\") AS dayd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add" 
					+ "FROM ((public.\"Gate\" INNER JOIN public.\"Coda di imbarco\" ON (public.\"Gate\".\"Ngate\" = public.\"Coda di imbarco\".\"Ngate\")) AS AA INNER JOIN public.\"Slot\" ON (AA.\"Codslot\" = public.\"Slot\".\"CodSlot\")) AS B "
					+ "WHERE  extract(month from B.\"data\") = ? AND extract(year from B.\"data\") = ?"  
					+ "GROUP BY yeard , dayd ,  monthd;");
			ps.setString(1, Mese);
			ps.setString(2, Anno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Tempistica tempo = new Tempistica(rs.getString("yeard"), rs.getString("monthd"), rs.getString("add"));
				list.add(tempo);
			}
			conn.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	
	}
		
	
	
}









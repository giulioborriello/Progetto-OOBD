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

	public void GetTempistiche(String Anno, String Mese, String Giorno) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT YEAR(public.\"B\".\"data\"), MONTH(public.\"B\".\"data\"), DAY(public.\"B\".\"data\") SUM public.\"B\".\"TempoDiImbarcoEffettivo\" "
					+ "FROM (public.\"gate\" INNER JOIN public.\"CodaDiImbarco\" ON (public.\"gate\".\"Ngate\" = public.\"CodaDiImbarco\".Ngate)) AS aa INNER JOIN public.\"Slot\" ON (public.\"aa\".\"CodSlot\" = public.\"Slot\".CodSlot) AS B "
					+ "WHERE YEAR(public.\"B\".\"data\") = ?,  MONTH(public.\"B\".\"data\") = ?,  DAY(public.\"B\".\"data\") "
					+ "GROUP BY year(public.\"B\".\"data\") AND day(public.\"B\".\"data\") AND  MONTH(public.\"B\".\"data\")");
			ps.setString(1, Anno);
			ps.setString(1, Mese);
			ps.setString(1, Giorno);
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
		
	}






}


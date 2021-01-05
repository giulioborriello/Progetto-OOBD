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
	private List<Gate> ListGate = new LinkedList<Gate>();

	
	public GateDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
	}
	
	public List<Gate> getAllGate() {
	
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Gate\"");
			while(rs.next()) {
				
				Gate gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"));
				
				ListGate.add(gate);
				
			}
			conn.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return ListGate;	
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
	
	public String insertGate(int Ngate, String CodTratta)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?); ");
			ps.setInt(1, Ngate);
			ps.setString(2, CodTratta);
			ps.execute();
			st.close();
			conn.close();
			
			return "Inserito Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	public String updateCodTrattaByNgate(String CodTratta, int Ngate)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Gate\" SET \"CodTratta\" = ? WHERE \"Ngate\" = ? ; ");
			ps.setString(1, CodTratta);
			ps.setInt(2, Ngate);
			ps.execute();
			st.close();
			conn.close();
			
			return "Aggiornato Correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	public String deleteGate(int Ngate) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Gate\"  WHERE \"Ngate\" = ? ; ");
				
			ps.setInt(1, Ngate);
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


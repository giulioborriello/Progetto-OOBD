package DAOPostgres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.GateDAO;
import Entità.Gate;

public class GateDAOPostgres implements GateDAO{
	Connection conn;
	PreparedStatement ps = null;
	Statement st = null;
	List<Gate> ListGate = new LinkedList<Gate>();
	
	public GateDAOPostgres(Connection connection) {
		conn = connection;
	}
	
	public List<Gate> getAllGate() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Gate\"");
			while(rs.next()) {
				TrattaDAOPostgres tratta = new TrattaDAOPostgres(conn);
				int nGate = rs.getInt("Ngate");
				Gate gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"), tratta.getTrattaNgate(nGate));
				
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
				TrattaDAOPostgres tratta = new TrattaDAOPostgres(conn);
				int nGate = rs.getInt("Ngate");
				gate = new Gate(rs.getInt("Ngate"), rs.getString("CodTratta"), tratta.getTrattaNgate(nGate));
				
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
				TrattaDAOPostgres tratta = new TrattaDAOPostgres(conn);
				int nGate = rs.getInt("Ngate");
				gate = new Gate(nGate, rs.getString("CodTratta"), tratta.getTrattaNgate(nGate));
				
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
	
	public void insertGate(int Ngate, String CodTratta)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Compagnia\"  VALUES (?, ?); ");
			ps.setInt(1, Ngate);
			ps.setString(2, CodTratta);
			ps.execute();
			conn.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCodTrattaByNgate(String CodTratta, int Ngate)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Gate\" SET \"CodTratta\" = ? WHERE \"Ngate\" = ? ; ");
			ps.setString(1, CodTratta);
			ps.setInt(2, Ngate);
			ps.execute();
			conn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


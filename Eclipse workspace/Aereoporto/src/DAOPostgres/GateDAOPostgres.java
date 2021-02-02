package DAOPostgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import DAO.GateDAO;
import Entità.Compagnia;
import Entità.Gate;
import Entità.Tempistica;
import Entità.Tratta;

public class GateDAOPostgres implements GateDAO{
	private Connection conn;
	private Statement st;
	private TrattaDAOPostgres tratta;
	private SingletonPostgres singleton;
	private Tratta codTratta2;
	
	public GateDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		tratta = new TrattaDAOPostgres(sp);
		singleton = sp;
	}
	
	
	public List<Gate> getGateByNGate(String NGate, Date data) {
		List<Gate> gates = new LinkedList<Gate>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"Ngate\" = ? AND \"Data\" = ?");
			ps.setString(1, NGate);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			
			TrattaDAOPostgres tratta2 = new TrattaDAOPostgres(singleton);
			codTratta2 = tratta2.getTrattaByCodTratta("CodTratta");
			while(rs.next()) {
				
				Gate gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), codTratta2, rs.getDate("Data"));
				gates.add(gate);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gates;	
	}
	
	public Gate getGateByCodGate(String CodGate) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"CodGate\" = ?");
			ps.setString(1, CodGate);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
				
				gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), tratta.getTrattaByCodTratta(rs.getString("CodTratta")), rs.getDate("Data"));
				
			
			conn.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gate;	
	}
	
	public Gate getGateByCodGate(String CodGate, Tratta tratta) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"CodGate\" = ?");
			ps.setString(1, CodGate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), tratta, rs.getDate("Data"));
				
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gate;	
	}
	
	public Gate getGateByCodTratta(String codTratta) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"CodTratta\" = ?");
			ps.setString(1, codTratta);
			ResultSet rs=ps.executeQuery();
			
			
			rs.next();
				TrattaDAOPostgres tratta2 = new TrattaDAOPostgres(singleton);
				codTratta2 = tratta2.getTrattaByCodTratta(rs.getString("CodTratta"));
				gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), codTratta2, rs.getDate("Data"));
				
			conn.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gate;	
	}

	public List<Tempistica> getTempisticheGiorni(String Ngate, String mese, String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Mese = Double.valueOf(mese);
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"Data\") AS yeard , extract(month from B.\"Data\" ) AS monthd, extract(day from B.\"Data\") AS dayd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add FROM ((public.\"Gate\" NATURAL JOIN public.\"Coda di imbarco\" ) AS AA NATURAL JOIN public.\"Slot\" ) AS B WHERE  extract(month from B.\"Data\") = ? AND extract(year from B.\"Data\") = ? AND \"Ngate\" = ? GROUP BY yeard , monthd,  dayd;");
			ps.setDouble(1, Mese);
			ps.setDouble(2, Anno);
			ps.setString(3, Ngate);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Tempistica tempo = new Tempistica(rs.getString("yeard"), rs.getString("monthd"), null,  rs.getString("dayd"), rs.getString("add"));
				list.add(tempo);
			}
			rs.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
		
	public List<Tempistica> getTempisticheMesi(String Ngate, String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"Data\") AS yeard , extract(month from B.\"Data\" ) AS monthd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add "
					+ "FROM ((public.\"Gate\" NATURAL JOIN public.\"Coda di imbarco\") AS AA NATURAL JOIN public.\"Slot\") AS B "
					+ "WHERE extract(year from B.\"Data\") = ? AND \"Ngate\" = ? "
					+ "GROUP BY yeard , monthd;");
			ps.setDouble(1, Anno);
			ps.setString(2, Ngate);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Tempistica tempo = new Tempistica(rs.getString("yeard"), rs.getString("monthd"),null, null, rs.getString("add"));
				list.add(tempo);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Tempistica> getTempisticheSettimane(String Ngate ,String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"Data\") AS yeard , extract(week from B.\"Data\" ) AS weekd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add "
					+ "FROM ((public.\"Gate\" NATURAL JOIN public.\"Coda di imbarco\" ) AS AA NATURAL JOIN public.\"Slot\") AS B "
					+ "WHERE extract(year from B.\"Data\") = ?, AND \"Ngate\" = ?  "
					+ "GROUP BY yeard , weekd;");
			ps.setDouble(1, Anno);
			ps.setString(2, Ngate);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Tempistica tempo = new Tempistica(rs.getString("yeard"), null, rs.getString("weekd"), null, rs.getString("add"));
				list.add(tempo);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String insertGate(String CodGate, String Ngate, String CodTratta)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Gate\"  VALUES (?, ?, null, ?); ");
			ps.setString(1, CodGate);
			ps.setString(2, CodTratta);
			ps.setString(3, Ngate);

			ps.execute();
			
			ps.close();
			conn.close();
			return "Inserito Correttamente";
		} catch (SQLException e) {
			return e.getMessage();
		}
		
	}


	public String deleteGate(String CodGate) {
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Gate\"  WHERE \"CodGate\" = ? ; ");
				
			ps.setString(1, CodGate);
			ps.execute();
			ps.close();
			conn.close();
				
			return "Eliminato correttamente";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
	










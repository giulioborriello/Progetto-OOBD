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
import Entità.Gate;
import Entità.Tempistica;

public class GateDAOPostgres implements GateDAO{
	private Connection conn;
	private Statement st;
	private TrattaDAOPostgres tratta;
	
	public GateDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		tratta = new TrattaDAOPostgres(sp);
	}
	
	
	public Gate getGateByCodGate(String CodGate) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Gate\" WHERE \"CodGate\" = ?");
			ps.setString(1, CodGate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), tratta.getTrattaByCodTratta("CodTratta"), rs.getDate("Data"));
				
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
	
	public Gate getGateByCodTratta(String codTratta, Date data) {
		Gate gate = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Fedeltà\" WHERE \"CodTratta\" = ?"
					+ "AND \"Data\" = ?");
			ps.setString(1, codTratta);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				gate = new Gate(rs.getString("CodGate"), rs.getString("Ngate"), tratta.getTrattaByCodTratta("CodTratta"), rs.getDate("Data"));
				
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

	public List<Tempistica> GetTempisticheGiorni(String mese, String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Mese = Double.valueOf(mese);
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"data\") AS yeard , extract(month from B.\"data\" ) AS monthd, extract(day from B.\"data\") AS dayd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add FROM ((public.\"Gate\" INNER JOIN public.\"Coda di imbarco\" ON (public.\"Gate\".\"Ngate\" = public.\"Coda di imbarco\".\"Ngate\")) AS AA INNER JOIN public.\"Slot\" ON (AA.\"Codslot\" = public.\"Slot\".\"CodSlot\")) AS B WHERE  extract(month from B.\"data\") = ? AND extract(year from B.\"data\") = ?  GROUP BY yeard , monthd,  dayd;");
			ps.setDouble(1, Mese);
			ps.setDouble(2, Anno);
			
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
		
	public List<Tempistica> GetTempisticheMesi(String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"data\") AS yeard , extract(month from B.\"data\" ) AS monthd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add "
					+ "FROM ((public.\"Gate\" INNER JOIN public.\"Coda di imbarco\" ON (public.\"Gate\".\"Ngate\" = public.\"Coda di imbarco\".\"Ngate\")) AS AA INNER JOIN public.\"Slot\" ON (AA.\"Codslot\" = public.\"Slot\".\"CodSlot\")) AS B "
					+ "WHERE extract(year from B.\"data\") = ?  "
					+ "GROUP BY yeard , monthd;");
			ps.setDouble(1, Anno);
			
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
	
	
	public List<Tempistica> GetTempisticheSettimane(String anno) {
		List<Tempistica> list = new LinkedList<Tempistica>();
		
		try {
			st = conn.createStatement();
			double Anno = Double.valueOf(anno);
			PreparedStatement ps = conn.prepareStatement("SELECT extract(year from B.\"data\") AS yeard , extract(week from B.\"data\" ) AS weekd, SUM (B.\"TempoDiImbarcoEffettivo\") AS add "
					+ "FROM ((public.\"Gate\" INNER JOIN public.\"Coda di imbarco\" ON (public.\"Gate\".\"Ngate\" = public.\"Coda di imbarco\".\"Ngate\")) AS AA INNER JOIN public.\"Slot\" ON (AA.\"Codslot\" = public.\"Slot\".\"CodSlot\")) AS B "
					+ "WHERE extract(year from B.\"data\") = ?  "
					+ "GROUP BY yeard , weekd;");
			ps.setDouble(1, Anno);
			
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
	
}









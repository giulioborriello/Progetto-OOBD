package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class TrattaDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	
	public TrattaDAO(Connection conn) {
			super();
			this.conn = conn;
	}
	
		
	public void getAllTratta() {
			try {
				st = conn.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM public.\"Tratta\"");
				int i=1;
				while(rs.next()) {
					System.out.println("Tratta numero"+i);
					System.out.println("CodTratta:"+rs.getString("CodTratta"));
					System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
					System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
					System.out.println("Data:" + rs.getDate("Data"));
					System.out.println("Ngate" + rs.getInt("Ngate"));
					System.out.println("CodIATA:" + rs.getString("CodIATA"));
					System.out.println("Destinazione:" + rs.getString("Destinazione"));
					i++;
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	public void getTrattaByCodTratta(String CodTratta){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodTratta:"+rs.getString("CodTratta"));
				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
				System.out.println("Data:" + rs.getDate("Data"));
				System.out.println("Ngate" + rs.getInt("Ngate"));
				System.out.println("CodIATA:" + rs.getString("CodIATA"));
				System.out.println("Destinazione:" + rs.getString("Destinazione"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getTrattaByData(String Data){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Data\" = ?");
			ps.setString(1, Data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodTratta:"+rs.getString("CodTratta"));
				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
				System.out.println("Data:" + rs.getDate("Data"));
				System.out.println("Ngate" + rs.getInt("Ngate"));
				System.out.println("CodIATA:" + rs.getString("CodIATA"));
				System.out.println("Destinazione:" + rs.getString("Destinazione"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getTrattaNgate(String Ngate){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Ngate\" = ?");
			ps.setString(1, Ngate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodTratta:"+rs.getString("CodTratta"));
				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
				System.out.println("Data:" + rs.getDate("Data"));
				System.out.println("Ngate" + rs.getInt("Ngate"));
				System.out.println("CodIATA:" + rs.getString("CodIATA"));
				System.out.println("Destinazione:" + rs.getString("Destinazione"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getTrattaCodIATA(String CodIATA){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodIATA\" = ?");
			ps.setString(1, CodIATA);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodTratta:"+rs.getString("CodTratta"));
				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
				System.out.println("Data:" + rs.getDate("Data"));
				System.out.println("Ngate" + rs.getInt("Ngate"));
				System.out.println("CodIATA:" + rs.getString("CodIATA"));
				System.out.println("Destinazione:" + rs.getString("Destinazione"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getTrattaDestinazione(String Destinazione){
		try {
			ps = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Destinazione\" = ?");
			ps.setString(1, Destinazione);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodTratta:"+rs.getString("CodTratta"));
				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
				System.out.println("Data:" + rs.getDate("Data"));
				System.out.println("Ngate" + rs.getInt("Ngate"));
				System.out.println("CodIATA:" + rs.getString("CodIATA"));
				System.out.println("Destinazione:" + rs.getString("Destinazione"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertTratta(String CodTratta, int Nprenotazioni, Time localTime, Date localDate, int Ngate,  String CodIATA, String Destinazione) {
		try {
			ps = conn.prepareStatement("INSERT INTO \"Tratta\" VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, CodTratta);
			ps.setInt(2, Nprenotazioni);
			ps.setTime(3, localTime);
			ps.setDate(4, localDate);
			ps.setInt(5, Ngate);
			ps.setString(6, CodIATA);
			ps.setString(7, Destinazione);
			ps.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	public void VerificaFormatoCodTratta() {
//		 try {
//			st.executeUpdate("ALTER TABLE \"Tratta\" ADD CONSTRAINT Verifica_Formato_CodTratta CHECK(\"CodTratta\" ~* '^[a-zA-Z] + [a-zA-Z] + [a-zA-Z] + % +$ ')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

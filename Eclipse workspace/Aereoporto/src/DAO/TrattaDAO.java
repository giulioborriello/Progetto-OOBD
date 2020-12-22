package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

public class TrattaDAO {
	Connection conn = null;
	PreparedStatement StGet = null;
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodTratta\" = ?");
			StGet.setString(1, CodTratta);
			ResultSet rs=StGet.executeQuery();
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Data\" = ?");
			StGet.setString(1, Data);
			ResultSet rs=StGet.executeQuery();
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Ngate\" = ?");
			StGet.setString(1, Ngate);
			ResultSet rs=StGet.executeQuery();
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"CodIATA\" = ?");
			StGet.setString(1, CodIATA);
			ResultSet rs=StGet.executeQuery();
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
			StGet = conn.prepareStatement("SELECT * FROM public.\"Tratta\" WHERE \"Destinazione\" = ?");
			StGet.setString(1, Destinazione);
			ResultSet rs=StGet.executeQuery();
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
	
	public void insertTratta(String CodTratta, int Nprenotazioni, LocalTime Orario_Di_Partenza, LocalDate Data, int Ngate,  String CodIATA, String Destinazione) {
		try {
			st.executeQuery("INSERT INTO \"Tratta\" VALUES (\\\"Tratta\\\", \\\"Tratta\\\", \\\"Tratta\\\", \\\"Tratta\\\", \\\"Tratta\\\", \\\"Tratta\\\")");
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

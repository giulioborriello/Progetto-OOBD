package DAOPostgres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAOPostgres {
	Statement st = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	public ClienteDAOPostgres(Connection conn) {
		super();
		this.conn = conn;
	}

	public void getAllCliente() {
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Cliente\"");
			while(rs.next()) {
				System.out.println("CodFiscale" + rs.getString("CodFiscale"));
				System.out.println("Nome:"+rs.getString("Nome"));
				System.out.println("Cognome:"+rs.getString("Cognome"));
				System.out.println("E-mail"+rs.getString("E-mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getClienteByCodFiscale(String CodFiscale) {
		try {
			ps = conn.prepareStatement("SELECT * FROM \"Cliente\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("CodFiscale" + rs.getString("CodCoda"));
				System.out.println("Nome:"+rs.getString("Nome"));
				System.out.println("Cognome:"+rs.getString("Ngate"));
				System.out.println("E-mail"+rs.getString("CodSlot"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertCliente(String CodFiscale, String Nome, String Cognome, String Email)	{
		
		try {
			ps = conn.prepareStatement("INSERT INTO \"Cliente\"  VALUES (?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Nome);
			ps.setString(3, Cognome);
			ps.setString(4, Email);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateEmailByCodFiscale(String Email, String CodFiscale)	{
	
		try {
			ps = conn.prepareStatement("UPDATE \"Cliente\" SET \"Email\" = ? WHERE \"CodFiscale\" = ? ; ");
			ps.setString(1, Email);
			ps.setString(2, CodFiscale);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

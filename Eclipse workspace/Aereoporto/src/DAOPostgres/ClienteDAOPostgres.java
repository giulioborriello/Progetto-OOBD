package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ClienteDAO;
import Entità.Cliente;

public class ClienteDAOPostgres implements ClienteDAO {
	
	private Connection conn;

	public ClienteDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();

	}

	
	public  Cliente  getClienteByCodFiscale(String CodFiscale) {
		Cliente cliente = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"Cliente\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
				
			cliente = new Cliente(rs.getString("CodFiscale"), rs.getString("Nome"), rs.getString("Ngate"), 
					rs.getString("CodSlot"));
				
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return cliente;	

	}
	
	public String insertCliente(String CodFiscale, String Nome, String Cognome, String Email)	{
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Cliente\"  VALUES (?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Nome);
			ps.setString(3, Cognome);
			ps.setString(4, Email);
			ps.execute();
			
			ps.close();
			conn.close();
			
			return "Inserito Correttamente";
		} catch (SQLException e) {
			
			return e.getMessage();
		}
		
		
	}
	
	public String updateEmailByCodFiscale(String Email, String CodFiscale)	{
	
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE \"Cliente\" SET \"Email\" = ? WHERE \"CodFiscale\" = ? ; ");
			ps.setString(1, Email);
			ps.setString(2, CodFiscale);
			ps.execute();
			
			ps.close();
			conn.close();
			
			return "Aggiornato Correttamente!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}
	
	public String deleteCliente(String CodFiscale) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete From \"Cliente\"  WHERE \"CodFiscale\" = ? ; ");
				
			ps.setString(1, CodFiscale);
			ps.execute();
			ps.close();
			conn.close();
			
			return "Eliminato Correttamente!";
		} catch (SQLException e) {
			
			return e.getMessage();
		}
		 
	}
	
	
	
}
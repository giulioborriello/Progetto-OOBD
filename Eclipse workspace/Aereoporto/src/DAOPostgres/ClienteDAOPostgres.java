package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.ClienteDAO;
import Entità.Biglietto;
import Entità.Cliente;

public class ClienteDAOPostgres implements ClienteDAO {
	Connection conn = null;
	List<Cliente> Listcliente = new LinkedList<Cliente>();
	SingletonPostgres singleton;

	public ClienteDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;

	}

	public List<Cliente> getAllCliente() {
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Cliente\"");
			while(rs.next()) {
				Cliente cliente = new Cliente(rs.getString("CodFiscale"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Email"));
				
				Listcliente.add(cliente);
			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Listcliente;	
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
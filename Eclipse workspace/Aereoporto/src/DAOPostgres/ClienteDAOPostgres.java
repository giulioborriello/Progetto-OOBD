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
import Entit�.Biglietto;
import Entit�.Cliente;

public class ClienteDAOPostgres implements ClienteDAO {
	Statement st = null;
	PreparedStatement ps = null;
	List<Cliente> Listcliente = new LinkedList<Cliente>();

	public ClienteDAOPostgres() {
		
	}

	public List<Cliente> getAllCliente() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Cliente\"");
			while(rs.next()) {
				Cliente cliente = new Cliente(rs.getString("CodFiscale"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Email"));
				
				Listcliente.add(cliente);
			}
			
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
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM \"Cliente\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();
				
			cliente = new Cliente(rs.getString("CodFiscale"), rs.getString("Nome"), rs.getString("Ngate"), 
					rs.getString("CodSlot"));
				
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return cliente;	

	}
	
	public void insertCliente(String CodFiscale, String Nome, String Cognome, String Email)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("INSERT INTO \"Cliente\"  VALUES (?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Nome);
			ps.setString(3, Cognome);
			ps.setString(4, Email);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateEmailByCodFiscale(String Email, String CodFiscale)	{
	
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("UPDATE \"Cliente\" SET \"Email\" = ? WHERE \"CodFiscale\" = ? ; ");
			ps.setString(1, Email);
			ps.setString(2, CodFiscale);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

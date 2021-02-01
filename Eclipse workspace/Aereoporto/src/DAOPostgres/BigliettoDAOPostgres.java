package DAOPostgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DAO.BigliettoDAO;
import Entità.Biglietto;
import Entità.Cliente;
import Entità.Tratta;

public class BigliettoDAOPostgres implements BigliettoDAO {
	
	private Connection conn;
	private List<Biglietto> listBiglietto = new LinkedList<Biglietto>();
	private SingletonPostgres singleton;
	
	public BigliettoDAOPostgres(SingletonPostgres sp) {
		conn = sp.getConnection();
		singleton = sp;
	}
	
	
	

	public List<Biglietto> getBigliettoByCodFiscale(String CodFiscale){
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				
				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				Cliente clienteE = cliente.getClienteByCodFiscale(rs.getString("CodFiscale"));
				TrattaDAOPostgres tratta = new TrattaDAOPostgres(singleton);
				Tratta trattaE = tratta.getTrattaByCodTratta(rs.getString("CodTratta"));
				
				Biglietto biglietto = new Biglietto(rs.getString("Posto"), rs.getString("Tipo di biglietto"), 
						rs.getString("CodBiglietto"),
						trattaE, 
						clienteE);
				
				listBiglietto.add(biglietto);
				
				}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return listBiglietto;


	}
	
	public List<Biglietto> getBigliettoByCodTratta(String CodTratta){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
				Cliente clienteE = cliente.getClienteByCodFiscale(rs.getString("CodFiscale"));
				TrattaDAOPostgres tratta = new TrattaDAOPostgres(singleton);
				Tratta trattaE = tratta.getTrattaByCodTratta(rs.getString("CodTratta"));
				
				
				Biglietto biglietto = new Biglietto( 
				rs.getString("Posto"), rs.getString("Tipo di biglietto"), rs.getString("CodBiglietto"),
				trattaE, 
				clienteE);
				
				listBiglietto.add(biglietto);
				}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listBiglietto;

	}
	
	public String insertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Biglietto\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Tipo_di_biglietto);
			ps.setString(3, CodBiglietto);
			ps.setString(4, CodTratta);
			ps.setString(5, Posto);
			ps.execute();
			
			ps.close();
			conn.close();
			return "Inserito Correttamente";
		} catch (SQLException e) {
			return e.getMessage();
		}
		
	}
	
	public String deleteBiglietto(String CodBiglietto)	{
		
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM \"Biglietto\"  WHERE \"CodBiglietto\" = ?; ");
			ps.setString(1, CodBiglietto);
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
package DAOPostgres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import DAO.BigliettoDAO;
import Entit�.Biglietto;
import Entit�.Cliente;

public class BigliettoDAOPostgres implements BigliettoDAO {
	ResultSet rs;
	Statement st = null;
	PreparedStatement ps = null;
	List<Biglietto> ListBiglietto = new LinkedList<Biglietto>();
	
	public BigliettoDAOPostgres() {
		
	}
	
	
	public List<Biglietto> getAllBiglietto() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			rs=st.executeQuery("SELECT * FROM public.\"Biglietto\"");
			
			while(rs.next()) {
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				TrattaDAOPostgres tratta = new TrattaDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				String codTratta = rs.getString("CodTratta");
				
				Biglietto biglietto = new Biglietto(codTratta, codFiscale, rs.getString("Nome"),
						rs.getString("Posto"), rs.getString("Tipo_Di_Biglietto"), rs.getString("CodBiglietto"), 
						cliente.getClienteByCodFiscale(codFiscale), tratta.getTrattaByCodTratta(codTratta));
				
				ListBiglietto.add(biglietto);
				}
			conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return ListBiglietto;
		}

	public List<Biglietto> getBigliettoByCodFiscale(String CodFiscale){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");

			ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodFiscale\" = ?");
			ps.setString(1, CodFiscale);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				TrattaDAOPostgres tratta = new TrattaDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				String codTratta = rs.getString("CodTratta");
				
				Biglietto biglietto = new Biglietto(codTratta, codFiscale, rs.getString("Nome"),
						rs.getString("Posto"), rs.getString("Tipo_Di_Biglietto"), rs.getString("CodBiglietto"), 
						cliente.getClienteByCodFiscale(codFiscale), tratta.getTrattaByCodTratta(codTratta));
				
				ListBiglietto.add(biglietto);
				
				}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListBiglietto;


	}
	
	public List<Biglietto> getBigliettoByCodTratta(String CodTratta){
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("SELECT * FROM public.\"Biglietto\" WHERE \"CodTratta\" = ?");
			ps.setString(1, CodTratta);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ClienteDAOPostgres cliente = new ClienteDAOPostgres();
				TrattaDAOPostgres tratta = new TrattaDAOPostgres();
				String codFiscale = rs.getString("CodFiscale");
				String codTratta = rs.getString("CodTratta");
				
				Biglietto biglietto = new Biglietto(codTratta, codFiscale, rs.getString("Nome"),
				rs.getString("Posto"), rs.getString("Tipo_Di_Biglietto"), rs.getString("CodBiglietto"),  
				cliente.getClienteByCodFiscale(codFiscale), tratta.getTrattaByCodTratta(codTratta));
				
				ListBiglietto.add(biglietto);
				}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListBiglietto;

	}
	
	public void insertBiglietto(String CodFiscale, String Tipo_di_biglietto, String CodBiglietto, String CodTratta, String Posto)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("INSERT INTO \"Biglietto\"  VALUES (?, ?, ?, ?, ?); ");
			ps.setString(1, CodFiscale);
			ps.setString(2, Tipo_di_biglietto);
			ps.setString(3, CodBiglietto);
			ps.setString(4, CodTratta);
			ps.setString(5, Posto);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void DeleteBiglietto(String CodBiglietto)	{
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			
			ps = conn.prepareStatement("DELETE FROM \"Biglietto\"  WHERE CodBiglietto = ?; ");
			ps.setString(1, CodBiglietto);
			ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
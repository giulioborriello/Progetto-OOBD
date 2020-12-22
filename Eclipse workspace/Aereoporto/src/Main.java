import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.TrattaDAO;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			 conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			}
		catch (SQLException e) {
			System.out.println("Eccezione 2 SQL\n"+e);
		}
		
	TrattaDAO TDAO = new TrattaDAO(conn);
	TDAO.GetTrattaByCodTratta("A1");
	}
}



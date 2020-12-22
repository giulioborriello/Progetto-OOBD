import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

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
	TDAO.insertTratta("A2", 0, LocalTime.of(0, 0, 0), LocalDate.of(2021, 2, 15), 1, "AL", "Milano");
	}
}



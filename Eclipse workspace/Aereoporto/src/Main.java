

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Aereoporto", "postgres", "abcd");
			}
		catch (SQLException e) {
			System.out.println("Eccezione 2 SQL\n"+e);
		}
	}
}



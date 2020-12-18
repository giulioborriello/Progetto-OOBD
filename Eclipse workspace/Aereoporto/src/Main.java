import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		//1.CARICO IL DRIVER
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException n)
		{ System.out.println("Classe Non Trovata\n"+n);
		//2.OTTENGO CONNESSIONE
		Connection conn = null;
		try {
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/First");
		} catch (SQLException e) {
			System.out.println("Eccezione SQL\n"+e);
		}
		//3.ESEGUO LO STATEMENT
		try {
			Statement st=conn.createStatement();
		}
		catch (SQLException e) {
			System.out.println("Eccezione SQL\n"+e);
		}
		//4.GESTISCO I RISULTATI
		//5.RILASCIO LE RISORSE
	}
	}
}

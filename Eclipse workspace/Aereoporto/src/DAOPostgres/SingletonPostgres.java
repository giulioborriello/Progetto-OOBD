package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonPostgres {
	Connection conn;
	
	private static SingletonPostgres istanza = null;
	
	private SingletonPostgres() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:50597","postgres","abcd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static SingletonPostgres getInstance() {
		if (istanza == null) {
			istanza = new SingletonPostgres();
			
		}
		else if (istanza.getConnection().isClosed()) {​​
			istanza = new SingletonPostgres();
		}
		return istanza;​​
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	

}

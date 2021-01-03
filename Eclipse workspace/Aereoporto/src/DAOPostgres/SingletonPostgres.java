package DAOPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonPostgres {
	private Connection conn;
	
	private static SingletonPostgres instanza = null;
	
	private SingletonPostgres() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Aereoporto","postgres","abcd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SingletonPostgres getInstance() {
		if(instanza == null) {
			instanza = new SingletonPostgres();
		} else
			try {
				if(instanza.getConnection().isClosed()) {
					instanza = new SingletonPostgres();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return instanza;
	}
	
	public Connection getConnection() {
		if conn.isClosed(true){
		
			return conn;	
		
		}
		
		
	}
	
	

}

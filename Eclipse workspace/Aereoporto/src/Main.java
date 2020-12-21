

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		

		//2.OTTENGO CONNESSIONE
		try {
			System.out.println("il programma funziona");

		Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/First");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM Tratta");
		System.out.println("il programma funziona");
		int i=1;
		
		while(rs.next()) {
		System.out.println("Tratta numero"+i);
		System.out.println("CodTratta:"+rs.getString("CodTratta"));
		System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
		System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
		System.out.println("Data:" + rs.getDate("Data"));
		System.out.println("Ngate" + rs.getInt("Ngate"));
		System.out.println("CodIATA:" + rs.getString("CodIATA"));
		System.out.println("Destinazione:" + rs.getString("Destinazione"));
		i++;
		}
		
		} 
		
		catch (SQLException e) {
			System.out.println("Eccezione SQL\n"+e);
		}
		//3.ESEGUO LO STATEMENT
		
		//4.GESTISCO I RISULTATI
		//5.RILASCIO LE RISORSE
	}
	}



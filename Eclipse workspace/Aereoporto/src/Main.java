package Package1;

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
		try {
		Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/First");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM ARTISTA");
		int i=1;
		while(rs.next()) {
		System.out.println("Artista numero"+i);
		System.out.println("Nome:="+rs.getString("nome"));
		System.out.println("Cognome:"+rs.getString("cognome"));
		System.out.println("Nome d'arte:"+rs.getString("nome_d_arte"));
		i++;
		}
		} catch (SQLException e) {
			System.out.println("Eccezione SQL\n"+e);
		}
		//3.ESEGUO LO STATEMENT
		
		//4.GESTISCO I RISULTATI
		//5.RILASCIO LE RISORSE
	}
	}
}

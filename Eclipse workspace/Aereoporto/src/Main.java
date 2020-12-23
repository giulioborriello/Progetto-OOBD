import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import DAO.*;

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
	TDAO.insertTratta("A2", 0, Time.valueOf(LocalTime.of(0, 0, 0)), Date.valueOf(LocalDate.of(2021, 1, 1)), 1, "AL", "Milano");

	BigliettoDAO BDAO = new BigliettoDAO(conn);
	BDAO.insertBiglietto("abcd", "economy", "Bi", "A1", "A11");
	
	Fedelt‡DAO FDAO = new Fedelt‡DAO(conn);
	FDAO.updateCentoKilometriByCodFiscale(123,"abcd" );
	
	SlotDAO SDAO = new SlotDAO(conn);
	SDAO.updateTempoDiImbarcoEffettivoByCodSlot(TempoDiImbarcoEffettivo, CodSlot);
	
	GateDAO GDAO = new GateDAO(conn);
	GDAO.updateCodTrattaByNgate(CodTratta, Ngate);
	
	}
}



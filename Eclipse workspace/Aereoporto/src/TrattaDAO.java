import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TrattaDAO {
	Statement st = null;

	public TrattaDAO(Statement st) {
			super();
			this.st = st;
		}
	//	public void getAllTratta(st) {
	//		try {
	//			ResultSet rs=st.executeQuery("SELECT * FROM public.\"Tratta\"");
	//			System.out.println("il programma funziona");
	//			int i=1;
	//
	//			while(rs.next()) {
	//				System.out.println("Tratta numero"+i);
	//				System.out.println("CodTratta:"+rs.getString("CodTratta"));
	//				System.out.println("Nprenotazioni:"+rs.getInt("Nprenotazioni"));
	//				System.out.println("Orario di partenza:"+rs.getTime("Orario di partenza"));
	//				System.out.println("Data:" + rs.getDate("Data"));
	//				System.out.println("Ngate" + rs.getInt("Ngate"));
	//				System.out.println("CodIATA:" + rs.getString("CodIATA"));
	//				System.out.println("Destinazione:" + rs.getString("Destinazione"));
	//				i++;
	//			}
	//		}
	//		catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}	
	//	}
		
		public void GetTrattaByCodTratta(st){
			
		}
		public void VerificaFormatoCodTratta( st) {
			 try {
				st.executeUpdate("ALTER TABLE \"Tratta\" ADD CONSTRAINT Verifica_Formato_CodTratta CHECK(\"CodTratta\" ~* '^[a-zA-Z] + [a-zA-Z] + [a-zA-Z] + % +$ ')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

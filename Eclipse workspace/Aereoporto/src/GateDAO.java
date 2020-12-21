import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GateDAO {

	

	public void InsertGate(Statement st){
		try {
			st.executeQuery("INSERT INTO public.\"gate\"");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}


package Check;

public class CheckFormatoCognome extends Exception {
	public boolean verificaFormatoNome(String text) {
		if ( ! text.matches(".*[^a-z].*") )   {
			return true;
		}
			
		return false;
	}

}

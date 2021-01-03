package Check;

public class CheckFormatoCodFiscale extends Exception {
	public boolean verificaFormatoCodFiscale(String testo) {
		if (testo.equals("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$\r\n"+ "")) {
			return true;
		}
	return false;
	}
}

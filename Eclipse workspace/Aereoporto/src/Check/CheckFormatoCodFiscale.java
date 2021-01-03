package Check;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException ;

public class CheckFormatoCodFiscale {
	public boolean verificaFormatoCodFiscale(String text){
		String espressione = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";  
		return text.matches(espressione);
		}
}

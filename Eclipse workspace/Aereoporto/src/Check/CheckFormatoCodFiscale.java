package Check;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException ;

public class CheckFormatoCodFiscale extends Exception {
	public static boolean verificaFormatoCodFiscale(String espressione, String text){
		espressione = "abcd";  
		if (Pattern.matches(espressione, text))
		    return true;
		  else
		    return false;
		}
}

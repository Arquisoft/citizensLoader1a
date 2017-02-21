package parser.cartas;

public class LetterFactory {
	
	public static Letter createLetter(String format){
		if (format.equals("txt")) {
			return (Letter) new TxtLetter();
		} else if (format.equals("pdf")) {
			return (Letter) new PdfLetter();
		} else if (format.equals("word")) {
			return (Letter) new WordLetter();
		} else {
			return (Letter) new WordLetter();
		}	
	}
}

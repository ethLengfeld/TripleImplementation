import java.util.List;

import org.junit.Test;

public class AutocompleteSystem {

	public static List<String> getListOfAutoComplete(String startOfWord, String[] words) {
		
		return null;
	}
	
	@Test
	public void testSample() {
		String word = "de";
		String[] words = {"dog","deer","deal"};
		List<String> possibleWords = AutocompleteSystem.getListOfAutoComplete(word, words);
	}
}

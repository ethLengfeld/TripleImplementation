import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.ArrayUtils;

public class AutocompleteSystem {

	public static List<String> getListOfAutoComplete(String startOfWord, String[] words) {
		char[] wordArr = startOfWord.toCharArray();
		List<String> autocomplete = new ArrayList<>();
		// Naive approach
		boolean diff = false;
		int i = 0;
		for(String currWord : words) {
			char[] currWordArr =  currWord.toCharArray();
			if(currWord.length() >= startOfWord.length()) {
				while(i < currWordArr.length && i < wordArr.length) {
					if(currWordArr[i] != wordArr[i]) {
						diff = true;
						break;
					}
					i++;
				}
				if(!diff) {
					autocomplete.add(currWord);
				}
			}
			i = 0;
			diff = false;
		}
		return autocomplete;
	}
	
	@Test
	public void testSample() {
		String word = "de";
		String[] words = {"dog","deer","deal"};
		List<String> possibleWords = AutocompleteSystem.getListOfAutoComplete(word, words);
		assertEquals("should return deer and deal", "[deer,deal]", ArrayUtils.printArray(possibleWords));
	}
}

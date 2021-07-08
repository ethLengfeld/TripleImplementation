package problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BalancedBrackets {

	public static boolean areBracketsBalanced(String brackets) {
		int square = 0;
		int curly = 0;
		for (int i = 0; i < brackets.length(); i++) {
			if (brackets.charAt(i) == '[') {
				square++;
			}
			if (brackets.charAt(i) == '{') {
				curly++;
			}
			if (brackets.charAt(i) == ']') {
				square--;
			}
			if (brackets.charAt(i) == '}') {
				curly--;
			}
		}
		if (square != 0 || curly != 0) {
			return false;
		}
		return true;
	}
// TODO actually do it properly
	@Test
	public void testBracketSampleTrue() {
		String brackets = "([])[]({})";
		boolean balanced = BalancedBrackets.areBracketsBalanced(brackets);
		assertEquals("it is balanced", true, balanced);
	}

}

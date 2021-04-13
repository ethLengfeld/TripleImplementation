
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordCircle {

	public static boolean checkWordCircle(String[] array) {

		char lastChar = 0;
		char firstChar = 0;
		String currStr = null;
		String nextStr = null;
		for (int i = 0; i < array.length; i++) {
			currStr = array[i];
			if (i + 1 == array.length) {
				nextStr = array[0];
			} else {
				nextStr = array[i + 1];
			}
			lastChar = currStr.toLowerCase().charAt(currStr.length() - 1);
			firstChar = nextStr.toLowerCase().charAt(0);

			if (firstChar != lastChar) {
				return false;
			}

		}

		return true;
	}

	@Test
	public void testSampleWordCircle() {
		String[] array = { "chair", "racket", "touch", "height", "tunic" };
		boolean wordCircle = WordCircle.checkWordCircle(array);

		assertEquals("Is word circle", true, wordCircle);
	}
	
	// TODO check if any circle exists 
}

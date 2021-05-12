import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncodeDecode {

	public static String encodeStringCount(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char lastChar = str.charAt(0);
		char currChar = 0;
		for(int i = 1; i < str.length(); i++) {
			currChar = str.charAt(i);
			if(currChar == lastChar) {
				count++;
			}
			else {
				sb.append(count+""+lastChar);
				count = 1;
				lastChar = currChar;
			}
		}
		sb.append(count+""+lastChar);
		
		return sb.toString();
	}

	@Test
	public void testSampleEncode() {
		String str = "AAAABBBCCDAA";
		String encoded = EncodeDecode.encodeStringCount(str);
		assertEquals("Encoded string", "4A3B2C1D2A", encoded);
	}

}
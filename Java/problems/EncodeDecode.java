package problems;
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
	
	public static String decodeStringCount(String str) {
		StringBuilder sb = new StringBuilder();
		char currChar = str.charAt(0);
		StringBuilder currNum = new StringBuilder(String.valueOf(currChar));
		int count = 0;
		for(int i = 1; i < str.length(); i++) {
			currChar = str.charAt(i);
			if(Character.isDigit(currChar)) {
				currNum.append(currChar);
			} else {
				String num = currNum.toString();
				count = Integer.valueOf(num);
				currNum = new StringBuilder();
				for(int j = 0; j < count; j++) {
					sb.append(currChar);
				}
			}
			
		}
		return sb.toString();
	}

	@Test
	public void testSampleEncode() {
		String str = "AAAABBBCCDAA";
		String encoded = EncodeDecode.encodeStringCount(str);
		assertEquals("Encoded string", "4A3B2C1D2A", encoded);
	}
	
	@Test
	public void testSampleDecode() {
		String str = "4A3B2C1D2A";
		String encoded = EncodeDecode.decodeStringCount(str);
		assertEquals("Decoded string", "AAAABBBCCDAA", encoded);
	}
	
	@Test
	public void testSampleDecodeDoubleDigits() {
		String str = "4A3B2C10D2A";
		String encoded = EncodeDecode.decodeStringCount(str);
		assertEquals("Decoded string", "AAAABBBCCDDDDDDDDDDAA", encoded);
	}

}
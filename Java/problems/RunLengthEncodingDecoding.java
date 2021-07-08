package problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RunLengthEncodingDecoding {

	public static String encode(String str) {
		StringBuilder encoded = new StringBuilder();

		char prev = 0;
		char currChar = 0;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			currChar = str.charAt(i);
			if (currChar == prev || i == 0) {
				count++;
			} else {
				encoded.append(count + "" + String.valueOf(prev).toUpperCase());
				count = 1;
			}
			prev = currChar;
		}
		encoded.append(count + "" + String.valueOf(prev).toUpperCase());

		return encoded.toString();
	}

	public static String decode(String str) {
		StringBuilder decode = new StringBuilder();
		StringBuilder num = new StringBuilder();

		char prev = 0;

		for (int i = 0; i < str.length(); i++) {
			prev = str.charAt(i);
			if (Character.isDigit(prev)) {
				num.append(prev);
			} else {
				int numVal = Integer.valueOf(num.toString());
				decode.append(RunLengthEncodingDecoding.createCharacterString(numVal, prev));
				num = new StringBuilder();
			}
		}

		return decode.toString();
	}

	private static String createCharacterString(int num, char currChar) {
		StringBuilder letterStr = new StringBuilder();
		for (int i = 0; i < num; i++) {
			letterStr.append(String.valueOf(currChar).toUpperCase());
		}
		return letterStr.toString();
	}

	@Test
	public void testEncoding() {
		String str = "AAAABBCCCDDDAA";
		String encodedStr = RunLengthEncodingDecoding.encode(str);

		assertEquals("Test encoding", "4A2B3C3D2A", encodedStr);
	}

	@Test
	public void testDecoding() {
		String str = "4A2B3C3D2A";
		String decodedStr = RunLengthEncodingDecoding.decode(str);

		assertEquals("Test decoding", "AAAABBCCCDDDAA", decodedStr);
	}

	@Test
	public void testEncodingDecoding() {
		String str = "AAAABBCCCDDDAA";
		String encodedStr = RunLengthEncodingDecoding.encode(str);
		String decodedStr = RunLengthEncodingDecoding.decode(encodedStr);

		assertEquals("Test decoding", "AAAABBCCCDDDAA", decodedStr);
	}
}

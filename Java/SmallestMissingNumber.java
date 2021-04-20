import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SmallestMissingNumber {

	public static int findSmallestNumberCheats(int[] array) {

		Arrays.sort(array);
		int currNum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (currNum > 0 && array[i] != currNum + 1) {
				return currNum + 1;
			}
			currNum = array[i];
		}
		return 0;
	}

	@Test
	public void testSample() {
		int[] array = { 3, 4, 1, -1 };
		int smallestMissing = SmallestMissingNumber.findSmallestNumberCheats(array);
		assertEquals("Two is missing", 2, smallestMissing);
	}

	@Test
	public void testMissingOne() {
		int[] array = { 3, 4, 2, -1 };
		int smallestMissing = SmallestMissingNumber.findSmallestNumberCheats(array);
		assertEquals("One is missing", 1, smallestMissing);
	}
}

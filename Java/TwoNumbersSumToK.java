import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoNumbersSumToK {

	public static boolean sumToKBrute(int[] array, int k) {
		
		int runningSum = k;
		for(int i = 0; i < array.length; i++) {
			runningSum -= array[i];
			for(int j = i+1; j < array.length; j++) {
				if(runningSum - array[j] == 0) {
					return true;
				}
			}
			runningSum = k;
		}
		return false;
	}
	
	@Test
	public void testSumToKBrute() {
		int[] array = { 10, 15, 3, 7 };
		boolean sumToK = TwoNumbersSumToK.sumToKBrute(array, 17);
		assertEquals("Sum of 17 exists, true", true, sumToK);
	}
}

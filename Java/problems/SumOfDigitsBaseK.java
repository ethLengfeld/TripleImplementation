package problems;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumOfDigitsBaseK {
	public static int sumBase(int n, int k) {
//		int exp = 0;
//		int remainder = 0;
		int sum = 0;
		while(n >= k) {
			sum += n%k;
			n = n/k;
//			sum += remainder*Math.pow(10,exp);
//			sum += remainder;
//			exp++;
		}

		return sum+n;
	}
	
	@Test
	public void testSample() {
		int n = 34;
		int k = 6;
		int sum = SumOfDigitsBaseK.sumBase(n, k);
		assertEquals("34 base 10 is 54 base 6", 9, sum);
	}
	
	@Test
	public void testLargeNumber99() {
		int n = 99;
		int k = 6;
		int sum = SumOfDigitsBaseK.sumBase(n, k);
		assertEquals("99 base 10 is 234 base 6", 9, sum);
	}
}

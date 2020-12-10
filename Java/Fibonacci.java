import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * implement the function finb(n), which returns the nth number in the fibonacci
 * sequence, using only O(1) space
 * 
 * @author e_len
 *
 */
public class Fibonacci {

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		int f1 = 1;
		int f2 = 1;
		int value = f1 + f2;
		for (int i = 2; i < n; i++) {
			value = f1 + f2;
			f1 = f2;
			f2 = value;
		}

		return value;
	}

	@Test
	public void testFibonacci3rdTerm() {
		int actualValue = fib(3);
		int expectedValue = 2;

		assertEquals("3rd term should be 2", expectedValue, actualValue);
	}

	@Test
	public void testFibonacci7thTerm() {
		int actualValue = fib(7);
		int expectedValue = 13;

		assertEquals("7th term should be 13", expectedValue, actualValue);
	}
}
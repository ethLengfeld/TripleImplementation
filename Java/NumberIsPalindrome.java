import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class NumberIsPalindrome {
	
	public static boolean isPalindrome(int num) {
	
		int temp = num;
		int reverse = 0;
		while(temp > 0) {
			int oneDigit = temp % 10;
			reverse = (reverse*10)+oneDigit;
			temp = temp / 10;			
		}
		
		return (num == reverse);
	}
	
	@Test
	public void test1221IsPalindrome() {
		int val = 1221;
		boolean isPal = NumberIsPalindrome.isPalindrome(val);
		
		assertEquals("test 1221 is Palindrome", true, isPal);
	}
	
	@Test
	public void test1222IsPalindrome() {
		int val = 1222;
		boolean isPal = NumberIsPalindrome.isPalindrome(val);
		
		assertEquals("test 1222 is NOT Palindrome", false, isPal);
	}
}

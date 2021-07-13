package problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PerfectDigits {

	public static int findPerfectDigit(int num) {
		
		int perfectNum = 19;
		int numPerfects = 0;
		while(true) {
			
			int digitVal = 0;
			for(int i = perfectNum; i > 0; i = i/10) {
				digitVal += i%10;
			}
			
			if(digitVal == 10) {
				numPerfects++;
			}
			
			if(numPerfects == num ) {
				return perfectNum;
			}
			perfectNum += 9;
		}
	}
	
	@Test
	public void test5thPerfectNum() {
		int num = 5;
		int fifthPerfect = PerfectDigits.findPerfectDigit(num);
		assertEquals("fifth perfect number is 55", 55, fifthPerfect);
	}
	
	@Test
	public void test11thPerfectNum() {
		int num = 11;
		int fifthPerfect = PerfectDigits.findPerfectDigit(num);
		assertEquals("eleventh perfect number is 118", 118, fifthPerfect);
	}
}

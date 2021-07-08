package problems;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindMinimumCoins {
	
	public static int findMinCoins(int coins[],  int value) {
		
		if(value == 0) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;

		for(int i=0; i < coins.length; i++) {

			if(coins[i] <= value) {
				int subResult = FindMinimumCoins.findMinCoins(coins, value-coins[i]);
				
				if(subResult != Integer.MAX_VALUE && subResult+1 < result) {
					result = subResult + 1;
				}
			}
		}
		
		return result;
	}
	
	@Test
	public void testFindMinCoins() {
		int[] coins = {9,6,5,1};
		int value = 11;
		int numCoins = FindMinimumCoins.findMinCoins(coins, value);
		assertEquals("Min coins is 2", 2, numCoins);
	}
	
}

package problems;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class ThrowDice {

	public static int throwDice(int numDice, int numFaces, int total) {
		int[][] dp = new int[numFaces+1][total+1];

//		for(int i = 1; i <= total && i <= numDice; i++) {
//			dp[1][i] = 1;
//		}
//		
//		for(int j = 2; j <= numFaces; j++) {
//			for(int k = 1; k <= total; k++) {
//				for(int l = 1; l < k && l <= numDice; l++) {
//					dp[j][k] += dp[j-1][k-l];
//				}
//			}
//		}
		dp[0][0] = 1;

		for(int i = 1; i <= numFaces; i++ ) {
			for(int j = i; j <= total; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
				if(j-numDice-1 >= 0) {
					dp[i][j] -= dp[i-1][j-numDice-1];
				}
			}
		}

//		for(int m = 0; m < numFaces+1; m++) {
//			for(int n = 0; n < total+1; n++) {
//				System.out.print(dp[m][n] + " ");
//			}
//			System.out.println();
//		}

		// TODO need to fix
		return dp[numFaces-1][total];
	}
	
	@Test
	public void testSample() {
		int totalCount = (int) ThrowDice.throwDice(3, 6, 7);
		assertEquals("There are 15 ways to get 7", 15, totalCount);
	}
	
	@Test
	@Ignore
	public void testThreeDiceSixFacesSixTotal() {
		int totalCount = (int) ThrowDice.throwDice(3, 6, 6);
		assertEquals("There are 10 ways to get 6", 10, totalCount);
	}
}

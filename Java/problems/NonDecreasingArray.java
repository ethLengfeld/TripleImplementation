package problems;

public class NonDecreasingArray {

	public static boolean IsArrayNonDecreasing(int[] array) {
		int pastElement = 0;
		int currElement = 0;
		int numNonDec = 0;
		for(int i = 1; i < array.length; i++) {
			pastElement = array[i-1];
			currElement = array[i];
			if(pastElement >= currElement) {
				numNonDec++;
				if (numNonDec == 2) return false;
			}
		}
		return true;
	}
}

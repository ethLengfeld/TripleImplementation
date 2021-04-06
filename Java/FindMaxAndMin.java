import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindMaxAndMin {

	/**
	 * 
	 * @param array
	 * @return in array of size 2, index 0 is Min
	 * 							   index 1 is Max
	 */
	public static int[] findMinAndMax(int[] array) {
		int[] minMax = new int[2];
		
		if(array.length == 1) {
			minMax[0] = array[0];
			minMax[1] = array[0];
			return minMax;
		}
		
		if(array[0] < array[1]) {
			minMax[0] = array[0];
			minMax[1] = array[1];
		}
		else {
			minMax[0] = array[1];
			minMax[1] = array[0];
		}
		
		for(int i=2; i < array.length; i++) {
			if(array[i] < minMax[0]) {
				minMax[0] = array[i];
			}
			if(array[i] > minMax[1]) {
				minMax[1] = array[i];
			}
		}
		
		return minMax;
	}
	
	@Test
	public void testFindMinMax() {
		int[] array =  {1,3,7,0};
		int[] minMax = FindMaxAndMin.findMinAndMax(array);
		assertEquals("Min is 0", 0, minMax[0]);
		assertEquals("Max is 7", 7, minMax[1]);
	}	
}

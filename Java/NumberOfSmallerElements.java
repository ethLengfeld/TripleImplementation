import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.ArrayUtils;

public class NumberOfSmallerElements {

	public static int[] countNumberOfSmallerElements(int[] array) {
		int[] smallerElementsToLeft = new int[array.length];

		int numSmaller = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				if(i != j && array[i] > array[j]) {
					numSmaller++;
				}
			}
			smallerElementsToLeft[i] = numSmaller;
			numSmaller = 0;
		}

		return smallerElementsToLeft;
	}
	
	@Test
	public void testSample() {
		int[] array = {3,4,9,6,1};
		int[] numSmaller = NumberOfSmallerElements.countNumberOfSmallerElements(array);
		
		assertEquals("Test sample problem","[1,1,2,1,0]", ArrayUtils.getIntArray(numSmaller));
	}
}

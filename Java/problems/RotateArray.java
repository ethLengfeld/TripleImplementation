package problems;
import org.junit.Test;

import utils.ArrayUtils;

import static org.junit.Assert.assertEquals;

public class RotateArray {

	public static int[] rotateArrayNaive(int[] array, int k) {
		int[] rotated = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			rotated[(i + k) % array.length] = array[i];
		}
		return rotated;
	}
	
	public static int[] rotateArraySpace(int[] nums, int k) {
		int temp = 0;
		int temp1 = 0;
		boolean firstPass = true;
		int pastIndex = 0;
		int currIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			currIndex = (pastIndex+k)%nums.length;
			
			if(firstPass) {
				temp = nums[currIndex];
				nums[currIndex] = nums[0];
				firstPass = false;
			} else {
				temp1 = nums[currIndex];
				nums[currIndex] = temp;
				temp = temp1;
			}
			
			pastIndex = currIndex;
		}
		return nums;
	}

	@Test
	public void testRotatedArrayNaive() {
		int[] array = {1,2,3,4,5,6,7};
		int[] rotated = RotateArray.rotateArrayNaive(array,3);
		assertEquals("rotated naive by 3", "[5,6,7,1,2,3,4]", ArrayUtils.getIntArray(rotated));
	}
	@Test
	public void testRotatedArraSpace() {
		int[] array = {1,2,3,4,5,6,7};
		int[] rotated = RotateArray.rotateArraySpace(array,3);
		assertEquals("rotated naive by 3", "[5,6,7,1,2,3,4]", ArrayUtils.getIntArray(rotated));
	}
}

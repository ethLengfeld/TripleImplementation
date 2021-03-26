import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class RotatedSortedArray {

	public static int findElementInRotatedSortedArray(int[] array, int element) {

		int pivot = RotatedSortedArray.findPivotOfArray(array, 0, array.length - 1);

		if (pivot == -1) {
			return RotatedSortedArray.binarySearch(array, 0, array.length - 1, element);
		}

		if(array[pivot] == element) {
			return element;
		}
		if (array[0] <= element) {
			return RotatedSortedArray.binarySearch(array, 0, pivot - 1, element);
		}
		return RotatedSortedArray.binarySearch(array, pivot + 1, array.length - 1, element);

	}

	private static int findPivotOfArray(int[] array, int low, int high) {
		if (high < low) {
			return -1;
		}
		if (low == high) {
			return low;
		}

		int mid = (low + high) / 2;
		// next element is less than mid element
		if (mid < high && array[mid] > array[mid + 1]) {
			return mid;
		}
		if (mid > low && array[mid] < array[mid - 1]) {
			return mid - 1;
		}
		if (array[low] >= array[mid]) {
			return RotatedSortedArray.findPivotOfArray(array, low, mid - 1);
		}
		return RotatedSortedArray.findPivotOfArray(array, mid + 1, high);
	}

	public static Integer binarySearch(int[] array, int low, int high, int element) throws NullPointerException {

		if (high < low) {
			return null;
		}

		int mid = (low + high) / 2;
		if (array[mid] == element) {
			return mid;
		}
		if (element > array[mid]) {
			return binarySearch(array, mid + 1, high, element);
		}
		return binarySearch(array, low, mid - 1, element);
	}

	@Test
//	@Ignore
	public void testFindPivotOfArray2() {
		int[] array = { 3, 4, 5, 1, 2 };
		int pivot = RotatedSortedArray.findPivotOfArray(array, 0, array.length - 1);
		assertEquals("Pivot should be index 2", 2, pivot);
	}

	@Test
	public void testFindPivotOfArrayNegative1() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int pivot = RotatedSortedArray.findPivotOfArray(array, 0, array.length - 1);
		assertEquals("Pivot should be 5", 5, pivot);
	}

	@Test
	public void testBinarySearch() {
		int[] array = { 1, 3, 6, 0, 0 };
		int pivot = RotatedSortedArray.findPivotOfArray(array, 0, array.length - 1);
		int index = RotatedSortedArray.binarySearch(array, 0, pivot - 1, 3);
		assertEquals("Element 3 is at index 1", 1, index);
	}

	@Test
	public void testFindElementInRotatedSortedArray() {
		int[] array = { 2, 3, 6, 0, 1 };
		int index = RotatedSortedArray.findElementInRotatedSortedArray(array, 3);
		assertEquals("Element 3 is at index 1", 1, index);
	}

	@Test
	public void testfindElementInRotatedSortedArrayExample() {
		int[] array = { 13, 18, 25, 2, 8, 10 };
		int index = RotatedSortedArray.findElementInRotatedSortedArray(array, 8);
		assertEquals("Element 8 is at index 4", 4, index);
	}
	
	@Test
	public void testfindElementInRotatedSortedArrayExampleNoElement() {
		int[] array = { 13, 18, 25, 2, 8, 10 };
		int index = -1;
		try {
			index = RotatedSortedArray.findElementInRotatedSortedArray(array, 81);
		} catch (NullPointerException e) {
			System.out.print(81+" doesn't exist in array: " + Arrays.toString(array));
		}
		assertEquals("Element 81 does NOT exist", -1, index);
	}
}

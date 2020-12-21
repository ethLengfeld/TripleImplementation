import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Sorting {

	public static void quickSort(int[] array, int low, int high) {

		if (array == null || array.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int middle = low + (high - low) / 2;
		int pivot = array[middle];
		System.out.println("low:" + low + ",high:" + high + ",pivot:" + pivot);

		int i = low;
		int j = high;

		while (i <= j) {

			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				Sorting.swapElements(array, i, j);
				System.out.println("i:"+i+",j:"+j+"_"+Arrays.toString(array));
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(array, low, j);
		}
		if (high > i) {
			quickSort(array, i, high);
		}

	}

	private static void swapElements(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	@Test
	public void testQuickSort() {
		int[] actualArr = { 1, 1, 9, 2, 5, 1, 10 };
		Sorting.quickSort(actualArr, 0, actualArr.length - 1);

		int[] expectedArr = { 1, 1, 1, 2, 5, 9, 10 };

		assertEquals("test quick sort", Arrays.toString(expectedArr), Arrays.toString(actualArr));
	}
}

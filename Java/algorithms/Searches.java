package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Searches {

    public static int binarySearchSorted(int[] array, int target) {
        int pivot = 0, left = 0, right = array.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (array[pivot] == target) {
                return pivot;
            } else if (array[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearchSorted() {
        int[] nums = {-1, 0, 2, 5, 9, 12, 18, 19, 33, 70};
        int target = 5;
        assertEquals("5 is at index 3", 3, Searches.binarySearchSorted(nums, target));
    }
}

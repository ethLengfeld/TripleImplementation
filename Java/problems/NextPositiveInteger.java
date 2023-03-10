package problems;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, find the first missing positive integer
 * in linear time and constant space. In other words, find the lowest
 * positive integer that does not exist in the array. The array can contain
 * duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class NextPositiveInteger {

    public static int findNextPositiveIntegerInArray(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                set.add(array[i]);
            }
        }

        int j = 1;
        while(j <= set.size()) {
            if (set.contains(j)) {
                j++;
            } else {
                return j;
            }
        }
        return j;
    }

    @Test
    public void test_findNextPositiveIntegerInArray_Set1() {
        int[] array = { 3, 4, -1, 1 };
        int nextPos = NextPositiveInteger.findNextPositiveIntegerInArray(array);
        int expected = 2;
        assertEquals(expected, nextPos);
    }

    @Test
    public void test_findNextPositiveIntegerInArray_Set2() {
        int[] array = { 0, 1, 2 };
        int nextPos = NextPositiveInteger.findNextPositiveIntegerInArray(array);
        int expected = 3;
        assertEquals(expected, nextPos);
    }
}
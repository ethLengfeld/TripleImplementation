package problems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class NumbersSumToK {
    private static final int[] ARRAY = { 10, 15, 3, 7 };
    private static final int K = 17;
    private static final int L = 11;

    /**
     * Brute force would take O(N^2)
     * @param numbers
     * @param k
     * @return
     */
    public static boolean doTwoNumbersSumToKBrute(int[] numbers, int k) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (k == (numbers[i]+numbers[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doTwoNumbersSumToKSet(int[] numbers, int k) {
        Set<Integer> seenNums = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (seenNums.contains(k - numbers[i])) {
                return true;
            }
            seenNums.add(numbers[i]);
        }
        return false;
    }

    @Test
    public void testNumbersSumToK_TrueBrute() {
        boolean answer = NumbersSumToK.doTwoNumbersSumToKBrute(ARRAY, K);
        assertEquals("two numbers exist that equal " + K, true, answer);
    }

    @Test
    public void testNumbersSumToK_FalseBrute() {
        boolean answer = NumbersSumToK.doTwoNumbersSumToKBrute(ARRAY, L);
        assertEquals("two numbers don't exist equal to " + L, false, answer);
    }

    @Test
    public void testNumbersSumToK_TrueSet() {
        boolean answer = NumbersSumToK.doTwoNumbersSumToKSet(ARRAY, K);
        assertEquals("two numbers exist that equal " + K, true, answer);
    }

    @Test
    public void testNumbersSumToK_FalseSet() {
        boolean answer = NumbersSumToK.doTwoNumbersSumToKSet(ARRAY, L);
        assertEquals("two numbers don't exist equal to " + L, false, answer);
    }
}

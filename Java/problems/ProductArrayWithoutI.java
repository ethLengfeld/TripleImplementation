package problems;

import org.junit.Test;
import utils.ArrayUtils;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the
 * original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected
 * output would be [120, 60, 40, 30, 24].
 *
 * If our input was [3, 2, 1], the expected
 * output would be [2, 3, 6].
 */
public class ProductArrayWithoutI {

    public static int[] calculateProductWithoutI_Brute(int[] array) {
        int[] productArray = new int[array.length];
        int product = 1;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if( i != j) {
                    product *= array[j];
                }
            }
            productArray[i] = product;
            product = 1;
        }
        return productArray;
    }

    public static int[] calculateProductWithoutI_Division(int[] array) {
        int[] productArray = new int[array.length];
        int product = array[0];
        for(int i = 1; i < array.length; i++) {
            product *= array[i];
        }
        for(int j = 0; j < array.length; j++) {
            productArray[j] = product / array[j];
        }
        return productArray;
    }

    public static int[] calculateProductWithoutI_NoDivision(int[] array) {
        int[] productArray = new int[array.length];
        ArrayUtils.printIntArray(array);


        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixArray[i] = prefixArray[i-1] * array[i];
        }

        int[] suffixArray = new int[array.length];
        suffixArray[array.length-1] = array[array.length-1];
        for(int j = array.length-2; j >= 0; j--) {
            suffixArray[j] = suffixArray[j+1] * array[j];
        }

        productArray[0] = suffixArray[1];
        productArray[array.length-1] = prefixArray[array.length-2];
        for(int k = 1; k < array.length-1; k++) {
            productArray[k] = prefixArray[k-1] * suffixArray[k+1];
        }

        return productArray;
    }

    @Test
    public void testCalculateProductWithoutI_Brute1() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_Brute(array);
        int[] expected = { 120, 60, 40, 30, 24 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }

    @Test
    public void testCalculateProductWithoutI_Brute2() {
        int[] array = { 3, 2, 1 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_Brute(array);
        int[] expected = { 2, 3, 6 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }

    @Test
    public void testCalculateProductWithoutI_Division1() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_Division(array);
        int[] expected = { 120, 60, 40, 30, 24 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }

    @Test
    public void testCalculateProductWithoutI_Division2() {
        int[] array = { 3, 2, 1 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_Division(array);
        int[] expected = { 2, 3, 6 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }

    @Test
    public void testCalculateProductWithoutI_NoDivision1() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_NoDivision(array);
        int[] expected = { 120, 60, 40, 30, 24 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }

    @Test
    public void testCalculateProductWithoutI_NoDivision2() {
        int[] array = { 3, 2, 1 };
        int[] product = ProductArrayWithoutI.calculateProductWithoutI_NoDivision(array);
        int[] expected = { 2, 3, 6 };
        for(int k = 0; k < product.length; k++) {
            assertEquals(expected[k], product[k]);
        }
    }
}

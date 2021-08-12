package problems;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Given a sorted list of integers, square the elements and give the output in sorted order.
 *
 * For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */
public class SquaredAndSorted {

    public static int[] squareAndSortArray(int[] array) {
        for (int i=0;i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 2.0);
        }
        Arrays.sort(array);
        return array;
    }

    @Test
    public void test_squareAndSortArray() {
        int[] array = {-9, -2, 0, 2, 3};
        SquaredAndSorted.squareAndSortArray(array);
        assertEquals("test array", "[0, 4, 4, 9, 81]", Arrays.toString(array));
    }

}

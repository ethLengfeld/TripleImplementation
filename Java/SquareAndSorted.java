import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import utils.ArrayUtils;

public class SquareAndSorted {

	public static int[] squareAndSortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.pow(array[i], 2);
		}
		// sorry quick hack and I'm tired
		// TODO implement own quicksort
		Arrays.sort(array);

		return array;
	}

	@Test
	public void testSampleArray() {
		int[] array = { -9, -2, 0, 2, 3 };
		SquareAndSorted.squareAndSortArray(array);
		String squaredArray = ArrayUtils.getIntArray(array);
		assertEquals("Sample Array", "[0,4,4,9,81]", squaredArray);
	}
}

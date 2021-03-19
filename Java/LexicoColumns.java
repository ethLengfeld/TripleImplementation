
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LexicoColumns {

	public static int numColumnsToRemoveForLexico(char[][] array) {
		int removeCount = 0;
		
		for(int i = 0; i < array[0].length; i++) {
			int lastVal = 0;
			for(int j = 0; j < array.length; j++) {
				int val = (int) Character.toLowerCase(array[j][i]);
				if (val > lastVal) {
					lastVal = val;
				} else {
					removeCount++;
					break;
				}
			}
		}
		
		return removeCount;
	}
	
	@Test
	public void test2DArray() {
		char[] arr1 = {'d','a','a'};
		char[] arr2 = {'b','b','b'};
		char[] arr3 = {'c','c','c'};
		char[][] array = {arr1,arr2,arr3};

		int colsToRemove = LexicoColumns.numColumnsToRemoveForLexico(array);
		
		assertEquals("First column should be removed", 1, colsToRemove);
	}
	
	@Test
	public void testSingleRowArray() {
		char[] arr1 = {'d','q','a','r'};
		char[][] array = {arr1};
		int colsToRemove = LexicoColumns.numColumnsToRemoveForLexico(array);
		
		assertEquals("Single row array, no removals", 0, colsToRemove);
	}
	
	@Test
	public void testSingleColumnArray() {
		char[] arr1 = {'d'};
		char[] arr2 = {'b'};
		char[] arr3 = {'c'};
		char[][] array = {arr1,arr2,arr3};

		int colsToRemove = LexicoColumns.numColumnsToRemoveForLexico(array);
		
		assertEquals("First column should be removed", 1, colsToRemove);
	}
	
	@Test
	public void testRemoveAll() {
		char[] arr1 = {'z','y','z'};
		char[] arr2 = {'w','v','u'};
		char[] arr3 = {'t','s','r'};
		char[][] array = {arr1,arr2,arr3};

		int colsToRemove = LexicoColumns.numColumnsToRemoveForLexico(array);
		
		assertEquals("All columns should be removed", 3, colsToRemove);
	}
	
}

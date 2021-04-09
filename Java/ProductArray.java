import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class ProductArray {

	public static int[] createProductArray(int[] array) {
		int[] productArray = new int[array.length];
		
		if(array.length == 1) {
			productArray[0] = 0;
			return productArray;
		}
		
		int productTotal = 1;
		for(int i = 0; i < array.length; i++) {
			productTotal = 1;
			for(int j = 0; j < array.length; j++) {
				if(i != j) {
					productTotal *= array[j];
				}
			}
			productArray[i] = productTotal;
		}
		
		return productArray;
	}
	
	@Test
	public void testCreateProductArraySample() {
		int[] array = { 1, 2, 3, 4, 5};
		int[] products = ProductArray.createProductArray(array);
		
		System.out.println(Arrays.toString(array));
		System.out.print(Arrays.toString(products));
		
		assertEquals("2*3*4*5=120", 120, products[0]);
		assertEquals("1*3*4*5=120", 60, products[1]);
		assertEquals("1*2*4*5=120", 40, products[2]);
		assertEquals("1*2*3*5=120", 30, products[3]);
		assertEquals("1*2*3*4=120", 24, products[4]);
	}
}

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EcommerceLogs {

	private List<Integer> logs;
	
	public EcommerceLogs() {
		this.logs = new ArrayList<>();
	}
	
	public void record(int orderId) {
		this.logs.add(orderId);
	}
	
	public int getLast(int index) {
		return this.logs.get(index).intValue();
	}
	
	@Test
	public void testEcommerceClass() {
		EcommerceLogs ecomm = new EcommerceLogs();
		// new order
		int orderId = 1;
		ecomm.record(orderId);
		ecomm.record(4);
		ecomm.record(3);
		ecomm.record(2);
		
		int indexTwoRecord = ecomm.getLast(2);
		assertEquals("Get element at index 2", 3, indexTwoRecord);
	}
}

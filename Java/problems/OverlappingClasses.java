package problems;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OverlappingClasses {

	public static int findMinimumNumOfClasses(int[][] schedule) {
		if(schedule.length == 0 ) return 0;
		if(schedule.length == 1 ) return 1;
		
		int numClasses = 0;
		for(int i = 0; i < schedule.length-1; i++) {
			for(int j = i; j < schedule.length; j++) {
				if(schedule[i][0] <= schedule[j][0] && schedule[i][1] >= schedule[j][0]) {
					numClasses++;
				}
			}
		}
		
		return numClasses;
	}
	
	//TODO
	@Test
	public void testSample() {
		int[][] schedule = {{30,75}, {0,50}, {60,150}};
		int numClasses = OverlappingClasses.findMinimumNumOfClasses(schedule);
		assertEquals("Need two classes", 2, numClasses);
	}
}

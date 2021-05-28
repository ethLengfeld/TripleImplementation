import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=Sny9Rta3k_Q&ab_channel=AwaisMirzaAwaisMirza
 * @author e_len
 *
 */
public class PracticeProblems {

	public static void printShapes() {
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 6; j++) {
				if (i > j) {
					System.out.print(j+1);
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < 6; i++) {
			for(int j = 5; j >= 0; j--) {
				if (i < j) {
					System.out.print(6-j);
				}
				else {
					System.out.print("&");
				}
			}
			System.out.println();
		}
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < i; j++) {
				if (j == 0 || j == i-1 || i == 6) {
					System.out.print("@");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	@Test
	public void testPrintShapes() {
		PracticeProblems.printShapes();
	}
	
	// 7:36
	
//	public void fill2DArray
}

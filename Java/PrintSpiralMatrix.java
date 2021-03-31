import org.junit.Test;

public class PrintSpiralMatrix {

	public static void printSpiralMatrix(int[][] matrix) {
		int intervals = 0;
		int numPrinted = 0;
		int total = (matrix[0].length * matrix.length);
		int col = 0;
		int row = 0;
		while (numPrinted < total) {
			for (col = intervals; col < (matrix[0].length - intervals); col++) {
				System.out.println(matrix[intervals][col]);
				numPrinted++;
			}
			if(numPrinted == total ) {
				return;
			}
			for (row = (intervals + 1); row < (matrix.length - intervals); row++) {
				System.out.println(matrix[row][col-1]);
				numPrinted++;
			}
			if(numPrinted == total ) {
				return;
			}
			for (col = ((matrix[0].length-1) - intervals - 1); col >= intervals; col--) {
				System.out.println(matrix[row-1][col]);
				numPrinted++;
			}
			for (row = ((matrix.length-1) - intervals - 1); row > intervals; row--) {
				System.out.println(matrix[row][col+1]);
				numPrinted++;
			}
			intervals++;
		}
	}

	@Test
	public void testPrintSpiralMatrix() {
		System.out.println("/-----------Sample Test-----------\\");
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 6, 7, 8, 9, 10 };
		int[] arr3 = { 11, 12, 13, 14, 15 };
		int[] arr4 = { 16, 17, 18, 19, 20 };
		int[][] matrix = { arr1, arr2, arr3, arr4 };
		PrintSpiralMatrix.printSpiralMatrix(matrix);
	}
	
	@Test
	public void test1DMatrix() {
		System.out.println("/-----------1-D Row Test-----------\\");
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[][] matrix = { arr1 };
		PrintSpiralMatrix.printSpiralMatrix(matrix);
	}
	
	@Test
	public void test1DMatrixCol() {
		System.out.println("/-----------1-D Col Test-----------\\");
		int[] arr1 = { 1 };
		int[] arr2 = { 6 };
		int[] arr3 = { 11 };
		int[] arr4 = { 16 };
		int[][] matrix = { arr1, arr2, arr3, arr4 };
		PrintSpiralMatrix.printSpiralMatrix(matrix);
	}
	
	@Test
	public void testPrintSpiralMatrix2() {
		System.out.println("/-----------Matrix 2 Test-----------\\");
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 6, 7, 8 };
		int[] arr3 = { 11, 12, 13 };
		int[] arr4 = { 16, 17, 18 };
		int[][] matrix = { arr1, arr2, arr3, arr4 };
		PrintSpiralMatrix.printSpiralMatrix(matrix);
	}
}

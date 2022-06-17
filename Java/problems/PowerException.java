package problems;

import java.util.Scanner;

class PowerException {

    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        long product = 1;
        for(int i = 0; i < p; i++) {
            product *= n;
        }
        return product;
    }

}

class PowerExceptionSolution {
    public static final PowerException my_calculator = new PowerException();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
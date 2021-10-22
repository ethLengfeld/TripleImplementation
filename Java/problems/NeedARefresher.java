package problems;

import java.util.Scanner;

public class NeedARefresher {

    public static void main(String[] args) {
        int x = 0;
        String yesOrNo = "n";
        Scanner scnr = new Scanner(System.in);

        do {
            if ("n".equals(yesOrNo)) {
                System.out.print("Please input an integer here -> ");
                x = scnr.nextInt();
                // eat return statement
                scnr.nextLine();
            }

            System.out.println("You just inputted " + x);
            System.out.print("Is that correct? Input Y (yes) or N (no) -> ");
            yesOrNo = scnr.nextLine().toLowerCase();
            if (!"n".equals(yesOrNo) && !"y".equals(yesOrNo)) {
                System.out.println(yesOrNo + " is not option.. Try again");
            }
        } while ( !"y".equals(yesOrNo) );

        System.out.println("the first digit of " + x + " is " + NeedARefresher.getFirstDigit(x));
        System.out.println("the last digit of " + x + " is " + NeedARefresher.getLastDigit(x));

    }

    private static int getFirstDigit(int num) {
        String strNum = Integer.toString(num);
        return Integer.parseInt(strNum.substring(0,1));
    }

    private static int getLastDigit(int num) {
        String strNum = Integer.toString(num);
        return Integer.parseInt(strNum.substring(strNum.length()-1, strNum.length()));
    }
}
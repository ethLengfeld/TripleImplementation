package utils;

import java.util.Scanner;

public class HelloIntellij {

    public static void main(String[] args) {

        System.out.println("Hello, we're here on IntelliJ!");
        Scanner scnr = new Scanner(System.in);

        System.out.print("Pick a number: ");
        String input = scnr.nextLine();
        try {
            int num = Integer.parseInt(input);
            System.out.println("Number was " + num + " and one more is " + Math.incrementExact(num));
        } catch (NumberFormatException e) {
            System.out.println("Error: That was a number" + e);
        } finally {
            System.out.print("user input was \"" + input + "\"");
            scnr.close();
        }
    }
}

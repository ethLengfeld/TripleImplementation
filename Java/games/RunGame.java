package games;

import utils.InputValidationUtil;

import java.util.Scanner;

public class RunGame {

    private static Scanner scnr;
    private static IGame game;

    public static void main(String args[]) {
        scnr = new Scanner(System.in);
        RunGame.execute();
    }

    public static void execute() {
        System.out.println("Please enter the game you'd like to play:");
        System.out.println("1. Hangman");
        System.out.println("Else. EXIT");
        System.out.print("Enter ->  ");
        String gameInput = scnr.nextLine();

        switch(gameInput) {
            case "1":
                System.out.println("Welcome to Hangman!");

                boolean validSolution = false;
                String solution = null;
                while(!validSolution) {
                    System.out.println("Please enter word/phrase you'd like to guess below");
                    System.out.print("->   ");
                    solution = scnr.nextLine().toUpperCase();
                    validSolution = InputValidationUtil.validateHangmanSolution(solution);
                    if(!validSolution) {
                        System.out.println("You entered an invalid solution. Please try again...\n");
                    }
                }
                // TODO need to clear the board to hide solution
                System.out.println("--------------------------------------------------------------");
                System.out.println("--------------------     HANGMAN     -------------------------");
                System.out.println("--------------------------------------------------------------");
                System.out.println("\n\n\n");

                game = new HangmanGame(solution);
                game.execute();
                break;
        }

    }
}

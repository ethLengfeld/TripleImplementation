package games;

import java.util.Scanner;

public class HangmanGame implements IGame{

    private static final int NUM_OF_INCORRECT_GUESSES = 7;

    private char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private int incorrectGuesses;

    private String solution;

    private static Scanner scnr;

    // TODO make singleton
    public HangmanGame(String solution) {
        this.incorrectGuesses = 0;
        this.solution = solution;
        HangmanGame.scnr = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("You have " + (6-incorrectGuesses) + " incorrect guesses remaining");
        while(incorrectGuesses < NUM_OF_INCORRECT_GUESSES) {
            // TODO
            System.out.println("Letters left: ");
            // TODO
            System.out.println("Letters guessed: ");

            System.out.print("Guess a letter ->  ");
            String guess = HangmanGame.scnr.nextLine().toUpperCase();
            // TODO validate it is letter and not already guessed
            System.out.println("You just guessed the letter " + guess);

            // TODO add incorrect check
            incorrectGuesses++;

            // TODO
            System.out.println("Hangman board");
            this.printMan();
            System.out.println();
        }
    }

    @Override
    public void printGame() {

    }

    public void printMan() {
//        System.out.println("   ________");
//        System.out.println("  |       |");
        if (incorrectGuesses >= 1) {
            System.out.println(" O ");
            if (incorrectGuesses == 2) {
                System.out.println(" | ");
            }
            if (incorrectGuesses == 3) {
                System.out.println("\\| ");
            }
            if (incorrectGuesses >= 4) {
                System.out.println("\\|/ ");
            }
            if(incorrectGuesses >= 5) {
                System.out.println(" | ");
                if (incorrectGuesses == 6) {
                    System.out.println("/  ");
                }
                if (incorrectGuesses == 7) {
                    System.out.println("/ \\ ");
                }
            }
        }
    }
}

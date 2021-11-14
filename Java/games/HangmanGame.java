package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HangmanGame implements IGame{

    private static final int NUM_OF_INCORRECT_GUESSES = 7;

    private char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private List<Character> lettersGuessed;
    private int incorrectGuesses;

    private String solution;

    private char[] solutionArr;

    private static Scanner scnr;

    // TODO make singleton
    public HangmanGame(String solution) {
        this.incorrectGuesses = 0;
        this.solution = solution;
        this.lettersGuessed = new ArrayList<>();
        this.solutionArr = new char[this.solution.length()];
        Arrays.fill(this.solutionArr,'_');

        if(this.solution.contains(" ")) {
            for(int i = 0; i < this.solution.length(); i++) {
                if(this.solution.charAt(i) == ' ')
                    this.solutionArr[i] = ' ';
            }
        }
        HangmanGame.scnr = new Scanner(System.in);
    }

    @Override
    public void execute() {
        while(incorrectGuesses < NUM_OF_INCORRECT_GUESSES) {
            int guessesLeft = NUM_OF_INCORRECT_GUESSES - incorrectGuesses;
            System.out.print("You have " + guessesLeft + " incorrect");
            if(guessesLeft > 1) {
                System.out.println(" guesses remaining");
            } else {
                System.out.println(" guess remaining..");
            }
            // TODO
            System.out.println("Letters left: ");
//            this.print
            // TODO
            System.out.println("Letters guessed: ");

            System.out.print("Puzzle: ");
            this.printSolutionArray();

            System.out.print("Guess a letter ->  ");
            String guess = HangmanGame.scnr.nextLine().toUpperCase();
            // TODO validate it is letter and not already guessed
            System.out.println("You just guessed the letter " + guess);

            // TODO add incorrect check
            if(this.solution.contains(guess)) {
                System.out.println("Yes! " + guess + " is in the solution! Good guess!");
                this.updateSolutionArray(guess.charAt(0));
            } else {
                System.out.println("Sorry, " + guess + " is not in the solution...");
                incorrectGuesses++;
            }

            // TODO
            System.out.println("Hangman board:");
            this.printMan();
            System.out.println();
        }
    }

    @Override
    public void printGame() {

    }

    public void printSolutionArray() {
        for(int i =0;i < this.solutionArr.length; i++) {
            System.out.print(this.solutionArr[i]);
        }
        System.out.println();
    }
    public void updateSolutionArray(char guessChar) {
        for(int i = 0; i < this.solution.length(); i++) {
            if(guessChar == this.solution.charAt(i)) {
                this.solutionArr[i] = guessChar;
            }
        }
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

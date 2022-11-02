package games;

import utils.InputValidationUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HangmanGame implements IGame{

    private static final int NUM_OF_INCORRECT_GUESSES = 7;

    private static final Character[] LETTERS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private List<Character> lettersGuessed;
    private int incorrectGuesses;

    private String solution;

    private char[] solutionArr;

    private static Scanner scnr;

    private static HangmanGame hangman;

    public static HangmanGame getInstance(String solution) {
        if (hangman == null) {
            hangman = new HangmanGame(solution);
        }
        return hangman;
    }

    private HangmanGame(String solution) {
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
// TODO add functionality to guess word
        while(incorrectGuesses < NUM_OF_INCORRECT_GUESSES) {
            int guessesLeft = NUM_OF_INCORRECT_GUESSES - incorrectGuesses;
            System.out.print("You have " + guessesLeft + " incorrect");

            if(guessesLeft > 1) {
                System.out.println(" guesses remaining");
            } else {
                System.out.println(" guess remaining..");
            }

            System.out.print("Letters left: ");
            this.printLettersAvailable();

            System.out.print("Letters guessed: ");
            this.printLettersGuessed();

            System.out.print("Puzzle: ");
            this.printSolutionArray();

            char guessedLetter = '-';

            while(guessedLetter == '-') {
                System.out.print("Guess a letter ->  ");
                String guess = HangmanGame.scnr.nextLine().toUpperCase();
                try {
                    guessedLetter = InputValidationUtil.validateHangmanGuess(guess, this.lettersGuessed);
                    System.out.println("You just guessed the letter " + guessedLetter);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please enter another guess...");
                }
            }

            boolean solved = false;
            if(this.solution.contains(Character.toString(guessedLetter))) {
                System.out.println("Yes! " + guessedLetter + " is in the solution! Good guess!");
                this.updateSolutionArray(guessedLetter);
                for(int i = 0; i < this.solutionArr.length; i++) {
                    if(this.solutionArr[i] == '_') {
                        solved = false;
                        break;
                    }
                    solved = true;
                }
                if (solved) {
                    incorrectGuesses = Integer.MAX_VALUE;
                }
            } else {
                System.out.println("Sorry, " + guessedLetter + " is not in the solution...");
                incorrectGuesses++;
            }

            if(!solved) {
                System.out.println("Hangman board:");
                this.printMan();
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println();

        }
        if(this.incorrectGuesses == NUM_OF_INCORRECT_GUESSES) {
            System.out.println("Sorry you didn't get the solution..");
            System.out.println("The solution you were looking for was " + this.solution);
        } else {
            System.out.println("Congrats you found the solution! -> " + this.solution);
        }
    }

    @Override
    public void printGame() {

    }

    public void printLettersAvailable() {
        for(Character currChar: HangmanGame.LETTERS) {
            if(!this.lettersGuessed.contains(currChar)) {
                System.out.print(currChar + " ");
            }
        }
        System.out.println();
    }

    public void printLettersGuessed() {
        for(Character currChar: this.lettersGuessed) {
            System.out.print(currChar + " ");
        }
        System.out.println();
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

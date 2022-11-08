package games;

import java.util.Scanner;

public class TicTacToeGame implements IGame{
    private int[][] guesses;

    private String drawBoardRow;

    private static TicTacToeGame ticTacToe;

    private static Scanner scnr;

    public static TicTacToeGame getInstance(int boardSize) {
        if(ticTacToe == null) {
            ticTacToe = new TicTacToeGame(boardSize);
        }
        return ticTacToe;
    }

    private TicTacToeGame(int boardSize) {
        drawBoardRow = new String(new char[(boardSize*2)+1]).replace("\0", "_");
        guesses = new int[boardSize][boardSize];
        scnr = new Scanner(System.in);
    }

    public void execute() {
        boolean over = false;

        while(!over) {
            // guess
            // Top Left, Middle, Right
            // Middle Left, Middle, Right
            // Bottom Left, Middle, Right
            // guess corresponds 1-9
            int guessedPos = 0;
            int xOrO = 0;
            while (xOrO == 0) {
                System.out.println("Please enter the number position for your mark, 1 thru 9");
                System.out.println("1: Top Left      " + "2: Top Middle      " + "3: Top Right\n" +
                        "4: Middle Left   " + "5: Middle Middle   " + "6: Middle Right\n" +
                        "7: Bottom Left   " + "8: Bottom Middle   " + "9: Bottom Right");
                String input = scnr.nextLine().toUpperCase();

                try {
                    char guess = input.charAt(0);
                    if (guess == 'X') {
                        xOrO = 1;
                    } else if (guess == 'O') {
                        xOrO = 2;
                    }
                    if(guess == 'Q') {
                        over = true;
                    }
                } catch (Exception e) {
                    System.out.println("Bad guess, please select X or O.");
                }
                // TODO: check if pos it taken, if not add to guesses
            }
            printGame();
            // TODO: check for three in a row
        }
    }

    public void printGame() {
        for(int i = 0; i < guesses.length; i++) {
            for(int j = 0; j < guesses[i].length; j++) {
                if(guesses[i][j] == 1) {
                    System.out.print("X");
                }
                else if(guesses[i][j] == 2) {
                    System.out.print("O");
                }
                else {
                    System.out.print(" ");
                }
                if(guesses[i].length != j) {
                    System.out.print("|");
                }
            }
            if(i+1 < guesses.length) {
                System.out.print("\n" + drawBoardRow + "\n");
            }
        }
        System.out.println("");
    }
}

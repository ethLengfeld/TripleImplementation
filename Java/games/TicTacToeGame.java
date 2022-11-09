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
        boolean isX = true;
        char currMark = 'X';
        System.out.println("X goes first!");

        while(!over) {
            if(isX) {
                currMark = 1;
            } else {
                currMark = 2;
            }

            int guessedPos = 0;
            while (guessedPos == 0) {
                System.out.println("Please enter the number position for your, 1 thru 9");
                System.out.println("1: Top Left      " + "2: Top Middle      " + "3: Top Right\n" +
                        "4: Middle Left   " + "5: Middle Middle   " + "6: Middle Right\n" +
                        "7: Bottom Left   " + "8: Bottom Middle   " + "9: Bottom Right");
                String input = scnr.nextLine().toUpperCase();

                try {
                    guessedPos = Integer.parseInt(input);
                    switch(guessedPos) {
                        case 1:
                            guesses[0][0] = currMark;
                            break;
                        case 2:
                            guesses[0][1] = currMark;
                            break;
                        case 3:
                            guesses[0][2] = currMark;
                            break;
                        case 4:
                            guesses[1][0] = currMark;
                            break;
                        case 5:
                            guesses[1][1] = currMark;
                            break;
                        case 6:
                            guesses[1][2] = currMark;
                            break;
                        case 7:
                            guesses[2][0] = currMark;
                            break;
                        case 8:
                            guesses[2][1] = currMark;
                            break;
                        case 9:
                            guesses[2][2] = currMark;
                            break;
                    }
                    if(guessedPos == -1) {
                        over = true;
                    }
                } catch (Exception e) {
                    System.out.println("Bad guess, please select a valid position");
                }
                // TODO: check if pos it taken, if not add to guesses
            }
            printGame();

            // switch turn
            if(isX) {
                isX = false;
            } else {
                isX = true;
            }
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

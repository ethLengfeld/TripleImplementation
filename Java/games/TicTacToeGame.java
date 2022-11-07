package games;

public class TicTacToeGame implements IGame{
    private int[][] guesses;

    private String drawBoardRow;

    private static TicTacToeGame ticTacToe;

    public static TicTacToeGame getInstance(int boardSize) {
        if(ticTacToe == null) {
            ticTacToe = new TicTacToeGame(boardSize);
        }
        return ticTacToe;
    }

    private TicTacToeGame(int boardSize) {
        drawBoardRow = new String(new char[(boardSize*2)+1]).replace("\0", "_");
        guesses = new int[boardSize][boardSize];
    }

    public void execute() {
        // guess
            // Top Left, Middle, Right
            // Middle Left, Middle, Right
            // Bottom Left, Middle, Right
        // guess corresponds 1-9
        int guessedPos = 0;
        printGame();
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

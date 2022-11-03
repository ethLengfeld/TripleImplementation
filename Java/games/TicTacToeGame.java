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
        drawBoardRow = new String(new char[boardSize*2]).replace("\0", "_");
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
                System.out.print(guesses[i][j]);
                if(guesses[i].length != j) {
                    System.out.print("|");
                }
            }
            System.out.print("\n" + drawBoardRow + "\n");
        }
    }
}

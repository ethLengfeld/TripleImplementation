package games;

public class TicTacToeGame implements IGame{
    private int[][] guesses;

    private int boardSize;

    private String drawBoardRow;

    private static TicTacToeGame ticTacToe;

    public static TicTacToeGame getInstance(int boardSize) {
        if(ticTacToe == null) {
            ticTacToe = new TicTacToeGame(boardSize);
        }
        return ticTacToe;
    }

    private TicTacToeGame(int boardSize) {
        drawBoardRow = new StringBuilder(boardSize).append("_",0,boardSize-1).toString();
        guesses = new int[boardSize][boardSize];
    }

    public void execute() {

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

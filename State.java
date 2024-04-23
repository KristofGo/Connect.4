package tictactoe;


/**
* Tic-Tac-Toe state variables.
*/
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_ROW][Constants.BOARD_COLUMN];


   public boolean isWinner() {
    // Check horizontal and vertical wins
    for (int row = 0; row < Constants.BOARD_ROW; row++) {
        for (int col = 0; col < Constants.BOARD_COLUMN; col++) {
            int totalHorizontal = 0;
            int totalVertical = 0;
            for (int k = 0; k < 4; k++) {
                // Horizontal check
                if (col + k < Constants.BOARD_COLUMN) {
                    totalHorizontal += getBoardCell(row, col + k);
                }
                // Vertical check
                if (row + k < Constants.BOARD_ROW) {
                    totalVertical += getBoardCell(row + k, col);
                }
            }
            if (Math.abs(totalHorizontal) == 4 || Math.abs(totalVertical) == 4) {
                return true;
            }
        }
    }

    // Check diagonal wins
    for (int row = 0; row < Constants.BOARD_ROW; row++) {
        for (int col = 0; col < Constants.BOARD_COLUMN; col++) {
            int totalDiagonal1 = 0;
            int totalDiagonal2 = 0;
            for (int k = 0; k < 4; k++) {
                // Diagonal 1 check (/)
                if (row + k < Constants.BOARD_ROW && col + k < Constants.BOARD_COLUMN) {
                    totalDiagonal1 += getBoardCell(row + k, col + k);
                }
                // Diagonal 2 check (\)
                if (row + k < Constants.BOARD_ROW && col - k >= 0) {
                    totalDiagonal2 += getBoardCell(row + k, col - k);
                }
            }
            if (Math.abs(totalDiagonal1) == 4 || Math.abs(totalDiagonal2) == 4) {
                return true;
            }
        }
    }

    return false;
}


   public boolean isTie() {
        for (int row=0; row<Constants.BOARD_ROW; row++) {
            for (int col=0; col<Constants.BOARD_COLUMN; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }


   public int getGameState() {
        return gameState;
    }


   public void setGameState(int gameState) {
        this.gameState = gameState;
    }


   public int getWhoseMove() {
        return whoseMove;
    }


   public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }


   public String getXName() {
        return xName;
    }


   public void setXName(String xName) {
        this.xName = xName;
    }


   public String getOName() {
        return oName;
    }


   public void setOName(String oName) {
        this.oName = oName;
    }


   public int getBoardCell(int row, int col) {
    // Check if the provided indices are within bounds
    if (row >= 0 && row < Constants.BOARD_ROW && col >= 0 && col < Constants.BOARD_COLUMN) {
        return this.board[row][col];
    } else {
        // If indices are out of bounds, return an invalid value
        return Constants.INVALID_VALUE;
    }
}
    public int [][] getBoard() {
        return this.board;
    }

   public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }
    
   public void reset() {
    // Clear the board and reset other game state variables
    for (int row = 0; row < Constants.BOARD_ROW; row++) {
        for (int col = 0; col < Constants.BOARD_COLUMN; col++) {
            board[row][col] = Constants.BLANK;
        }
    }
    whoseMove = Constants.X; // Reset the starting player to X
    gameState = Constants.GET_X_NAME; // Reset the game state
    }
}

package io.github.reconsolidated.reversi;

import lombok.Getter;

@Getter
public class Move {
    private int startingI;
    private int startingJ;
    private int i;
    private int j;
    private BoardElement playerElement;

    private Board boardBeforeMove;
    private Board boardAfterMove;

    public Move(Board board, int startingI, int startingJ, int i, int j, BoardElement playerElement) {
        this.startingI = startingI;
        this.startingJ = startingJ;
        this.i = i;
        this.j = j;
        this.playerElement = playerElement;

        boardBeforeMove = board.copy();
        boardAfterMove = board.copy();
        BoardElement[][] boardArray = boardAfterMove.getBoard();
        if (startingI == i) {
            for (int k = Math.min(startingJ, j); k <= Math.max(startingJ, j); k++) {
                boardArray[i][k] = playerElement;
            }
        }
        else if (startingJ == j) {
            for (int k = Math.min(startingI, i); k <= Math.max(startingI, i); k++) {
                boardArray[k][j] = playerElement;
            }
        }
        else {
            int k = Math.min(startingI, i);
            int l = Math.min(startingJ, j);
            while (k <= Math.max(startingI, i) && l <= Math.max(startingJ, j)) {
                boardArray[k][l] = playerElement;
                k++;
                l++;
            }
        }
    }

    @Override
    public String toString() {
        return "Move for player: " + playerElement + " from (" + startingI + ", " + startingJ + ") to (" + i + ", " + j + ")";
    }
}
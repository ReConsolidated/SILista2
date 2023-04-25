package io.github.reconsolidated.reversi;

import lombok.Getter;

@Getter
public class Move {
    private int startingI;
    private int startingJ;
    private int i;
    private int j;
    private BoardElement playerElement;
    private Board board;

    public Move(Board board, int startingI, int startingJ, int i, int j, BoardElement playerElement) {
        this.board = board;
        this.startingI = startingI;
        this.startingJ = startingJ;
        this.i = i;
        this.j = j;
        this.playerElement = playerElement;
    }

    public Board getBoardAfterMove() {
        Board boardAfterMove = board.copy();
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
            int iChange = i - startingI > 0 ? 1 : -1;
            int jChange = j - startingJ > 0 ? 1 : -1;
            while (startingI != i && startingJ != j) {
                boardArray[startingI][startingJ] = playerElement;
                startingI += iChange;
                startingJ += jChange;
            }
            boardArray[startingI][startingJ] = playerElement;
        }
        return boardAfterMove;
    }

    @Override
    public String toString() {
        return "Move for player: " + playerElement + " from (" + startingI + ", " + startingJ + ") to (" + i + ", " + j + ")";
    }
}

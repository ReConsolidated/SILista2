package io.github.reconsolidated.reversi;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Board {
    @Getter
    private final BoardElement[][] board;

    public Board() {
        this.board = new BoardElement[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = BoardElement.EMPTY;
            }
        }

        board[3][3] = BoardElement.PLAYER1;
        board[3][4] = BoardElement.PLAYER2;
        board[4][3] = BoardElement.PLAYER2;
        board[4][4] = BoardElement.PLAYER1;
    }

    public List<Move> getAvailableMoves(BoardElement playerElement) {
        List<Move> moves = new ArrayList<>();
        BoardElement oppositeElement = playerElement == BoardElement.PLAYER1 ? BoardElement.PLAYER2 : BoardElement.PLAYER1;
        BoardElement empty = BoardElement.EMPTY;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int startingI = i;
                int startingJ = j;
                if (this.board[i][j] == playerElement) {
                    // check to the right
                    try {
                        boolean dirty = false;
                        while (board[i+1][j] == oppositeElement) {
                            dirty = true;
                            i++;
                        }
                        if (board[i+1][j] == empty && dirty) {
                            moves.add(new Move(this, startingI, j, i+1, j, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    // check to the left
                    i = startingI;
                    try {
                        boolean dirty = false;
                        while (board[i-1][j] == oppositeElement) {
                            dirty = true;
                            i--;
                        }
                        if (board[i-1][j] == empty && dirty) {
                            moves.add(new Move(this, startingI, j, i-1, j, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check upwards
                    i = startingI;
                    try {
                        boolean dirty = false;
                        while (board[i][j+1] == oppositeElement) {
                            dirty = true;
                            j++;
                        }
                        if (board[i][j+1] == empty && dirty) {
                            moves.add(new Move(this, i, startingJ, i, j+1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check downwards
                    j = startingJ;
                    try {
                        boolean dirty = false;
                        while (board[i][j-1] == oppositeElement) {
                            dirty = true;
                            j--;
                        }
                        if (board[i][j-1] == empty && dirty) {
                            moves.add(new Move(this, i, startingJ, i, j-1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check diagonally up-right
                    j = startingJ;
                    try {
                        boolean dirty = false;
                        while (board[i+1][j+1] == oppositeElement) {
                            dirty = true;
                            i++;
                            j++;
                        }
                        if (board[i+1][j+1] == empty && dirty) {
                            moves.add(new Move(this, startingI, startingJ, i+1, j+1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check diagonally up-left
                    i = startingI;
                    j = startingJ;
                    try {
                        boolean dirty = false;
                        while (board[i-1][j+1] == oppositeElement) {
                            dirty = true;
                            i--;
                            j++;
                        }
                        if (board[i-1][j+1] == empty && dirty) {
                            moves.add(new Move(this, startingI, startingJ, i-1, j+1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check diagonally down-right
                    i = startingI;
                    j = startingJ;
                    try {
                        boolean dirty = false;
                        while (board[i+1][j-1] == oppositeElement) {
                            dirty = true;
                            i++;
                            j--;
                        }
                        if (board[i+1][j-1] == empty && dirty) {
                            moves.add(new Move(this, startingI, startingJ, i+1, j-1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    //check diagonally down-left
                    i = startingI;
                    j = startingJ;
                    try {
                        boolean dirty = false;
                        while (board[i-1][j-1] == oppositeElement) {
                            dirty = true;
                            i--;
                            j--;
                        }
                        if (board[i-1][j-1] == empty && dirty) {
                            moves.add(new Move(this, startingI, startingJ, i-1, j-1, playerElement));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                }
                i = startingI;
                j = startingJ;
            }
        }

        return moves;
    }

    public Board copy() {
        Board copy = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy.board[i][j] = this.board[i][j];
            }
        }
        return copy;
    }

    public boolean isFinished() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board[i][j] == BoardElement.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
